package championweb

class ObservacionesContrato {
	
	String observacion
	String responsable
	Date fecha
	static belongsTo =[contrato:Contrato]

    static constraints = {
		observacion(blank:false)
		observacion(nullable:false)
		responsable(blank:false)
		responsable(nullable:false)
		fecha(blank:false)
		fecha(nullable:false)
    }
	
	static mapping = {
		table "obscontratos";
		observacion type: 'text'
	}
}
