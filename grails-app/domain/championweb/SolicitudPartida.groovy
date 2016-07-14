package championweb

import championweb.enums.EstatusPartida

class SolicitudPartida {
	
	static belongsTo = [solicitud : Solicitud]
	float cantidad
	String cveProducto
	String descProducto
	String unidad = 0
	Almacen lugarEntrega
	
	EstatusPartida estatus
	
	Long idSAE //si tiene id de proveedor es que se clasifico para cotizacion

    static constraints = {
		cantidad nullable:false, blank:false
		cveProducto nullable:false, blank:false
		unidad nullable:false, blank:false
		idSAE nullable:true, blank:true
		estatus nullable:true, blank:true
		lugarEntrega nullable:true, blank:true
    }
	
	static mapping = {
		table "solicitud_partidas"
	}
}
