
<%@ page import="championweb.Receptor" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'receptor.label', default: 'Receptor')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-receptor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="receptor.list.title" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-receptor" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list receptor">
			
				<g:if test="${receptorInstance?.nombres}">
				<li class="fieldcontain">
					<span id="nombres-label" class="property-label"><g:message code="receptor.nombres.label" default="Nombres" /></span>
					
						<span class="property-value" aria-labelledby="nombres-label"><g:fieldValue bean="${receptorInstance}" field="nombres"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${receptorInstance?.apellidoP}">
				<li class="fieldcontain">
					<span id="apellidoP-label" class="property-label"><g:message code="receptor.apellidoP.label" default="Apellido P" /></span>
					
						<span class="property-value" aria-labelledby="apellidoP-label"><g:fieldValue bean="${receptorInstance}" field="apellidoP"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${receptorInstance?.apellidoM}">
				<li class="fieldcontain">
					<span id="apellidoM-label" class="property-label"><g:message code="receptor.apellidoM.label" default="Apellido M" /></span>
					
						<span class="property-value" aria-labelledby="apellidoM-label"><g:fieldValue bean="${receptorInstance}" field="apellidoM"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${receptorInstance?.idNextel}">
				<li class="fieldcontain">
					<span id="idNextel-label" class="property-label"><g:message code="receptor.idNextel.label" default="Id Nextel" /></span>
					
						<span class="property-value" aria-labelledby="idNextel-label"><g:fieldValue bean="${receptorInstance}" field="idNextel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${receptorInstance?.observaciones}">
				<li class="fieldcontain">
					<span id="observaciones-label" class="property-label"><g:message code="receptor.observaciones.label" default="Observaciones" /></span>
					
						<span class="property-value" aria-labelledby="observaciones-label"><g:fieldValue bean="${receptorInstance}" field="observaciones"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${receptorInstance?.telMovil}">
				<li class="fieldcontain">
					<span id="telMovil-label" class="property-label"><g:message code="receptor.telMovil.label" default="Tel Movil" /></span>
					
						<span class="property-value" aria-labelledby="telMovil-label"><g:fieldValue bean="${receptorInstance}" field="telMovil"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${receptorInstance?.telNextel}">
				<li class="fieldcontain">
					<span id="telNextel-label" class="property-label"><g:message code="receptor.telNextel.label" default="Tel Nextel" /></span>
					
						<span class="property-value" aria-labelledby="telNextel-label"><g:fieldValue bean="${receptorInstance}" field="telNextel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${receptorInstance?.telOficina}">
				<li class="fieldcontain">
					<span id="telOficina-label" class="property-label"><g:message code="receptor.telOficina.label" default="Tel Oficina" /></span>
					
						<span class="property-value" aria-labelledby="telOficina-label"><g:fieldValue bean="${receptorInstance}" field="telOficina"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${receptorInstance?.id}" />
					<g:link class="edit" action="edit" id="${receptorInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
