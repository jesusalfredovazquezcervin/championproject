<script type="text/javascript">
	function searchCotPendiente(){
		var parametro = $('#pbuscar').val();
			${remoteFunction(
					action:'searchPendientes',
					controller:'cotizaciones',
					params:'\'pbuscar=\'+parametro',
					update:'cotpendientes'
				)}
		}
</script>

<table border="0" style="width: 50%;">
	  <tr style="background: #ffffff;">
	    <td>
	    	<input type="search" size="50" id="pbuscar" name="pbuscar" autofocus="autofocus" placeholder="Buscar por Folio de Solicitud" value="${pbuscar}" >
	    </td>
	    <td class="tdButton" id="tdButton" onclick="searchCotPendiente();">
			&nbsp;<img src="${resource(dir: 'images/skin/batch_icons/16x16', file: 'search.png')}" alt="CHAMPION"/>
		</td>
	  </tr>
	 
</table>

<table>
	<thead>
	<tr>
		<th>Solicitud</th>
		<th>Proveedor</th>
		<th>Fecha Creación</th>
		<th>Cant. Partidas</th>
		<th>&nbsp;</th>
	</tr>
	</thead>
	<tbody>
	<g:each in="${cotPendientesList}" var="cotPendiente" status="i">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			<td>${cotPendiente[1]} - ${cotPendiente[2]}</td>
			<td>${cotPendiente[4]}</td>
			<td>${cotPendiente[5]}</td>
			<td>${cotPendiente[3]}</td>
			<td><g:link action="detalle" params="[id:cotPendiente[0],prov:cotPendiente[4]]">Ver</g:link></td>
		</tr>
	</g:each>
	</tbody>
</table>
	
	<div class="pagination">
		<util:remotePaginate controller="cotizaciones" action="searchPendientes" total="${cotPendientesTotal?:0}"
         update="cotpendientes" max="10" pageSizes="[10, 20, 50]" alwaysShowPageSizes="true" params="['pbuscar':pbuscar?:'']" />
	</div>