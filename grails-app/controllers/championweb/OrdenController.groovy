//TODO:: Me dijo el rena que lo que falta es:
//1.- realizar los calculos de los campos de: Esquema, Desc, Desc Final que se apliquen para las partidas.
//2.- El boton actualizar guarda los datos calculados.
//3.- Agregar un boton llamado crear, el cual va a enviar los datos de la orden al ws service de crear mod en los WS que va a crear el MOD, este WS segun rena ya existe.
//Solo resta crear dentro de este proyecto un servicio que arme la info para enviarla al WS 
package championweb

import java.math.BigDecimal;

import com.koomoni.dto.ProveedorDTO
import com.koomoni.dto.ProveedoresDTO;
import com.koomoni.dto.filtro.ProveedoresFC
import com.koomoni.ws.ProveedorService
import com.koomoni.ws.ArchivoMODService

import grails.converters.JSON
import wslite.soap.SOAPClient
import championweb.OrdenCompra
import championweb.ConfGeneral

import org.apache.commons.logging.LogFactory;

class OrdenController {
	private static final log = LogFactory.getLog(this);

	def index() {
		redirect(action: "list", params: params)
	}
	
	def list(){
		def ordenCompraInstanceList = OrdenCompra.list();
		[ordenCompraInstanceList:ordenCompraInstanceList]
	}
	
	def searchOrden(){
		def ordenCompraInstanceList = OrdenCompra.findAllByOrdenSAELike("%${params.pbuscar}%");
		render template:'remoteList', model:[ordenCompraInstanceList:ordenCompraInstanceList]
	}
	
	def create(){}
	
	def generateFromCotizacion(){
		log.debug(params)
		def cotizacionEnviadaInstance = CotizacionEnviada.get(params.idCotizacion.toLong())
		def ordenInstance = new OrdenCompra()
		
		
		if(cotizacionEnviadaInstance){
			
			ordenInstance.fecha = new Date()
			ordenInstance.almacen = cotizacionEnviadaInstance.partida.first().solicitud.lugarEntrega
			ordenInstance.provSAE = cotizacionEnviadaInstance.provSAE
			ordenInstance.solicitud = cotizacionEnviadaInstance.partida.first().solicitud
			ordenInstance.servicio = "N/A"
			ordenInstance.moneda = 1
			
			if(!ordenInstance.save(flush:true)){
				log.debug("Error al intentar guardar la orden :: "+ordenInstance.errors)
			}else{
					log.debug("Se ha creado la cotizacion ${ordenInstance.id} ")
					ArrayList<PartidaOrden> partidas = new ArrayList<PartidaOrden>()
					def partidaOrden
					cotizacionEnviadaInstance.partida.each {
						partidaOrden = new PartidaOrden()
						partidaOrden.orden = ordenInstance
						partidaOrden.cantidad = it.cantidad
						partidaOrden.almacen = ordenInstance.almacen
						partidaOrden.cveProducto = it.cveProducto
						partidaOrden.descProducto = it.descProducto
						partidaOrden.unidad = it.unidad
						
						partidas.add(partidaOrden)
					}
					
					ordenInstance.partidas = partidas
					
					if(!ordenInstance.save(flush:true)){
						log.debug("Error al intentar guardar la orden :: "+ordenInstance.errors)
					}
					
				log.debug("Se han guardado las partidas")
			
				redirect action: 'edit', params:[id:ordenInstance.id]
			}
			
		}
		
	}
	
	def edit(){
		log.debug(params)
		
		def ordenInstance = OrdenCompra.get(params.id)
		def datosProveedor
		
		if(ordenInstance){
			datosProveedor = getProveedorWS(ordenInstance.provSAE.toInteger())
		}
		def iva = ConfGeneral.findByName("IVA").value.toInteger()
		def isr = ConfGeneral.findByName("ISR").value.toInteger()
		def other = ConfGeneral.findByName("otros").value.toInteger()
		Float subtotal=0
		def partidasid=[]	 		
		ordenInstance.partidas.each {partida->
			def costo = ((partida.costoUnidad * partida.cantidad));
			def ivalinea=(partida.IVA/100) * costo;
			def retisr=(partida.isrRet/100) * costo;
			def otros=(partida.otros/100) * costo;
			def retiva=(partida.retIVA/100)  * costo;
			def desc =(partida.descuento/100) * costo;
			subtotal+= (costo-desc)  + ivalinea - (otros + retisr + retiva);
			partidasid.add(partida.id)
		}
		Float total= subtotal- (subtotal*(ordenInstance.descFinal/100))
		
		def descuento=ordenInstance.descuento
		if(descuento && descuento > 0)
			descuento/=100
		
		render view: 'edit', model:[ordenInstance:ordenInstance,datosProveedor:datosProveedor, iva:iva, isr:isr, 
			descuento:descuento, descFin:ordenInstance.descFinal, other:other, subtotal:subtotal.trunc(2), 
			total:total, partidasid:partidasid]
	}
	
	
	def deletePartida(){
		log.debug(params)
		
		def partidaOrdenInstance = PartidaOrden.get(params.id)
		def ordenInstance = OrdenCompra.get(partidaOrdenInstance.orden.id)
		def cantPartidas = ordenInstance.partidas.size()

		log.debug("Se intentara eliminar de la orden la partida: "+partidaOrdenInstance.id)
		log.debug("Cantidad de partidas: "+cantPartidas)
		
		if(partidaOrdenInstance){
			if(!partidaOrdenInstance.delete(flush:true))
				log.error(partidaOrdenInstance.errors)
		}else{
				log.error("NO SE PUDO ELIMINAR POR QUE ES LA UNICA")
				flash.message = "Imposible eliminar la partida"
			}
		
		render template: 'partidas', model:[ordenInstance:ordenInstance]
	}
	
