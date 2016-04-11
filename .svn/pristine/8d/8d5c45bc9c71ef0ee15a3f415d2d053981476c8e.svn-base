package championweb

import java.sql.ResultSet;
import java.util.Date;

class User {

	transient springSecurityService
	def static dataSource

	String nombres
	String apellidos
	String email

	String username
	String password
	static belongsTo = [perfil:Perfil, zona:Zona];
	String getNombreCompleto(){ nombres+" "+apellidos }
	
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Group perfil
	static transients = ['springSecurityService','nombreCompleto']

	static constraints = {
		username blank: false, unique: true
		password blank: false
		email email:true,blank:false, nullable:false
		apellidos nullable:false, blank:false
		nombres nullable:false, blank:false
		perfil blank:false, nullable:false
	}

	static mapping = {
		password column: '`password`'
		sort id: "desc"
	}

	Set<Role> getAuthorities() {
		//UserRole.findAllByUser(this).collect { it.role } as Set
		GroupRole.findAllByGroup(this.perfil).collect{it.role} as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
