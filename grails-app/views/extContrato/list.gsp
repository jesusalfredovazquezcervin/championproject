
<%@ page import="championweb.ExtContrato" %>
<!doctype html>
<html>
	<head>
		<!--meta name="layout" content="main"-->
		<g:set var="entityName" value="${message(code: 'extContrato.label', default: 'ExtContrato')}" />
		<title><g:message code="extContrato.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-extContrato" class="content scaffold-list" role="main">
			<!--h1><g:message code="extContrato.list.label" args="[entityName]" /></h1-->
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<!--g:sortableColumn property="fechaInicial" title="${message(code: 'extContrato.fechaInicial.label', default: 'Fecha Inicial')}" /-->
						<th class="sortable">${message(code: 'extContrato.fechaInicial.label', default: 'Fecha Inicial')}</th>
						<th class="sortable">${message(code: 'extContrato.fechaFinal.label', default: 'Fecha Final')}</th>
						<th class="sortable"></th>
						<!--g:sortableColumn property="fechaFinal" title="${message(code: 'extContrato.fechaFinal.label', default: 'Fecha Final')}" /-->
					
						<!--th><g:message code="extContrato.contrato.label" default="Contrato" /></th-->
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${extContratoInstanceList}" status="i" var="extContratoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<!--td><g:link action="show" id="${extContratoInstance.id}">${fieldValue(bean: extContratoInstance, field: "fechaInicial")}</g:link></td-->
						<td><g:formatDate format='dd /MM /yyyy' date="${extContratoInstance.fechaInicial}" /></td>
						
						<td><g:formatDate format='dd /MM /yyyy' date="${extContratoInstance.fechaFinal}" /></td>
						
						<td>
							<g:remoteLink controller="extContrato" onSuccess="refreshExt();" action="delete" id="${extContratoInstance.id}">
							<span class="ui-icon ui-icon-trash"></span>
							</g:remoteLink>
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>
