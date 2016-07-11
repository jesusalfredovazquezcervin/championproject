<script type="text/javascript">
function saveMe(partida){
	console.debug(partida);
	alert($('#cant_'+partida).val());
} 
</script>
<input type="hidden" name="cantidad_partidas" id="cantidad_partidas" value="${partidas.size() }"/> <%--CANTIDAD PARTIDAS DE LA SOLICITUD--%>
<table>
				<thead>
					<tr>
					
						<th>Partida</th>
					
						<th>Clave</th>
					
						<th>Descripción</th>
						
						<th>Cantidad</th>
					
						<th>Unidad/Medida</th>
						
						<th>Almacen</th>
						
						<th>&nbsp;</th>
						
					</tr>
				</thead>
				<tbody>
					<g:each in="${partidas}" var="partidaInstance" status="i">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${i + 1}</td>
					
						<td>${partidaInstance.cveProducto }</td>
						
						<td>${partidaInstance.descProducto }</td>
						
						
						
						<td><g:field type="number" min="1" value="${partidaInstance.cantidad?:1}" name="cant_${partidaInstance.cveProducto }" onChange="${remoteFunction(action: 'addCantidadTmpPartida', 
                       params: '\'tmpProyectoID=\'+\''+ partidaInstance.tmpProyectoID +'\'+\'&claveProducto=\'+\''+partidaInstance.cveProducto +'\'+\'&cantidad=\'+$(\'#cant_'+partidaInstance.cveProducto+'\').val()'  )}
						"/></td>
						<td>${partidaInstance.unidad }</td>
						<td>${partidaInstance?.lugarEntrega?.claveAlmacen}-${partidaInstance?.lugarEntrega?.descripcion} </td>
						
						<td><span onclick="${remoteFunction(action: 'delCantidadTmpPartida', 
								update:'partidasList',
		                       params: '\'tmpProyectoID=\'+\''+ partidaInstance.tmpProyectoID +'\'+\'&claveProducto=\'+\''+partidaInstance.cveProducto +'\'' )}"
		                       class='ui-icon ui-icon-circle-minus'></span></td>
					
					</tr>
					</g:each>
					
				</tbody>
			</table>