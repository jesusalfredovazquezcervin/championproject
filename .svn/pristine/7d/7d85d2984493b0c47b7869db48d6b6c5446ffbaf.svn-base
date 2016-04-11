package championweb

import java.text.DateFormat
import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.annotation.Secured;

@Secured(['ROLE_ADMIN','ROLE_CONTRATOS_CREATE','ROLE_CONTRATOS_EDIT','ROLE_CONTRATOS_DELETE'])
class ContratoController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
		def contratoList
		def contratoListTotal
		def offsetp = params.offset!=null?params.offset.toInteger():0
		def maxp = params.max!=null?params.max.toInteger():10
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		//Consultas para la busqueda de contrato ya sea por nombre, cliente y periodo
		// o solo uno de ellos
		def QRY_PARAMS = 
		 "from Contrato WHERE numContrato LIKE '%${params.pcontrato}%' AND nombreCliente LIKE '%${params.pcliente}%' ";
		def QRY_PARAMS_WITH_DATE = 
		 "AND date_format(fechaInicio,'%d/%m/%Y') = '${params.fechaInicio}' AND date_format(fechaFin,'%d/%m/%Y') = '${params.fechaFin}' ";
		def QRY_ONLY_DATE =
		 "from Contrato WHERE date_format(fechaInicio,'%d/%m/%Y') = '${params.fechaInicio}' AND date_format(fechaFin,'%d/%m/%Y') = '${params.fechaFin}' ";
		
        
		//Se empieza a validar si hay parametros de busqueda
		StringBuilder qryParams = new StringBuilder();  
		if(params.pcontrato||params.pcliente){
			qryParams.append(QRY_PARAMS);
			
			if(params.fechaInicio&&params.fechaFin)
				qryParams.append(QRY_PARAMS_WITH_DATE);
			
			contratoList = Contrato.findAll(qryParams,[offset:offsetp, max:maxp]); 
			contratoListTotal = Contrato.findAll(qryParams).size()
			
		}else if (params.fechaInicio&&params.fechaFin) {
			qryParams.append(QRY_ONLY_DATE);
			
			contratoList = Contrato.findAll(qryParams,[offset:offsetp, max:maxp]);
			contratoListTotal = Contrato.findAll(qryParams).size()
		
		}else{
			contratoList = Contrato.list(params)
			contratoListTotal = Contrato.count()
		}
		
		log.debug("SE HAN ENCONTRADO: "+contratoList);
		
		//[contratoInstanceList: Contrato.list(params), contratoInstanceTotal: Contrato.count()]
		[contratoInstanceList:contratoList,
			contratoInstanceTotal:contratoListTotal,
			pcontrato:params.pcontrato, pcliente:params.pcliente]
    }
	
	def listByAjax(){
		def contratoList
		def contratoListTotal
		def QRY_PARAMS = "from Contrato WHERE numContrato LIKE '%${params.pcontrato}%' ";
		
		try {
			log.debug("Buscando Contrato con el parametro: "+params.pcontrato)
			contratoList = Contrato.findAll(QRY_PARAMS);
			contratoListTotal = contratoList.size()
			
		} catch (Exception e) {
			log.error("Ha ocurrido un error al buscar contratos")
			
			render(contentType: 'text/json'){
				result success:true,code:'ERROR', message:e.getCause().toString()
			}
			e.printStackTrace()
			return
		}
		
		render(contentType: 'text/json'){
			result success:true,code:'OK', contratoList:contratoList, contratoListTotal:contratoListTotal
		}
		
	}

	@Secured(['ROLE_ADMIN','ROLE_CONTRATOS_CREATE'])
    def create() {
        [contratoInstance: new Contrato(params)]
    }

	@Secured(['ROLE_ADMIN','ROLE_CONTRATOS_CREATE'])
    def save() {
        def contratoInstance = new Contrato()
		def proyectoInstance = Proyecto.get(params.proyecto.id)
		
		//obteniendo los datos del formulario para contratos
		contratoInstance.numContrato = params.numContrato
		contratoInstance.fechaInicio = params.fechaInicio
		contratoInstance.fechaFin = params.fechaFin
		contratoInstance.nombreCliente = params.nombreCliente
		contratoInstance.tipoContrato = params.tipoContrato
		contratoInstance.objetoContrato = params.objetoContrato
		contratoInstance.lugarAplicacion = params.lugarAplicacion
		contratoInstance.responsableCliente = params.responsableCliente
		contratoInstance.responsableCTM = params.responsableCTM
		contratoInstance.proyecto = proyectoInstance
		
		//intentando guardar
        if (!contratoInstance.save(flush: true)) {
            render(view: "create", model: [contratoInstance: contratoInstance])
            return
        }
		
		//Ya que las observaciones no son vitales no detenemos el flujo 
		// (nuevo contrato) si falla el guardado de las mismas
		try {
			
			def observacionesContratoInstance = new ObservacionesContrato();
			
			observacionesContratoInstance.contrato = contratoInstance;
			observacionesContratoInstance.observacion = params.observacion;
			observacionesContratoInstance.responsable = params.responsable;
			observacionesContratoInstance.fecha = params.fecha;
			
			if (!observacionesContratoInstance.save(flush: true)) {
				log.error("No se ha guardado correctamente la observacion para el nuevo contrato: "+contratoInstance.id)
				log.error(observacionesContratoInstance.getErrors())
			}
			
		} catch (Exception e) {
			log.error("Error al intentar guardar las observaciones: "+e.getMessage());
			e.printStackTrace();
		}
		

		flash.message = message(code: 'contrato.created.message', args: [message(code: 'contrato.label', default: 'Contrato'), contratoInstance.id])
        redirect(action: "show", id: contratoInstance.id)
    }

    def show() {
        def contratoInstance = Contrato.get(params.id)
		DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT);
        if (!contratoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'contrato.label', default: 'Contrato'), params.id])
            redirect(action: "list")
            return
        }

        [contratoInstance: contratoInstance]
    }

	@Secured(['ROLE_ADMIN','ROLE_CONTRATOS_EDIT'])
    def edit() {
        def contratoInstance = Contrato.get(params.id)
        if (!contratoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contrato.label', default: 'Contrato'), params.id])
            redirect(action: "list")
            return
        }

        [contratoInstance: contratoInstance]
    }

	@Secured(['ROLE_ADMIN','ROLE_CONTRATOS_EDIT'])
    def update() {
        def contratoInstance = Contrato.get(params.id)
        if (!contratoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contrato.label', default: 'Contrato'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (contratoInstance.version > version) {
                contratoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'contrato.label', default: 'Contrato')] as Object[],
                          "Another user has updated this Contrato while you were editing")
                render(view: "edit", model: [contratoInstance: contratoInstance])
                return
            }
        }

        contratoInstance.properties = params

        if (!contratoInstance.save(flush: true)) {
            render(view: "edit", model: [contratoInstance: contratoInstance])
            return
        }

		flash.message = message(code: 'contrato.updated.message', args: [message(code: 'contrato.label', default: 'Contrato'), contratoInstance.id])
        redirect(action: "edit", id: contratoInstance.id)
    }

	@Secured(['ROLE_ADMIN','ROLE_CONTRATOS_DELETE'])
    def delete() {
        def contratoInstance = Contrato.get(params.id)
        if (!contratoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'contrato.label', default: 'Contrato'), params.id])
            redirect(action: "list")
            return
        }

        try {
            contratoInstance.delete(flush: true)
			flash.message = message(code: 'contrato.deleted.message', args: [message(code: 'contrato.label', default: 'Contrato'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'contrato.label', default: 'Contrato'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def getByIdAjax(){
		def contratoInstance = Contrato.get(params.id)
		
		render(contentType: 'text/json'){
			result success:true,code:'OK', contratoInstance:contratoInstance
		}
	}
}
