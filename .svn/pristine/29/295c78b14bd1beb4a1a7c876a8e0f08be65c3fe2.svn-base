package championweb

class Proyecto {

	String nombre
	String tipoProyecto
	String descripcion
	Boolean activo = true
	
	Almacen almacen
	Responsable responsable
	Zona zona
	//static hasOne = [ responsable:Responsable, zona:Zona]
	
		
    static constraints = {
		nombre(blank:false)
		nombre(unique:false)
		nombre(nullable:false)
		
		tipoProyecto(blank:false)
		tipoProyecto(nullable:false)
		
		descripcion(blank:false)
		descripcion(nullable:false)
		
		almacen(blank:false)
		almacen(nullable:false)
		
		responsable(blank:false)
		responsable(nullable:false)
		
		zona(blank:false)
		zona(nullable:false)
		
		nombre maxSize:100
		tipoProyecto maxSize:100
		descripcion maxSize:250
		
    }
	
	static mapping = {
		table "proyectos"
		descripcion type: 'text'
	}
}
