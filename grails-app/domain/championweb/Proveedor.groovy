package championweb

//PROVEEDOR RELACIONADO A UNA ORDEN DE COMPRA
class Proveedor {
	Long idSAE
	String referencia
	static belongsTo = [orden:OrdenCompra]

    static constraints = {
		idSAE nullable:false, blank:false
		referencia nullable:false, blank:false
    }
	
	static mapping = {
		table "proveedores_ordencompra";
	}
	
}
