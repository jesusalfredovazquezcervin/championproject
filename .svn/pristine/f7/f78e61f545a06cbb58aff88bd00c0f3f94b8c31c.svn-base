
<%@ page import="championweb.Receptor" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'receptor.label', default: 'Receptor')}" />
		<title><g:message code="receptor.list.title" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-receptor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-receptor" class="content scaffold-list" role="main">
			<h1><g:message code="receptor.list.title" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombres" title="${message(code: 'receptor.nombres.label', default: 'Nombres')}" />
					
						<g:sortableColumn property="apellidoP" title="${message(code: 'receptor.apellidoP.label', default: 'Apellido P')}" />
					
						<g:sortableColumn property="apellidoM" title="${message(code: 'receptor.apellidoM.label', default: 'Apellido M')}" />
					
						<g:sortableColumn property="idNextel" title="${message(code: 'receptor.idNextel.label', default: 'Id Nextel')}" />
					
						<g:sortableColumn property="observaciones" title="${message(code: 'receptor.observaciones.label', default: 'Observaciones')}" />
					
						<g:sortableColumn property="telMovil" title="${message(code: 'receptor.telMovil.label', default: 'Tel Movil')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${receptorInstanceList}" status="i" var="receptorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${receptorInstance.id}">${fieldValue(bean: receptorInstance, field: "nombres")}</g:link></td>
					
						<td>${fieldValue(bean: receptorInstance, field: "apellidoP")}</td>
					
						<td>${fieldValue(bean: receptorInstance, field: "apellidoM")}</td>
					
						<td>${fieldValue(bean: receptorInstance, field: "idNextel")}</td>
					
						<td>${fieldValue(bean: receptorInstance, field: "observaciones")}</td>
					
						<td>${fieldValue(bean: receptorInstance, field: "telMovil")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${receptorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
