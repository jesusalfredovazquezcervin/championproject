package championweb

/**
 * Listado informativo de productos en stock de algun almacen
 * se asocia a una solicitud
 * @author renatocastaneda
 *
 */
class TmpSolicitudStock implements Serializable{
	
	Long tmpProyectoID //unixtime
	String cveProducto
	String nombreProducto
	Integer cveAlmacen
	Integer cantidad

    static constraints = {
		tmpProyectoID unique:false, nullable:false, blank:false 
		cveProducto unique:false, nullable:false, blank:false 
		nombreProducto unique:false, nullable:false, blank:false
		cveAlmacen unique:false, nullable:false, blank:false
		cantidad unique:false, nullable:false, blank:false 
    }
	
	static mapping = {
		id composite : ['tmpProyectoID','cveProducto']  
	}
}
