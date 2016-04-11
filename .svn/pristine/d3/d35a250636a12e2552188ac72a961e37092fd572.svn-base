package championweb

import com.koomoni.ws.HealtService;
import org.apache.commons.logging.LogFactory;

import wslite.soap.SOAPClient

class CheckHealtWSJob {
	private static final log = LogFactory.getLog(this);
	def grailsApplication
	def mailService
    static triggers = {
       cron name: 'healtJob', cronExpression: "0 0/10 * * * ?"
    }

    def execute() {
        def client = new SOAPClient(grailsApplication.config.ws.healt)
		client.httpClient.sslTrustStoreFile = grailsApplication.config.sec.sslTrustStoreFile
		client.httpClient.sslTrustStorePassword = grailsApplication.config.sec.sslTrustStorePassword
		
		def s = new HealtService()
		def resp = s.checkHealt(client)
		log.debug(resp);
		
		if(resp.toString()!="OK-001")
			mailService.sendMail {
				to "rcastaneda@koomoni.com"
				subject "CHAMPION SOLICITUDES :: ALERTA WS"
				body "Ha ocurrido un error :: "+resp.toString()
			 }
		
    }
}
