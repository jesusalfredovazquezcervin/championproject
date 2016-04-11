package championweb

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.annotation.Secured;


@Secured(['ROLE_ADMIN','ROLE_RESPONSABLE_CREATE','ROLE_RESPONSABLE_EDIT','ROLE_RESPONSABLE_DELETE'])
class ResponsableController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [responsableInstanceList: Responsable.list(params), responsableInstanceTotal: Responsable.count()]
    }

	@Secured(['ROLE_ADMIN','ROLE_RESPONSABLE_CREATE'])
    def create() {
        [responsableInstance: new Responsable(params)]
    }

	@Secured(['ROLE_ADMIN','ROLE_RESPONSABLE_CREATE'])
    def save() {
        def responsableInstance = new Responsable(params)
        if (!responsableInstance.save(flush: true)) {
            render(view: "create", model: [responsableInstance: responsableInstance])
            return
        }

		flash.message = message(code: 'responsable.create.success', args: [message(code: 'responsable.label', default: responsableInstance.nombres), responsableInstance.id])
        redirect(action: "show", id: responsableInstance.id)
    }

    def show() {
        def responsableInstance = Responsable.get(params.id)
        if (!responsableInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'responsable.label', default: 'Responsable'), params.id])
            redirect(action: "list")
            return
        }

        [responsableInstance: responsableInstance]
    }

	@Secured(['ROLE_ADMIN','ROLE_RESPONSABLE_EDIT'])
    def edit() {
        def responsableInstance = Responsable.get(params.id)
        if (!responsableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'responsable.label', default: 'Responsable'), params.id])
            redirect(action: "list")
            return
        }

        [responsableInstance: responsableInstance]
    }

	@Secured(['ROLE_ADMIN','ROLE_RESPONSABLE_EDIT'])
    def update() {
        def responsableInstance = Responsable.get(params.id)
        if (!responsableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'responsable.label', default: 'Responsable'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (responsableInstance.version > version) {
                responsableInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'responsable.label', default: 'Responsable')] as Object[],
                          "Another user has updated this Responsable while you were editing")
                render(view: "edit", model: [responsableInstance: responsableInstance])
                return
            }
        }

        responsableInstance.properties = params

        if (!responsableInstance.save(flush: true)) {
            render(view: "edit", model: [responsableInstance: responsableInstance])
            return
        }

		flash.message = message(code: 'responsable.updated.message', args: [message(code: 'responsable.label', default: 'Responsable'), responsableInstance.id])
        redirect(action: "show", id: responsableInstance.id)
    }

	@Secured(['ROLE_ADMIN','ROLE_RESPONSABLE_DELETE'])
    def delete() {
        def responsableInstance = Responsable.get(params.id)
        if (!responsableInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'responsable.label', default: 'Responsable'), params.id])
            redirect(action: "list")
            return
        }

        try {
            responsableInstance.delete(flush: true)
			flash.message = message(code: 'responsables.deleted.message', args: [message(code: 'responsable.label', default: 'Responsable'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'responsable.label', default: 'Responsable'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
