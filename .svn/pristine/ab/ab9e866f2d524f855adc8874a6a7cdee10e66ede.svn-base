<%@ page import="championweb.Contrato" %>
<%@ page import="championweb.ObservacionesContrato" %>


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
		
		&nbsp;&nbsp;Al:
		<g:datePicker name="fechaFin" precision="day"  value="${contratoInstance?.fechaFin}"  />

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
	<g:textArea name="objetoContrato" required="" value="${contratoInstance?.objetoContrato}"/><br>
</div>

<!-- SECCION DE OBSERVACION -->
<fieldset id="fs02">
    <legend><g:message code="contrato.observacion.fieldset" default="Fecha observación" /></legend>
   <g:textArea style="width:100%" name="observacion" value="${observacionesContratoInstance?.observacion}"/><br><br>
   <label for="responsable">
		<g:message code="contrato.responsableObs.label" default="Responsable de observación" />
	</label>
   <g:textField name="responsable" size="30" value="${observacionesContratoInstance?.responsable}"/>
   &nbsp;&nbsp;
   <label for="fecha">
		<g:message code="contrato.fechaObs.label" default="Fecha observación" />
	</label>
   <g:datePicker name="fecha" precision="day"  value="${observacionesContratoInstance?.fecha}"  />
</fieldset>
<!-- SECCION DE OBSERVACION -->
