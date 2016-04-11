package com.koomoni.ws

import java.util.List;

import org.apache.commons.logging.LogFactory;

import com.koomoni.bean.Almacen
import com.koomoni.dto.AlmacenDTO
import com.koomoni.dto.ProductoDTO;
import com.koomoni.dto.ProductosDTO;
import com.koomoni.dto.AlmacenesDTO;
import com.koomoni.dto.filtro.AlmacenesFC;
import com.koomoni.dto.filtro.InventarioFC;
import com.koomoni.exception.BusinessException;

import wslite.soap.*;

class AlmacenService{

	
	private static final log = LogFactory.getLog(this);
	
	
	/**
	 * Obtiene Almacen buscando por su ID
	 * @param idAlmacen
	 * @return Almacen Bean
	 * @throws BusinessException
	 */
//    public Almacen getAlmacenByID(SOAPClient client, Integer idAlmacen) throws BusinessException{
//		Almacen almacen = new Almacen();
//		log.info("CONSULTANDO ALMACEN POR ID: "+idAlmacen);
//		
//			def response = client.send(SOAPAction:'consultaAlmacen') {
//				body{
//					'ser:consultaAlmacen'('xmlns:ser':'http://services.ws.champion.com/'){  
//						arg0(idAlmacen)
//					}
//				}
//			}
//			
//			response.envelope.Body.consultaAlmacenResponse.return.each{
//				log.info("Se ha encontrado el almacen: "+idAlmacen);
//				almacen.setClaveAlmacen(it.claveAlmacen.toInteger())
//				almacen.setCveMsal(it.cveMsal.toInteger())
//				almacen.setCveMent(it.cveMent.toInteger())
//				almacen.setDescripcion(it.descripcion.toString())
//				almacen.setStatus(it.status.toString())
//			}
//			
//		return almacen;
//		
//	}
	
	/**
	 * Obtiene solo el nombre de todos los almacenes existentes
	 * @param 
	 * @return
	 * @throws BusinessException
	 */
	public AlmacenesDTO getAlamacenes(SOAPClient client) throws BusinessException{
		 
		AlmacenesDTO almacenes = new AlmacenesDTO();
		AlmacenesFC filtro = new AlmacenesFC();
		
		filtro.setCurrPage(0);
		filtro.setDescripcion("");
		filtro.setCveAlm(null);
		
			
		def response = callConsultaAlmacenes(client, filtro);
			
		AlmacenDTO almacen  ;
		List<AlmacenDTO> almacenesList = new ArrayList<AlmacenDTO>();
			
		def ident
		def desc
		Integer countR = response.envelope.Body.consultaAlmacenesResponse.return.rowcount.toInteger()
		Integer countP = response.envelope.Body.consultaAlmacenesResponse.return.rowsPerPage.toInteger()
			
		def paginas = Math.ceil(countR / countP).toInteger()
			
			response.envelope.Body.consultaAlmacenesResponse.return.almacenes.each{
				almacen = new AlmacenDTO();
				ident = it.id
				desc = it.descripcion
				almacen.setId(ident.toInteger())
				almacen.setDescripcion(desc.toString())
				almacenesList.add(almacen)
				
			}
			
			
		def contador = 1
		while(paginas>1){
				
			filtro.setCurrPage(contador);
				
			response = callConsultaAlmacenes(client, filtro)
				
			response.envelope.Body.consultaAlmacenesResponse.return.almacenes.each{
				almacen = new AlmacenDTO();
				ident = it.id
				desc = it.descripcion
				almacen.setId(ident.toInteger())
				almacen.setDescripcion(desc.toString())
				almacenesList.add(almacen)
					
			}
				
			contador++;
			paginas--;
		}
			
			
			almacenes.setAlmacenes(almacenesList);
			
		
		return almacenes;
		
	}
	
	/**
	 * Obtiene los datos de los almacenes, haciendo una busqueda por descripcion (nombre)
	 * @param desc
	 * @return
	 * @throws BusinessException
	 */
	public AlmacenesDTO getAlmacenesByDesc(String desc) throws BusinessException{
		AlmacenesDTO almacenes = new AlmacenesDTO();
		
		try {
			//TODO: SE VA A LLENAR EL ALMACENESDTO CON BEANS DE ALMACEN
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return almacenes;
	}
	
	/**
	 * Consulta el WS de Almacen :: consultaInventario
	 * @param filtro
	 * @return
	 */
	public ProductosDTO getStockProducto(InventarioFC filtro, SOAPClient client) throws BusinessException{
		ProductosDTO productos = new ProductosDTO();
		ProductoDTO producto;
		List<ProductoDTO> productoList = new ArrayList<ProductoDTO>();
		
	
		//Consultando el WS
		def response = client.send(SOAPAction:'consultaInventario') {
			body{
				'ser:consultaInventario'('xmlns:ser':'http://services.ws.champion.com/'){ 
					arg0({
						 claveAlmacen(filtro.getClaveAlmacen()==null?"":filtro.getClaveAlmacen())
						 claveAlterna(filtro.getClaveAlterna()==null?"":filtro.getClaveAlterna())
						 claveProducto(filtro.getClaveProducto()==null?"":filtro.getClaveProducto())
						 descripcion(filtro.getDescripcion()==null?"":filtro.getDescripcion())
						 currPage(0)
					})
				}
			}
		}
		
		//Obtniendo los datos
		producto = new ProductoDTO()
		response.envelope.Body.consultaInventarioResponse.return.inventario.each{
			producto = new ProductoDTO()
			producto.setClave(it.claveProducto.toString())
			producto.setClaveAlterna(it.claveAlterna.toString())
			producto.setDescripcion(it.descripcionProducto.toString())
			producto.setClaveAlmacen(it.claveAlmacen.toString())
			producto.setDescAlmacen(it.descripcionAlmacen.toString())
			producto.setExistencia(it.existencia.toString())
			
			productoList.add(producto)
		}
		
		productos.setProductos(productoList)
		
		return productos;
	}
	
	
	
	private SOAPResponse callConsultaAlmacenes (SOAPClient client, AlmacenesFC filtro) {
		def response = client.send(SOAPAction:'consultaAlmacenes') {
			body{
				'ser:consultaAlmacenes'('xmlns:ser':'http://services.ws.champion.com/'){  
					arg0({
						 cveAlm(filtro.getCveAlm()==null?"?":filtro.getCveAlm())
						 descripcion(filtro.getDescripcion()==null?"?":filtro.getDescripcion())
						 currPage(filtro.getCurrPage())
					})
				}
			}
		}
		
		return response
	}
	 
}
