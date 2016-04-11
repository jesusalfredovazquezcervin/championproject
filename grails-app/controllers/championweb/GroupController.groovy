package championweb

import org.springframework.dao.DataIntegrityViolationException

import grails.plugin.springsecurity.annotation.Secured
import org.apache.commons.logging.LogFactory;


@Secured(['ROLE_ADMIN','ROLE_GROUP_CREATE','ROLE_GROUP_EDIT','ROLE_GROUP_DELETE'])
class GroupController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	private static final log = LogFactory.getLog(this);
	
	def beforeInterceptor = {
		println params
	}
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [groupInstanceList: Group.list(params), groupInstanceTotal: Group.count()]
    }

	@Secured(['ROLE_ADMIN','ROLE_GROUP_CREATE'])
    def create() {
        [groupInstance: new Group(params)]
    }

	@Secured(['ROLE_ADMIN','ROLE_GROUP_CREATE'])
    def save() {
		println params
        def groupInstance = new Group(params)
        if (!groupInstance.save(flush: true)) {
            render(view: "create", model: [groupInstance: groupInstance])
            return
        }
		
		def role
		def groupRole
		
		if(params.roleAdmin == "ROLE_ADMIN"){
			role = Role.findByAuthority("ROLE_ADMIN")
			groupRole = new GroupRole()
			groupRole.group = groupInstance
			groupRole.role = role
			groupRole.save(flush:true)
			log.debug(groupRole.errors)
		}else{
			if(params.roles.class.isArray()){
			
				params.roles.each {
					role = Role.findByAuthority(it)
					
					if(role){
						groupRole = new GroupRole()
						groupRole.group = groupInstance
						groupRole.role = role
						groupRole.save(flush:true)
					}
					
				}
				
			}else{
				role = Role.findByAuthority(params.roles)
				groupRole = new GroupRole()
				groupRole.group = groupInstance
				groupRole.role = role
				groupRole.save(flush:true)
			}
		}
		

        flash.message = message(code: 'default.created.message', args: [message(code: 'group.label', default: 'Group'), groupInstance.id])
        redirect(action: "show", id: groupInstance.id)
    }

    def show(Long id) {
		println "aa"
        def groupInstance = Group.get(id)
        if (!groupInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'group.label', default: 'Group'), id])
            redirect(action: "list")
            return
        }

        [groupInstance: groupInstance]
    }

	@Secured(['ROLE_ADMIN','ROLE_GROUP_EDIT'])
    def edit(Long id) {
        def groupInstance = Group.get(id)
        if (!groupInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'group.label', default: 'Group'), id])
            redirect(action: "list")
            return
        }

        [groupInstance: groupInstance]
    }

	@Secured(['ROLE_ADMIN','ROLE_GROUP_EDIT'])
    def update(Long id, Long version) {
        def groupInstance = Group.get(id)
        if (!groupInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'group.label', default: 'Group'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (groupInstance.version > version) {
                groupInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'group.label', default: 'Group')] as Object[],
                          "Another user has updated this Group while you were editing")
                render(view: "edit", model: [groupInstance: groupInstance])
                return
            }
        }
		
		def role
		def groupRole
		
		GroupRole.executeUpdate("DELETE GroupRole g WHERE group.id = ${groupInstance.id}")
		
		if(params.roleAdmin == "ROLE_ADMIN"){
			role = Role.findByAuthority("ROLE_ADMIN")
			groupRole = new GroupRole()
			groupRole.group = groupInstance
			groupRole.role = role
			groupRole.save(flush:true)
			log.debug(groupRole.errors)
		}else{
			if(params.roles.class.isArray()){
				
				params.roles.each {
					role = Role.findByAuthority(it)
					
					if(role){
						groupRole = new GroupRole()
						groupRole.group = groupInstance
						groupRole.role = role
						groupRole.save(flush:true)
					}
					
				}
				
			}else{
				role = Role.findByAuthority(params.roles)
				groupRole = new GroupRole()
				groupRole.group = groupInstance
				groupRole.role = role
				groupRole.save(flush:true)
			}
		}

        groupInstance.properties = params

        if (!groupInstance.save(flush: true)) {
            render(view: "edit", model: [groupInstance: groupInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'group.label', default: 'Group'), groupInstance.id])
        redirect(action: "show", id: groupInstance.id)
    }

	@Secured(['ROLE_ADMIN','ROLE_GROUP_DELETE'])
    def delete(Long id) {
        def groupInstance = Group.get(id)
        if (!groupInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'group.label', default: 'Group'), id])
            redirect(action: "list")
            return
        }

        try {
			def descripcion = groupInstance.descripcion
			
			if(User.findAllByPerfil(groupInstance).isEmpty())
				GroupRole.executeUpdate("DELETE GroupRole g WHERE group.id = ${groupInstance.id}")
			
            groupInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'group.label', default: 'Group'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'group.label', default: 'Group'), id])
            redirect(action: "show", id: id)
        }
    }
}
