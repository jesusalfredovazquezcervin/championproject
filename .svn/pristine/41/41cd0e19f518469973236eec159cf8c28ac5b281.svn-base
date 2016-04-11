package championweb

import org.apache.commons.logging.LogFactory;


class IndexController {
	//def beforeInterceptor = [action:this.&auth, except:["auth"]]
	private static final log = LogFactory.getLog(this);
	def springSecurityService
	
		def auth(){
			
			if(!session.user) {
				redirect(uri: "/login")
				return false
			  }
			
		}
	
		def index() {
			def user = springSecurityService.currentUser
			def misSolicitudes = Solicitud.findAllByUsuarioCreoAndEstatusNotEqual(user,4) //Todas las solicitudes que no se encuentren canceladas del usuario
			def ultimasSolicitudes = Solicitud.findAllByEstatusNotEqual(4, [max:10]) 
			
			StringBuilder qry = new StringBuilder();
			
			qry.append("SELECT sp.solicitud.id, sp.solicitud.contPorZona, ")
				.append("sp.solicitud.lugarEntrega.zona.id, count(sp), sp.idSAE as prov, sp.solicitud.fechaCreacionSolicitud FROM SolicitudPartida sp ")
				.append("WHERE sp.idSAE != null AND sp.estatus = 2 GROUP BY sp.idSAE, sp.solicitud.id")
			
			def cotPendientesList = SolicitudPartida.executeQuery(qry.toString())
			
			render view:"/index" , model:[misSolicitudes:misSolicitudes,ultimasSolicitudes:ultimasSolicitudes,cotPendientesList:cotPendientesList]
		
		}
}
