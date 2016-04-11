package championweb

class Receptor {
	String nombres;
	String apellidoP;
	String apellidoM;
	String telMovil;
	String telOficina;
	String telNextel;
	String idNextel;
	String observaciones;
	
	String getNombreCompleto(){ nombres+" "+apellidoP+" "+apellidoM }
	static transients = ['nombreCompleto']

	static constraints = {
		nombres(blank:false);
		apellidoP(blank:false);
		apellidoM(blank:false);
	}
	
	static mapping = {
		table "receptores";
		id generator:'increment';
		observaciones type: 'text'
	}
}
