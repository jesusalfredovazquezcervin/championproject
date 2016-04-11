package championweb

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.annotation.Secured;


@Secured(['ROLE_ADMIN','ROLE_ZONA_CREATE','ROLE_ZONA_EDIT','ROLE_ZONA_DELETE'])
class ZonaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [zonaInstanceList: Zona.list(params), zonaInstanceTotal: Zona.count()]
    }

	@Secured(['ROLE_ZONA_CREATE','ROLE_ADMIN'])
    def create() {
        [zonaInstance: new Zona(params)]
    }

	@Secured(['ROLE_ZONA_CREATE','ROLE_ADMIN'])
    def save() {
        def zonaInstance = new Zona(params)
        if (!zonaInstance.save(flush: true)) {
            render(view: "create", model: [zonaInstance: zonaInstance])
            return
        }

		flash.message = message(code: 'zona.create.success', args: [message(code: 'zona.label', default: zonaInstance.nombreZona), zonaInstance.id])
        redirect(action: "show", id: zonaInstance.id)
    }

    def show() {
        def zonaInstance = Zona.get(params.id)
        if (!zonaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'zona.label', default: 'Zona'), params.id])
            redirect(action: "list")
            return
        }

        [zonaInstance: zonaInstance]
    }

	@Secured(['ROLE_ZONA_EDIT','ROLE_ADMIN'])
    def edit() {
        def zonaInstance = Zona.get(params.id)
        if (!zonaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'zona.label', default: 'Zona'), params.id])
            redirect(action: "list")
            return
        }

        [zonaInstance: zonaInstance]
    }

	@Secured(['ROLE_ZONA_EDIT','ROLE_ADMIN'])
    def update() {
        def zonaInstance = Zona.get(params.id)
        if (!zonaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'zona.label', default: 'Zona'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (zonaInstance.version > version) {
                zonaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'zona.label', default: 'Zona')] as Object[],
                          "Another user has updated this Zona while you were editing")
                render(view: "edit", model: [zonaInstance: zonaInstance])
                return
            }
        }

        zonaInstance.properties = params

        if (!zonaInstance.save(flush: true)) {
            render(view: "edit", model: [zonaInstance: zonaInstance])
            return
        }

		flash.message = message(code: 'zona.updated.message', args: [message(code: 'zona.label', default: 'Zona'), zonaInstance.id])
        redirect(action: "show", id: zonaInstance.id)
    }

	@Secured(['ROLE_ZONA_DELETE','ROLE_ADMIN'])
    def delete() {
        def zonaInstance = Zona.get(params.id)
        if (!zonaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'zona.label', default: 'Zona'), params.id])
            redirect(action: "list")
            return
        }

        try {
            zonaInstance.delete(flush: true)
			flash.message = message(code: 'zona.deleted.message', args: [message(code: 'zona.label', default: 'Zona'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'zona.label', default: 'Zona'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
