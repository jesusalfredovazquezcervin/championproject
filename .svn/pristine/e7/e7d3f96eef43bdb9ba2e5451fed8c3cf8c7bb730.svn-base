package championweb

import championweb.Group;
import championweb.GroupRole;
import championweb.Role;
import org.apache.commons.lang.builder.HashCodeBuilder

/**
 * Relaci—n entre un grupo (perfil) y sus roles
 * @author renatocastaneda
 *
 */
class GroupRole implements Serializable{
	
	private static final long serialVersionUID = 1

    Group group
	Role role

    boolean equals(other) {
		if (!(other instanceof GroupRole)) {
			return false
		}

		other.group?.id == group?.id &&
			other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (group) builder.append(group.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static GroupRole get(long groupId, long roleId) {
		GroupRole.where {
			group == Group.load(groupId) &&
			role == Role.load(roleId)
		}.get()
	}

	static GroupRole create(Group g, Role role, boolean flush = false) {
		new GroupRole(group: Group, role: role).save(flush: flush, insert: true)
	}

	static boolean remove(Group g, Role r, boolean flush = false) {
		int rowCount = GroupRole.where {
			group == Group.load(g.id) &&
			role == Role.load(r.id)
		}.deleteAll()

		rowCount > 0
	}

	static void removeAll(Group g) {
		GroupRole.where {
			group == User.load(g.id)
		}.deleteAll()
	}

	static void removeAll(Role r) {
		GroupRole.where {
			role == Role.load(r.id)
		}.deleteAll()
	}

	static mapping = {
		id composite: ['role', 'group']
		version false
	}
}
