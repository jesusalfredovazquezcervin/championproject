<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>BIENVENIDO :: CTMWEBAPP</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				/*margin: 2em 1em 1.25em 18em;*/
				margin: 2em 1em 1.25em 2em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
			
			.uppercase {
			    text-transform: uppercase;
			}
		</style>
	</head>
	<body>
		<%-- -div id="status" role="complementary">
			<h1>Application Status </h1>
			<ul>
				<li>App version: <g:meta name="app.version"/></li>
				<li>Grails version: <g:meta name="app.grails.version"/></li>
				<li>Groovy version: ${groovy.lang.GroovySystem.getVersion()}</li>
				<li>JVM version: ${System.getProperty('java.version')}</li>
				<li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
				<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
				<li>Domains: ${grailsApplication.domainClasses.size()}</li>
				<li>Services: ${grailsApplication.serviceClasses.size()}</li>
				<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
			</ul>
			<h1>Installed Plugins</h1>
			<ul>
				<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
					<li>${plugin.name} - ${plugin.version}</li>
				</g:each>
			</ul>
		</div--%>
		<div id="page-body" role="main">
			<h1 class="uppercase" >BIENVENIDO <sec:loggedInUserInfo field="username"/></h1>
			<p></p>

			<div id="controller-list" role="navigation">
				<fieldset id="fs02" style="">
				<legend>Mis solicitudes</legend>
					<table>
						<thead>
							<tr>
							
								<th><g:message code="solicitud.folio.label" default="Folio Zona" /></th>
								
								<th><g:message code="solicitud.zona.label" default="Zona" /></th>
								
								<th><g:message code="solicitud.almacen.label" default="Almacén" /></th>
							
								<th><g:message code="solicitud.fechaCreacionSolicitud.label" default="Fecha de creación" /></th>
								
								<th><g:message code="solicitud.estatus.label" default="Estatus" /></th>
							
							</tr>
						</thead>
						<tbody>
						<g:each in="${misSolicitudes}" status="i" var="solicitudInstance">
							<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							
								<td><g:link action="edit" controller="solicitud" id="${solicitudInstance.id}">${fieldValue(bean: solicitudInstance, field: "contPorZona")}-${solicitudInstance.usuarioCreo?.zona?.id}</g:link></td>
								
								<td>${solicitudInstance.usuarioCreo?.zona?.descripcion?:'NA' }</td>
							
								<td>${fieldValue(bean: solicitudInstance, field: "lugarEntrega.descripcion")}</td>
								
								<td><g:formatDate date="${solicitudInstance.fechaCreacionSolicitud}" type="datetime" style="MEDIUM"/></td>
								
								<td>${solicitudInstance.estatus==1?'Abierta':(solicitudInstance.estatus==2?'En revisión':'En cotización')}</td>
							
							</tr>
						</g:each>
						</tbody>
					</table>
				</fieldset>
			
			
				<fieldset id="fs02" style="">
					<legend>Últimas Solicitudes creadas</legend>
					
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
						<g:each in="${ultimasSolicitudes}" status="i" var="solicitudInstance">
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
				</fieldset>
				
				<br>
				<fieldset id="fs02" style="">
					<legend>Cotizaciones sin enviar</legend>
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
				</fieldset>
				
			</div>
		</div>
	</body>
</html>
