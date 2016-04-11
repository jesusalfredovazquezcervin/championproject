package com.koomoni.ws
import org.apache.commons.logging.LogFactory;
import com.koomoni.bean.Almacen
import com.koomoni.dto.AlmacenDTO
import com.koomoni.dto.ProductoDTO;
import com.koomoni.dto.ProductosDTO;
import com.koomoni.dto.AlmacenesDTO;
import com.koomoni.dto.filtro.AlmacenesFC;
import com.koomoni.dto.filtro.InventarioFC;
import com.koomoni.exception.BusinessException;
import com.koomoni.dto.OrdenCompraDTO;
import com.koomoni.dto.PartidaDTO;

import championweb.OrdenCompra;
import championweb.PartidaOrden;
import org.apache.commons.lang.StringUtils;

import wslite.soap.SOAPClient;

class ArchivoMODService {

//	TODO: Queda pendiente obtener ahora si la informacion real a enviar como las claves del proveedor y producto etc.
	public Boolean crearMOD(Integer ordenID, SOAPClient client){
		def archivoGenerado
		def instanceOrden = OrdenCompra.get(ordenID)
		log.debug "-----La orden de compra es: ${instanceOrden}"
		def provSAE=StringUtils.leftPad(instanceOrden.provSAE.toString(), 10, " ")
		log.debug "------ el proveedor SAE es: ${provSAE}"
		
		log.debug "------ Consultando el WS-----"
	
		def response = client.send(SOAPAction:'loadInfo') {
			body{
				'ser:loadInfo'('xmlns:ser':'http://services.ws.champion.com/'){			 
						arg0({
							comTot("")
							condicion("")
							cveClpv(provSAE)//Si lo tenemos clave proveedor String formatted = String.format("%07d", number);
							cvePedi("")
							cveVend("")
							desFin(instanceOrden.descFinal.toString())
							desTot(instanceOrden.descuento.toString())
							entrega("")
							esquema(instanceOrden.esquema.toString())
							modulo("COMP")
							numAlma(instanceOrden.almacen.claveAlmacen)//Alamcen si lo tenemos
							numMoned(instanceOrden.moneda.toString())
							strObs(instanceOrden.solicitud.obsPrograma.toString()) //Tmb pendiente las observaciones
							suRefer("123456")//Queda pendiente porque no se donde sale este valor
							tipCamb(instanceOrden.tipoCambio.toString())
							totInd("0")
							
							instanceOrden.partidas.each {partida->								
								 partidas({
								 //se agrega 1 sola partida
								 cantidad(partida.cantidad.toInteger())
								 cveArt(partida.cveProducto.toString())
								 desc1("0")
								 desc2("0")
								 desc3("0")
								 impu1("")//Columna otros dentro de SAE
								 impu2("0")//ISR Ret
								 impu3("0")//Ret IVA
								 impu4(partida.IVA.toInteger())//IVA
								 comi("")
								 prec("0")
								 numAlm(instanceOrden.almacen.claveAlmacen)
								 strObs("")
								 regGpoprod("0")
								 regKitprod("")
								 numReg("")								
								 costo(partida.costoUnidad.toInteger())
								 tipoProd("P")
								 tipoElem("N")
								 minDirecto("0")
								 tipoCambio(instanceOrden.tipoCambio.toInteger())
								 factConv("1")
								 uniVenta(partida.unidad)
								 imp1Apla("0")
								 imp2Apla("0")
								 imp3Apla("0")
								 imp4Apla("0")
								 precSinRedo("0")
								 costoSinRedo(partida.costoUnidad.toInteger())
								 })
							}
							
						})																	
				}
			}
		}
		
		if(!response.envelope.Body.loadInfoResponse.return.isEmpty()){
			log.debug("respuesta NO VACIA")
			
//			archivoGenerado=  response.envelope.Body.consultaEmailContactoResponse.return
			archivoGenerado = response.envelope.Body.loadInfoResponse.return
			log.debug("Archivo generado: ${archivoGenerado}")
		}
		return archivoGenerado
	}

	
	
	
	
}
