
<%@ page import="championweb.RecoveryLink" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'recoveryLink.label', default: 'RecoveryLink')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-recoveryLink" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-recoveryLink" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="hashLink" title="${message(code: 'recoveryLink.hashLink.label', default: 'Hash Link')}" />
					
						<th><g:message code="recoveryLink.usuario.label" default="Usuario" /></th>
					
						<g:sortableColumn property="fecha" title="${message(code: 'recoveryLink.fecha.label', default: 'Fecha')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${recoveryLinkInstanceList}" status="i" var="recoveryLinkInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${recoveryLinkInstance.id}">${fieldValue(bean: recoveryLinkInstance, field: "hashLink")}</g:link></td>
					
						<td>${fieldValue(bean: recoveryLinkInstance, field: "usuario")}</td>
					
						<td><g:formatDate date="${recoveryLinkInstance.fecha}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${recoveryLinkInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
