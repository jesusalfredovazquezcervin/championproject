package championweb

import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.CriteriaSpecification;
import grails.plugin.springsecurity.annotation.Secured;

@Secured(['ROLE_ADMIN','ROLE_PROYECTO_CREATE','ROLE_PROYECTO_EDIT','ROLE_PROYECTO_DELETE'])
class ProyectoController {

	private static final log = LogFactory.getLog(this);
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
		log.debug("Parametro de busqueda: "+params.pbusqueda)
		
		def proyectosList
		def offsetp = params.offset!=null?params.offset.toInteger():0
		def maxp = params.max!=null?params.max.toInteger():10
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def proyectosListTotal
		
		if(params.pbusqueda){
			log.debug(params);
			def param = params.pbusqueda.toLowerCase()
				proyectosList = Proyecto.findAll("from Proyecto as p where LOWER(p.nombre) like '%${param}%'"
												+"OR LOWER(p.almacen.descripcion) like '%${param}%'"
												+"OR LOWER(p.zona.nombreZona) like '%${param}%' ",[offset:offsetp, max:maxp])
				proyectosListTotal = Proyecto.findAll("from Proyecto as p where LOWER(p.nombre) like '%${param}%'"
					+"OR LOWER(p.almacen.descripcion) like '%${param}%'"
					+"OR LOWER(p.zona.nombreZona) like '%${param}%' ")
		}else{
				proyectosList = Proyecto.list(params)
			}
			
        
        [proyectoInstanceList: proyectosList, proyectoInstanceTotal: params.pbusqueda?proyectosListTotal.size():Proyecto.count(), pbusqueda:params.pbusqueda]
    }

	
	def listByAjax() {
		log.debug("Parametro de busqueda: "+params.pbusqueda)
		
		def proyectosList
		def offsetp = params.offset!=null?params.offset.toInteger():0
		def maxp = params.max!=null?params.max.toInteger():10
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def proyectosListTotal
		
		if(params.pbusqueda){
			log.debug(params);
			def param = params.pbusqueda.toLowerCase()
				proyectosList = Proyecto.findAll("from Proyecto as p where LOWER(p.nombre) like '%${param}%'",[offset:offsetp, max:maxp])
				proyectosListTotal = Proyecto.findAll("from Proyecto as p where LOWER(p.nombre) like '%${param}%'")
				log.info("Se han encontrado: "+proyectosListTotal.size());
		}else{
			proyectosList = Proyecto.list(params)
			}
		
		log.info((Proyecto.list() as JSON))
		
		render(contentType: 'text/json'){
			result success:true,code:'OK',proyectoInstanceList: proyectosList, proyectoInstanceTotal: params.pbusqueda?proyectosListTotal.size():Proyecto.count(), pbusqueda:params.pbusqueda
		}	
//		return
		//[proyectoInstanceList: proyectosList, proyectoInstanceTotal: params.pbusqueda?proyectosListTotal.size():Proyecto.count(), pbusqueda:params.pbusqueda]
	}
	
	
	@Secured(['ROLE_ADMIN','ROLE_PROYECTO_CREATE'])
    def create() {
        [proyectoInstance: new Proyecto(params)]
    }

	@Secured(['ROLE_ADMIN','ROLE_PROYECTO_CREATE'])
    def save() {
        def proyectoInstance = new Proyecto(params)
        if (!proyectoInstance.save(flush: true)) {
            render(view: "create", model: [proyectoInstance: proyectoInstance])
            return
        }

		flash.message = message(code: 'proyecto.created.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), proyectoInstance.id])
        redirect(action: "show", id: proyectoInstance.id)
    }

    def show() {
        def proyectoInstance = Proyecto.get(params.id)
        if (!proyectoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), params.id])
            redirect(action: "list")
            return
        }

        [proyectoInstance: proyectoInstance]
    }
	
	def showByAjax(){
		def proyectoInstance = Proyecto.get(params.id)
        if (!proyectoInstance) {
			render(contentType: 'text/json'){
				result success:true,code:'ERROR',message: message(code: 'default.not.found.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), params.id])
			}
        }

        render(contentType: 'text/json'){
			result success:true,code:'OK',proyectoInstance: proyectoInstance
		}
	}

	@Secured(['ROLE_ADMIN','ROLE_PROYECTO_EDIT'])
    def edit() {
        def proyectoInstance = Proyecto.get(params.id)
        if (!proyectoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), params.id])
            redirect(action: "list")
            return
        }

        [proyectoInstance: proyectoInstance]
    }

	@Secured(['ROLE_ADMIN','ROLE_PROYECTO_EDIT'])
    def update() {
        def proyectoInstance = Proyecto.get(params.id)
        if (!proyectoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (proyectoInstance.version > version) {
                proyectoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'proyecto.label', default: 'Proyecto')] as Object[],
                          "Another user has updated this Proyecto while you were editing")
                render(view: "edit", model: [proyectoInstance: proyectoInstance])
                return
            }
        } 

        proyectoInstance.properties = params

        if (!proyectoInstance.save(flush: true)) {
            render(view: "edit", model: [proyectoInstance: proyectoInstance])
            return
        }

		flash.message = message(code: 'proyecto.updated.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), proyectoInstance.id])
        redirect(action: "show", id: proyectoInstance.id)
    }

	@Secured(['ROLE_ADMIN','ROLE_PROYECTO_DELETE'])
    def delete() {
        def proyectoInstance = Proyecto.get(params.id)
        if (!proyectoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), params.id])
            redirect(action: "list")
            return
        }

        try {
            proyectoInstance.delete(flush: true)
			flash.message = message(code: 'proyecto.deleted.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'proyecto.label', default: 'Proyecto'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
