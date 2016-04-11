
<%@ page import="championweb.ObservacionesContrato" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'observacionesContrato.label', default: 'ObservacionesContrato')}" />
		<title><g:message code="observacionesContrato.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-observacionesContrato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="observacionesContrato.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-observacionesContrato" class="content scaffold-list" role="main">
			<h1><g:message code="observacionesContrato.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="observacion" title="${message(code: 'observacionesContrato.observacion.label', default: 'Observacion')}" />
					
						<g:sortableColumn property="responsable" title="${message(code: 'observacionesContrato.responsable.label', default: 'Responsable')}" />
					
						<g:sortableColumn property="fecha" title="${message(code: 'observacionesContrato.fecha.label', default: 'Fecha')}" />
					
						<th><g:message code="observacionesContrato.contrato.label" default="Contrato" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${observacionesContratoInstanceList}" status="i" var="observacionesContratoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${observacionesContratoInstance.id}">${fieldValue(bean: observacionesContratoInstance, field: "observacion")}</g:link></td>
					
						<td>${fieldValue(bean: observacionesContratoInstance, field: "responsable")}</td>
					
						<td><g:formatDate date="${observacionesContratoInstance.fecha}" /></td>
					
						<td>${fieldValue(bean: observacionesContratoInstance, field: "contrato")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${observacionesContratoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
