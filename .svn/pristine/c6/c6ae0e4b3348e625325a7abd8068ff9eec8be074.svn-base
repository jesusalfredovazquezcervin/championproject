package championweb

import grails.plugin.springsecurity.annotation.Secured;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ALMACENES_RELACIONAR','ROLE_ADMIN'])
class RecepcionController {
	
	private static final log = LogFactory.getLog(this);


    def index(){redirect action:'list'}
	
	def list(Integer max){
		params.max = Math.min(max ?: 10, 100)
		
		def rececepcionList = Recepcion.findAll(params);
		def recepcionInstanceTotal = Recepcion.findAll().size()
		[rececepcionList:rececepcionList, recepcionInstanceTotal:recepcionInstanceTotal]
		
//		[receptorInstanceList: Receptor.list(params), receptorInstanceTotal: Receptor.count()]
		
	}
	
	@Secured(['ROLE_ALMACENES_RELACIONAR','ROLE_ADMIN'])
	def create() {
		[recepcionInstance: new Recepcion(params)]
	}
	
	@Secured(['ROLE_ALMACENES_RELACIONAR','ROLE_ADMIN'])
	def save() {
		def recepcionInstance = new Recepcion(params)
		if (!recepcionInstance .save(flush: true)) {
			render(view: "create", model: [recepcionInstance : recepcionInstance ])
			return
		}

		flash.message = message(code: 'recepcion.created.message', args: [message(code: 'recepcion.label', default: 'Recepcion'), recepcionInstance .id])
		redirect(action: "show", id: recepcionInstance .id)
	}
	
	@Secured(['ROLE_ALMACENES_RELACIONAR','ROLE_ADMIN'])
	def show() {
		def recepcionInstance = Recepcion.get(params.id)
		if (!recepcionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'recepcion.label', default: 'Recepcionr'), params.id])
			redirect(action: "list")
			return
		}

		[recepcionInstance: recepcionInstance]
	}
	
	
	@Secured(['ROLE_ALMACENES_RELACIONAR','ROLE_ADMIN'])
	def edit() {
		def recepcionInstance = Recepcion.get(params.id)
		if (!recepcionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'recepcion.label', default: 'Recepcion'), params.id])
			redirect(action: "list")
			return
		}

		[recepcionInstance: recepcionInstance]
	}

	@Secured(['ROLE_ALMACENES_RELACIONAR','ROLE_ADMIN'])
	def update() {
		def recepcionInstance = Recepcion.get(params.id)
		if (!recepcionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'recepcion.label', default: 'Recepcion'), params.id])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (recepcionInstance.version > version) {
				recepcionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'recepcion.label', default: 'Recepcion')] as Object[],
						  "Another user has updated this Receptor while you were editing")
				render(view: "edit", model: [recepcionInstance: recepcionInstance])
				return
			}
		}

		recepcionInstance.properties = params

		if (!recepcionInstance.save(flush: true)) {
			render(view: "edit", model: [recepcionInstance: recepcionInstance])
			return
		}

		flash.message = message(code: 'recepcion.success.update', args: [message(code: 'recepcion.label', default: 'Recepcion'), recepcionInstance.id])
		redirect(action: "show", id: recepcionInstance.id)
	}

	
	def delete() {
		def recepcionInstance = Recepcion.get(params.id)
		if (!recepcionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'recepcion.label', default: 'Recepcion'), params.id])
			redirect(action: "list")
			return
		}

		try {
			recepcionInstance.delete(flush: true)
			flash.message = message(code: 'recepcion.deleted.message', args: [message(code: 'recepcion.label', default: 'Recepcion'), params.id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'recepcion.label', default: 'Recepcion'), params.id])
			redirect(action: "show", id: params.id)
		}
	}
	
	
}
