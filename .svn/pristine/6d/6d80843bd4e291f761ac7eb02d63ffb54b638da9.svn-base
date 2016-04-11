package championweb

class Zona {

		Integer id;
		String nombreZona;
		String descripcion;
		Long solicitudcont = 0; //Contador de solicitud por zona 
	
    static constraints = {
		nombreZona(nullable:false);
		nombreZona(blank:false);
		nombreZona(unique:true);
//		solicitudcont(nullable:true, blank:true);
    }
	
	static mapping = {
		table "zonas";
		id generator:'increment';
	}
}
