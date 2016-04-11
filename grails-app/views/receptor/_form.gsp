<%@ page import="championweb.Receptor" %>



<div class="fieldcontain ${hasErrors(bean: receptorInstance, field: 'nombres', 'error')} required">
	<label for="nombres">
		<g:message code="receptor.nombres.label" default="Nombres" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombres" required="" size="30" maxlength="50" value="${receptorInstance?.nombres}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: receptorInstance, field: 'apellidoP', 'error')} required">
	<label for="apellidoP">
		<g:message code="receptor.apellidoP.label" default="Apellido P" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidoP" size="30" maxlength="50" required="" value="${receptorInstance?.apellidoP}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: receptorInstance, field: 'apellidoM', 'error')} required">
	<label for="apellidoM">
		<g:message code="receptor.apellidoM.label" default="Apellido M" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidoM" size="30" maxlength="50" required="" value="${receptorInstance?.apellidoM}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: receptorInstance, field: 'observaciones', 'error')} ">
	<label for="observaciones">
		<g:message code="receptor.observaciones.label" default="Observaciones" />
	</label>
	<g:textArea name="observaciones" value="${receptorInstance?.observaciones}"/>
</div>
<br/>
<table border="0">
<tr>
<th>
	<label for="telMovil">
			<g:message code="receptor.telMovil.label" maxlength="15" default="Tel. Movil" />
	</label>
</th>
<th>
	<label for="telOficina">
			<g:message code="receptor.telOficina.label" default="Tel Oficina" />
	</label>
</th>
<th>
	<label for="telNextel">
		<g:message code="receptor.telNextel.label" default="Tel Nextel" />
	</label>
</th>
<th>
	<label for="idNextel">
		<g:message code="receptor.idNextel.label" default="Id Nextel" />
	</label>
</th>
</tr>
<tr>
<td>
	<g:textField name="telMovil" maxlength="15" value="${receptorInstance?.telMovil}"/>
</td>
<td>
	<g:textField name="telOficina" maxlength="15" value="${receptorInstance?.telOficina}"/>
</td>
<td>
	<g:textField name="telNextel" maxlength="15" value="${receptorInstance?.telNextel}"/>
</td>
<td>
	<g:textField name="idNextel" size="5" maxlength="15" value="${receptorInstance?.idNextel}"/>
</td>
</tr>
</table>
<br/>
