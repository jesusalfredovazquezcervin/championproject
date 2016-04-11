 <table>
	 <thead>
	   <tr>
	   	  <th>Clave</th>
	      <th>Nombre</th>
	      <th>Almac&eacute;n</th>
	      <th>Existencia</th>
	      <th>Cantidad</th>
	      <th>&nbsp;</th>
	   </tr>
	 </thead>
	 <tbody>
	<g:each in="${productos.productos}"  status="i" var="productoInstance">
	   <g:if test="${productoInstance}">
	      <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
	       	 <td>${productoInstance.clave}</td>
	         <td>${productoInstance.descripcion}</td>
	         <td>${productoInstance.descAlmacen}</td>
	         <td>${productoInstance.existencia}</td>
	         <td> <input type="number" id="cantidadStock_${i}" name="cantidadStock_${i}" style="width: 35px;"> </td>
	         <td> <span onclick="saveStockTMP('${productoInstance.clave}','${productoInstance.claveAlmacen}','${i}');" class="ui-icon ui-icon-circle-plus"></span> </td>
	      </tr>
	   </g:if>
	</g:each>
	</tbody>
</table>
