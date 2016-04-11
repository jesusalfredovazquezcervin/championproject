package championweb

import org.springframework.dao.DataIntegrityViolationException

import org.apache.commons.logging.LogFactory;

class ExtContratoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	private static final log = LogFactory.getLog(this);
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
//        [extContratoInstanceList: ExtContrato.list(params), extContratoInstanceTotal: ExtContrato.count()]
		[extContratoInstanceList: ExtContrato.findAll("from ExtContrato WHERE contrato.id = ${params.contrato.id} order by fechaInicial desc"),
			extContratoInstanceTotal: ExtContrato.count()]
    }

    def create() {
        [extContratoInstance: new ExtContrato(params)]
    }

    def save() {
        def extContratoInstance = new ExtContrato(params)
        if (!extContratoInstance.save(flush: true)) {
            render(view: "create", model: [extContratoInstance: extContratoInstance])
            return
        }
		
		render(contentType: 'text/json'){
			result success:true, code:'Se ha creado la extensi—n ',id: extContratoInstance.id
			}
		return
		//flash.message = message(code: 'default.created.message', args: [message(code: 'extContrato.label', default: 'ExtContrato'), extContratoInstance.id])
		//redirect(action: "show", id: extContratoInstance.id)
    }

    def show() {
        def extContratoInstance = ExtContrato.get(params.id)
        if (!extContratoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'extContrato.label', default: 'ExtContrato'), params.id])
            redirect(action: "list")
            return
        }

        [extContratoInstance: extContratoInstance]
    }

    def edit() {
        def extContratoInstance = ExtContrato.get(params.id)
        if (!extContratoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'extContrato.label', default: 'ExtContrato'), params.id])
            redirect(action: "list")
            return
        }

        [extContratoInstance: extContratoInstance]
    }

    def update() {
        def extContratoInstance = ExtContrato.get(params.id)
        if (!extContratoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'extContrato.label', default: 'ExtContrato'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (extContratoInstance.version > version) {
                extContratoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'extContrato.label', default: 'ExtContrato')] as Object[],
                          "Another user has updated this ExtContrato while you were editing")
                render(view: "edit", model: [extContratoInstance: extContratoInstance])
                return
            }
        }

        extContratoInstance.properties = params

        if (!extContratoInstance.save(flush: true)) {
            render(view: "edit", model: [extContratoInstance: extContratoInstance])
            return
        }

		flash.message = message(code: 'extContrato.updated.message', args: [message(code: 'extContrato.label', default: 'ExtContrato'), extContratoInstance.id])
        redirect(action: "show", id: extContratoInstance.id)
    }

    def delete() {
        def extContratoInstance = ExtContrato.get(params.id)
        if (!extContratoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'extContrato.label', default: 'ExtContrato'), params.id])
            //redirect(action: "list")
            return
        }

        try {
            extContratoInstance.delete(flush: true)
			//flash.message = message(code: 'extContrato.deleted.message', args: [message(code: 'extContrato.label', default: 'ExtContrato'), params.id])
			render(contentType: 'text/json'){
				result success:true, code:"${message(code:'extContrato.deleted.message')}",id: extContratoInstance.id
				}
			return
			//redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'extContrato.label', default: 'ExtContrato'), params.id])
			return
			//redirect(action: "show", id: params.id)
        }
    }
}
