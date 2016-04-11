<%@ page import="championweb.ObservacionesContrato" %>



<div class="fieldcontain ${hasErrors(bean: observacionesContratoInstance, field: 'observacion', 'error')} required">
	<label for="observacion">
		<g:message code="observacionesContrato.observacion.label" default="Observacion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="observacion" required="" value="${observacionesContratoInstance?.observacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: observacionesContratoInstance, field: 'responsable', 'error')} required">
	<label for="responsable">
		<g:message code="observacionesContrato.responsable.label" default="Responsable" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="responsable" required="" value="${observacionesContratoInstance?.responsable}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: observacionesContratoInstance, field: 'fecha', 'error')} required">
	<label for="fecha">
		<g:message code="observacionesContrato.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fecha" precision="day"  value="${observacionesContratoInstance?.fecha}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: observacionesContratoInstance, field: 'contrato', 'error')} required">
	<label for="contrato">
		<g:message code="observacionesContrato.contrato.label" default="Contrato" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="contrato" name="contrato.id" from="${championweb.Contrato.list()}" optionKey="id" required="" value="${observacionesContratoInstance?.contrato?.id}" class="many-to-one"/>
</div>

