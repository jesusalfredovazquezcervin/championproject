package championweb

class CotizacionEnviada {
	
	static hasMany = [partida:SolicitudPartida]
	Long provSAE
	String correoProv
	String nombreProv
	String idiomaCorreo
	String observaciones
	Integer vecesEnviado 
	
	Date fechaEnvPrimeraVez
	Date fechaUltimoEnvio
	
    static constraints = {
		observaciones nullable:true, blank:true
		fechaUltimoEnvio nullable:true, blank:true
    }
	
	def beforeInsert(){
		fechaEnvPrimeraVez = new Date()
		vecesEnviado = (Integer)1
	}
	
	def beforeUpdate(){
		fechaUltimoEnvio = new Date()
	}
	
	
	static mapping={observaciones type:'text'}
	
}
