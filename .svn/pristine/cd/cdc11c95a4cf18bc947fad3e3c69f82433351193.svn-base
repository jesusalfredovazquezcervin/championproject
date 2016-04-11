/**
 * Se crea como ayuda para relacionar proyectos con
 * solicitudes aun no existentes
 */
package championweb

class TmpSolicitudProyecto implements Serializable{
	
	Long tmpProyectoID //unixtime
	Long idProyecto
	Integer prorrateo
	String nombre
	String tipoProyecto
	String responsable
	

    static constraints = {
		tmpProyectoID nullable:false,blank:false
		idProyecto nullable:false, blank:false
		prorrateo nullable:false, blank:true
		nombre nullable:false, blank:true
		tipoProyecto nullable:false, blank:true
		responsable nullable:false, blank:true
    }
	
	static mapping = {
		table "tmp_solicitud_proyectos"
		prorrateo defaultValue : 0
		id composite : ['tmpProyectoID','idProyecto']
	}
}
