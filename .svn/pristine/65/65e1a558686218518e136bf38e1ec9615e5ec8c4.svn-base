
<%@ page import="championweb.Solicitud" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'solicitud.label', default: 'Solicitud')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-solicitud" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-solicitud" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list solicitud">
			
				<g:if test="${solicitudInstance?.contrato}">
				<li class="fieldcontain">
					<span id="contrato-label" class="property-label"><g:message code="solicitud.contrato.label" default="Contrato" /></span>
					
						<span class="property-value" aria-labelledby="contrato-label"><g:link controller="contrato" action="show" id="${solicitudInstance?.contrato?.id}">${solicitudInstance?.contrato?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${solicitudInstance?.lugarEntrega}">
				<li class="fieldcontain">
					<span id="lugarEntrega-label" class="property-label"><g:message code="solicitud.lugarEntrega.label" default="Lugar Entrega" /></span>
					
						<span class="property-value" aria-labelledby="lugarEntrega-label"><g:link controller="almacen" action="show" id="${solicitudInstance?.lugarEntrega?.id}">${solicitudInstance?.lugarEntrega?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${solicitudInstance?.recibe}">
				<li class="fieldcontain">
					<span id="recibe-label" class="property-label"><g:message code="solicitud.recibe.label" default="Recibe" /></span>
					
						<span class="property-value" aria-labelledby="recibe-label"><g:link controller="receptor" action="show" id="${solicitudInstance?.recibe?.id}">${solicitudInstance?.recibe?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${solicitudInstance?.proyecto}">
				<li class="fieldcontain">
					<span id="proyecto-label" class="property-label"><g:message code="solicitud.proyecto.label" default="Proyecto" /></span>
					
						<g:each in="${solicitudInstance.proyecto}" var="p">
						<span class="property-value" aria-labelledby="proyecto-label"><g:link controller="proyecto" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${solicitudInstance?.razon}">
				<li class="fieldcontain">
					<span id="razon-label" class="property-label"><g:message code="solicitud.razon.label" default="Razon" /></span>
					
						<g:each in="${solicitudInstance.razon}" var="r">
						<span class="property-value" aria-labelledby="razon-label"><g:link controller="razonSolicitud" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${solicitudInstance?.id}" />
					<g:link class="edit" action="edit" id="${solicitudInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
