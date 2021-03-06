<%@ page import="championweb.ExtContrato" %>
<!doctype html>
<html>
	<head>
		<!--  meta name="layout" content="main"-->
		<g:set var="entityName" value="${message(code: 'extContrato.label', default: 'ExtContrato')}" />
		<title><g:message code="extContrato.create.label" args="[entityName]" /></title>
		
	</head>
	<body>
		<div id="create-extContrato" class="content scaffold-create" role="main">
			<h1><g:message code="extContrato.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${extContratoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${extContratoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			
		
				<fieldset class="form"  id="extForm" name="extForm">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<input class="save" type="button" onclick="guardarExt();" value="Guardar">
				</fieldset>
		</div>
	</body>
</html>
