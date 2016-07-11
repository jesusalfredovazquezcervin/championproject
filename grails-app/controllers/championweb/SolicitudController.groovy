/**
 * For the brave souls who get this far: You are the chosen ones,
 * the valiant knights of programming who toil away, without rest,
 * fixing our most awful code. To you, true saviors, kings of men,
 * I say this: never gonna give you up, never gonna let you down,
 * never gonna run around and desert you. Never gonna make you cry,
 * never gonna say goodbye. Never gonna tell a lie and hurt you.
 */

package championweb

import championweb.enums.EstatusPartida;

import com.koomoni.bean.Producto;
import com.koomoni.dto.ProductoDTO
import com.koomoni.dto.ProductosDTO
import com.koomoni.dto.filtro.InventarioFC
import com.koomoni.dto.filtro.ProductoFC
import com.koomoni.ws.AlmacenService
import com.koomoni.ws.HealtService;
import com.koomoni.ws.ProductosService

import org.springframework.dao.DataIntegrityViolationException
import org.apache.commons.logging.LogFactory;

import wslite.soap.SOAPClient
import grails.plugin.springsecurity.annotation.Secured;
import grails.validation.Validateable;

@Secured(['ROLE_ADMIN','ROLE_SOLICITUD_CREATE','ROLE_SOLICITUD_EDIT','ROLE_SOLICITUD_DELETE','ROLE_SOLICITUD_ASIGNAR_ORDEN'])
class SolicitudController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	private static final log = LogFactory.getLog(this);
	def springSecurityService
	
	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		
		def solicitudInstanceList = Solicitud.findAllByEstatusNotEqual(4,[max: params.max, offset: params.offset?params.offset.toInteger():0])
		def solicitudInstanceTotal = Solicitud.findAllByEstatusNotEqual(4).size()
		
		[solicitudInstanceList: solicitudInstanceList, solicitudInstanceTotal:solicitudInstanceTotal]
	}

	@Secured(['ROLE_ADMIN','ROLE_SOLICITUD_CREATE'])
	def create() {
		long unixTime = System.currentTimeMillis() / 1000L;
		ArrayList<String> pr =  new ArrayList<String>();
		def mapProyectos = [name:unixTime, proyectos:pr]
		session.mapsProy = mapProyectos
		session.tmpProyID = unixTime
		
		
		[solicitudInstance: new Solicitud(params),tmpID:unixTime]
	}

	def copy = { File src,File dest->
		
		   def input = src.newDataInputStream()
		   def output = dest.newDataOutputStream()
		
		   output << input
		
		   input.close()
		   output.close()
	   }
	
	/**
	 * Guardado de solicitud
	 * @return
	 */
	@Secured(['ROLE_ADMIN','ROLE_SOLICITUD_CREATE'])
	def save() {
		def solicitudInstance = new Solicitud()
		
		println params
		log.debug("PROYECTO TEMPORAL:"+params.tmpSolicitudH)
		
		/*----Guardando informacion header----*/
		//Contrato
		log.debug("CONTRATO ID:"+params.contrato_id)
		def contratoInstance = Contrato.findById(params.contrato_id)
		solicitudInstance.contrato = contratoInstance
		
		//Lugar de entrega - almacen
		def almacen = Almacen.findById(params.lugarentrega_id)
		solicitudInstance.lugarEntrega = almacen
		
		//Receptor
		def receptor = Receptor.findById(params.receptor_id)
		solicitudInstance.recibe = receptor
		
		//Razones
		List<RazonSolicitud> razones = new ArrayList<RazonSolicitud>()
		params.razon.each {
			razones.add(RazonSolicitud.get(it))
		}
		solicitudInstance.razon = razones
		
		//Fechas
		solicitudInstance.fechaCreacionSolicitud = new Date()
		solicitudInstance.fechaAreaAdm = new Date() //TODO: ESTA ES HASTA EL CAMBIO DE ESTATUS
		
		solicitudInstance.tipoSolicitud = 1//params.tipoSolicitud
		solicitudInstance.estatus = 1//params.estatusSolicitud
		
		//Folio
		try {
			log.debug("GENERANDO FOLIO DE ZONA")
			def user = springSecurityService.currentUser
			solicitudInstance.contPorZona = user.zona.solicitudcont + (Long) 1
			Zona.executeUpdate("UPDATE Zona SET solicitudcont = solicitudcont+1 WHERE id = :id",[id:user.zona.id])
			
		} catch (Exception e) {
			log.error("NO SE PUDO GENERAR EL FOLIO");
			e.printStackTrace()
		}
		
		
		//Usuario creacion
		try {
			def user = springSecurityService.currentUser
			solicitudInstance.usuarioCreo = user
		} catch (Exception e) {
			log.error("No se pudo guardar el usuario de creacion")
			e.printStackTrace()
			
			solicitudInstance.usuarioCreo = User.get(1)
			
		}
		
		//primer guardado para generar el id
		if (!solicitudInstance.save(flush: true)) {
			render(view: "create", model: [solicitudInstance: solicitudInstance])
			return
		}
		
		//Proyectos
		def tmpProyectosList = TmpSolicitudProyecto.findAllByTmpProyectoID(params.tmpSolicitudH)
		List<Proyecto> proyectos = new ArrayList<Proyecto>()
		def proyectoSolicitud
		tmpProyectosList.each {
			proyectoSolicitud = new ProyectoSolicitud()
			proyectoSolicitud.prorrateo = it.prorrateo
			proyectoSolicitud.proyecto = Proyecto.findById(it.idProyecto)
			proyectoSolicitud.solicitud = solicitudInstance
			
			proyectoSolicitud.save(flush:true)
			proyectos.add(proyectoSolicitud)
		}
		
		solicitudInstance.proyecto = proyectos
		
		
		
		/*----Informacion general----*/
		//Programas de trabajo
		def pathTmp = grailsApplication.config.path.files.tmp.solicitudes
		def pathProg = grailsApplication.config.path.files.programa.solicitudes
		
		
		File srcFile
		File destFile
		
		def tmpProgramas = TmpSolicitudPrograma.findByTmpProyectoID(params.tmpSolicitudH)
		
		if(tmpProgramas?.obsPrograma){
			solicitudInstance.obsPrograma = tmpProgramas.obsPrograma
		}
		
		if(tmpProgramas){
			
			if(tmpProgramas.pathDesin){
				srcFile = new File(pathTmp + tmpProgramas.pathDesin)
				destFile = new File(pathProg + tmpProgramas.pathDesin)
				copy(srcFile, destFile)
				solicitudInstance.pathDesin = tmpProgramas.pathDesin
			}
			
			if(tmpProgramas.pathEval){
				srcFile = new File(pathTmp + tmpProgramas.pathEval)
				destFile = new File(pathProg + tmpProgramas.pathEval)
				copy(srcFile, destFile)
				solicitudInstance.pathEval = tmpProgramas.pathEval
			}
			
			if(tmpProgramas.pathInstal){
				srcFile = new File(pathTmp + tmpProgramas.pathInstal)
				destFile = new File(pathProg + tmpProgramas.pathInstal)
				copy(srcFile, destFile)
				solicitudInstance.pathInstal = tmpProgramas.pathInstal
			}
			
			if(tmpProgramas.pathIny){
				srcFile = new File(pathTmp + tmpProgramas.pathIny)
				destFile = new File(pathProg + tmpProgramas.pathIny)
				copy(srcFile, destFile)
				solicitudInstance.pathIny = tmpProgramas.pathIny
			}
			
			if(tmpProgramas.pathMant){
				srcFile = new File(pathTmp + tmpProgramas.pathMant)
				destFile = new File(pathProg + tmpProgramas.pathMant)
				copy(srcFile, destFile)
				solicitudInstance.pathMant = tmpProgramas.pathMant
			}
			
			
		}
		
		//Lista de stock
		def tmpSolicitudStockList = TmpSolicitudStock.findAllByTmpProyectoID(params.tmpSolicitudH)
		def solicitudStockInstance
		
		if(tmpSolicitudStockList){
			tmpSolicitudStockList.each{
				solicitudStockInstance = new SolicitudStock()
				solicitudStockInstance.solicitud = solicitudInstance
				solicitudStockInstance.cveProducto = it.cveProducto
				solicitudStockInstance.nombreProducto = it.nombreProducto
				solicitudStockInstance.cveAlmacen = it.cveAlmacen
				solicitudStockInstance.cantidad = it.cantidad
				
				if(!solicitudStockInstance.save(flush:true)){
					log.error("NO SE PUDO GUARDAR UN PRODUCTO EN STOCK :: "+solicitudStockInstance.errors)
				}
				
			}
		}
		
		//Partidas
		def tmpPartidasSolicitudList = TmpSolicitudPartida.findAllByTmpProyectoID(params.tmpSolicitudH)
		def solicitudPartidaInstance
		
		if(tmpPartidasSolicitudList){
			tmpPartidasSolicitudList.each{
				solicitudPartidaInstance = new SolicitudPartida()
				solicitudPartidaInstance.solicitud = solicitudInstance
				solicitudPartidaInstance.cantidad = it.cantidad
				solicitudPartidaInstance.cveProducto = it.cveProducto
				solicitudPartidaInstance.descProducto = it.descProducto
				solicitudPartidaInstance.unidad = it.unidad
				if (it.lugarEntrega)
				  solicitudPartidaInstance.lugarEntrega = it.lugarEntrega
				else
				  solicitudPartidaInstance.lugarEntrega = almacen
				
				
				if(!solicitudPartidaInstance.save(flush:true)){
					log.error("NO SE PUDO GUARDAR UNA PARTIDA: "+solicitudPartidaInstance.errors)
				}
				
			}
		}
		
		if (!solicitudInstance.save(flush: true)) {
			render(view: "create", model: [solicitudInstance: solicitudInstance])
			return
		}
		
		
		try {
				log.debug "enviando correo a: ${ConfGeneral.findByName("mail_foranea").value} con los datos...."
				sendMail {
					to ConfGeneral.findByName("mail_foranea").value
//					cc "javazquez@koomoni.com"
					subject "CHAMPION SOLICITUDES :: Nueva solicitud"
					body (view:"/layouts/correoSolicitud",
						 model:[idsol:solicitudInstance.id, correoTitulo:"Alta de Solicitud",
								 mensajeCorreo:"Se ha dado de alta una nueva solicitud",
								fechaCreacion:  solicitudInstance.fechaCreacionSolicitud.format('dd/MM/yyyy HH:mm:ss')   ,
								folio:solicitudInstance.contPorZona+"-"+solicitudInstance.lugarEntrega.id,
								fechaSolicito:solicitudInstance.fechaAreaAdm.format('dd/MM/yyyy HH:mm:ss'),
								contrato:solicitudInstance.contrato.numContrato,
								usuarioCreo:solicitudInstance.usuarioCreo.getNombreCompleto(),
								lugarEntrega:solicitudInstance.lugarEntrega.descripcion,
								mensajeLink:"Para ver la nueva solicitud", textoLink:"Ver solicitud"])
				 }
				
				
		} catch (Exception e) {
			log.error("NO SE PUDO ENVIAR EL CORREO DE NUEVA SOLICITUD")
			e.printStackTrace()
		}
		

		flash.message = message(code: 'default.created.message', args: [message(code: 'solicitud.label', default: 'Solicitud'), solicitudInstance.id])
//        redirect(action: "show", id: solicitudInstance.id)
		redirect(action: "list")
	}

	def show(Long id) {
		def solicitudInstance = Solicitud.get(id)
		if (!solicitudInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'solicitud.label', default: 'Solicitud'), id])
			redirect(action: "list")
			return
		}

		[solicitudInstance: solicitudInstance]
	}

	@Secured(['ROLE_ADMIN','ROLE_SOLICITUD_EDIT'])
	def edit(Long id) {
		def solicitudInstance = Solicitud.get(id)
		if (!solicitudInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'solicitud.label', default: 'Solicitud'), id])
			redirect(action: "list")
			return
		}

		[solicitudInstance: solicitudInstance]
	}

	@Secured(['ROLE_ADMIN','ROLE_SOLICITUD_EDIT'])
	def update(Long id, Long version) {
		def solicitudInstance = Solicitud.get(id)
		if (!solicitudInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'solicitud.label', default: 'Solicitud'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (solicitudInstance.version > version) {
				solicitudInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'solicitud.label', default: 'Solicitud')] as Object[],
						  "Another user has updated this Solicitud while you were editing")
				render(view: "edit", model: [solicitudInstance: solicitudInstance])
				return
			}
		}

		solicitudInstance.properties = params

		if (!solicitudInstance.save(flush: true)) {
			render(view: "edit", model: [solicitudInstance: solicitudInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'solicitud.label', default: 'Solicitud'), solicitudInstance.id])
		redirect(action: "show", id: solicitudInstance.id)
	}

	@Secured(['ROLE_ADMIN','ROLE_SOLICITUD_DELETE'])
	def delete(Long id) {
		def solicitudInstance = Solicitud.get(id)
		if (!solicitudInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'solicitud.label', default: 'Solicitud'), id])
			redirect(action: "list")
			return
		}

		try {
			solicitudInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'solicitud.label', default: 'Solicitud'), id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'solicitud.label', default: 'Solicitud'), id])
			redirect(action: "show", id: id)
		}
	}
	
	/**
	 * Almacenara temporalmente una lista de proyectos mientras la solicitud no sea creada
	 * @return
	 */
	def tmpProyectos(){
		println "ID PROYECTO : "+params.proyid.toLong()
		println "ID TEMPORAL DE SOLICITUD : "+params.tmpID.toLong()
		println "PRORRATEO : "+params.prorrateo.toInteger()
		
		def proyectoInstance = Proyecto.get(params.proyid.toLong())
		def tmpProySolicitudList
		
		def tmpSolProyecto = TmpSolicitudProyecto.findByTmpProyectoIDAndIdProyecto( params.tmpID.toLong(), params.proyid.toLong())
		
		if (tmpSolProyecto) {
			log.info("Existe");
			tmpSolProyecto.prorrateo = params.prorrateo.toInteger()
		}else{
			tmpSolProyecto = new TmpSolicitudProyecto();
			tmpSolProyecto.idProyecto = params.proyid.toLong()
			tmpSolProyecto.tmpProyectoID = params.tmpID.toLong()
			tmpSolProyecto.prorrateo = params.prorrateo.toInteger()
			tmpSolProyecto.nombre = proyectoInstance.nombre
			tmpSolProyecto.tipoProyecto = proyectoInstance.tipoProyecto
			tmpSolProyecto.responsable = proyectoInstance.responsable.nombres
		}
		
		try {
			if(!tmpSolProyecto.save(flush: true)){
				log.error(message(code: 'solicitud.proyecto.add.error'))
				log.error(tmpSolProyecto.getErrors())
			}
			
			tmpProySolicitudList = TmpSolicitudProyecto.findAllByTmpProyectoID(tmpSolProyecto.tmpProyectoID)
			
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			log.error( e.getMessage() );
			render(contentType: 'text/json'){
				result success:false,code:'ERROR',message:message(code: 'solicitud.proyecto.add.error')
			}
			return
		}
		
		
		render(contentType: 'text/json'){
			result success:true,code:'OK', tmpProySolicitudList:tmpProySolicitudList, tmpProySolicitudTotal : tmpProySolicitudList.size()
		}
	}
	
	def delTmpProyectos(){
		println "ID PROYECTO : "+params.proyid.toLong()
		println "ID TEMPORAL DE SOLICITUD : "+params.tmpID.toLong()
		
		def tmpSolProyecto = TmpSolicitudProyecto.findByTmpProyectoIDAndIdProyecto( params.tmpID.toLong(), params.proyid.toLong())
		tmpSolProyecto.delete(flush: true)
		
		def tmpProySolicitudList = TmpSolicitudProyecto.findAllByTmpProyectoID(tmpSolProyecto.tmpProyectoID)
		
		render(contentType: 'text/json'){
			result success:true,code:'OK', tmpProySolicitudList:tmpProySolicitudList, tmpProySolicitudTotal : tmpProySolicitudList.size()
		}
	}
	
	/**
	 * Guardara temporalmente los archivos del programa asociado a la solicitud
	 * @return
	 */
	def saveTmpProgramaFiles(){
		println "idSol::"+params.idSol;
		println "Observaciones::"+params.obs_programa
		
		def pathTmp = grailsApplication.config.path.files.tmp.solicitudes
		 
		def tmpPrograma = TmpSolicitudPrograma.findByTmpProyectoID(  params.idSol.toLong() ) ?: new TmpSolicitudPrograma()
		tmpPrograma.tmpProyectoID = params.idSol.toLong()
		
		//Guardando observaciones
		if(params.obs_programa){
			tmpPrograma.obsPrograma = params.obs_programa
		}
		
		//Obteniendo los archivos de programa
		def mantFile = request.getFile('arch_mantenimiento')
		def insFile  = request.getFile('arch_instalacion')
		def desFile  = request.getFile('arch_desinstalacion')
		def evalFile = request.getFile('arch_eval')
		def inyFile	 = request.getFile('arch_inyeccion')
		
		
		//GUARDANDO EN UNA RUTA TEMPORAL
		if(!mantFile.empty){
			mantFile.transferTo( new File( pathTmp+"${tmpPrograma.tmpProyectoID}_"+mantFile.getOriginalFilename() ) )
			tmpPrograma.pathMant = "${tmpPrograma.tmpProyectoID}_"+mantFile.getOriginalFilename()
		}else{}
		
		if(!insFile.empty){
			insFile.transferTo( new File( pathTmp+"${tmpPrograma.tmpProyectoID}_"+insFile.getOriginalFilename() ) )
			tmpPrograma.pathInstal = "${tmpPrograma.tmpProyectoID}_"+insFile.getOriginalFilename()
		}else{}
		
		
		if(!desFile.empty){
			desFile.transferTo(new File( pathTmp+"${tmpPrograma.tmpProyectoID}_"+desFile.getOriginalFilename() ) )
			tmpPrograma.pathDesin = "${tmpPrograma.tmpProyectoID}_"+desFile.getOriginalFilename()
		}else{}
		
		
		if(!evalFile.empty){
			evalFile.transferTo( new File( pathTmp+"${tmpPrograma.tmpProyectoID}_"+evalFile.getOriginalFilename() ) )
			tmpPrograma.pathEval = "${tmpPrograma.tmpProyectoID}_"+evalFile.getOriginalFilename()
		}else{}
			
		
		if(!inyFile.empty){
			inyFile.transferTo( new File( pathTmp+"${tmpPrograma.tmpProyectoID}_"+inyFile.getOriginalFilename() ) )
			tmpPrograma.pathIny = "${tmpPrograma.tmpProyectoID}_"+inyFile.getOriginalFilename()
		}else{}
		
		
		//GUARDANDO EN LA TABLA TEMPORAL DE PROGRAMA
		if(!tmpPrograma.save(flush: true)){
			log.error("Error al guardar en la DB"+tmpPrograma.errors)
			render(contentType: 'text/json'){
				result success:true,code:'ERROR', message:'Error al guardar en la DB'
			}
			return
		}
		
		
		//REGRESAR RESPUESTA POR JSON
		render(contentType: 'text/json'){
			result success:true,code:'OK', message:'todo re bien boluudo', tmpPrograma:tmpPrograma
		}
	}
	
	
	def downloadProgramaTMP(){
		def tmpPrograma = TmpSolicitudPrograma.findByTmpProyectoID(params.idtmpfile)
		def path = grailsApplication.config.path.files.tmp.solicitudes
		def file
		
		log.debug("Buscando el archivo de "+params.tipoTmpFile.trim()+" para la solicitud temporal "+tmpPrograma)
		
		switch(params.tipoTmpFile.trim()){
			case "pathMant":
				log.debug(path+tmpPrograma.pathMant)
				file = new File(path+tmpPrograma.pathMant)
				break
			case "pathInstal":
				file = new File(path+tmpPrograma.pathInstal)
				break
			case "pathDesin":
				file = new File(path+tmpPrograma.pathDesin)
				break
			case "pathEval":
				file = new File(path+tmpPrograma.pathEval)
				break
			case "pathIny":
				file = new File(path+tmpPrograma.pathIny)
				break
		}
			
		
		try {
			response.setContentType("application/octet-stream")
			response.setHeader("Content-disposition", "attachment;filename=${file.getName()}")
			
			response.outputStream << file.newInputStream()
		} catch (Exception e) {
			log.error("Ha ocurrido un error al obtener el archivo: "+ e.getMessage())
			//e.printStackTrace()
		}
		
		return false;
	}
	
	def downloadPrograma(){
		def solicitudInstance = Solicitud.get(params.id)
		def path = grailsApplication.config.path.files.programa.solicitudes
		def file
		
		log.debug("Buscando el archivo de "+params.tipoFile.trim()+" para la solicitud "+solicitudInstance.id)
		
		switch(params.tipoFile.trim()){
			case "pathMant":
				log.debug(path+solicitudInstance.pathMant)
				file = new File(path+solicitudInstance.pathMant)
				break
			case "pathInstal":
				file = new File(path+solicitudInstance.pathInstal)
				break
			case "pathDesin":
				file = new File(path+solicitudInstance.pathDesin)
				break
			case "pathEval":
				file = new File(path+solicitudInstance.pathEval)
				break
			case "pathIny":
				file = new File(path+solicitudInstance.pathIny)
				break
		}
			
		
		try {
			response.setContentType("application/octet-stream")
			response.setHeader("Content-disposition", "attachment;filename=${file.getName()}")
			
			response.outputStream << file.newInputStream()
		} catch (Exception e) {
			log.error("Ha ocurrido un error al obtener el archivo: "+ e.getMessage())
			//e.printStackTrace()
		}
		
		return false;
	}
	
	def saveStockList(){
		log.debug("ID TEMPORAL SOLICITUD: "+params.idSol)
		log.debug("CVE PRODUCTO: "+	params.cveProducto)
		log.debug("CVE ALMACEN: "+	params.cveAlmacen)
		log.debug("CANTIDAD: "+	params.cantidad)
		
		def client = new SOAPClient(grailsApplication.config.ws.almacen)
		def sAlmacen = new AlmacenService();
		def filtro = new InventarioFC();
		def prodDTO = new ProductosDTO();
		def stock = TmpSolicitudStock.findByTmpProyectoIDAndCveProducto(params.idSol.toLong(),params.cveProducto);
		
		if(!stock){
			stock = new TmpSolicitudStock()
		}
		
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
		
		//obteniendo datos del post
		filtro.setClaveAlmacen(params.cveAlmacen!=null?params.cveAlmacen:"");
		filtro.setClaveProducto(params.cveProducto!=null?params.cveProducto:"");
		
		prodDTO = sAlmacen.getStockProducto(filtro, client)
		ProductoDTO producto = prodDTO.productos.get(0)
		
		stock.setTmpProyectoID(params.idSol.toLong())
		stock.setCveProducto(producto.getClave())
		stock.setNombreProducto(producto.getDescripcion())
		stock.setCveAlmacen(producto.getClaveAlmacen().toInteger())
		stock.setCantidad(params.cantidad.toInteger())
		
		if(!stock.save(flush:true)){
			log.info(stock.getErrors())
		}
		
		log.debug("Se ha guardado el producto ${stock.nombreProducto} con el id ${stock.id}")
		//redirect(action:'tmpStockSolicitudList',params:params);
		render(contentType: 'text/json'){
			result success:true,code:'OK', message:"Se ha guardado el producto ${stock.nombreProducto} con el id ${stock.id}"
		}
	}
	
	def deleteStockList(){
		log.debug("EL ID: "+params)
		def stock = TmpSolicitudStock.findByTmpProyectoIDAndCveProducto(params.tmpProyectoID, params.cveProducto)
		if(stock){
			
			try {
				stock.delete(flush:true)
				//redirect(view:'tmpStockSolicitudList',params:params)
			} catch (DataIntegrityViolationException e) {
				log.error(e.getMessage())
				render(contentType: 'text/json'){
					result success:true,code:'ERROR', message:'No se pudo eliminar el registro'
				}
			}
			
		}
		
		render(contentType: 'text/json'){
			result success:true,code:'OK', message:'Se ha eliminado el registro'
		}
		
	}
	
	def tmpStockSolicitudList(Long idSolStock){
		def stockList = TmpSolicitudStock.findAllByTmpProyectoID( params.idSolStock.toLong() )
		[stockList:stockList]
	}
	
	/**
	 * Obtiene el stock de un producto
	 * @return
	 */
	def searchStock(){
		log.debug("BUSCANDO PRODUCTOS");
		
		def client = new SOAPClient(grailsApplication.config.ws.producto)
		def sProducto = new ProductosService();
		def filtro = new ProductoFC();
		def prodDTO = new ProductosDTO();
		
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
		
		//obteniendo datos del post
		filtro.setClaveAlterna(params.cveSearch!=null?params.cveSearch:"");
		filtro.setClave(params.cveSearch!=null?params.cveSearch:"");
		filtro.setDescripcion(params.descSearch!=null?params.descSearch:"");
		
		
		prodDTO = sProducto.searchProductos(client, filtro)
		
		log.debug("PRODUCTOS ENCONTRADOS: "+prodDTO.productos.size())
		
		render(view:"listProductos", model:[productos:prodDTO])
		
	}
	
	/**
	 * Agrega una partida nueva a una solicitud
	 * @return
	 */
	def addTmpPartida(){
		log.debug("Solicitud-> "+params.tmpProyectoID)
		log.debug("Clave Producto-> "+params.claveProducto)
		log.debug("Descripcion-> "+params.desc)
		
		def partidaInstance = TmpSolicitudPartida.findByTmpProyectoIDAndCveProducto( params.tmpProyectoID.toLong(),params.claveProducto)
		
		if(!partidaInstance){
			partidaInstance = new TmpSolicitudPartida()
			partidaInstance.tmpProyectoID = params.tmpProyectoID.toLong()
			partidaInstance.cveProducto = params.claveProducto
			partidaInstance.cantidad = 0
			if (params.lugarentrega_selected_id)
			   partidaInstance.lugarEntrega = Almacen.findById(params.lugarentrega_selected_id)
		}
		
		def client = new SOAPClient(grailsApplication.config.ws.producto)
		def sProducto = new ProductosService();
		def filtro = new ProductoFC();
		def prodDTO = new ProductosDTO();
		
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
		
		//obteniendo datos del post
		filtro.setClave(params.claveProducto!=null?params.claveProducto:"");
		
		
		prodDTO = sProducto.searchProductos(client, filtro)
		prodDTO.productos.each {p->
			partidaInstance.descProducto = p.descripcion
		}
		
		partidaInstance.unidad = params.medida.toString().toUpperCase();
		
		if(!partidaInstance.save(flush:true)){
			log.error(partidaInstance.getErrors().toString())
		}
		def partidas=TmpSolicitudPartida.findAllByTmpProyectoID(partidaInstance.tmpProyectoID)
		render view:"listPartidas", model:[partidas:partidas]
		
		
		
		
	}
	
	def addCantidadTmpPartida(){
		log.debug("Solicitud-> "+params.tmpProyectoID)
		log.debug("Clave Producto-> "+params.claveProducto)
		
		def partidaInstance = TmpSolicitudPartida.findByTmpProyectoIDAndCveProducto( params.tmpProyectoID.toLong(),params.claveProducto)
		println partidaInstance
		if(partidaInstance){
			partidaInstance.cantidad = params.cantidad.toFloat()
			
			if(!partidaInstance.save(flush:true)){
				log.error(partidaInstance.getErrors().toString())
			}
			
		}
		
		render(view:"listPartidas", model:[partidas:TmpSolicitudPartida.findAllByTmpProyectoID(partidaInstance.tmpProyectoID)])
	}
	
	def delCantidadTmpPartida(){
		log.debug("Solicitud-> "+params.tmpProyectoID)
		log.debug("Clave Producto-> "+params.claveProducto)
		
		def partidaInstance = TmpSolicitudPartida.findByTmpProyectoIDAndCveProducto( params.tmpProyectoID.toLong(),params.claveProducto)
		if(partidaInstance){
			try {
				partidaInstance.delete(flush:true)
			} catch (DataIntegrityViolationException e) {
				e.printStackTrace()
			}
		}
		
		render(view:"listPartidas", model:[partidas:TmpSolicitudPartida.findAllByTmpProyectoID(params.tmpProyectoID)])
	}
	
	/**
	 * Solo se modifica a 1 o 2, abierta o revision, el estatus 3 cotizacion se modificara automaticamente
	 * @return
	 */
	def cambiaEstatusSolicitud(){
		log.debug(params)
		
		def solicitudInstance = Solicitud.get(params.idsolicitud)
		
		if(solicitudInstance){
			solicitudInstance.estatus = params.estatus.toInteger() //(params.estatus == '2')?params.estatus.toInteger():(params.estatus==4?params.estatus.toInteger():2)
			solicitudInstance.save(flush:true)
		}
		
		render "Estatus modificado"
	}
	
	def searchSolicitud(Integer max){
		log.debug(params)
		StringBuilder qry = new StringBuilder()
		params.max = Math.min(max ?: 10, 100)
		
		if(params.pbuscar && params.pbuscar.length()>0){
			
			log.debug(params.pbuscar)
			def folio = params.pbuscar.trim().split('-')
			log.debug("folio ${folio} tamano ${folio.length}")
			
			if(folio.length>1){
				log.debug(folio[0].isNumber())
				log.debug(folio[1].isNumber())
			}
			
			qry.append("FROM Solicitud WHERE")
				.append(" contrato.numContrato like '%${params.pbuscar.trim()}%' ")
				.append("OR lugarEntrega.descripcion like '%${params.pbuscar.trim()}%' ")
			if( folio.length>1 && (folio[0].isNumber()&&folio[1].isNumber()) )
				qry.append("OR (contPorZona = ${folio[0]} AND usuarioCreo.zona.id = ${folio[1]}) ")
			
			qry.append(" and estatus != 4 order by id desc")
			
			def solicitudInstanceList = Solicitud.findAll(qry.toString(),[max: params.max, offset: params.offset?params.offset.toInteger():0])
			def solicitudInstanceTotal = Solicitud.executeQuery("SELECT COUNT(*) "+qry.toString())
			log.debug(solicitudInstanceTotal)
			
			render template:'listRemote', model:[solicitudInstanceList: solicitudInstanceList, solicitudInstanceTotal: solicitudInstanceTotal[0],
				 pbuscar:params.pbuscar]
			
		}else{
			def solicitudInstanceList = Solicitud.findAllByEstatusNotEqual(4,[max: params.max, offset: params.offset?params.offset.toInteger():0])
			def solicitudInstanceTotal = Solicitud.findAllByEstatusNotEqual(4).size()
			render template:'listRemote', model:[solicitudInstanceList: solicitudInstanceList, solicitudInstanceTotal: solicitudInstanceTotal,
				pbuscar:params.pbuscar]
		}
		
		
	}
	
}
