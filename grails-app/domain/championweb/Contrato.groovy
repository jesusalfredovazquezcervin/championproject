package championweb

class Contrato {
	
	String numContrato
	Date fechaInicio
	Date fechaFin
	String nombreCliente
	String tipoContrato
	String objetoContrato //descripcion
	String lugarAplicacion
	String responsableCliente
	String responsableCTM
	

	static hasMany = [extension:ExtContrato,observacion:ObservacionesContrato]
	
	Proyecto proyecto

    static constraints = {
		numContrato(blank:false)
		numContrato(nullable:false)
		numContrato(matches:/^[A-Za-z0-9_-]+$/)
		fechaInicio(nullable:false)
		fechaFin(nullable:false)
		fechaInicio(blank:false)
		fechaFin(blank:false)
		nombreCliente(blank:false)
		nombreCliente(nullable:false)
		lugarAplicacion(blank:false)
		lugarAplicacion(nullable:false)
		responsableCliente(blank:false)
		responsableCliente(nullable:false)
		responsableCTM(blank:false)
		responsableCTM(nullable:false)
		tipoContrato(blank:false)
		tipoContrato(nullable:false)
		objetoContrato(blank:false)
		objetoContrato(nullable:false)
    }
	
	static mapping = {
		table "contratos";
	}
}
