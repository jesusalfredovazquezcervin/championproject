 <table>
	 <thead>
	   <tr>
	   	  <th>Clave</th>
	      <th>Nombre</th>
	      <th>Almac&eacute;n</th>
	      <th>Cantidad</th>
	      <th>&nbsp;</th>
	   </tr>
	 </thead>
	 <tbody>
	<g:each in="${stockList}"  status="i" var="productoInstance">
	   <g:if test="${productoInstance}">
	      <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
	       	 <td>${productoInstance.cveProducto}</td>
	         <td>${productoInstance.nombreProducto}</td>
	         <td>${productoInstance.cveAlmacen}</td>
	         <td>${productoInstance.cantidad}</td>
	         <td> <g:remoteLink action="deleteStockList" params="[tmpProyectoID:productoInstance.tmpProyectoID, cveProducto:productoInstance.cveProducto]" controller="solicitud" onSuccess="refreshStockList()"><span  class="ui-icon ui-icon-circle-minus"></span></g:remoteLink>  </td>
	      </tr>
	   </g:if>
	</g:each>
	</tbody>
</table>
