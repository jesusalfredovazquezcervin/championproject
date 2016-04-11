
<%@ page import="championweb.Perfil" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'perfil.label', default: 'Perfil')}" />
		<title><g:message code="perfil.list.title" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-perfil" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-perfil" class="content scaffold-list" role="main">
			<h1><g:message code="perfil.list.title" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombrePerfil" title="${message(code: 'perfil.nombrePerfil.label', default: 'Nombre Perfil')}" />
					
						<g:sortableColumn property="descripcion" title="${message(code: 'perfil.descripcion.label', default: 'Descripcion')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${perfilInstanceList}" status="i" var="perfilInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${perfilInstance.id}">${fieldValue(bean: perfilInstance, field: "nombrePerfil")}</g:link></td>
					
						<td>${fieldValue(bean: perfilInstance, field: "descripcion")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${perfilInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
