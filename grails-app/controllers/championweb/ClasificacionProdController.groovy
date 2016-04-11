package championweb

import championweb.enums.EstatusPartida;

import com.koomoni.dto.ProveedorDTO
import com.koomoni.dto.ProveedoresDTO;
import com.koomoni.dto.filtro.ProveedoresFC
import com.koomoni.ws.ProveedorService

import grails.converters.JSON
import wslite.soap.SOAPClient

import org.apache.commons.logging.LogFactory;

class ClasificacionProdController {
	
	private static final log = LogFactory.getLog(this);
	
	def buscarProveedor(){
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
		
		render(view:"_remote_proveedores", model:[proveedores:dto])
	}
	
	
	def getProveedor(){
		log.debug("OBTENIENDO EL PROVEEDOR CON ID:"+params.provid)
		def dto = new com.koomoni.bean.Proveedor()
		dto = getProveedorWS(params.provid.toInteger())
		
		log.debug(dto.getNombre())
		
		render template:'provSeleccionado', model:[nombreProveedor:dto.getNombre().trim(), proveedor:dto.getClave().trim()]
	}
	
	def getPartidasSinProveedor(){
		log.debug("Buscando partidas sin proveedor de la solicitud: "+params.idsolicitud)
		def solicitudInstance = Solicitud.get(params.idsolicitud.trim().toLong())
		def solicitudPartidaList = SolicitudPartida.findAllBySolicitudAndIdSAEIsNull(solicitudInstance)
		
		log.debug(solicitudPartidaList)
		
		render template:'listPartidas', model:[partidas:solicitudPartidaList]
	}
	
	def mostrarClasificacion(){
		log.debug(params)
		
		def solicitudPartidaInstance = SolicitudPartida.get(params.partida.trim().toLong())
		def solicitudPartidaList
		ArrayList<List> clasificacion = new ArrayList<List>();
		def map
		
		if(solicitudPartidaInstance){
			solicitudPartidaInstance.idSAE = params.proveedor.trim().toLong()
			solicitudPartidaInstance.estatus = EstatusPartida.REVISION
			if(!solicitudPartidaInstance.save(flush:true)){
				log.error(solicitudPartidaInstance.errors)
			}
			
			
			solicitudPartidaList = SolicitudPartida.findAllBySolicitudAndIdSAEIsNotNull(solicitudPartidaInstance.solicitud,[sort:"idSAE"])
			List provclas = new ArrayList();
			
			if(solicitudPartidaList){
				
				solicitudPartidaList.each {
					if(provclas.empty){
						log.debug("guardando por primera vez")
						provclas.add(it)
					}else{
						log.debug("guardando por segunda vez ${provclas[0].idSAE} - ${it.idSAE}")
						if(provclas[0].idSAE == it.idSAE){
							provclas.add(it)
						}else{
							map = [proveedor:getProveedorWS(provclas[0].idSAE.toInteger()).getNombre(), lista:provclas, idproveedor:provclas[0].idSAE.toInteger(),
									solicitud:solicitudPartidaInstance.solicitud.id]
							clasificacion.add(map)
							provclas = new ArrayList();
							provclas.add(it)
						}
					}
				}
				
				log.debug("provclas :: "+provclas[0].cveProducto+" - "+provclas[0].idSAE)
				map = [proveedor:getProveedorWS(provclas[0].idSAE.toInteger()).getNombre(), lista:provclas, idproveedor:provclas[0].idSAE.toInteger(),
						solicitud:solicitudPartidaInstance.solicitud.id]
				clasificacion.add(map)
				
			}
			
		}
		
		render template:'clasificacionProv', model:[clasificacion:clasificacion]
	}
	
	def undoClasificacion(){
		log.debug(params)
		
		def solicitudPartidaInstance = SolicitudPartida.get(params.partida.trim().toLong())
		def solicitudPartidaList
		ArrayList<List> clasificacion = new ArrayList<List>();
		
		if(solicitudPartidaInstance){
			solicitudPartidaInstance.idSAE = null
			if(!solicitudPartidaInstance.save(flush:true)){
				log.error(solicitudPartidaInstance.errors)
			}
		solicitudPartidaList = SolicitudPartida.findAllBySolicitudAndIdSAEIsNull(solicitudPartidaInstance.solicitud,[sort:"idSAE"])
			List provclas = new ArrayList();
			
			solicitudPartidaList.each {
				if(provclas.empty){
					provclas.add(it)
				}else{
					if(provclas[0].idSAE == it.idSAE){
						provclas.add(it)
					}else{
						provclas = new ArrayList();
						provclas.add(it)
					}
				}
				
				clasificacion.add(provclas)
			}
			
		}
		
		render template:'clasificacionProv', model:[clasificacion:clasificacion]
	}
	
