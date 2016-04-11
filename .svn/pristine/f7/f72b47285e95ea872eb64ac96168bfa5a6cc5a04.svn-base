<%@ page import="championweb.RecoveryLink" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="login">
		<g:set var="entityName" value="${message(code: 'recoveryLink.public.label', default: 'RecoveryLink')}" />
		<title><g:message code="recoveryLink.public.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-recoveryLink" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
		</div>
		<div id="create-recoveryLink" class="content scaffold-create" role="main">
			<h1><g:message code="recoveryLink.public.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:if test="${flash.error}">
			<ul class="errors" role="alert"><li>${flash.error}</li></ul>
			</g:if>
			<g:hasErrors bean="${recoveryLinkInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${recoveryLinkInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons" align="center">
					<g:submitButton name="create" class="save" value="${message(code: 'recoveryLink.public.button', default: 'Get password')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
