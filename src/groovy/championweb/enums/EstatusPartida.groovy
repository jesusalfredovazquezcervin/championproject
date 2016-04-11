package championweb.enums

public enum EstatusPartida {
	
	REVISION(1),
	COTIZACION(2),
	COTIZACION_ENVIADA(3),
	CANCELADA(4),
	Integer id
	
	EstatusPartida(Integer id){this.id = id}
	
}
