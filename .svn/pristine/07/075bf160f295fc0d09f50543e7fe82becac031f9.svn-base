package championweb

import org.springframework.dao.DataIntegrityViolationException

import org.apache.commons.logging.LogFactory;


class RecoveryLinkController {
	private static final log = LogFactory.getLog(this);
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def beforeInterceptor = [action:this.&auth, except:["create","save"]]
	
	def auth(){
		if(!session.user) {
			redirect(uri: "/login")
			return false
		  }
		
		//TODO: VALIDAR PERFIL
	}

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [recoveryLinkInstanceList: RecoveryLink.list(params), recoveryLinkInstanceTotal: RecoveryLink.count()]
    }

    def create() {
        [recoveryLinkInstance: new RecoveryLink(params)]
    }

    def save() {
		def usuarioInstance = Usuario.findByUsuario(params.usuario)
		
			if(usuarioInstance){
				log.info("Usuario ${usuarioInstance.usuario} intentando recuperar su contrase–a")
				
				if(usuarioInstance.email.isEmpty()){
					log.info("El usuario ${usuarioInstance.usuario} no tiene un correo asigndo");
					flash.error = message(code: 'recoveryLink.user.eamail.notfound', args: [params.usuario])
				}else{
					def recoveryLinkInstance = RecoveryLink.findByUsuario(usuarioInstance)
				}
				
			}else{
				log.info("El usuario ${params.usuario} no existe, contacte al ‡rea de soporte")
				flash.error=message(code: 'recoveryLink.user.notfound', args: [params.usuario])
			}
		
			render(view:"create")
			return
		
//        def recoveryLinkInstance = new RecoveryLink(params)
//        if (!recoveryLinkInstance.save(flush: true)) {
//            render(view: "create", model: [recoveryLinkInstance: recoveryLinkInstance])
//            return
//        }
//
//		flash.message = message(code: 'default.created.message', args: [message(code: 'recoveryLink.label', default: 'RecoveryLink'), recoveryLinkInstance.id])
//        redirect(action: "show", id: recoveryLinkInstance.id)
    }

    def show() {
        def recoveryLinkInstance = RecoveryLink.get(params.id)
        if (!recoveryLinkInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'recoveryLink.label', default: 'RecoveryLink'), params.id])
            redirect(action: "list")
            return
        }

        [recoveryLinkInstance: recoveryLinkInstance]
    }

    def edit() {
        def recoveryLinkInstance = RecoveryLink.get(params.id)
        if (!recoveryLinkInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'recoveryLink.label', default: 'RecoveryLink'), params.id])
            redirect(action: "list")
            return
        }

        [recoveryLinkInstance: recoveryLinkInstance]
    }

    def update() {
        def recoveryLinkInstance = RecoveryLink.get(params.id)
        if (!recoveryLinkInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'recoveryLink.label', default: 'RecoveryLink'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (recoveryLinkInstance.version > version) {
                recoveryLinkInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'recoveryLink.label', default: 'RecoveryLink')] as Object[],
                          "Another user has updated this RecoveryLink while you were editing")
                render(view: "edit", model: [recoveryLinkInstance: recoveryLinkInstance])
                return
            }
        }

        recoveryLinkInstance.properties = params

        if (!recoveryLinkInstance.save(flush: true)) {
            render(view: "edit", model: [recoveryLinkInstance: recoveryLinkInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'recoveryLink.label', default: 'RecoveryLink'), recoveryLinkInstance.id])
        redirect(action: "show", id: recoveryLinkInstance.id)
    }

    def delete() {
        def recoveryLinkInstance = RecoveryLink.get(params.id)
        if (!recoveryLinkInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'recoveryLink.label', default: 'RecoveryLink'), params.id])
            redirect(action: "list")
            return
        }

        try {
            recoveryLinkInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'recoveryLink.label', default: 'RecoveryLink'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'recoveryLink.label', default: 'RecoveryLink'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
