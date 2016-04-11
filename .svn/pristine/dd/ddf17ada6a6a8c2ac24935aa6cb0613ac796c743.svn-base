<%@ page import="championweb.Recepcion" %>



<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'noPipa', 'error')} ">
	<label for="noPipa">
		<g:message code="recepcion.noPipa.label" default="No Pipa" />
		
	</label>
	<g:textField name="noPipa" value="${recepcionInstance?.noPipa}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'placas', 'error')} ">
	<label for="placas">
		<g:message code="recepcion.placas.label" default="Placas" />
		
	</label>
	<g:textField name="placas" value="${recepcionInstance?.placas}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'nomChofer', 'error')} ">
	<label for="nomChofer">
		<g:message code="recepcion.nomChofer.label" default="Nom Chofer" />
		
	</label>
	<g:textField name="nomChofer" value="${recepcionInstance?.nomChofer}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'marcaVehiculo', 'error')} ">
	<label for="marcaVehiculo">
		<g:message code="recepcion.marcaVehiculo.label" default="Marca Vehiculo" />
		
	</label>
	<g:textField name="marcaVehiculo" value="${recepcionInstance?.marcaVehiculo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'observaciones', 'error')} ">
	<label for="observaciones">
		<g:message code="recepcion.observaciones.label" default="Observaciones" />
		
	</label>
	<g:textField name="observaciones" value="${recepcionInstance?.observaciones}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'noVehiculo', 'error')} ">
	<label for="noVehiculo">
		<g:message code="recepcion.noVehiculo.label" default="No Vehiculo" />
		
	</label>
	<g:textField name="noVehiculo" value="${recepcionInstance?.noVehiculo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'bl', 'error')} ">
	<label for="bl">
		<g:message code="recepcion.bl.label" default="Bl" />
		
	</label>
	<g:textField name="bl" value="${recepcionInstance?.bl}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'fechaRecepcion', 'error')} required">
	<label for="fechaRecepcion">
		<g:message code="recepcion.fechaRecepcion.label" default="Fecha Recepcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaRecepcion" precision="day"  value="${recepcionInstance?.fechaRecepcion}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'fechaRemision', 'error')} required">
	<label for="fechaRemision">
		<g:message code="recepcion.fechaRemision.label" default="Fecha Remision" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaRemision" precision="day"  value="${recepcionInstance?.fechaRemision}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'folioRemision', 'error')} ">
	<label for="folioRemision">
		<g:message code="recepcion.folioRemision.label" default="Folio Remision" />
		
	</label>
	<g:textField name="folioRemision" value="${recepcionInstance?.folioRemision}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'isProdQuimico', 'error')} ">
	<label for="isProdQuimico">
		<g:message code="recepcion.isProdQuimico.label" default="Is Prod Quimico" />
		
	</label>
	<g:checkBox name="isProdQuimico" value="${recepcionInstance?.isProdQuimico}" />
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'obsMaterial', 'error')} ">
	<label for="obsMaterial">
		<g:message code="recepcion.obsMaterial.label" default="Obs Material" />
		
	</label>
	<g:textField name="obsMaterial" value="${recepcionInstance?.obsMaterial}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recepcionInstance, field: 'orden', 'error')} required">
	<label for="orden">
		<g:message code="recepcion.orden.label" default="Orden" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="orden" name="orden.id" from="${championweb.OrdenCompra.list()}" optionKey="id" 
	optionValue="${{it.id +' - '+it.fecha.format('yyyy-MM-dd')}}" required="" 
	value="${recepcionInstance?.orden?.id}" class="many-to-one"/>
</div>

