package championweb

class TipoProyecto {
	String nombre
	String descripcion
	
    static constraints = {
		nombre(unique:true)
		nombre(nullable:false)
		nombre(blank:false)
    }
	
	static mapping = {
		table "tipoproyectos";
	}
}
