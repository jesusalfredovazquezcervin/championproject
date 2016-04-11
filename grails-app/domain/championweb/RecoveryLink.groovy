package championweb

/**
 * Funcionalidad de olvide contrase–a, el hash sirve para
 * generar un link y envarlo al correo del usuario
 * @author renatocastaneda
 *
 */
class RecoveryLink {
	
	String hashLink 
	Usuario usuario
	Date fecha
	

    static constraints = {
		hashLink(nullable:false)
		hashLink(unique:true)
		hashLink(blank:false)
		usuario(nullable:false)
		usuario(unique:true)
    }
	
	static mapping = {
		table "recoveryLinks";
	}
}
