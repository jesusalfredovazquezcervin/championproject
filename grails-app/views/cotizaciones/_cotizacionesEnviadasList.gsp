<script type="text/javascript">
	function searchEnviadas(){
		var parametro = $('#pbuscarEnv').val();
			${remoteFunction(
					action:'searchEnviadas',
					controller:'cotizaciones',
					params:'\'pbuscarEnv=\'+parametro',
					update:'cotenviadas'
				)}
		}
</script>

<table border="0" style="width: 50%;">
	  <tr style="background: #ffffff;">
	    <td>
	    	<input type="search" size="50" id="pbuscarEnv" name="pbuscarEnv" autofocus="autofocus" placeholder="Buscar por Folio de Solicitud / Nombre de proveedor" value="${pbuscarEnv}" >
	    </td>
	    <td class="tdButton" id="tdButton" onclick="searchEnviadas();">
			&nbsp;<img src="${resource(dir: 'images/skin/batch_icons/16x16', file: 'search.png')}" alt="CHAMPION"/>
		</td>
	  </tr>
	 
</table>

<table>
	<thead>
	<tr>
		<th>Solicitud</th>
		<th>Proveedor</th>
		<th>Fecha envío</th>
		<th>Fecha último envío</th>
		<th>Cant. Partidas</th>
		<th>Veces enviada</th>
		<th>&nbsp;</th>
	</tr>
	</thead>
	<tbody>
	<g:each in="${cotizacionesList}" var="cotizacion" status="i">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			<td>${cotizacion?.partida?.solicitud[0].contPorZona +'-'+ cotizacion?.partida?.solicitud[0].usuarioCreo?.zona?.id}</td>
			<td>${cotizacion.nombreProv } (${cotizacion.provSAE})</td>
			<td><g:formatDate date="${cotizacion.fechaEnvPrimeraVez}" type="datetime" style="MEDIUM"/></td>
			<td><g:formatDate date="${cotizacion.fechaUltimoEnvio}" type="datetime" style="MEDIUM"/></td>
			<td>${cotizacion.partida.size()}</td>
			<td>${cotizacion.vecesEnviado}</td>
			<td><g:link action="cotizacionEnviada" controller="cotizaciones" id="${cotizacion.id}">Ver</g:link></td>
		</tr>
	</g:each>
	</tbody>
</table>

<div class="pagination">
	<util:remotePaginate controller="cotizaciones" action="searchEnviadas" total="${cotizacionesTotal?:0}"
        update="cotenviadas" max="10" pageSizes="[10, 20, 50]" alwaysShowPageSizes="true" params="['pbuscarEnv':pbuscarEnv?:'']" />
</div>