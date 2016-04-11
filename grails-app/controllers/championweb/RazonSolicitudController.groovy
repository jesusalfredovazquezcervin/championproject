package championweb

import org.springframework.dao.DataIntegrityViolationException

class RazonSolicitudController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [razonSolicitudInstanceList: RazonSolicitud.list(params), razonSolicitudInstanceTotal: RazonSolicitud.count()]
    }

    def create() {
        [razonSolicitudInstance: new RazonSolicitud(params)]
    }

    def save() {
        def razonSolicitudInstance = new RazonSolicitud(params)
        if (!razonSolicitudInstance.save(flush: true)) {
            render(view: "create", model: [razonSolicitudInstance: razonSolicitudInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'razonSolicitud.label', default: 'RazonSolicitud'), razonSolicitudInstance.id])
        redirect(action: "show", id: razonSolicitudInstance.id)
    }

    def show(Long id) {
        def razonSolicitudInstance = RazonSolicitud.get(id)
        if (!razonSolicitudInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'razonSolicitud.label', default: 'RazonSolicitud'), id])
            redirect(action: "list")
            return
        }

        [razonSolicitudInstance: razonSolicitudInstance]
    }

    def edit(Long id) {
        def razonSolicitudInstance = RazonSolicitud.get(id)
        if (!razonSolicitudInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'razonSolicitud.label', default: 'RazonSolicitud'), id])
            redirect(action: "list")
            return
        }

        [razonSolicitudInstance: razonSolicitudInstance]
    }

    def update(Long id, Long version) {
        def razonSolicitudInstance = RazonSolicitud.get(id)
        if (!razonSolicitudInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'razonSolicitud.label', default: 'RazonSolicitud'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (razonSolicitudInstance.version > version) {
                razonSolicitudInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'razonSolicitud.label', default: 'RazonSolicitud')] as Object[],
                          "Another user has updated this RazonSolicitud while you were editing")
                render(view: "edit", model: [razonSolicitudInstance: razonSolicitudInstance])
                return
            }
        }

        razonSolicitudInstance.properties = params

        if (!razonSolicitudInstance.save(flush: true)) {
            render(view: "edit", model: [razonSolicitudInstance: razonSolicitudInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'razonSolicitud.label', default: 'RazonSolicitud'), razonSolicitudInstance.id])
        redirect(action: "show", id: razonSolicitudInstance.id)
    }

    def delete(Long id) {
        def razonSolicitudInstance = RazonSolicitud.get(id)
        if (!razonSolicitudInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'razonSolicitud.label', default: 'RazonSolicitud'), id])
            redirect(action: "list")
            return
        }

        try {
            razonSolicitudInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'razonSolicitud.label', default: 'RazonSolicitud'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'razonSolicitud.label', default: 'RazonSolicitud'), id])
            redirect(action: "show", id: id)
        }
    }
}
