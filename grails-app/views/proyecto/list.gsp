
<%@ page import="championweb.Proyecto" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'proyecto.label', default: 'Proyecto')}" />
		<title><g:message code="proyecto.list.title" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-proyecto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		
		
		<div id="list-proyecto" class="content scaffold-list" role="main">
			<h1><g:message code="proyecto.list.title" args="[entityName]" /></h1>
			
			<fieldset class="form" align="center">
					<g:render template="search"/>
			</fieldset>
			
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'proyecto.nombre.label', default: 'Nombre')}" />
					
						<!--  g:sortableColumn property="tipoProyecto" title="${message(code: 'proyecto.tipoProyecto.label', default: 'Tipo Proyecto')}" /-->
					
						<!-- g:sortableColumn property="descripcion" title="${message(code: 'proyecto.descripcion.label', default: 'Descripcion')}" /-->
					
						<th><g:message code="proyecto.almacen.label" default="Almacen" /></th>
					
						<!-- th><g:message code="proyecto.responsable.label" default="Responsable" /></th-->
					
						<th><g:message code="proyecto.zona.label" default="Zona" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${proyectoInstanceList}" status="i" var="proyectoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${proyectoInstance.id}">${fieldValue(bean: proyectoInstance, field: "nombre")}</g:link></td>
					
						<!--td>${fieldValue(bean: proyectoInstance, field: "tipoProyecto")}</td-->
					
						<!--td>${fieldValue(bean: proyectoInstance, field: "descripcion")}</td-->
					
						<td>${fieldValue(bean: proyectoInstance, field: "almacen.descripcion")}</td>
					
						<!--td>${fieldValue(bean: proyectoInstance, field: "responsable")}</td-->
					
						<td>${fieldValue(bean: proyectoInstance, field: "zona.nombreZona")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${proyectoInstanceTotal}" params="${[pbusqueda: pbusqueda]}" />
			</div>
		</div>
	</body>
</html>
