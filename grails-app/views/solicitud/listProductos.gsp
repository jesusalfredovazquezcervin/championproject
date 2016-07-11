 <table>
	 <thead>
	   <tr>
	   	  <th><g:message code="solicitud.prod.th.cve" default="Cve" /></th>
	      <th><g:message code="solicitud.prod.th.desc" default="Desc" /></th>
	      <th><g:message code="solicitud.prod.th.medida" default="Unidad/Medida" /></th>
	      <th><g:message code="solicitud.prod.th.almacen" default="Lugar entrega" /></th>
	      <th>&nbsp;</th>
	   </tr>
	 </thead>
	 <tbody>
	<g:each in="${productos.productos}"  status="i" var="productoInstance">
	   <g:if test="${productoInstance}">
	      <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
	       	 <td> <label id="productoclave_${i}">${productoInstance.clave}</label> </td>
	         <td>${productoInstance.descripcion}</td>
	         <td><label id="medida_${i}">${productoInstance.uni_med.toUpperCase()}</label> </td> 
	         
	         <td>
                <g:select id="lugarentrega_select_${i}" name="lugarentrega_select_${i}" from="${championweb.Almacen.list()}" optionKey="id" 
                   optionValue="nombreCompleto" required=""  class="many-to-one" noSelection="['':'-Seleccione-']" />

</td>
	         <td>
	         	
	         	<g:remoteLink action="addTmpPartida" controller="solicitud" update="partidasList" 
	         	
	         	params="{lugarentrega_selected_id:\$('#lugarentrega_select_${i}').val(), claveProducto:\$('#productoclave_${i}').text(), tmpProyectoID: ${params.idSolicitudTMP}, medida:\$('#medida_${i}').text()  } ">
	         	<span class="ui-icon ui-icon-circle-plus"></span>
	         	</g:remoteLink> 
	         	
	         </td>
	      </tr>
	   </g:if>
	</g:each>
	</tbody>
</table>


