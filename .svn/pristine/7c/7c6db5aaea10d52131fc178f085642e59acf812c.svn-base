
<%@ page import="championweb.ObservacionesContrato" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'observacionesContrato.label', default: 'ObservacionesContrato')}" />
		<title><g:message code="observacionesContrato.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-observacionesContrato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="observacionesContrato.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="observacionesContrato.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-observacionesContrato" class="content scaffold-show" role="main">
			<h1><g:message code="observacionesContrato.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list observacionesContrato">
			
				<g:if test="${observacionesContratoInstance?.observacion}">
				<li class="fieldcontain">
					<span id="observacion-label" class="property-label"><g:message code="observacionesContrato.observacion.label" default="Observacion" /></span>
					
						<span class="property-value" aria-labelledby="observacion-label"><g:fieldValue bean="${observacionesContratoInstance}" field="observacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${observacionesContratoInstance?.responsable}">
				<li class="fieldcontain">
					<span id="responsable-label" class="property-label"><g:message code="observacionesContrato.responsable.label" default="Responsable" /></span>
					
						<span class="property-value" aria-labelledby="responsable-label"><g:fieldValue bean="${observacionesContratoInstance}" field="responsable"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${observacionesContratoInstance?.fecha}">
				<li class="fieldcontain">
					<span id="fecha-label" class="property-label"><g:message code="observacionesContrato.fecha.label" default="Fecha" /></span>
					
						<span class="property-value" aria-labelledby="fecha-label"><g:formatDate date="${observacionesContratoInstance?.fecha}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${observacionesContratoInstance?.contrato}">
				<li class="fieldcontain">
					<span id="contrato-label" class="property-label"><g:message code="observacionesContrato.contrato.label" default="Contrato" /></span>
					
						<span class="property-value" aria-labelledby="contrato-label"><g:link controller="contrato" action="show" id="${observacionesContratoInstance?.contrato?.id}">${observacionesContratoInstance?.contrato?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${observacionesContratoInstance?.id}" />
					<g:link class="edit" action="edit" id="${observacionesContratoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
