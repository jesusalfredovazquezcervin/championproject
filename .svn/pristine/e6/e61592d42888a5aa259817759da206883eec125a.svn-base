package championweb

class Perfil {

	Integer id;
	String nombrePerfil;
	String descripcion;
	
    static constraints = {
		nombrePerfil(unique:true);
		nombrePerfil(blank:false);
		nombrePerfil(nullable:false);
		descripcion(nullable:true);
		descripcion(blank:true);
    }
	
	static mapping = {
		table "perfiles";
		id generator:'increment';	
	}	
}
