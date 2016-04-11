<%@ page import="championweb.Contrato" %>

<div class="fieldcontain ${hasErrors(bean: contratoInstance, field: 'numContrato', 'error')} required">
	<label for="numContrato">
		<g:message code="contrato.numContrato.label" default="Num Contrato" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="numContrato" required="" pattern="${contratoInstance.constraints.numContrato.matches}" value="${fieldValue(bean: contratoInstance, field: 'numContrato')}"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: contratoInstance, field: 'nombreCliente', 'error')} required">
	<label for="nombreCliente">
		<g:message code="contrato.nombreCliente.label" default="Nombre Cliente" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombreCliente" required="" size="80" value="${contratoInstance?.nombreCliente}"/>
</div>

<div class="fieldcontain">
	<label for="periodo"><g:message code="contrato.periodo.label" default="Periodo Contrato" /></label>
		De:
		<g:datePicker name="fechaInicio" precision="day"  value="${contratoInstance?.fechaInicio}"  />
		
		&nbsp;&nbsp;A:
		<g:datePicker name="fechaFin" precision="day"  value="${contratoInstance?.fechaFin}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: contratoInstance, field: 'extension', 'error')} ">
	<label for="extension">
		<g:message code="contrato.extension.label" default="Extension" />
		
	</label>
	
<ul class="one-to-many">
	<li class="add">
	<div id="updateMe" style="overflow:scroll;height:150px;width:310px;"></div>
	<button id="create-ext"><g:message code="contrato.add.extension" default="Extension" /></button>
	</li>
	
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: contratoInstance, field: 'lugarAplicacion', 'error')} ">
	<label for="lugarAplicacion">
		<g:message code="contrato.lugarAplicacion.label" default="Lugar Aplicacion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lugarAplicacion" required="" size="80" value="${contratoInstance?.lugarAplicacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contratoInstance, field: 'proyecto', 'error')} required">
	<label for="proyecto">
		<g:message code="contrato.proyecto.label" default="Proyecto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select  style="max-width:300px;" id="proyecto" name="proyecto.id" from="${championweb.Proyecto.list()}" optionKey="id" optionValue="nombre" required="" value="${contratoInstance?.proyecto?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contratoInstance, field: 'responsableCTM', 'error')} ">
	<label for="responsableCTM">
		<g:message code="contrato.responsableCTM.label" default="Responsable CTM" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="responsableCTM" required="" size="80" value="${contratoInstance?.responsableCTM}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contratoInstance, field: 'responsableCliente', 'error')} ">
	<label for="responsableCliente">
		<g:message code="contrato.responsableCliente.label" default="Responsable Cliente" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="responsableCliente" required="" size="80" value="${contratoInstance?.responsableCliente}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contratoInstance, field: 'tipoContrato', 'error')} ">
	<label for="tipoContrato">
		<g:message code="contrato.tipoContrato.label" default="Tipo Contrato" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="tipoContrato" size="80" required="" value="${contratoInstance?.tipoContrato}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contratoInstance, field: 'objetoContrato', 'error')} ">
	<label for="objetoContrato">
		<g:message code="contrato.objetoContrato.label" default="Objeto Contrato" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="objetoContrato" required="" value="${contratoInstance?.objetoContrato}"/>
</div>


<!-- MODAL PARA EXTENSIONES -->
<div id="dialog-form" title="<g:message code="extContrato.modal.header" default="Agregar Extensión" />" class="myDialogClass">
 	<!-- SE CARGA LA PANTALLA DE MODO REMOTO -->
</div>
<!-- MODAL PARA EXTENSIONES -->


