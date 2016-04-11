<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="solicitud.cotizacion.label" /></title>
	</head>
	<body>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			<li><a class="list" href="${createLink(uri: '/cotizaciones')}"><g:message code="solicitud.cotizaciones.list.label"/></a></li>
		</ul>
	</div>
	<div id="list-cotpendientes" class="content scaffold-list" role="main">
	
	<g:form action="reSendCotizacion" controller="cotizaciones" >
	<input type="hidden" id="idsolicitud" name="idsolicitud" value="${idsolicitud}">
	<input type="hidden" id="idcotizacion" name="idcotizacion" value="${idcotizacion}">
	<input type="hidden" id="provclave" name="provclave" value="${proveedor.clave}">
	<input type="hidden" id="provnombre" name="provnombre" value="${proveedor.nombre}">
	<input type="hidden" id="provmail" name="provmail" value="${emailprov}">
	<table style="width: 98%; margin-left: 1%; ">
		<tr>
			<td><strong>Proveedor</strong></td>
			<td>${proveedor.nombre}</td>
			<td><strong>Estatus</strong></td>
			<td>Enviada</td>
		</tr>
		<tr>
			<td><strong>Correo proveedor</strong></td>
			<td>${emailprov}</td>
			<td><strong>Idioma del texto</strong></td>
			<td>
				<select id="idioma" name="idioma" 
					onchange="${remoteFunction(action:'getMensajeCorreo', controller:'cotizaciones',
								 update:[success:'mensaje',failure:'mensaje'], params:'\'idioma=\'+this.value')}">
					<option value="es">Español</option>
					<option value="en">Inglés</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><strong>Observaciones</strong></td>
			<td colspan="3">
				<textarea  id="observaciones" name="observaciones" draggable="false" id="observaciones" name="observaciones">${observaciones}</textarea>
			</td>
		</tr>
		<tr>
			<td><strong>Mensaje del correo</strong></td>
			<td colspan="3" id="mensaje" name="mensaje"><p>${msg.value}</p></td>
		</tr>
		<tr>
			<td style="padding-top: 12px;" colspan="2">
				<g:link style="background-color: #fcfcfc;border: 1px solid #cccccc;font-size: 1em;padding: 0.2em 0.4em;"
					 action="generateFromCotizacion" controller="orden" params="['idCotizacion':idcotizacion]" >Generar Orden de compra</g:link>
			</td>
			<td colspan="2" id="mensaje" name="mensaje" style="text-align: right;"><g:submitButton name="Enviar cotización" /> </td>
		</tr>
	</table>
	</g:form>
	<table>
		<thead>
			<tr>
				<th>Clave</th>
				<th>Descripción</th>
				<th>Cantidad</th>
				<th>Unidad/Medida</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${partidas}" var="partidaInstance" status="i">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
				<td>${partidaInstance.cveProducto}</td>
				<td>${partidaInstance.descProducto}</td>
				<td>${partidaInstance.cantidad }</td>
				<td>${partidaInstance.unidad }</td>
			</tr>
			</g:each>
		</tbody>
	</table>
	
	
	
	</div>
	<div class="pagination"></div>
	</body>
</html>