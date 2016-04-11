package championweb

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.annotation.Secured;


@Secured(['ROLE_ADMIN','ROLE_RECEPTOR_CREATE','ROLE_RECEPTOR_EDIT','ROLE_RECEPTOR_DELETE'])
class ReceptorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [receptorInstanceList: Receptor.list(params), receptorInstanceTotal: Receptor.count()]
    }

	@Secured(['ROLE_ADMIN','ROLE_RECEPTOR_CREATE'])
    def create() {
        [receptorInstance: new Receptor(params)]
    }

	@Secured(['ROLE_ADMIN','ROLE_RECEPTOR_CREATE'])
    def save() {
        def receptorInstance = new Receptor(params)
        if (!receptorInstance.save(flush: true)) {
            render(view: "create", model: [receptorInstance: receptorInstance])
            return
        }

		flash.message = message(code: 'receptor.created.message', args: [message(code: 'receptor.label', default: 'Receptor'), receptorInstance.id])
        redirect(action: "show", id: receptorInstance.id)
    }

    def show() {
        def receptorInstance = Receptor.get(params.id)
        if (!receptorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'receptor.label', default: 'Receptor'), params.id])
            redirect(action: "list")
            return
        }

        [receptorInstance: receptorInstance]
    }

	@Secured(['ROLE_ADMIN','ROLE_RECEPTOR_EDIT'])
    def edit() {
        def receptorInstance = Receptor.get(params.id)
        if (!receptorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'receptor.label', default: 'Receptor'), params.id])
            redirect(action: "list")
            return
        }

        [receptorInstance: receptorInstance]
    }

	@Secured(['ROLE_ADMIN','ROLE_RECEPTOR_EDIT'])
    def update() {
        def receptorInstance = Receptor.get(params.id)
        if (!receptorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'receptor.label', default: 'Receptor'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (receptorInstance.version > version) {
                receptorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'receptor.label', default: 'Receptor')] as Object[],
                          "Another user has updated this Receptor while you were editing")
                render(view: "edit", model: [receptorInstance: receptorInstance])
                return
            }
        }

        receptorInstance.properties = params

        if (!receptorInstance.save(flush: true)) {
            render(view: "edit", model: [receptorInstance: receptorInstance])
            return
        }

		flash.message = message(code: 'receptor.success.update', args: [message(code: 'receptor.label', default: 'Receptor'), receptorInstance.id])
        redirect(action: "show", id: receptorInstance.id)
    }

	@Secured(['ROLE_ADMIN','ROLE_RECEPTOR_DELETE'])
    def delete() {
        def receptorInstance = Receptor.get(params.id)
        if (!receptorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'receptor.label', default: 'Receptor'), params.id])
            redirect(action: "list")
            return
        }

        try {
            receptorInstance.delete(flush: true)
			flash.message = message(code: 'receptor.deleted.message', args: [message(code: 'receptor.label', default: 'Receptor'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'receptor.label', default: 'Receptor'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def getListAjax(){
		def receptorList = Receptor.findAll("FROM Receptor WHERE nombres LIKE '%${params.preceptor}%' OR apellidoP LIKE '%${params.preceptor}%' OR apellidoM LIKE '%${params.preceptor}%'")
		def receptorTotal = receptorList.size();
		
		render(contentType: 'text/json'){
			result success:true,code:'OK', receptorList:receptorList, receptorTotal:receptorTotal
		}
		 
	}
	
	def getByIdAjax(){
		def receptorInstance = Receptor.get(params.id)
		 
		render(contentType: 'text/json'){
			result success:true,code:'OK', receptorInstance:receptorInstance
		}
	}
}
