<script type="text/javascript">
	function checkID(){
		if($('#proveedoridh').length > 0)
			return true;
		else{
			alert("No hay proveedor seleccionado")
		}
	}
</script>
<g:if test="${partidas}">
	<fieldset id="fs02" style="">
	<legend><g:message code="partidas.sinclas.fieldset.label" default="Partidas sin clasificar" /></legend>
	<table>
					<thead>
						<tr>
						
							<th>Partida</th>
						
							<th>Clave</th>
						
							<th>Descripción</th>
							
							<th>Cantidad</th>
						
							<th>Unidad/Medida</th>
							
							<th>&nbsp;</th>
							
						</tr>
					</thead>
					<tbody>
						<g:each in="${partidas}" var="partidaInstance" status="i">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td>${i + 1}</td>
							<td>${partidaInstance.cveProducto }</td>
							<td>${partidaInstance.descProducto }</td>
							<td>${partidaInstance.cantidad }</td>
							<td>${partidaInstance.unidad }</td>
							
							<td><span onclick="${remoteFunction(action: 'mostrarClasificacion', 
									controller:'clasificacionProd',
									update:'clasificacion-partidas',
									before:'checkID()',
									onSuccess:'obtenerPartidas()',
			                       	params: '\'partida=\'+\''+ partidaInstance.id +'\'+\'&proveedor=\'+$(\'#proveedoridh\').val()' )}"
			                       class='ui-icon ui-icon-circle-plus'></span></td>
						</tr>
						</g:each>
						
					</tbody>
				</table>
	</fieldset>
</g:if>