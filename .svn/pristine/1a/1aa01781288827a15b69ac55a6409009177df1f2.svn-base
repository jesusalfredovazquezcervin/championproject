package championweb

/**
 * Listado informativo de productos en stock de algun almacen
 * se asocia a una solicitud
 * @author renatocastaneda
 *
 */
class SolicitudStock implements Serializable{
	
	Solicitud solicitud
	String cveProducto
	String nombreProducto
	Integer cveAlmacen
	Integer cantidad

    static constraints = {
		solicitud unique:false, nullable:false, blank:false 
		cveProducto unique:false, nullable:false, blank:false 
		nombreProducto unique:false, nullable:false, blank:false
		cveAlmacen unique:false, nullable:false, blank:false
		cantidad unique:false, nullable:false, blank:false 
    }
	
	static mapping = {
		id composite : ['solicitud','cveProducto']  
	}
}
