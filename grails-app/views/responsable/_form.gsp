<%@ page import="championweb.Responsable" %>



<div class="fieldcontain ${hasErrors(bean: responsableInstance, field: 'nombres', 'error')} required">
	<label for="nombres">
		<g:message code="responsable.nombres.label" default="Nombres" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombres" required="" value="${responsableInstance?.nombres}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: responsableInstance, field: 'apellidoP', 'error')} required">
	<label for="apellidoP">
		<g:message code="responsable.apellidoP.label" default="Apellido P" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidoP" required="" value="${responsableInstance?.apellidoP}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: responsableInstance, field: 'apellidoM', 'error')} required">
	<label for="apellidoM">
		<g:message code="responsable.apellidoM.label" default="Apellido M" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidoM" required="" value="${responsableInstance?.apellidoM}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: responsableInstance, field: 'observaciones', 'error')} ">
	<label for="observaciones">
		<g:message code="responsable.observaciones.label" default="Observaciones" />
		
	</label>
	<g:textArea name="observaciones" value="${responsableInstance?.observaciones}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: responsableInstance, field: 'zona', 'error')} required">
	<label for="zona">
		<g:message code="responsable.zona.label" default="Zona" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="zona" name="zona.id" from="${championweb.Zona.list()}" optionKey="id" optionValue="nombreZona" required="" value="${responsableInstance?.zona?.id}" class="many-to-one"/>
</div>
<br/>
<table border="0">
<tr>
<th>
	<label for="telMovil">
			<g:message code="receptor.telMovil.label" maxlength="15" default="Tel Movil" />
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
	<g:textField name="telMovil" maxlength="15" value="${responsableInstance?.telMovil}"/>
</td>
<td>
	<g:textField name="telOficina" maxlength="15" value="${responsableInstance?.telOficina}"/>
</td>
<td>
	<g:textField name="telNextel" maxlength="15" value="${responsableInstance?.telNextel}"/>
</td>
<td>
	<g:textField name="idNextel" size="5" maxlength="15" value="${responsableInstance?.idNextel}"/>
</td>
</tr>
</table>
