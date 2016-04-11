
<%@ page import="championweb.Solicitud" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'solicitud.label', default: 'Solicitud')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-solicitud" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="solicitud.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div class="content scaffold-list" role="main">
			<h1><g:message code="solicitud.list.label" args="[entityName]" /></h1>
			
			<div  id="list-solicitud" class="content scaffold-list">
				<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
				</g:if>
				<g:render template="listRemote"></g:render>
			</div>
			
		</div>
	</body>
</html>
