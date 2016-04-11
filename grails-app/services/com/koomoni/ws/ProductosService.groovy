package com.koomoni.ws

import org.codehaus.groovy.grails.commons.GrailsApplication;
import org.springframework.beans.factory.annotation.Autowired;

import wslite.soap.*

import com.koomoni.dto.ProductoDTO
import com.koomoni.dto.ProductosDTO
import com.koomoni.dto.filtro.ProductoFC

class ProductosService {

	//TODO: SIN TERMINAR
    def ProductoDTO getProducto(String cveAlterna, String ws){
		
		def client = new SOAPClient(ws)
		client.httpClient.sslTrustStoreFile = "/web/cert/test/key.jks"
		client.httpClient.sslTrustStorePassword = "cliente"
		
		def p = new ProductoDTO()

				def response = client.send(SOAPAction:'consultaProducto') {
			body{
				'ser:consultaProducto'('xmlns:ser':'http://services.ws.champion.com/'){
					arg0({ 
						 clave("")
						 claveAlterna(cveAlterna)
						 currPage(1)
						 descripcion("?")
						 familia("")
				 })
				}
			}
		}
		
		println response.envelope.Body.consultaProductoResponse.return.clave
		 response.envelope.Body.consultaProductoResponse.return.each{
			 println "---${it.clave}---" 
			 p.clave = it.clave
			 p.descripcion = it.descripcion
		 }
	
		 return p
    }
	
	
	def ProductosDTO searchProductos(SOAPClient client, ProductoFC filtro){
		ProductosDTO productos = new ProductosDTO();
		ProductoDTO producto;
		List<ProductoDTO> productoList = new ArrayList<ProductoDTO>();
		
		//Consultando el WS
		def response = client.send(SOAPAction:'consultaProductos') {
			body{
				'ser:consultaProductos'('xmlns:ser':'http://services.ws.champion.com/'){
					arg0({
						 claveAlterna(filtro.getClaveAlterna()==null?"":filtro.getClaveAlterna())
						 clave(filtro.getClave()==null?"":filtro.getClave())
						 descripcion(filtro.getDescripcion()==null?"":filtro.getDescripcion())
						 familia(filtro.getFamilia()==null?"":filtro.getFamilia())
						 currPage(0)
					})
				}
			}
		}
		
		response.envelope.Body.consultaProductosResponse.return.productos.each{
			producto = new ProductoDTO()
			
			producto.setClave(it.clave.toString())
			producto.setClaveAlterna(it.claveAlterna.toString())
			producto.setDescripcion(it.descripcion.toString())
			producto.setFamilia(it.familia.toString())
			producto.setUni_med(it.uni_med.toString())
			productoList.add(producto)
		}
		
		productos.setProductos(productoList)
		
		return productos;
	}
}
