
<%@ page import="championweb.ExtContrato" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'extContrato.label', default: 'ExtContrato')}" />
		<title><g:message code="extContrato.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-extContrato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="extContrato.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="extContrato.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-extContrato" class="content scaffold-show" role="main">
			<h1><g:message code="extContrato.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list extContrato">
			
				<g:if test="${extContratoInstance?.fechaInicial}">
				<li class="fieldcontain">
					<span id="fechaInicial-label" class="property-label"><g:message code="extContrato.fechaInicial.label" default="Fecha Inicial" /></span>
					
						<span class="property-value" aria-labelledby="fechaInicial-label"><g:formatDate date="${extContratoInstance?.fechaInicial}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${extContratoInstance?.fechaFinal}">
				<li class="fieldcontain">
					<span id="fechaFinal-label" class="property-label"><g:message code="extContrato.fechaFinal.label" default="Fecha Final" /></span>
					
						<span class="property-value" aria-labelledby="fechaFinal-label"><g:formatDate date="${extContratoInstance?.fechaFinal}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${extContratoInstance?.contrato}">
				<li class="fieldcontain">
					<span id="contrato-label" class="property-label"><g:message code="extContrato.contrato.label" default="Contrato" /></span>
					
						<span class="property-value" aria-labelledby="contrato-label"><g:link controller="contrato" action="show" id="${extContratoInstance?.contrato?.id}">${extContratoInstance?.contrato?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${extContratoInstance?.id}" />
					<g:link class="edit" action="edit" id="${extContratoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
