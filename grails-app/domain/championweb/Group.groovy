package championweb

/**
 * Un grupo es un perfil, los grupos contienen varios roles (ver GroupRole)
 *
 * @author renatocastaneda
 *
 */
class Group {

	String authority //Nombre del back o clave, ej: GRP_CONTABILIDAD
	String descripcion //Descripcion del grupo, ej: Area de Contabilidad
	
    static mapping = {
		table 'grupo'
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
		descripcion blank:false, nullable:false
	}
}
