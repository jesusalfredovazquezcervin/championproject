package championweb

class Solicitud {
	
	Contrato contrato
	Almacen lugarEntrega
	Receptor recibe
	Date fechaAreaAdm
	Date fechaCreacionSolicitud
	Integer tipoSolicitud //1 extranjera 
	Integer estatus //1 abierta, 2 en revisi�n, 3 en cotizacion, 4 cancelada
	
	Long contPorZona = 0 //Valor del Contador por zona para que sea el folio de la solicitud
	User usuarioCreo 
	
	//RUTAS DE LOS ARCHIVOS DE PROGRAMA (DOC, PDF, XLS, ETC)
	String pathMant
	String pathInstal
	String pathDesin
	String pathEval
	String pathIny
	String obsPrograma
	
	static hasMany = [proyecto:ProyectoSolicitud, razon:RazonSolicitud, partida:SolicitudPartida]
	
    static constraints = {
		contrato nullable:false 
		contrato blank:false
		lugarEntrega nullable:true
		lugarEntrega blank:true	
		recibe blank:true
		recibe nullable:true
		proyecto blank:true
		proyecto nullable:true
		razon blank:true
		razon nullable:true 
		partida nullable:true
		obsPrograma nullable:true, blank:true
		
		fechaAreaAdm nullable:true, blank:true
		pathMant nullable:true, blank:true
		pathInstal nullable:true, blank:true
		pathDesin nullable:true, blank:true
		pathEval nullable:true, blank:true
		pathIny nullable:true, blank:true
		
		usuarioCreo nullable:true, blank:true
		
    }
	
	static mapping = {
		table "solicitudes"
		sort id: "desc"
		obsPrograma type: 'text'
		
		pathMant comment:"Mantenimiento"
		pathInstal comment:"Instalacion"
		pathDesin comment:"Desinstalacion"
		pathEval comment:"Evaluacion"
		pathIny comment:"Inyeccion de prod. quimico"
		fechaAreaAdm defaultValue: "now()"
		fechaCreacionSolicitud defaultValue: "now()"
	}
	
}
