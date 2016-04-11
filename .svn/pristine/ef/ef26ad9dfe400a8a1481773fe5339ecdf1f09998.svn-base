package championweb

/**
 * Para esta aplicaci—n los roles ser‡n sobre funcionalidades
 * ROLE_<NOMBRE_CONTROLLER>_<FUNCIONALIDAD>
 * EJ: ROLE_PROVEEDOR_CREATE
 * @author renatocastaneda
 *
 */
class Role {

	String authority //Nombre en el back, por ejemplo -ROLE_PROVEEDOR_CREATE-
	String descripcion //Nombre en pantalla, por ejemplo -Crear Proveedor-

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
		descripcion blank: false, nullable:false
	}
}
