
<%@ page import="championweb.Proyecto" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'proyecto.label', default: 'Proyecto')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-proyecto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="proyecto.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-proyecto" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list proyecto">
			
				<g:if test="${proyectoInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="proyecto.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${proyectoInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${proyectoInstance?.tipoProyecto}">
				<li class="fieldcontain">
					<span id="tipoProyecto-label" class="property-label"><g:message code="proyecto.tipoProyecto.label" default="Tipo Proyecto" /></span>
					
						<span class="property-value" aria-labelledby="tipoProyecto-label"><g:fieldValue bean="${proyectoInstance}" field="tipoProyecto"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${proyectoInstance?.almacen}">
				<li class="fieldcontain">
					<span id="almacen-label" class="property-label"><g:message code="proyecto.almacen.label" default="Almacen" /></span>
					
						<span class="property-value" aria-labelledby="almacen-label">${proyectoInstance?.almacen?.descripcion.encodeAsHTML()}</span>
					
				</li>
				</g:if>
			
				<g:if test="${proyectoInstance?.responsable}">
				<li class="fieldcontain">
					<span id="responsable-label" class="property-label"><g:message code="proyecto.responsable.label" default="Responsable" /></span>
					
						<span class="property-value" aria-labelledby="responsable-label"><g:link controller="responsable" action="show" id="${proyectoInstance?.responsable?.id}">${proyectoInstance?.responsable?.nombreCompleto.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${proyectoInstance?.zona}">
				<li class="fieldcontain">
					<span id="zona-label" class="property-label"><g:message code="proyecto.zona.label" default="Zona" /></span>
					
						<span class="property-value" aria-labelledby="zona-label"><g:link controller="zona" action="show" id="${proyectoInstance?.zona?.id}">${proyectoInstance?.zona?.nombreZona.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${proyectoInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="proyecto.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${proyectoInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${proyectoInstance?.id}" />
					<g:link class="edit" action="edit" id="${proyectoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
