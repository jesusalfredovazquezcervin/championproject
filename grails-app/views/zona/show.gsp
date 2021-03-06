
<%@ page import="championweb.Zona" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'zona.label', default: 'Zona')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-zona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="zona.list.title" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="zona.create.title" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-zona" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list zona">
			
				<g:if test="${zonaInstance?.nombreZona}">
				<li class="fieldcontain">
					<span id="nombreZona-label" class="property-label"><g:message code="zona.nombreZona.label" default="Nombre Zona" /></span>
					
						<span class="property-value" aria-labelledby="nombreZona-label"><g:fieldValue bean="${zonaInstance}" field="nombreZona"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${zonaInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="zona.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${zonaInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${zonaInstance?.id}" />
					<g:link class="edit" action="edit" id="${zonaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
