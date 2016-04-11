<script type="text/javascript">
	function searchOrden(){
		var parametro = $('#pbuscar').val();
			${remoteFunction(
					action:'searchOrden',
					controller:'orden',
					params:'\'pbuscar=\'+parametro',
					update:'list-orden'
				)}
		}
</script>

<table border="0" style="width: 90%; margin-left: 5%;">
	  <tr style="background: #ffffff;">
	    <td>
	    	<input type="search" size="50" id="pbuscar" name="pbuscar" autofocus="autofocus" placeholder="Buscar por Orden Interna o SAE" value="${pbuscar}" >
	    </td>
	    <td class="tdButton" id="tdButton" onclick="searchOrden();">
			&nbsp;<img src="${resource(dir: 'images/skin/batch_icons/16x16', file: 'search.png')}" alt="CHAMPION"/>
		</td>
	  </tr>
	 
</table>


<table>
	<thead>
		<tr>
			<th><g:message code="ordenCompra.idInterno.label" default="No. orden" /></th>
		
			<th><g:message code="ordenCompra.idSae.label" default="No. orden SAE" /></th>
		
			<th><g:message code="ordenCompra.fecha.label" default="Fecha" /></th>
			
			<th><g:message code="ordenCompra.almacen.label" default="Almacén" /></th>
			
			<th></th>
					
		</tr>
	</thead>
	<tbody>
	<g:each in="${ordenCompraInstanceList}" status="i" var="ordenCompraInstance">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
		
			<td><g:link action="edit" id="${ordenCompraInstance.id}">${fieldValue(bean: ordenCompraInstance, field: "id")}</g:link></td>
			
			<td>${ordenCompraInstance.ordenSAE?:'Agregar No. SAE' }</td>
		
			<td><g:formatDate date="${ordenCompraInstance.fecha}" type="datetime" style="MEDIUM"/></td>
			
			<td>${ordenCompraInstance.almacen?.descripcion}</td>
		
			<td>Agregar recepción</td>
		</tr>
	</g:each>
	</tbody>
</table>