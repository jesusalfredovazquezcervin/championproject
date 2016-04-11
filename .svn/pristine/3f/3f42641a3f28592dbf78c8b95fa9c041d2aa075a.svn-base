package championweb

class OrdenCompra {
	static hasMany = [partidas : PartidaOrden]
	
	Date fecha
	Date fechaRec
	Almacen almacen
	Long provSAE //id proveedor
	Solicitud solicitud //no es obligatorio en este punto
	
	String servicio
	String ordenSAE //Numero de orden en el SAE
	
	Integer moneda 
	float esquema = 0.0
	float descuento = 0.0
	float descFinal = 0.0//No es descuento final, es descuento financiero.
	float tipoCambio = 0.0
	
    static constraints = {
		esquema nullable:false, blank:false
		moneda 	nullable:false, blank:false
		solicitud nullable:true, blank:true
		fechaRec nullable:true, blank:true
		ordenSAE nullable:true, blank:true
    }
	
	static mapping={
		partidas cascade: "all-delete-orphan"
	}
	
}
