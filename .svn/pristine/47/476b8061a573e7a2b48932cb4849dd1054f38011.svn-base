package championweb

import grails.converters.JSON
import groovy.servlet.ServletBinding;

import com.koomoni.dto.AlmacenesDTO
import com.koomoni.dto.ProductosDTO
import com.koomoni.dto.filtro.InventarioFC
import com.koomoni.ws.AlmacenService

import wslite.soap.SOAPClient

import org.apache.commons.logging.LogFactory;

import grails.plugin.springsecurity.annotation.Secured;

import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession

@Secured(['ROLE_ALMACENES_RELACIONAR','ROLE_ADMIN'])
class AlmacenController {
	
	private static final log = LogFactory.getLog(this);
	
	
	
    def index() { 
		redirect(action: "relacionarZona", params: params)
	}
	
	def relacionarZona(){
		
		def client = new SOAPClient(grailsApplication.config.ws.almacen)
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
		
		def sAlmacen = new AlmacenService();
		AlmacenesDTO res = sAlmacen.getAlamacenes(client);
		[resList:res.getAlmacenes(), almacenInstanceList:Almacen.list(params)]
	}
	
	/**
	 * Metodo para guardar / actualizar la relacion almacen-zona
	 * @return
	 */
	def relacionarSave(){
		
		log.info("Intentando guardar relacion...");
		log.debug("Parametros:"+params);
		def almacenInstance
		
		if(params.claveAlmacen != null){//si no viene null es una relacion nueva
			almacenInstance = new Almacen()
			almacenInstance.claveAlmacen = params.claveAlmacen.toInteger()
		}else{
			almacenInstance = Almacen.findByClaveAlmacen(params.almacenUpdate)
		}
			
		almacenInstance.descripcion = params.descripcion
		almacenInstance.zona = Zona.findById(params.zona)
		
		if(!almacenInstance.save(flush:true)){
			
			def client = new SOAPClient(grailsApplication.config.ws.almacen)
			client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
			client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
			
			def sAlmacen = new AlmacenService();
			AlmacenesDTO res = sAlmacen.getAlamacenes(client);
			
			render(view: "relacionarZona", model: [almacenInstance: almacenInstance,resList:res.getAlmacenes(),almacenInstanceList:Almacen.list(params)])
			return
		}
		
		log.info("Se ha creado/actualizado la relacion.");
		redirect(action: "relacionarZona")
	}
	

	def getListAjax(){
		def almacenList = Almacen.findAll("FROM Almacen WHERE descripcion LIKE '%${params.palmacen}%' ")
		def almacenTotal = almacenList.size();
		render(contentType: 'text/json'){
			result success:true,code:'OK', almacenList:almacenList, almacenTotal : almacenTotal
		}
	}
	
	def getByIdAjax(){
		
		def almacenInstance = Almacen.get(params.id)
		
		render(contentType: 'text/json'){
			result success:true,code:'OK', almacenInstance:almacenInstance
		}
	}
	
	/**
	 * Obtiene el stock de un producto
	 * @return
	 */
	def searchStock(){
		def client = new SOAPClient(grailsApplication.config.ws.almacen)
		def sAlmacen = new AlmacenService();
		def filtro = new InventarioFC();
		def prodDTO = new ProductosDTO();
		
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
		
		//obteniendo datos del post
		filtro.setClaveAlmacen(params.almacen!=null?params.almacen.id:"");
		filtro.setClaveAlterna(params.cve!=null?params.cve:"");
		filtro.setClaveProducto(params.cve!=null?params.cve:"");
		filtro.setDescripcion(params.desc!=null?params.desc:"");
		
		
		prodDTO = sAlmacen.getStockProducto(filtro, client)
		
		log.debug("PRODUCTOS ENCONTRADOS: "+prodDTO.productos.size())
		
		render(view:"listStock", model:[productos:prodDTO])
		
	}
}
