<%@ page import="championweb.Perfil" %>



<div class="fieldcontain ${hasErrors(bean: perfilInstance, field: 'nombrePerfil', 'error')} required">
	<label for="nombrePerfil">
		<g:message code="perfil.nombrePerfil.label" default="Nombre Perfil" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombrePerfil" required="" maxlength="10" value="${perfilInstance?.nombrePerfil}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: perfilInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="perfil.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" size="30" maxlength="80" value="${perfilInstance?.descripcion}"/>
</div>

