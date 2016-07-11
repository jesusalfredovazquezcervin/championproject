<script>
$(function() {
	$( "#accordion-clasificacion" ).accordion({
		heightStyle: "content"
	});
});
</script>
<style>

.ui-accordion .ui-accordion-content {
    border-top: 0 none;
    overflow: auto;
    padding: 0.0em 0.0em;
}

</style>

<g:if test="${clasificacion}">
<fieldset id="fs02" style="">
<legend><g:message code="partidas.clasificadas.fieldset.label" default="Partidas ya clasificadas" /></legend>

<div id="accordion-clasificacion">

<g:each in="${clasificacion}" var="clasif">
	<h3>${clasif.proveedor }</h3>
		<div>
		<table style="">
			<thead>
			<tr>
				<th>Clave</th>
			
				<th>Descripción</th>
				
				<th>Cantidad</th>
			
				<th>Unidad/Medida</th>
				
				<th>Estatus</th>
				<th>Almacen</th>
				
				<th>&nbsp;</th>
			</tr>
			</thead>
			<tbody>
				<g:each in="${clasif.lista }" var="partida" status="i"> 
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${partida.cveProducto}</td>
						<td>${partida.descProducto}</td>
						<td>${partida.cantidad}</td>
						<td>${partida.unidad}</td>
						<td>${partida.estatus?.id==2?'Cotizaci&oacute;n':(partida.estatus?.id==1?'Revisi&oacute;n':(partida.estatus?.id==3?'Cot. enviada':'NA')) }</td>
						<td>${partida.lugarEntrega.claveAlmacen}-${partida.lugarEntrega.descripcion}</td>
						<td>
							<span id="modalProveedores" class='ui-icon ui-icon-circle-minus' 
								onclick="${remoteFunction(controller:'clasificacionProd',action:'undoClasificacion',
						   					params:['partida':partida.id], update:[success:'prov-seleccionado'],
											onSuccess:'refreshClasificacion()', onFailure:'refreshClasificacion()')}">
							</span>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
			
		Marcar todos como:&nbsp; 
		<select onchange="cambiaEstatusPartidas(this, ${clasif.idproveedor}, ${clasif.solicitud})">
			<option value="0">Seleccione...</option>
			<option value="1">En revisi&oacute;n</option>
			<option value="2">En cotizaci&oacute;n</option>
		</select>				
			
		</div> 
</g:each>

</div>

</fieldset>
</g:if>