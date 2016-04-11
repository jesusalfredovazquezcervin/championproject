package com.koomoni.ws

import org.grails.datastore.gorm.finders.MethodExpression.IsNull;

import wslite.soap.*;

import com.koomoni.bean.Proveedor
import com.koomoni.dto.ProveedorDTO
import com.koomoni.dto.ProveedoresDTO;
import com.koomoni.dto.filtro.ProveedoresFC;

class ProveedorService {
	
	public ProveedoresDTO searchProveedor(ProveedoresFC filtro, SOAPClient client){
		ProveedoresDTO proveedores = new ProveedoresDTO();
		ProveedorDTO proveedor;
		List<ProveedorDTO> proveedoresList = new ArrayList<ProveedorDTO>()
		
		//Consultando el WS
		def response = client.send(SOAPAction:'consultaProveedores') {
			body{
				'ser:consultaProveedores'('xmlns:ser':'http://services.ws.champion.com/'){
					arg0({
						 clave(filtro.getClave()==null?"":filtro.getClave().trim())
						 nombre(filtro.getNombre()==null?"":filtro.getNombre().trim())
						 rfc(filtro.getRfc()==null?"":filtro.getRfc().trim())
						 currPage(filtro.getCurrPage()==null?0:filtro.getCurrPage())
					})
				}
			}
		}
		
		//Obteniendo los datos
		response.envelope.Body.consultaProveedoresResponse.return.proveedores.each {
			proveedor = new ProveedorDTO()
			proveedor.setId(it.id.toInteger())
			proveedor.setNombre(it.nombre.toString())
			proveedor.setLocalidad(it.localidad.toString())
			proveedor.setRfc(it.rfc.toString())
			
			
			proveedoresList.add(proveedor)
		}
		
		proveedores.currPage 	= response.envelope.Body.consultaProveedoresResponse.return.currPage.toInteger()
		proveedores.rowcount 	= response.envelope.Body.consultaProveedoresResponse.return.rowcount.toInteger()
		proveedores.rowsPerPage = response.envelope.Body.consultaProveedoresResponse.return.rowsPerPage.toInteger()
		proveedores.totalPages 	= response.envelope.Body.consultaProveedoresResponse.return.totalPages.toInteger()
		
		proveedores.setProveedores(proveedoresList)
		
		return proveedores
	}
	
	public Proveedor consultaProveedor(Integer id, SOAPClient client){
		Proveedor proveedor = new Proveedor()
		
		//Consultando el WS
		def response = client.send(SOAPAction:'consultaProveedor') {
			body{
				'ser:consultaProveedor'('xmlns:ser':'http://services.ws.champion.com/'){
						 arg0(id)
				}
			}
		}
		
		if(!response.envelope.Body.consultaProveedorResponse.return.isEmpty()){
			proveedor.clave = response.envelope.Body.consultaProveedorResponse.return.clave
			proveedor.calle = response.envelope.Body.consultaProveedorResponse.return.calle
			proveedor.codigo = response.envelope.Body.consultaProveedorResponse.return.codigo
			proveedor.cve_pais = response.envelope.Body.consultaProveedorResponse.return.cve_pais
			proveedor.cve_zona = response.envelope.Body.consultaProveedorResponse.return.cve_zona
			proveedor.localidad = response.envelope.Body.consultaProveedorResponse.return.localidad
			proveedor.nacionalidad = response.envelope.Body.consultaProveedorResponse.return.nacionalidad
			proveedor.nombre = response.envelope.Body.consultaProveedorResponse.return.nombre
			proveedor.numext = response.envelope.Body.consultaProveedorResponse.return.numext
			proveedor.numint = response.envelope.Body.consultaProveedorResponse.return.numint
			proveedor.rfc = response.envelope.Body.consultaProveedorResponse.return.rfc
			proveedor.telefono = response.envelope.Body.consultaProveedorResponse.return.telefono
			proveedor.colonia = response.envelope.Body.consultaProveedorResponse.return.colonia
		}
		
		return proveedor
	}
	
	public String consultaMailProveedor(Integer id, SOAPClient client){
		String email 
		
		//Consultando el WS
		def response = client.send(SOAPAction:'consultaEmailContacto') {
			body{
				'ser:consultaEmailContacto'('xmlns:ser':'http://services.ws.champion.com/'){
						 arg0(id)
				}
			}
		}
		
		if(!response.envelope.Body.consultaEmailContactoResponse.return.isEmpty()){
			email= response.envelope.Body.consultaEmailContactoResponse.return
		}
		
		return email
	}

}
