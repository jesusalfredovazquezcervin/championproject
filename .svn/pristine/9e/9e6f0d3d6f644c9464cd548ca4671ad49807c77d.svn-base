package championweb

class Usuario implements Serializable{

    String usuario;
	String nombres;
	String apellidos;
	String email;
	String password;
	static belongsTo = [perfil:Perfil, zona:Zona];
	
	String getNombreCompleto(){ nombres+" "+apellidos }
	static transients = ['nombreCompleto']

    static constraints = {
		usuario(blank:false);
		usuario(unique:true);
		password(blank:false);
		password(nullable:false);
		password(password:true);
		nombres(blank:false);
		apellidos(blank:false);
		email(email:true);
    }
	
	static mapping = {
		table "usuarios";
	}
}
