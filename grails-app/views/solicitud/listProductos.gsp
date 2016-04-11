 <table>
	 <thead>
	   <tr>
	   	  <th><g:message code="solicitud.prod.th.cve" default="Cve" /></th>
	      <th><g:message code="solicitud.prod.th.desc" default="Desc" /></th>
	      <th><g:message code="solicitud.prod.th.medida" default="Unidad/Medida" /></th>
	      <th>&nbsp;</th>
	   </tr>
	 </thead>
	 <tbody>
	<g:each in="${productos.productos}"  status="i" var="productoInstance">
	   <g:if test="${productoInstance}">
	      <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
	       	 <td>${productoInstance.clave}</td>
	         <td>${productoInstance.descripcion}</td>
	         <td>${productoInstance.uni_med.toUpperCase()}</td>
	         <td>
	         	
	         	<g:remoteLink action="addTmpPartida" controller="solicitud" update="partidasList" params="[tmpProyectoID:params.idSolicitudTMP,claveProducto:productoInstance.clave, desc:productoInstance.descripcion, medida:productoInstance.uni_med]">
	         	<span class="ui-icon ui-icon-circle-plus"></span> 
	         	</g:remoteLink> 
	         	
	         </td>
	      </tr>
	   </g:if>
	</g:each>
	</tbody>
</table>
