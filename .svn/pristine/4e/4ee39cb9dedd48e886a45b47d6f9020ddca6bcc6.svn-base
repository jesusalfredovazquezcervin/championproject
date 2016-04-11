package championweb

class Logtrans {
	Usuario usr
	Date fecha
	String mensaje
	String metodo
	String controller

    static constraints = {
		usr(nullable:false)
		fecha(nullable:false)
		mensaje(nullable:false)
		
		usr(blank:false)
		fecha(blank:false)
		mensaje(blank:false)
    }
	
	static mapping = {
		table "logtrans"
		mensaje type: 'text'
	}
}
