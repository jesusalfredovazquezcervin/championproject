package championweb

class PartidaOrden {
	
	static belongsTo = [orden : OrdenCompra]
	
	float cantidad
	Almacen almacen
	String cveProducto
	String descProducto
	String unidad = "N/A"
	
	BigDecimal descuento = 0.0
	BigDecimal otros = 0.0
	BigDecimal isrRet = 0.0
	BigDecimal retIVA = 0.0
	BigDecimal IVA = 0.0
	
	BigDecimal costoUnidad = 0.0
	

    static constraints = {
		cveProducto nullable:false, blank:false
		descProducto nullable:false, blank:false
		cantidad nullable:false, blank:false, scale: 5
		almacen nullable:false, blank:false
		costoUnidad nullable:false, blank:false
    }
	
	static mapping = {
		sort cveProducto: "asc"
	}
	
	
}
