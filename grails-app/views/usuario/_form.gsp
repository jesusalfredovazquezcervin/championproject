<%@ page import="championweb.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="usuario.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="usuario" required="" value="${usuarioInstance?.usuario}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="usuario.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="password" required="" value="${usuarioInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'nombres', 'error')} required">
	<label for="nombres">
		<g:message code="usuario.nombres.label" default="Nombres" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombres" required="" value="${usuarioInstance?.nombres}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'apellidos', 'error')} required">
	<label for="apellidos">
		<g:message code="usuario.apellidos.label" default="Apellidos" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidos" required="" value="${usuarioInstance?.apellidos}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="usuario.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${usuarioInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'perfil', 'error')} required">
	<label for="perfil">
		<g:message code="usuario.perfil.label" default="Perfil" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="perfil" name="perfil.id" from="${championweb.Perfil.list()}" optionKey="id" optionValue="nombrePerfil" required="" value="${usuarioInstance?.perfil?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'zona', 'error')} required">
	<label for="zona">
		<g:message code="usuario.zona.label" default="Zona" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="zona" name="zona.id" from="${championweb.Zona.list()}" optionKey="id" optionValue="nombreZona" required="" value="${usuarioInstance?.zona?.id}" class="many-to-one"/>
</div>

