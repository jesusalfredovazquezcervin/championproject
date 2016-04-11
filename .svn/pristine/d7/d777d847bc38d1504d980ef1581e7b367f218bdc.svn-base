package championweb

import org.springframework.dao.DataIntegrityViolationException

class ObservacionesContratoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [observacionesContratoInstanceList: ObservacionesContrato.list(params), observacionesContratoInstanceTotal: ObservacionesContrato.count()]
		
    }
	
	def listByContrato() {
		def contratoInstance = Contrato.get(params.contrato.id)
		def observacionesContratoList = ObservacionesContrato.findAllByContrato(contratoInstance,[sort:"fecha", order:"desc"])
		[observacionesContratoInstanceList: observacionesContratoList]
		
	}

    def create() {
        [observacionesContratoInstance: new ObservacionesContrato(params)]
    }

    def save() {
        def observacionesContratoInstance = new ObservacionesContrato(params)
        if (!observacionesContratoInstance.save(flush: true)) {
            render(view: "create", model: [observacionesContratoInstance: observacionesContratoInstance])
            return
        }

//		flash.message = message(code: 'observacionesContrato.updated.message.created.message', args: [message(code: 'observacionesContrato.label', default: 'ObservacionesContrato'), observacionesContratoInstance.id])
//		redirect(action:"listByContrato", params:["contrato.id" : observacionesContratoInstance.contrato.id])
		
		render(contentType: 'text/json'){
			result success:true, code:'Se ha creado la observaci—n ',id: observacionesContratoInstance.contrato.id
			}
		return
    }

    def show() {
        def observacionesContratoInstance = ObservacionesContrato.get(params.id)
        if (!observacionesContratoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'observacionesContrato.label', default: 'ObservacionesContrato'), params.id])
            redirect(action: "list")
            return
        }

        [observacionesContratoInstance: observacionesContratoInstance]
    }

    def edit() {
        def observacionesContratoInstance = ObservacionesContrato.get(params.id)
        if (!observacionesContratoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'observacionesContrato.label', default: 'ObservacionesContrato'), params.id])
            redirect(action: "list")
            return
        }

        [observacionesContratoInstance: observacionesContratoInstance]
    }

    def update() {
        def observacionesContratoInstance = ObservacionesContrato.get(params.id)
        if (!observacionesContratoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'observacionesContrato.label', default: 'ObservacionesContrato'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (observacionesContratoInstance.version > version) {
                observacionesContratoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'observacionesContrato.label', default: 'ObservacionesContrato')] as Object[],
                          "Another user has updated this ObservacionesContrato while you were editing")
                render(view: "edit", model: [observacionesContratoInstance: observacionesContratoInstance])
                return
            }
        }

        observacionesContratoInstance.properties = params

        if (!observacionesContratoInstance.save(flush: true)) {
            render(view: "edit", model: [observacionesContratoInstance: observacionesContratoInstance])
            return
        }

		flash.message = message(code: 'observacionesContrato.updated.message', args: [message(code: 'observacionesContrato.label', default: 'ObservacionesContrato'), observacionesContratoInstance.id])
        redirect(action: "show", id: observacionesContratoInstance.id)
    }

    def delete() {
        def observacionesContratoInstance = ObservacionesContrato.get(params.id)
        if (!observacionesContratoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'observacionesContrato.label', default: 'ObservacionesContrato'), params.id])
            redirect(action: "list")
            return
        }

        try {
            observacionesContratoInstance.delete(flush: true)
			flash.message = message(code: 'observacionesContrato.deleted.message', args: [message(code: 'observacionesContrato.label', default: 'ObservacionesContrato'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'observacionesContrato.label', default: 'ObservacionesContrato'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
