
<%@ page import="championweb.Contrato" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contrato.label', default: 'Contrato')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-contrato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="contrato.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-contrato" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list contrato">
			
				<g:if test="${contratoInstance?.numContrato}">
				<li class="fieldcontain">
					<span id="numContrato-label" class="property-label"><g:message code="contrato.numContrato.label" default="Num Contrato" /></span>
					
						<span class="property-value" aria-labelledby="numContrato-label"><g:fieldValue bean="${contratoInstance}" field="numContrato"/></span>
					
				</li>
				</g:if>
				<label for="periodo"><g:message code="contrato.periodo.label" default="Periodo Contrato" /></label>
				<g:if test="${contratoInstance?.fechaInicio}">
				<li class="fieldcontain">
					<span id="fechaInicio-label" class="property-label"><g:message code="contrato.fechaInicio.label" default="Fecha Inicio" /></span>
					
						<span class="property-value" aria-labelledby="fechaInicio-label"><g:formatDate format='dd/MM/yyyy' date="${contratoInstance?.fechaInicio}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${contratoInstance?.fechaFin}">
				<li class="fieldcontain">
					<span id="fechaFin-label" class="property-label"><g:message code="contrato.fechaFin.label" default="Fecha Fin" /></span>
					
						<span class="property-value" aria-labelledby="fechaFin-label"><g:formatDate format='dd/MM/yyyy' date="${contratoInstance?.fechaFin}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${contratoInstance?.nombreCliente}">
				<li class="fieldcontain">
					<span id="nombreCliente-label" class="property-label"><g:message code="contrato.nombreCliente.label" default="Nombre Cliente" /></span>
					
						<span class="property-value" aria-labelledby="nombreCliente-label"><g:fieldValue bean="${contratoInstance}" field="nombreCliente"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contratoInstance?.extension}">
				<li class="fieldcontain">
					<span id="extension-label" class="property-label"><g:message code="contrato.extension.label" default="Extension" /></span>
					
						<g:each in="${contratoInstance.extension}" var="e">
						<span class="property-value" aria-labelledby="extension-label">
							<!--  g:link controller="extContrato" action="show" id="${e.id}" -->
								Del <g:formatDate format='dd/MM/yyyy' date="${e?.fechaInicial}" /> al <g:formatDate format='dd/MM/yyyy' date="${e?.fechaFinal}" />
							<!-- /g:link -->
						</span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${contratoInstance?.lugarAplicacion}">
				<li class="fieldcontain">
					<span id="lugarAplicacion-label" class="property-label"><g:message code="contrato.lugarAplicacion.label" default="Lugar Aplicacion" /></span>
					
						<span class="property-value" aria-labelledby="lugarAplicacion-label"><g:fieldValue bean="${contratoInstance}" field="lugarAplicacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contratoInstance?.objetoContrato}">
				<li class="fieldcontain">
					<span id="objetoContrato-label" class="property-label"><g:message code="contrato.objetoContrato.label" default="Objeto Contrato" /></span>
					
						<span class="property-value" aria-labelledby="objetoContrato-label"><g:fieldValue bean="${contratoInstance}" field="objetoContrato"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contratoInstance?.proyecto}">
				<li class="fieldcontain">
					<span id="proyecto-label" class="property-label"><g:message code="contrato.proyecto.label" default="Proyecto" /></span>
					
						<span class="property-value" aria-labelledby="proyecto-label"><g:link controller="proyecto" action="show" id="${contratoInstance?.proyecto?.id}">${contratoInstance?.proyecto?.nombre?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${contratoInstance?.responsableCTM}">
				<li class="fieldcontain">
					<span id="responsableCTM-label" class="property-label"><g:message code="contrato.responsableCTM.label" default="Responsable CTM" /></span>
					
						<span class="property-value" aria-labelledby="responsableCTM-label"><g:fieldValue bean="${contratoInstance}" field="responsableCTM"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contratoInstance?.responsableCliente}">
				<li class="fieldcontain">
					<span id="responsableCliente-label" class="property-label"><g:message code="contrato.responsableCliente.label" default="Responsable Cliente" /></span>
					
						<span class="property-value" aria-labelledby="responsableCliente-label"><g:fieldValue bean="${contratoInstance}" field="responsableCliente"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contratoInstance?.tipoContrato}">
				<li class="fieldcontain">
					<span id="tipoContrato-label" class="property-label"><g:message code="contrato.tipoContrato.label" default="Tipo Contrato" /></span>
					
						<span class="property-value" aria-labelledby="tipoContrato-label"><g:fieldValue bean="${contratoInstance}" field="tipoContrato"/></span>
					
				</li>
				</g:if>
				
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${contratoInstance?.id}" />
					<g:link class="edit" action="edit" id="${contratoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
