package championweb

class PartidaOrdenCompra {
	
	Integer noPartida
	float cantidad
	String cveProducto
	String descProducto
	String unidad
	float descuento
	float otros
	float isrRet
	float retIva
	float iva
	float costoUnidad
	float totalPartida

	static belongsTo = [solicitud:Solicitud]	

    static constraints = {
		noPartida nullable:false, blank:false
		cantidad nullable:false, blank:false
		cveProducto nullable:false, blank:false
		unidad nullable:false, blank:false
		descuento nullable:false, blank:false
		otros nullable:false, blank:false
		isrRet nullable:false, blank:false
		retIva nullable:false, blank:false
		iva nullable:false, blank:false
		costoUnidad nullable:false, blank:false
		totalPartida nullable:false, blank:false
    }
	
	static mapping = {
		table "partidas_ordencompra"
	}
}
