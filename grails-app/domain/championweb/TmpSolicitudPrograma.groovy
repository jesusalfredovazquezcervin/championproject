package championweb

class TmpSolicitudPrograma implements Serializable{
	
	Long tmpProyectoID //unixtime
	
	String obsPrograma
	String pathMant
	String pathInstal
	String pathDesin
	String pathEval
	String pathIny
	
    static constraints = {
		tmpProyectoID unique:true
		obsPrograma nullable:true, blank:true
		pathMant nullable:true, blank:true
		pathInstal nullable:true, blank:true
		pathDesin nullable:true, blank:true
		pathEval nullable:true, blank:true
		pathIny nullable:true, blank:true
    }
	
	static mapping = {
		table "tmp_solicitud_programa"
		obsPrograma type: 'text'
	}
}
