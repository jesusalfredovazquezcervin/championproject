package championweb

class Almacen {

	String descripcion
	Integer claveAlmacen
	static belongsTo = [zona:Zona] 
	
	String getNombreCompleto(){ claveAlmacen+" - "+ descripcion }
	static transients = ['nombreCompleto']
	
    static constraints = {
		descripcion(nullable: false )
		claveAlmacen(unique:true)
    }
	
	static mapping = {
		table "almacenes";
	}
	
}
