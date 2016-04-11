package championweb

class Almacen {

	String descripcion
	Integer claveAlmacen
	static belongsTo = [zona:Zona] 
	
    static constraints = {
		descripcion(nullable: false )
		claveAlmacen(unique:true)
    }
	
	static mapping = {
		table "almacenes";
	}
	
}
