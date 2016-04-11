package championweb

class Recepcion {
	
	static belongsTo = [orden:OrdenCompra]
	Date fechaRecepcion
	String obsMaterial
	String folioRemision
	Date fechaRemision
	Boolean isProdQuimico = false
	String noPipa
	String placas
	String nomChofer
	String marcaVehiculo
	String observaciones
	String noVehiculo
	String bl

    static constraints = {
		noPipa(nullable:true, blank:true)
		placas(nullable:true, blank:true)
		nomChofer(nullable:true, blank:true)
		marcaVehiculo(nullable:true, blank:true)
		observaciones(nullable:true, blank:true)
		noVehiculo(nullable:true, blank:true)
		bl(nullable:true, blank:true)
    }
	
	static mapping ={
		obsMaterial type: 'text'
		observaciones type: 'text'
	}
}
