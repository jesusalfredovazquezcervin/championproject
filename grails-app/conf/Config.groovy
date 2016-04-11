// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

def grailsApplication

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']


// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// enable query caching by default
grails.hibernate.cache.queries = true

//correo de envio para el plugin 'mail'
grails.mail.default.from="solicitudes@ctxmx.com"

def log4jConsoleLogLevel = Priority.WARN
def log4jAppFileLogLevel = Priority.INFO

// set per-environment serverURL stem for creating absolute links
environments {
    development {
        grails.logging.jul.usebridge = true
		log4jConsoleLogLevel = Priority.DEBUG
		log4jAppFileLogLevel = Priority.DEBUG
		
		grails {
//			  	mail {
//			 host = "smtp.gmail.com"
//		     port = 465
//		     username = "koomonifsw@gmail.com"
//		     password = "fsw_2014"
//			 props = ["mail.smtp.auth":"true",
//					"mail.smtp.socketFactory.port":"465",
//					"mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
//					"mail.smtp.socketFactory.fallback":"false"]
//		 }
			/*mail {
				host = "email-smtp.us-east-1.amazonaws.com"
				port = 465
				username = "AKIAI6U3QFXXJQADD3YQ"
				password = "AnYww4MfCBprwXcMc8EYVoTagLb7DFTS3PaPVgAXi8JO"
				props = ["mail.smtp.auth":"true",
					   "mail.smtp.socketFactory.port":"465",
					   "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
					   "mail.smtp.socketFactory.fallback":"false"]
			}*/
			mail {
				host = "smtp.gmail.com"
				port = 465
//					username = "gimnasioglobaltraining@gmail.com"
				username = "jesusalfredovazquezcervin@gmail.com"
//					password = "pwq92p33_5"
				password = "mokrfizmvxindbxu"
				props = ["mail.smtp.auth":"true",
							"mail.smtp.socketFactory.port":"465",
							"mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
							"mail.smtp.socketFactory.fallback":"false"]
									
		}
			/*mail {
				host = "smtp.mail.yahoo.com"
				port = 465
				username = "solicitudes@ctxmx.com"
				password = "s0l1c1tud3s"
				props = ["mail.smtp.auth":"true",
					   "mail.smtp.socketFactory.port":"465",
					   "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
					   "mail.smtp.socketFactory.fallback":"false"]
			}*/
		 }
		
		//Rutas para almacenar archivos
		path{
			files{
				tmp.solicitudes="/web/cham_files/tmp/solicitudes/"
				programa.solicitudes="/web/cham_files/programa/solicitudes/"
			}
		}
		
		//WS para SAE
		ws{
			almacen   = 'https://201.128.224.11:8080/ChampionWS/Almacen?wsdl'
			producto  = 'https://201.128.224.11:8080/ChampionWS/Productos?wsdl'
			proveedor = 'https://201.128.224.11:8080/ChampionWS/Proveedor?wsdl'
			healt 	  = 'https://201.128.224.11:8080/ChampionWS/Healt?wsdl'
			mod = 'https://201.128.224.11:8080/ChampionWS/MOD?wsdl'
//			https://201.128.224.11:8080/ChampionWS/MOD?wsdl
			
//			almacen   = 'http://localhost:8081/ChampionWS/Almacen?wsdl'
//			producto  = 'http://localhost:8081/ChampionWS/Productos?wsdl'
//			proveedor = 'http://localhost:8081/ChampionWS/Proveedor?wsdl'
		}
		
		
    }
    production {
        grails.logging.jul.usebridge = true
		log4jConsoleLogLevel = Priority.DEBUG
		log4jAppFileLogLevel = Priority.DEBUG
        // TODO: grails.serverURL = "http://www.changeme.com"
		
		log4j = {
			// Example of changing the log pattern for the default console
			// appender:
			//
//			appenders {
//				rollingFile name:"appFile", maxFileSize:1024, layout:pattern(conversionPattern: '%d{HH:mm:ss,SSS} - [%-5p] %c{2}: %m%n'), fileName:"/home/ubuntu/logs/champion/champion.log"
//			}
//			
			root {
				error 'appFile'
				additivity = true
			  }
		
			error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
				   'org.codehaus.groovy.grails.web.pages', //  GSP
				   'org.codehaus.groovy.grails.web.sitemesh', //  layouts
				   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
				   'org.codehaus.groovy.grails.web.mapping', // URL mapping
				   'org.codehaus.groovy.grails.commons', // core / classloading
				   'org.codehaus.groovy.grails.plugins', // plugins
				   'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
				   'org.springframework',
				   'org.hibernate',
				   'net.sf.ehcache.hibernate'
			info   'org.codehaus.groovy.grails.web.servlet',  //  controllers
				   'org.codehaus.groovy.grails.web.pages', //  GSP
				   'org.codehaus.groovy.grails.web.sitemesh', //  layouts
				   'championweb',
				   'com.koomoni'
			debug  'championweb',
				   'com.koomoni'
				   
				   debug 'grails.app.controllers'
				   debug 'grails.app.services'
				   debug 'grails.app.domain'
				   debug 'grails.app.conf'
				   
		}
		
		
		
		grails {
//			mail {
//				host = "email-smtp.us-east-1.amazonaws.com"
//				port = 465
//				username = "AKIAI6U3QFXXJQADD3YQ"
//				password = "AnYww4MfCBprwXcMc8EYVoTagLb7DFTS3PaPVgAXi8JO"
//				props = ["mail.smtp.auth":"true",
//					   "mail.smtp.socketFactory.port":"465",
//					   "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
//					   "mail.smtp.socketFactory.fallback":"false"]
//			}
			
			mail {
				host = "smtp.mail.yahoo.com"
				port = 465
				username = "solicitudes@ctxmx.com"
				password = "s0l1c1tud3s"
				props = ["mail.smtp.auth":"true",
					   "mail.smtp.socketFactory.port":"465",
					   "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
					   "mail.smtp.socketFactory.fallback":"false"]
			}
	   }
		
		//Rutas para almacenar archivos
		path{
			files{
				tmp.solicitudes="/home/ubuntu/champion_files/tmp/solicitudes"
				programa.solicitudes="/home/ubuntu/champion_files/programa/"
			}
		}
		
		//WS para SAE
		ws{
			almacen   = 'https://201.128.224.11:8080/ChampionWS/Almacen?wsdl'
			producto  = 'https://201.128.224.11:8080/ChampionWS/Productos?wsdl'
			proveedor = 'https://201.128.224.11:8080/ChampionWS/Proveedor?wsdl'
			healt 	  = 'https://201.128.224.11:8080/ChampionWS/Healt?wsdl'
			mod = 'https://201.128.224.11:8080/ChampionWS/MOD?wsdl'
		}
		
		
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
	log4jConsoleLogLevel = Priority.DEBUG
	log4jAppFileLogLevel = Priority.DEBUG
	
//    appenders {
//        console name:'stdout', layout:pattern(conversionPattern: '%d{HH:mm:ss,SSS} - [%-5p] %c{2}: %m%n')
//    }
	
	root {
		error 'stdout'
		additivity = true
	  }

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
	info   'org.codehaus.groovy.grails.web.servlet',  //  controllers
		   'org.codehaus.groovy.grails.web.pages', //  GSP
		   'org.codehaus.groovy.grails.web.sitemesh', //  layouts
		   'championweb',
		   'com.koomoni'
	debug  'championweb',
		   'com.koomoni'
		   debug 'grails.app.controllers'
		   debug 'grails.app.services'
		   debug 'grails.app.domain'
		   debug 'grails.app.conf'
}

 

//sec.sslTrustStoreFile =  '/var/lib/tomcat7/webapps/certificados/clientchampion.jks' //ruta prod /home/ubuntu/champion_files/certificados
//sec.sslTrustStoreFile =  '/home/ubuntu/champion_files/certificados/clientchampion.jks' //ruta prod /home/ubuntu/champion_files/certificados
sec.sslTrustStoreFile =  '/Users/Alfredo/Documents/ws champs/clientchampion.jks' //ruta lap alfredo
sec.sslTrustStorePassword = 'wUg9FhnWLwsWa38'
sec.server = '201.128.224.11'


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'championweb.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'championweb.UserRole'
grails.plugin.springsecurity.authority.className = 'championweb.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/':                              ['IS_AUTHENTICATED_FULLY'],
	'/index':                         ['IS_AUTHENTICATED_FULLY'],
	'/index.gsp':                     ['IS_AUTHENTICATED_FULLY'],
	'/**/js/**':                      ['permitAll'],
	'/**/css/**':                     ['permitAll'],
	'/**/images/**':                  ['permitAll'],
	'/**/favicon.ico':                ['permitAll'],
	'/**':							  ['IS_AUTHENTICATED_FULLY'],
	'/quartz/**':					  ['ROLE_ADMIN'],
	'/recoveryLink/**':				  ['permitAll'],
	'/login/denied.gsp':              ['IS_AUTHENTICATED_FULLY']
]

grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.useSecurityEventListener = true
grails.plugin.springsecurity.onInteractiveAuthenticationSuccessEvent = { e, appCtx ->
   // handle InteractiveAuthenticationSuccessEvent
}

grails.plugin.springsecurity.onAbstractAuthenticationFailureEvent = { e, appCtx ->
   // handle AbstractAuthenticationFailureEvent
}

grails.plugin.springsecurity.onAuthenticationSuccessEvent = { e, appCtx ->
   // handle AuthenticationSuccessEvent
}

