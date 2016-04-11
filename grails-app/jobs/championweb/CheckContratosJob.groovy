package championweb

import org.apache.commons.logging.LogFactory;

class CheckContratosJob {
	private static final log = LogFactory.getLog(this);
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        //log.info('revisando contratos')
    }
}
