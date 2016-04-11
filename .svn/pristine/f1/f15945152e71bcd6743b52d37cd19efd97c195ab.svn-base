<script type="text/javascript">
	function searchSolicitud(){
		var parametro = $('#pbuscar').val();
			${remoteFunction(
					action:'searchSolicitud',
					controller:'solicitud',
					params:'\'pbuscar=\'+parametro',
					update:'list-solicitud'
				)}
		}
</script>

<table border="0" style="width: 90%; margin-left: 5%;">
	  <tr style="background: #ffffff;">
	    <td>
	    	<input type="search" size="50" id="pbuscar" name="pbuscar" autofocus="autofocus" placeholder="Buscar por Folio/Contrato/Almac&eacute;n" value="${pbuscar}" >
	    </td>
	    <td class="tdButton" id="tdButton" onclick="searchSolicitud();">
			&nbsp;<img src="${resource(dir: 'images/skin/batch_icons/16x16', file: 'search.png')}" alt="CHAMPION"/>
		</td>
	  </tr>
	 
</table>


<table>
	<thead>
		<tr>
		
			<th><g:message code="solicitud.folio.label" default="Folio Zona" /></th>
			
			<th><g:message code="solicitud.zona.label" default="Zona" /></th>
			
			<th><g:message code="solicitud.almacen.label" default="Almacén" /></th>
		
			<th><g:message code="solicitud.fechaCreacionSolicitud.label" default="Fecha de creación" /></th>
			
			<th><g:message code="solicitud.usuarioCreo.label" default="Usuario que solicita" /></th>
			
			<th><g:message code="solicitud.estatus.label" default="Estatus" /></th>
		
		</tr>
	</thead>
	<tbody>
	<g:each in="${solicitudInstanceList}" status="i" var="solicitudInstance">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
		
			<td><g:link action="edit" id="${solicitudInstance.id}">${fieldValue(bean: solicitudInstance, field: "contPorZona")}-${solicitudInstance.usuarioCreo?.zona?.id}</g:link></td>
			
			<td>${solicitudInstance.usuarioCreo?.zona?.descripcion?:'NA' }</td>
		
			<td>${fieldValue(bean: solicitudInstance, field: "lugarEntrega.descripcion")}</td>
			
			<td><g:formatDate date="${solicitudInstance.fechaCreacionSolicitud}" type="datetime" style="MEDIUM"/></td>
			
			<td>${solicitudInstance.usuarioCreo?.getNombreCompleto()}</td>
			
			<td>${solicitudInstance.estatus==1?'Abierta':(solicitudInstance.estatus==2?'En revisión':'En cotización')}</td>
		
		</tr>
	</g:each>
	</tbody>
</table>

	<div class="pagination">
		<util:remotePaginate controller="solicitud" action="searchSolicitud" total="${solicitudInstanceTotal?:0}"
         update="list-solicitud" max="10" pageSizes="[10, 20, 50]" alwaysShowPageSizes="true" params="['pbuscar':pbuscar?:'']" />
	</div>
	
<script>
$("#pbuscar").keyup(function (e) {
    if (e.keyCode == 13) {
    	searchSolicitud();
    }
});
</script>