<%@ page import="championweb.ExtContrato" %>

<div class="fieldcontain ${hasErrors(bean: extContratoInstance, field: 'fechaInicial', 'error')} required">
	<label for="fechaInicial">
		<g:message code="extContrato.fechaInicial.label" default="Fecha Inicial" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaInicial" precision="day"  value="${extContratoInstance?.fechaInicial}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: extContratoInstance, field: 'fechaFinal', 'error')} required">
	<label for="fechaFinal">
		<g:message code="extContrato.fechaFinal.label" default="Fecha Final" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaFinal" precision="day"  value="${extContratoInstance?.fechaFinal}"  />
</div>
<g:hiddenField name="contrato.id" value="${extContratoInstance?.contrato?.id}"/>
<!--  div class="fieldcontain ${hasErrors(bean: extContratoInstance, field: 'contrato', 'error')} required">
	<label for="contrato">
		<g:message code="extContrato.contrato.label" default="Contrato" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="contrato" name="contrato.id" from="${championweb.Contrato.list()}" optionKey="id" required="" value="${extContratoInstance?.contrato?.id}" class="many-to-one"/>
</div-->

