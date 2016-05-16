import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import championweb.Group
import championweb.GroupRole
import championweb.Perfil
import championweb.RazonSolicitud;
import championweb.Role
import championweb.TipoProyecto;
import championweb.User
import championweb.Usuario
import championweb.Zona;
import championweb.Almacen;
import championweb.ConfGeneral

import org.springframework.web.context.support.WebApplicationContextUtils

import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession

class BootStrap {
	def grailsApplication
	
    def init = { servletContext ->
		TimeZone.setDefault(TimeZone.getTimeZone("America/Mexico_City"))
		
		def springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )
		
		// Custom marshalling
		springContext.getBean( "customObjectMarshallers" ).register()
		
		if (!Perfil.count()) {
			new Perfil(id: 1, descripcion: "Administrador",nombrePerfil:"admin").save(failOnError: true)
		}
		
		
		if(!Zona.count()){
			new Zona(id:1,nombreZona:"QRO",descripcion:"ZONA DE PRUEBAS", solicitudcont:(Long)0).save(failOnError:true)
			new Zona(id:2,nombreZona:"DF",descripcion:"ZONA DE PRUEBAS DOS", solicitudcont:(Long)0).save(failOnError:true)
			new Zona(id:3,nombreZona:"TPC",descripcion:"ZONA DE PRUEBAS TRES", solicitudcont:(Long)0).save(failOnError:true)
		}
		
		def adminRole = new Role(authority: 'ROLE_ADMIN',descripcion:'Role general de administrador').save(flush: true)
		def perf = new Group(authority: 'ADMIN',descripcion:'Super Administrador').save(flush: true)
		new GroupRole(group:perf,role:adminRole).save(flush: true)
		
		if(!User.count()){
			def testUser = new User(username: 'admin', password: 'admin', nombres:'Administrador default', apellidos:'Admin', email:'admin@admin.com', perfil:Group.get(1), zona:Zona.get(1))
			testUser.save(flush: true)
			println(testUser.errors)
		}
		
		if (!Usuario.count()) {
			new Usuario(id: 1, apellidos: "Administrador", nombres:"Administrador", email:"admin@server.com", usuario:"admin", password:"admin".encodeAsSHA1(), perfil:Perfil.get(1),zona:Zona.get(1)).save(failOnError: true)
		}
		
		if(!TipoProyecto.count()){
			new TipoProyecto(id:1,nombre:"Deshidratacion",descripcion:"").save(failOnError:true)
			new TipoProyecto(id:2,nombre:"Capilar",descripcion:"").save(failOnError:true)
			new TipoProyecto(id:3,nombre:"Telemetria",descripcion:"").save(failOnError:true)
		}
		
		if(!RazonSolicitud.count()){
			new RazonSolicitud(id:1,descripcion:"CTM").save(failOnError:true)
			new RazonSolicitud(id:2,descripcion:"ITS").save(failOnError:true)
			new RazonSolicitud(id:3,descripcion:"Dentro del Programa CTM").save(failOnError:true)
			new RazonSolicitud(id:4,descripcion:"Por necesidad del cliente").save(failOnError:true)
			new RazonSolicitud(id:5,descripcion:"Instalacion nueva").save(failOnError:true)
			new RazonSolicitud(id:6,descripcion:"Instlacion existente").save(failOnError:true)
			new RazonSolicitud(id:7,descripcion:"Desinstalacion").save(failOnError:true)
			new RazonSolicitud(id:8,descripcion:"Mantenimiento").save(failOnError:true)
			new RazonSolicitud(id:9,descripcion:"Evaluacion industrial").save(failOnError:true)
			new RazonSolicitud(id:10,descripcion:"Evaluacion de laboratorio").save(failOnError:true)
		} 
		if(!Almacen.count()){
			new Almacen(id:1,descripcion:"Almacen 1", claveAlmacen:1,zona:Zona.get(1)).save(failOnError:true)
			new Almacen(id:2,descripcion:"Almacen 2", claveAlmacen:2, zona:Zona.get(1)).save(failOnError:true)
		}
		
		
		if(!ConfGeneral.count()){
			new ConfGeneral(id:1,name:"mail_foranea", value:"jesus.alfredo.vazquez.cervin@gmail.com").save(failOnError:true)//Es el correo al que se van a enviar las solicitudes
			new ConfGeneral(id:2,name:"ES_MSG", value:"Buenos dias/tardes, me podrias cotizar lo siguiente: ").save(failOnError:true)//Es el mensaje de correo
			new ConfGeneral(id:3,name:"EN_MSG", value:"Good morning/afternoon, could you quote me the next: ").save(failOnError:true)
			new ConfGeneral(id:4,name:"pruebas", value:"yes").save(failOnError:true)//Indica si se está en pruebas para mandar todos los mails al correo de pruebas
			new ConfGeneral(id:5,name:"mail_pruebas", value:"jesus.alfredo.vazquez.cervin@gmail.com").save(failOnError:true)//Indica si se está en pruebas para mandar todos los mensajes al correo
			new ConfGeneral(id:6,name:"IVA", value:"16").save(failOnError:true)//IVA
			new ConfGeneral(id:7,name:"ISR", value:"3").save(failOnError:true)//ISR
			new ConfGeneral(id:8,name:"otros", value:"1").save(failOnError:true)//ISR
		}
		
		
		//GLOBAL PARA LA CONEXION A LOS WS, AUN ASI SE NECESITA INDICAR ARCHIVO Y CONTRASE�A POR WSLITE
//		System.setProperty("javax.net.ssl.trustStrore", grailsApplication.config.sec.sslTrustStoreFile)
//		System.setProperty("javax.net.ssl.trustStorePassword", grailsApplication.config.sec.sslTrustStorePassword)
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier()
			{
				public boolean verify(String hostname, SSLSession session)
				{
//					if (hostname.equals(grailsApplication.config.sec.server))
						return true;
//					return false;
				}
			});
		
    }
	
	
	
    def destroy = {
    }
}
