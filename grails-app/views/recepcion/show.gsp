
<%@ page import="championweb.Recepcion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'recepcion.label', default: 'Recepcion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-recepcion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-recepcion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list recepcion">
			
				<g:if test="${recepcionInstance?.noPipa}">
				<li class="fieldcontain">
					<span id="noPipa-label" class="property-label"><g:message code="recepcion.noPipa.label" default="No Pipa" /></span>
					
						<span class="property-value" aria-labelledby="noPipa-label"><g:fieldValue bean="${recepcionInstance}" field="noPipa"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.placas}">
				<li class="fieldcontain">
					<span id="placas-label" class="property-label"><g:message code="recepcion.placas.label" default="Placas" /></span>
					
						<span class="property-value" aria-labelledby="placas-label"><g:fieldValue bean="${recepcionInstance}" field="placas"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.nomChofer}">
				<li class="fieldcontain">
					<span id="nomChofer-label" class="property-label"><g:message code="recepcion.nomChofer.label" default="Nom Chofer" /></span>
					
						<span class="property-value" aria-labelledby="nomChofer-label"><g:fieldValue bean="${recepcionInstance}" field="nomChofer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.marcaVehiculo}">
				<li class="fieldcontain">
					<span id="marcaVehiculo-label" class="property-label"><g:message code="recepcion.marcaVehiculo.label" default="Marca Vehiculo" /></span>
					
						<span class="property-value" aria-labelledby="marcaVehiculo-label"><g:fieldValue bean="${recepcionInstance}" field="marcaVehiculo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.observaciones}">
				<li class="fieldcontain">
					<span id="observaciones-label" class="property-label"><g:message code="recepcion.observaciones.label" default="Observaciones" /></span>
					
						<span class="property-value" aria-labelledby="observaciones-label"><g:fieldValue bean="${recepcionInstance}" field="observaciones"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.noVehiculo}">
				<li class="fieldcontain">
					<span id="noVehiculo-label" class="property-label"><g:message code="recepcion.noVehiculo.label" default="No Vehiculo" /></span>
					
						<span class="property-value" aria-labelledby="noVehiculo-label"><g:fieldValue bean="${recepcionInstance}" field="noVehiculo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.bl}">
				<li class="fieldcontain">
					<span id="bl-label" class="property-label"><g:message code="recepcion.bl.label" default="Bl" /></span>
					
						<span class="property-value" aria-labelledby="bl-label"><g:fieldValue bean="${recepcionInstance}" field="bl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.fechaRecepcion}">
				<li class="fieldcontain">
					<span id="fechaRecepcion-label" class="property-label"><g:message code="recepcion.fechaRecepcion.label" default="Fecha Recepcion" /></span>
					
						<span class="property-value" aria-labelledby="fechaRecepcion-label"><g:formatDate date="${recepcionInstance?.fechaRecepcion}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.fechaRemision}">
				<li class="fieldcontain">
					<span id="fechaRemision-label" class="property-label"><g:message code="recepcion.fechaRemision.label" default="Fecha Remision" /></span>
					
						<span class="property-value" aria-labelledby="fechaRemision-label"><g:formatDate date="${recepcionInstance?.fechaRemision}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.folioRemision}">
				<li class="fieldcontain">
					<span id="folioRemision-label" class="property-label"><g:message code="recepcion.folioRemision.label" default="Folio Remision" /></span>
					
						<span class="property-value" aria-labelledby="folioRemision-label"><g:fieldValue bean="${recepcionInstance}" field="folioRemision"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.isProdQuimico}">
				<li class="fieldcontain">
					<span id="isProdQuimico-label" class="property-label"><g:message code="recepcion.isProdQuimico.label" default="Is Prod Quimico" /></span>
					
						<span class="property-value" aria-labelledby="isProdQuimico-label"><g:formatBoolean boolean="${recepcionInstance?.isProdQuimico}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.obsMaterial}">
				<li class="fieldcontain">
					<span id="obsMaterial-label" class="property-label"><g:message code="recepcion.obsMaterial.label" default="Obs Material" /></span>
					
						<span class="property-value" aria-labelledby="obsMaterial-label"><g:fieldValue bean="${recepcionInstance}" field="obsMaterial"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recepcionInstance?.orden}">
				<li class="fieldcontain">
					<span id="orden-label" class="property-label"><g:message code="recepcion.orden.label" default="Orden" /></span>
					
						<span class="property-value" aria-labelledby="orden-label">
						<g:link controller="orden" action="edit" id="${recepcionInstance?.orden?.id}">
						${recepcionInstance?.orden?.id}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${recepcionInstance?.id}" />
					<g:link class="edit" action="edit" id="${recepcionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
