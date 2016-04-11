package championweb

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class UsuarioController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

//	def beforeInterceptor = [action:this.&auth, except:["login", "authenticate", "logout"]]
	
	def auth(){
		if(!session.user) {
			redirect(uri: "/login")
			return false
		  }
		
		//TODO: VALIDAR PERFIL
	}
	
	def authenticate(){
		def usuarioInstance = Usuario.findByUsuarioAndPassword(params.usuario, params.password.encodeAsSHA1())
		
			if(usuarioInstance){
				log.info("Ha entrado el usuario ${usuarioInstance.nombres}");
				session.user = usuarioInstance
				flash.message = "Hola ${usuarioInstance.nombres}"
				
					redirect(uri: "/")
				
				return false
			}else{
			
//			try {
//				sendMail{
//					//multipart true
//					to "rcastaneda@koomoni.com"
//					subject "PRUEBA MORTAL 123"	
//					body(view:"/login")
//					//attachBytes '/Users/renatocastaneda/Desktop/Varios/34-facebook-cover.jpg','image/jpg', new File('/Users/renatocastaneda/Desktop/Varios/34-facebook-cover.jpg').readBytes()
//				}
//			} catch (Exception e) {
//				System.out.println("HA TRONAO' LO DEL MAIL \n"+e.getMessage());
//			}
			
			
				log.error("Se ha intentado hacer login con el usuario ${params.usuario}!")
//				def logdb = new Logtrans()
//				
//				logdb.metodo=this.class
//				logdb.fecha = new Date()
//				logdb.mensaje = "Se ha intentado hacer login con el usuario ${params.usuario}"
//				logdb.metodo="authenticate"
//				logdb.usr = Usuario.getById(1)
//				logdb.save(flush:true);
				
				flash.error = message(code: 'default.bad.user')
				redirect(uri: "/login")
				return false
			}
		
	}
	
	def logout = {
		flash.message = message(code:'default.logout.user')
		session.user = null
//		session.invalidate();
		redirect(uri: "/login")
		return false
	  }
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [usuarioInstanceList: Usuario.list(params), usuarioInstanceTotal: Usuario.count()]
    }

    def create() {
        [usuarioInstance: new Usuario(params)]
    }

    def save() {
        def usuarioInstance = new Usuario(params)
		usuarioInstance.setPassword(params.password.encodeAsSHA1())//CIFRANDO EL PASSWORD
        if (!usuarioInstance.save(flush: true)) {
            render(view: "create", model: [usuarioInstance: usuarioInstance])
            return
        }

		flash.message = message(code: 'usuario.success.save', args: [message(code: 'usuario.label', default: usuarioInstance.usuario), usuarioInstance.id])
        redirect(action: "show", id: usuarioInstance.id)
    }

    def show() {
        def usuarioInstance = Usuario.get(params.id)
        if (!usuarioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "list")
            return
        }

        [usuarioInstance: usuarioInstance]
    }

    def edit() {
        def usuarioInstance = Usuario.get(params.id)
        if (!usuarioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "list")
            return
        }

        [usuarioInstance: usuarioInstance]
    }

    def update() {
        def usuarioInstance = Usuario.get(params.id)
		usuarioInstance.setPassword(params.password.encodeAsSHA1())//CIFRANDO EL PASSWORD
        if (!usuarioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (usuarioInstance.version > version) {
                usuarioInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'usuario.label', default: 'Usuario')] as Object[],
                          "Another user has updated this Usuario while you were editing")
                render(view: "edit", model: [usuarioInstance: usuarioInstance])
                return
            }
        }

        usuarioInstance.properties = params

        if (!usuarioInstance.save(flush: true)) {
            render(view: "edit", model: [usuarioInstance: usuarioInstance])
            return
        }

		flash.message = message(code: 'usuario.updated.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuarioInstance.id])
        redirect(action: "show", id: usuarioInstance.id)
    }

    def delete() {
        def usuarioInstance = Usuario.get(params.id)
        if (!usuarioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "list")
            return
        }

        try {
            usuarioInstance.delete(flush: true)
			flash.message = message(code: 'usuario.deleted.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
