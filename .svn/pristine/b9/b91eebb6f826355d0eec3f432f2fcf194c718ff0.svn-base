<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="CHAMPION"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<META NAME="ROBOTS" CONTENT="NOINDEX, NOFOLLOW">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'menu/css', file: 'component.css')}" type="text/css">
		<link href='http://fonts.googleapis.com/css?family=Roboto:300' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="${resource(dir: 'css/champion-theme', file: 'jquery-ui-1.10.3.custom.min.css')}" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script src="${resource(dir: 'js', file: 'jquery-ui-1.10.3.custom.min.js')}"></script>
		
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
		<div id="grailsLogo" role="banner" >
			<g:link controller="index"><img src="${resource(dir: 'images', file: 'logo.jpg')}" alt="CHAMPION"/></g:link>
			<div class="divUsuario" id="divUsuario">
				
				<div id="nomUsr">
					<sec:loggedInUserInfo field="username"/>&nbsp;&nbsp;|<a href="${createLink(controller:'logout' ) }">
					Cerrar Sesión</a>
				</div>
			</div>
		</div>
		
		
				<nav id="cbp-hrmenu" class="cbp-hrmenu">
					<ul>
						<li>
							<a href="#">Administración</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner"> 
									<div>
										<h4>Usuarios</h4>
										<ul>
											<li><a href="${createLink(uri: '/user/list')}"><g:message code="usuario.list.title" /></a></li>
											<li><a href="${createLink(uri: '/user/create')}"><g:message code="usuario.create.title" /></a></li>
										</ul>
									</div>
									<div>
										<h4>Perfiles</h4>
										<ul>
											<li><a href="${createLink(uri: '/group/list')}"><g:message code="perfil.list.title" /></a></li>
											<li><a href="${createLink(uri: '/group/create')}"><g:message code="perfil.create.title" /></a></li>
										</ul>
									</div>
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li>
						<li>
							<a href="#">Catálogos</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner"> 
									<div>
										<h4>Zonas</h4>
										<ul>
											<li><a href="${createLink(uri: '/zona/list')}"><g:message code="zona.list.title" /></a></li>
											<li><a href="${createLink(uri: '/zona/create')}"><g:message code="zona.create.title" /></a></li>
										</ul>
										<h4>Quién recibe</h4>
										<ul>
											<li><a href="${createLink(uri: '/receptor/list')}"><g:message code="receptor.list.title" /></a></li>
											<li><a href="${createLink(uri: '/receptor/create')}"><g:message code="receptor.create.title" /></a></li>
										</ul>
										<h4>Responsables</h4>
										<ul>
											<li><a href="${createLink(uri: '/responsable/list')}"><g:message code="responsable.list.title" /></a></li>
											<li><a href="${createLink(uri: '/responsable/create')}"><g:message code="responsable.create.title" /></a></li>
										</ul>
									</div>
									<div>
										<h4>Proyectos</h4>
										<ul>
											<li><a href="${createLink(uri: '/proyecto/list')}"><g:message code="proyecto.list.title" /></a></li>
											<li><a href="${createLink(uri: '/proyecto/create')}"><g:message code="proyecto.create.title" /></a></li>
										</ul>
										<h4>Almacenes</h4>
										<ul>
											<li><a href="${createLink(uri: '/almacen/relacionarZona')}"><g:message code="almacen.relacion.list" /></a></li>
										</ul>
										<h4>Contratos</h4>
										<ul>
											<li><a href="${createLink(uri: '/contrato/list')}"><g:message code="contrato.list.title" /></a></li>
											<li><a href="${createLink(uri: '/contrato/create')}"><g:message code="contrato.create.title" /></a></li>
										</ul>
									</div>
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li>
						<li>
							<a href="#">Materiales e insumos</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner" >
									<div style="width:500px;">
										<h4><g:message code="solicitud.label.long" /></h4>
										<ul>
											<li><a href="${createLink(uri: '/solicitud/create')}"><g:message code="solicitud.new.label" /></a></li>
											<li><a href="${createLink(uri: '/solicitud/list')}"><g:message code="solicitud.list.label" /></a></li>
										</ul>
										<h4><g:message code="solicitud.cotizacion.label" /></h4>
										<ul>
											<li><a href="${createLink(uri: '/cotizaciones')}"><g:message code="solicitud.cotizaciones.list.label" /></a></li>
										</ul>
									</div>
									<div>
										<h4>Ordenes de compra</h4>
										<ul>
											<%--  li><a href="${createLink(uri: '/orden/create')}"><g:message code="orden.list" default="Crear orden de compra"/></a></li--%>
											<li><a href="${createLink(uri: '/orden/list')}"><g:message code="orden.list" default="Listado de ordenes de compra"/></a></li>
										</ul>
									</div>
									<div>
										<h4>Recepci&oacute;n de producto</h4>
										<ul>
											<li><a href="${createLink(uri: '/recepcion/create')}"><g:message code="recepcion.create" default="Nueva recepci&oacute;n"/></a></li>
											<li><a href="${createLink(uri: '/recepcion/list')}"><g:message code="recepcion.list" default="Listado de recepciones"/></a></li>
										</ul>
									</div>
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li>
						<!-- li>
							<a href="#">Ordenes</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner"> 
									<div>
										<h4>Learning &amp; Games</h4>
										<ul>
											<li><a href="#">Catch the Bullet</a></li>
											<li><a href="#">Snoopydoo</a></li>
										</ul>
										<h4>Utilities</h4>
										<ul>
											<li><a href="#">Gadget Finder</a></li>
											<li><a href="#">Green Tree Express</a></li>
											<li><a href="#">Green Tree Pro</a></li>
											<li><a href="#">Wobbler 3.0</a></li>
											<li><a href="#">Coolkid</a></li>
										</ul>
									</div>
									<div>
										<h4>Education</h4>
										<ul>
											<li><a href="#">Learn Thai</a></li>
											<li><a href="#">Math Genius</a></li>
											<li><a href="#">Chemokid</a></li>
										</ul>
										<h4>Professionals</h4>
										<ul>
											<li><a href="#">Success 1.0</a></li>
											<li><a href="#">Moneymaker</a></li>
										</ul>
									</div>
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li -->
						<!-- li>
							<a href="#">Pedimentos</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner"> 
									<div>
										<h4>Usuarios</h4>
										<ul>
											<li><a href="${createLink(uri: '/usuario/list')}">Lista de Usuarios</a></li>
											<li><a href="#">Nuevo Usuario</a></li>
										</ul>
									</div>
									<div>
										<h4>Perfiles</h4>
										<ul>
											<li><a href="#">Lista de Perfiles</a></li>
											<li><a href="#">Nuevo Perfil</a></li>
										</ul>
									</div>
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li -->
					</ul>
				</nav>
		<script src="${resource(dir: 'menu/js', file: 'cbpHorizontalMenu.min.js')}"></script>
		<script>
			$(function() {
				cbpHorizontalMenu.init();
			});
		</script>
		
		
		<g:layoutBody/>
		<div class="footer" role="contentinfo" align="center"> &copy; 2014 Todos los derechos reservados Champion Technologies de Mexico S.A. de C.V. - Desarrollado por Koomonisoft :: BUILD <g:meta name="app.version"/></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
        <r:layoutResources />
	</body>
</html>