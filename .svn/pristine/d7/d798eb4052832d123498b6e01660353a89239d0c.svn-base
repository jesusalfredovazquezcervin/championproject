
<%@ page import="championweb.Responsable" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'responsable.label', default: 'Responsable')}" />
		<title><g:message code="responsable.list.title" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-responsable" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="responsable.create.title" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-responsable" class="content scaffold-list" role="main">
			<h1><g:message code="responsable.list.title" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombres" title="${message(code: 'responsable.nombres.label', default: 'Nombres')}" />
					
						<g:sortableColumn property="apellidoP" title="${message(code: 'responsable.apellidoP.label', default: 'Apellido P')}" />
					
						<g:sortableColumn property="apellidoM" title="${message(code: 'responsable.apellidoM.label', default: 'Apellido M')}" />
					
						<g:sortableColumn property="zona" title="${message(code: 'responsable.zona.label', default: 'Zona')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${responsableInstanceList}" status="i" var="responsableInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${responsableInstance.id}">${fieldValue(bean: responsableInstance, field: "nombres")}</g:link></td>
					
						<td>${fieldValue(bean: responsableInstance, field: "apellidoP")}</td>
					
						<td>${fieldValue(bean: responsableInstance, field: "apellidoM")}</td>
					
						<td>${fieldValue(bean: responsableInstance, field: "zona.nombreZona")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${responsableInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
