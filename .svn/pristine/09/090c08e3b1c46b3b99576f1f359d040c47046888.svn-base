<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>CREAR ORDEN DE COMPRA</title>
<script src="${resource(dir: 'js', file: 'spin.min.js')}"></script>
<script type="text/javascript">
var consultaProveedor  = "${createLink(controller:'orden', action:'consultaProveedor')}";
$(function() {
    $( "#fecha" ).datepicker({dateFormat: 'dd/mm/yy'});
    var myDate = new Date();
	var prettyDate = myDate.getDate() + '/' + (myDate.getMonth()+1) + '/' +
	        myDate.getFullYear();
	$("#fecha").val(prettyDate)
  });

	function consultaProv(idP){
		$( "#dialog-proveedores" ).dialog("close");
		$('#spinner').spin("modal");
		$.ajax({
			type: 'POST',
			url: consultaProveedor,
			dataType: 'json',
			data:"idp="+idP,
			success:function(data){
				$('#proveedor').val($.trim(data.clave))
				$('#rfc').val(data.rfc);
				$('#nombre').val(data.nombre);
				$('#calle').val(data.calle);
				$('#numext').val(data.numext);
				$('#colonia').val(data.colonia);
				$('#numint').val(data.numint);
				$('#cp').val(data.codigo);
				$('#poblacion').val(data.localidad);
				$('#pais').val(data.nacionalidad);
				$('#spinner').spin("modal");
				
			},
			error:function(request, status, error) {
					alert('ERROR: '+error+' '+request);
					$( "#dialog-proveedores" ).dialog("open");
					loading(true);
	              }	 
			});
	}

</script>

</head>


<style>
  #progressbar-proveedores .ui-progressbar-value {
    background-color: #ccc;
  }
</style>
<body>
<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
	</div>
  <div class="body">
		<g:render template="datos_generales"/>
		<g:render template="partidas"></g:render>
  </div>
  
  
</body>
</html>