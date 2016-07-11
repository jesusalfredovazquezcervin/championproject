package championweb

class TmpSolicitudPartida implements Serializable{
	
	Long tmpProyectoID //unixtime
	
	float cantidad
	String cveProducto
	String descProducto
	String unidad = 0
	Almacen lugarEntrega
	

    static constraints = {
		cantidad nullable:false, blank:false
		cveProducto nullable:false, blank:false
		unidad nullable:false, blank:false
		lugarEntrega nullable:true, blank:true
    }
	
	static mapping = {
		table "tmp_solicitud_partidas"
		id composite : ['tmpProyectoID','cveProducto']
	}
	
}
