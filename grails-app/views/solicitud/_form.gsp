<%@ page import="championweb.Solicitud" %>

<g:field type="hidden" name="tmpSolicitudH" value="${idSolicitudTMP }"/>
<fieldset id="fs02" style="width: 42%; float: left; position: relative;">
	
	<legend><g:message code="solicitud.fieldset.general.label" default="General" /></legend>
	
	<!--  label>
		<g:message code="solicitud.fecha.solicita" default="General" />:${ new Date() }
	</label><br-->
	
	<div class=" ${hasErrors(bean: solicitudInstance, field: 'contrato', 'error')} required">
		<label for="contrato">
			<g:message code="solicitud.contrato.label" default="Contrato" />
			<span class="required-indicator">*</span>
		</label>
		<!--g:select id="contrato" name="contrato.id" from="${championweb.Contrato.list()}" optionKey="id" required="" value="${solicitudInstance?.contrato?.id}" class="many-to-one"/-->
		<g:select id="contrato_id" name="contrato_id" from="${championweb.Contrato.list()}" optionKey="id" optionValue="numContrato" required=""  class="many-to-one" noSelection="['':'-Seleccione-']" data-live-search="true" style="width:270px; padding-bottom:10px;margin-left:80px;"/>
		
			
	</div>
	
	<div class=" ${hasErrors(bean: solicitudInstance, field: 'proyecto', 'error')} required">
		<label for="proyecto">
			<g:message code="solicitud.proyecto.label" default="Proyecto(s)" />
			<span class="required-indicator">*</span>
		</label>
		<!--g:select name="proyecto" from="${championweb.Proyecto.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${solicitudInstance?.proyecto*.id}" class="many-to-many"/-->
		<g:field type="text" class="many-to-one" required="" name="proyectos_txt" id="proyectos_txt" disabled="" style="margin-left:85px;" />
		<button id="lista-proyectos" style="font-size: 14px; margin-bottom: 4px;">...</button>
	</div>
	
	<div class=" ${hasErrors(bean: solicitudInstance, field: 'lugarEntrega', 'error')} required">
		<label for="lugarEntrega">
			<g:message code="solicitud.lugarEntrega.label" default="Lugar Entrega" />
			<span class="required-indicator">*</span>
		</label>
		<!--g:select id="lugarEntrega" name="lugarEntrega.id" from="${championweb.Almacen.list()}" optionKey="id" required="" value="${solicitudInstance?.lugarEntrega?.id}" class="many-to-one"/-->
		<g:select id="lugarentrega_id" name="lugarentrega_id" from="${championweb.Almacen.list()}" optionKey="id" optionValue="nombreCompleto" required=""  class="many-to-one" noSelection="['':'-Seleccione-']" data-live-search="true" style="width:250px; padding-bottom:10px;margin-left:75px;"/>
		
		
	
	</div>
	
	<div class=" ${hasErrors(bean: solicitudInstance, field: 'recibe', 'error')} required">
		<label for="recibe">
			<g:message code="solicitud.recibe.label" default="Recibe" />
			<span class="required-indicator">*</span>
		</label>
		
		<g:select id="receptor_id" name="receptor_id" from="${championweb.Receptor.list()}" optionKey="id" optionValue="nombreCompleto" required=""  class="many-to-one" noSelection="['':'-Seleccione-']" data-live-search="true" style="width:270px; padding-bottom:10px;margin-left:80px;"/>
		
		
	</div>
	<br><br>

</fieldset>

<fieldset>
<div>
	<!--  label>
		<g:message code="solicitud.fecha.creacion" default="Creación" />:${ new Date() }
	</label><br><br-->
	<div class="required">
		<!--label for="razon">
			<g:message code="solicitud.razon.label" default="Razon" />
			<span class="required-indicator">*</span>
		</label-->
		<!-- g:select name="razon" from="${championweb.RazonSolicitud.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${solicitudInstance?.razon*.id}" class="many-to-many"/-->
		
		<g:each in="${championweb.RazonSolicitud.list()}" var="razonSolicitudInstance">
    		<g:checkBox name="razon" value="${razonSolicitudInstance?.id}" checked="false"/>
    		${razonSolicitudInstance?.descripcion }<br>
		</g:each>
		
	</div>
</div>
</fieldset>
<br>
<button id="add-programa"><g:message code="solicitud.programas.label" default="Programa de trabajo" /></button>
<button id="search-stock"><g:message code="solicitud.stock.label" default="Stock" /></button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<g:message code="solicitud.tipo.label" default="Stock" />&nbsp;
<!--  g:select name="tipoSolicitud" from=""/-->
<select name="tipoSolicitud" id="tipoSolicitud">
  <option value="1">Extranjera</option>
</select>
&nbsp;
<g:message code="solicitud.status.label" default="Status" />&nbsp;
<select name="estatusSolicitud" id="estatusSolicitud">
  <option value="1">Abierta</option>
</select>
<!--g:select name="estatusSolicitud" from=""/-->
<br>


<script type="text/javascript" src="${resource(dir: 'js', file: 'select2.min.js')}"></script>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'select2.css')}">
		<script type="text/javascript">
		$("#receptor_id").select2();
		$("#lugarentrega_id").select2();
		$("#contrato_id").select2();
		
	</script>

