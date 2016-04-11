package championweb

class ExtContrato {
	
	static belongsTo =[contrato:Contrato]
	Date fechaInicial
	Date fechaFinal

    static constraints = {
		fechaInicial(nullable:false)
		fechaFinal(nullable:false)
		fechaInicial(blank:false)
		fechaFinal(blank:false)
    }
	
	static mapping = {
		table "extcontratos";
	}
}
