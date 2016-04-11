<table>
				<thead>
					<tr>						
						<g:sortableColumn property="folioRemision" title="${message(code: 'recepcion.folioRemision.label', default: 'Folio Rem.')}" />
					
						<g:sortableColumn property="fechaRemision" title="${message(code: 'recepcion.fechaRemision.label', default: 'Fecha Rem.')}" />
						
						<g:sortableColumn property="fechaRecepcion" title="${message(code: 'recepcion.fechaRecepcion.label', default: 'Fecha Recep.')}" />
						
						<g:sortableColumn property="noPipa" title="${message(code: 'recepcion.noPipa.label', default: 'No. Pipa')}" />
						
						<g:sortableColumn property="placas" title="${message(code: 'recepcion.placas.label', default: 'Placas')}" />
						
						<g:sortableColumn property="nomChofer" title="${message(code: 'recepcion.nomChofer.label', default: 'Chofer')}" />
						
						<g:sortableColumn property="noVehiculo" title="${message(code: 'recepcion.noVehiculo.label', default: 'Vehiculo')}" />
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${rececepcionList}" status="i" var="recepcionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${recepcionInstance.id}">${fieldValue(bean: recepcionInstance, field: "folioRemision")}</g:link></td>
					
						<td>${fieldValue(bean: recepcionInstance, field: "fechaRemision")}</td>
					
						<td>${fieldValue(bean: recepcionInstance, field: "fechaRecepcion")}</td>
						
						<td>${fieldValue(bean: recepcionInstance, field: "noPipa")}</td>
						
						<td>${fieldValue(bean: recepcionInstance, field: "placas")}</td>
						
						<td>${fieldValue(bean: recepcionInstance, field: "nomChofer")}</td>
						
						<td>${fieldValue(bean: recepcionInstance, field: "noVehiculo")}</td>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${recepcionInstanceTotal}" />
			</div>