	def solicitudClasificacion(){
		log.debug("ENTRANDO A solicitudClasificacion :: "+params)
		def solicitudPartidaList
		def solicitudInstance = Solicitud.get(params.idsolicitud)
		ArrayList<List> clasificacion = new ArrayList<List>();
		List provclas
		def map 
		if(solicitudInstance){
			log.debug(solicitudInstance.id)
			solicitudPartidaList = SolicitudPartida.findAllBySolicitudAndIdSAEIsNotNull(solicitudInstance,[sort:"idSAE"])
			provclas = new ArrayList();
			
				if(solicitudPartidaList){
					
					solicitudPartidaList.each {
						if(provclas.empty){
							log.debug("guardando por primera vez")
							provclas.add(it)
						}else{
							log.debug("guardando por segunda vez ${provclas[0].idSAE} - ${it.idSAE}")
							if(provclas[0].idSAE == it.idSAE){
								provclas.add(it)
							}else{
								map = [proveedor:getProveedorWS(provclas[0].idSAE.toInteger()).getNombre(), lista:provclas, idproveedor:provclas[0].idSAE.toInteger(),solicitud:solicitudInstance.id]
								clasificacion.add(map)
								provclas = new ArrayList();
								provclas.add(it)
							}
						}
					}
					
					map = [proveedor:getProveedorWS(provclas[0].idSAE.toInteger()).getNombre(), lista:provclas, idproveedor:provclas[0].idSAE.toInteger(), solicitud:solicitudInstance.id]
					clasificacion.add(map)
					
				}
			}
		
		render template:'clasificacionProv', model:[clasificacion:clasificacion]
		
	}
	
	def cambiaEstatusPartidas(){
		log.debug(params)
		
		SolicitudPartida.executeUpdate("UPDATE SolicitudPartida SET estatus = :estatus WHERE solicitud.id = :solicitud AND idSAE = :proveedor ",
										[estatus:params.estatus.toInteger()==2?EstatusPartida.COTIZACION:EstatusPartida.REVISION, solicitud:params.solicitud.toLong(), proveedor:params.proveedor.toLong()])
		
		checkEstatus(params.solicitud.toLong())
		
		render ""
	}
	
	public com.koomoni.bean.Proveedor getProveedorWS(Integer idprov){
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
	 * Valida el estatus de las partidas para asi decidir
	 * en automatico el estatus de la solicitud
	 * @return
	 */
	def checkEstatus(Long idSolicitud){
		StringBuilder qry = new StringBuilder()
		
		qry.append("SELECT count(*) FROM SolicitudPartida WHERE solicitud.id = :idsolicitud AND estatus = :estatus")
		
		def partidasEnRevisionTotales = SolicitudPartida.executeQuery(qry.toString(),[idsolicitud:idSolicitud, estatus:EstatusPartida.REVISION])
		def partidasEnCotizacionTotales = SolicitudPartida.executeQuery(qry.toString(),[idsolicitud:idSolicitud, estatus:EstatusPartida.COTIZACION])
		def partidasEnCotEnviadaTotales = SolicitudPartida.executeQuery(qry.toString(),[idsolicitud:idSolicitud, estatus:EstatusPartida.COTIZACION_ENVIADA])
		
		def solicitud = Solicitud.get(idSolicitud)
		
		if(partidasEnRevisionTotales[0]>0){
			log.debug("EN REVISION")
			solicitud.estatus = 2
			if(!solicitud.save(flush:true))
				log.error("NO SE PUDO CAMBIAR EL ESTATUS ->"+solicitud.errors)
		}else if(partidasEnCotizacionTotales[0]>0 || partidasEnCotEnviadaTotales[0]>0){
			log.debug("EN COTIZACION O ENVIADA")
			solicitud.estatus = 3
			if(!solicitud.save(flush:true))
				log.error("NO SE PUDO CAMBIAR EL ESTATUS ->"+solicitud.errors)
		
		}
		
	}
	
}