	def getProveedor(){
		log.debug("BUSCANDO PROVEEDORES")
		def client = new SOAPClient(grailsApplication.config.ws.proveedor)
		def sProveedor = new ProveedorService()
		def filtro = new ProveedoresFC()
		def dto = new ProveedoresDTO()
		
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
		
		filtro.setClave(params.claveP!=null?params.claveP:"")
		filtro.setNombre(params.nombreP!=null?params.nombreP:"")
		filtro.setRfc(params.rfcP!=null?params.rfcP:"")
		filtro.setCurrPage(params.pageP!=null?params.pageP.toInteger():0)
		
		dto = sProveedor.searchProveedor(filtro, client);
		
		render(view:"remote_proveedores", model:[proveedores:dto])
	}
	
	/**
	 * Regresa los datos como JSON
	 * @return
	 */
	def consultaProveedor(){
		def sProveedor = new ProveedorService()
		def client = new SOAPClient(grailsApplication.config.ws.proveedor)
		com.koomoni.bean.Proveedor proveedor = new com.koomoni.bean.Proveedor();
		
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
		
		if(params.idp){
			proveedor = sProveedor.consultaProveedor(params.idp.toInteger(), client)
		}
		
		render proveedor as JSON
	}
	
	/**
	 * Regresa los datos en un DTO
	 * @param idprov
	 * @return
	 */
	private com.koomoni.bean.Proveedor getProveedorWS(Integer idprov){
		log.debug("Llamando al ws...")
		
		def client = new SOAPClient(grailsApplication.config.ws.proveedor)
		def sProveedor = new ProveedorService()
		def filtro = new ProveedoresFC()
		def dto = new com.koomoni.bean.Proveedor()
		
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
		
		dto = sProveedor.consultaProveedor(idprov, client)
		
		return dto
	}
	
	/**
	 *
	 * Actualiza valores de cantidades y costos solamente
	 * @return
	 */
	def updatePartida(){
 		log.debug(params)
		
		def partidaOrdenInstance = PartidaOrden.get(params.id)
		
		if(partidaOrdenInstance){
			log.debug("Guardando cambios en la partida ${partidaOrdenInstance.id}")
			partidaOrdenInstance.costoUnidad = params.costounidad?params.costounidad.toBigDecimal():0
			partidaOrdenInstance.cantidad = params.cantidad?.toFloat()
			partidaOrdenInstance.descuento = params.descuento?.toFloat()
			
			partidaOrdenInstance.otros = params.otros?.toFloat()
			partidaOrdenInstance.isrRet  = params.isrRet?.toFloat()
			partidaOrdenInstance.retIVA = params.retIVA?.toFloat()
			partidaOrdenInstance.IVA = params.IVA?.toFloat()
			
			BigDecimal costoUnidad = 0.0
		
			if(!partidaOrdenInstance.save(flush:true))
				log.error("Error al guardar los cambios: ${partidaOrdenInstance.errors}")
			
		}
		
		render "OK"
	}
	
	def crearMOD(params){
		log.debug params
		log.debug("Llamando al ws ArchivoMOD Service")
		def respuesta
		def client = new SOAPClient(grailsApplication.config.ws.mod)
		log.debug grailsApplication.config.ws.mod
		def sArchivoMOD = new ArchivoMODService()		
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword				
		respuesta = sArchivoMOD.crearMOD(params.porden.toInteger(), client)
//		return respuesta
		flash.message = "Archivo MOD generado exitosamente!"
		render template:'mensaje',model: [params:params, respuesta:"esta es una respuesta"]

	}

	def updateOrden(params){
		log.debug(params)
		def fechaRec
		def fecha
		if (params.fechaRec){
			String theDate =params.fechaRec
			fechaRec = new Date().parse("yyyy-MM-dd",theDate)
		} 
		
		if (params.fecha){
			String theDate =params.fecha
			fecha = new Date().parse("yyyy-MM-dd",theDate)
		}
		
		def ordenInstance = OrdenCompra.get(params.idOrden.toLong())
		ordenInstance.ordenSAE=params.numeroOrden.toString()
		ordenInstance.moneda=params.moneda.toInteger()		
		ordenInstance.fechaRec=fechaRec
		ordenInstance.fecha=fecha
		ordenInstance.descFinal=params.descFinal.toFloat()
		ordenInstance.descuento=params.descuento.toFloat()
		ordenInstance.tipoCambio=params.tipoCambio.toFloat()
		ordenInstance.esquema=params.esquema.toFloat()
		ordenInstance.provSAE=params.idProveedor.toLong()
		if(!ordenInstance.save(true))
			flash.message = "Error al actualizar la orden"
		else
			flash.message = "Orden actualizada correctamente"
		
		
		render template:'mensaje',model: [params:params, respuesta:"esta es una respuesta"]
	}
	

		
}


