<%@ page import="championweb.Group" %>

<div class="fieldcontain ${hasErrors(bean: groupInstance, field: 'authority', 'error')} required">
	<label for="authority">
		<g:message code="perfil.nombrePerfil.label" default="Nombre Perfil" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="authority" required="" value="${groupInstance?.authority}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: groupInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="perfil.descripcion.label" default="Descripción" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${groupInstance?.descripcion}"/>
</div>

<fieldset id="fs02">
 
	<legend>Permisos:</legend>
	 
		<label for="descripcion">
			<g:message code="group.descripcion.label" default="Administración" />
		</label>
		<input type="checkbox" value="ROLE_ADMIN" name="roleAdmin" ${roles?.role?.authority.any{'ROLE_ADMIN'.equals(it)} ? 'checked':''}>
		
	<br><br>
	
	<table>
	  <tr>
	    <td>
	    	<g:message code="role.user.title" /><br>
	    	<select multiple name="roles" class="form-control" style="width:150px;">
			  <option value="ROLE_USER_CREATE" ${roles?.role?.authority.any{'ROLE_USER_CREATE'.equals(it)} ? 'selected':''}><g:message code="role.create"  /></option>
			  <option value="ROLE_USER_EDIT" ${roles?.role?.authority.any{'ROLE_USER_EDIT'.equals(it)} ? 'selected':''}><g:message code="role.edit"  /></option>
			  <option value="ROLE_USER_DELETE" ${roles?.role?.authority.any{'ROLE_USER_DELETE'.equals(it)} ? 'selected':''}><g:message code="role.delete" /></option>
			</select>
	    </td>
	    <td>
	    	<g:message code="role.group.title" /><br>
	    	<select multiple name="roles" class="form-control" style="width:150px;">
			  <option value="ROLE_GROUP_CREATE" ${roles?.role?.authority.any{'ROLE_GROUP_CREATE'.equals(it)} ? 'selected':''}><g:message code="role.create"  /></option>
			  <option value="ROLE_GROUP_EDIT" ${roles?.role?.authority.any{'ROLE_GROUP_EDIT'.equals(it)} ? 'selected':''}><g:message code="role.edit"  /></option>
			  <option value="ROLE_GROUP_DELETE" ${roles?.role?.authority.any{'ROLE_GROUP_DELETE'.equals(it)} ? 'selected':''}><g:message code="role.delete" /></option>
			</select>
	    </td>
	    <td>
	    	<g:message code="role.proyecto.title" /><br>
	    	<select multiple name="roles" class="form-control" style="width:150px;">
			  <option value="ROLE_PROYECTO_CREATE" ${roles?.role?.authority.any{'ROLE_PROYECTO_CREATE'.equals(it)} ? 'selected':''}><g:message code="role.create"  /></option>
			  <option value="ROLE_PROYECTO_EDIT" ${roles?.role?.authority.any{'ROLE_PROYECTO_EDIT'.equals(it)} ? 'selected':''}><g:message code="role.edit"  /></option>
			  <option value="ROLE_PROYECTO_DELETE" ${roles?.role?.authority.any{'ROLE_PROYECTO_DELETE'.equals(it)} ? 'selected':''}><g:message code="role.delete" /></option>
			</select>
	    </td>
	    <td>
	    	<g:message code="role.zona.title" /><br>
	    	<select multiple name="roles" class="form-control" style="width:150px;">
			  <option value="ROLE_ZONA_CREATE" ${roles?.role?.authority.any{'ROLE_ZONA_CREATE'.equals(it)} ? 'selected':''}><g:message code="role.create"  /></option>
			  <option value="ROLE_ZONA_EDIT" ${roles?.role?.authority.any{'ROLE_ZONA_EDIT'.equals(it)} ? 'selected':''}><g:message code="role.edit"  /></option>
			  <option value="ROLE_ZONA_DELETE" ${roles?.role?.authority.any{'ROLE_ZONA_DELETE'.equals(it)} ? 'selected':''}><g:message code="role.delete" /></option>
			</select>
	    </td>
	  </tr>
	  
	  <tr>
	    <td>
	    	<g:message code="role.receptor.title" /><br>
	    	<select multiple name="roles" class="form-control" style="width:150px;">
			  <option value="ROLE_RECEPTOR_CREATE" ${roles?.role?.authority.any{'ROLE_RECEPTOR_CREATE'.equals(it)} ? 'selected':''}><g:message code="role.create"  /></option>
			  <option value="ROLE_RECEPTOR_EDIT" ${roles?.role?.authority.any{'ROLE_RECEPTOR_EDIT'.equals(it)} ? 'selected':''}><g:message code="role.edit"  /></option>
			  <option value="ROLE_RECEPTOR_DELETE" ${roles?.role?.authority.any{'ROLE_RECEPTOR_DELETE'.equals(it)} ? 'selected':''}><g:message code="role.delete" /></option>
			</select>
	    </td>
	    <td>
	    	<g:message code="role.responsable.title" /><br>
	    	<select multiple name="roles" class="form-control" style="width:150px;">
			  <option value="ROLE_RESPONSABLE_CREATE" ${roles?.role?.authority.any{'ROLE_RESPONSABLE_CREATE'.equals(it)} ? 'selected':''}><g:message code="role.create"  /></option>
			  <option value="ROLE_RESPONSABLE_EDIT" ${roles?.role?.authority.any{'ROLE_RESPONSABLE_EDIT'.equals(it)} ? 'selected':''}><g:message code="role.edit"  /></option>
			  <option value="ROLE_RESPONSABLE_DELETE" ${roles?.role?.authority.any{'ROLE_RESPONSABLE_DELETE'.equals(it)} ? 'selected':''}><g:message code="role.delete" /></option>
			</select>
	    </td>
	    <td>
	    	<g:message code="role.relacionalma.title" /><br>
	    	<select multiple name="roles" class="form-control" style="width:150px;">
			  <option value="ROLE_ALMACENES_RELACIONAR" ${roles?.role?.authority.any{'ROLE_ALMACENES_RELACIONAR'.equals(it)} ? 'selected':''}><g:message code="role.relacionar.almacenes"  /></option>
			</select>
	    </td>
	    <td>
	    	<g:message code="role.contrato.title" /><br>
	    	<select multiple name="roles" class="form-control" style="width:150px;">
			  <option value="ROLE_CONTRATOS_CREATE" ${roles?.role?.authority.any{'ROLE_CONTRATOS_CREATE'.equals(it)} ? 'selected':''}><g:message code="role.create"  /></option>
			  <option value="ROLE_CONTRATOS_EDIT" ${roles?.role?.authority.any{'ROLE_CONTRATOS_EDIT'.equals(it)} ? 'selected':''}><g:message code="role.edit"  /></option>
			  <option value="ROLE_CONTRATOS_DELETE" ${roles?.role?.authority.any{'ROLE_CONTRATOS_DELETE'.equals(it)} ? 'selected':''}><g:message code="role.delete" /></option>
			</select>
	    </td>
	  </tr>
	  
	  <tr>
	    <td colspan="2">
	    	<g:message code="role.solicitud.title" /><br>
	    	<select multiple name="roles" class="form-control" style="width:200px;">
			  <option value="ROLE_SOLICITUD_CREATE" ${roles?.role?.authority.any{'ROLE_SOLICITUD_CREATE'.equals(it)} ? 'selected':''}><g:message code="role.create"  /></option>
			  <option value="ROLE_SOLICITUD_EDIT" ${roles?.role?.authority.any{'ROLE_SOLICITUD_EDIT'.equals(it)} ? 'selected':''}><g:message code="role.edit"  /></option>
			  <option value="ROLE_SOLICITUD_DELETE" ${roles?.role?.authority.any{'ROLE_SOLICITUD_DELETE'.equals(it)} ? 'selected':''}><g:message code="role.delete" /></option>
			  <option value="ROLE_SOLICITUD_ASIGNAR_ORDEN" ${roles?.role?.authority.any{'ROLE_SOLICITUD_ASIGNAR_ORDEN'.equals(it)} ? 'selected':''}><g:message code="role.solicitud.ordencompra" /></option>
			</select>
	    </td>
	    <td>
	    	<!--  -->
	    </td>
	    <td>
	    	<!--  -->
	    </td>
	   
	  </tr>
	  
	</table>

</fieldset>

