package championweb

import org.apache.commons.logging.LogFactory;

import championweb.TmpSolicitudProyecto;

class CleanSolicitudTMPJob {
	private static final log = LogFactory.getLog(this);
     static triggers = {
	    cron name: 'myTrigger', cronExpression: "0 0/2 * * * ?"
	  }
	 def group = "champion"
	 def execute(){
		 //log.info("--- ELIMINANDO LA TABLA TEMPORAL DE SOLICITUD PROYECTOS ${TmpSolicitudProyecto.count()}---");
//	   TmpSolicitudProyecto.executeUpdate('delete from TmpSolicitudProyecto')
	   //log.info("Se ha eliminado los datos de la tabla")
	 }
}
