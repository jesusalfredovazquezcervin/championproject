
<%@ page import="championweb.Zona" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zona.label', default: 'Zona')}" />
		<title><g:message code="zona.list.title" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-zona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="zona.create.title" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-zona" class="content scaffold-list" role="main">
			<h1><g:message code="zona.list.title" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombreZona" title="${message(code: 'zona.nombreZona.label', default: 'Nombre Zona')}" />
					
						<g:sortableColumn property="descripcion" title="${message(code: 'zona.descripcion.label', default: 'Descripcion')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${zonaInstanceList}" status="i" var="zonaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${zonaInstance.id}">${fieldValue(bean: zonaInstance, field: "nombreZona")}</g:link></td>
					
						<td>${fieldValue(bean: zonaInstance, field: "descripcion")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${zonaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
