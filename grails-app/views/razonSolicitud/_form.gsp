<%@ page import="championweb.RazonSolicitud" %>



<div class="fieldcontain ${hasErrors(bean: razonSolicitudInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="razonSolicitud.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${razonSolicitudInstance?.descripcion}"/>
</div>

