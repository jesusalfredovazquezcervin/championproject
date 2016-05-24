<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>EDITAR ORDEN DE COMPRA</title>
<script src="${resource(dir: 'js', file: 'spin.min.js')}"></script>
<script type="text/javascript">
var consultaProveedor  = "${createLink(controller:'orden', action:'consultaProveedor')}";
/*$(function() {
    $( "#fecha" ).datepicker({dateFormat: 'dd/mm/yy'});
    var myDate = new Date();
	var prettyDate = myDate.getDate() + '/' + (myDate.getMonth()+1) + '/' +
	        myDate.getFullYear();
	$("#fecha").val(prettyDate)
  });
*/
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

	function actualizarOrden(){
		var idOrden = $('#idOrden').val();
		var numeroOrden= $('#numero').val();
		var fechaRec = $('#fechaRec').val();
		var moneda =$('#moneda').val();
		var descFinal=$('#descFinal').val();
		var desc =$('#desc').val();		
		var tipoCambio=$('#tipoCambio').val();
		var esquema=$('#esquema').val();
		var idProve=$('#proveedor').val();
		var fecha=$('#fecha').val();
		${remoteFunction(
				action:'updateOrden',
				controller:'orden',				
				params:'\'idOrden=\'+idOrden+\'&numeroOrden=\'+numeroOrden+\'&fechaRec=\'+fechaRec+\'&moneda=\'+moneda+\'&descFinal=\'+descFinal+\'&descuento=\'+desc+\'&tipoCambio=\'+tipoCambio+\'&esquema=\'+esquema+\'&idProveedor=\'+idProve+\'&fecha=\'+fecha',
				update:'mensaje'
			)}

		var partidasArray = $("#partidasid").val().replace('[','').replace(']','').replace(' ','').split(',');
		recalcularTotal(partidasArray[0]);
	}
		//alert("ostras");

	
	
	function crearMOD(){
		var parametro = $('#idOrden').val();
			${remoteFunction(
					action:'crearMOD',
					controller:'orden',
					params:'\'porden=\'+parametro',
					update:'mensaje'
				)}
		};


	
	$(function(){
		$( "#dialog-resumen" ).dialog({
			  autoOpen: false,
		    modal: true,
		    height: 550,
		    width: 650,
		    stack: false,
		    buttons: {
		      Aceptar: function() {
		        $( this ).dialog("close");
		      }
		    }
		});



				  
	});

	
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
		<div id="listado-partidas">
			<g:render template="partidas"></g:render>
			<g:render template="resumen"/>
		</div>
  </div>
  
	<fieldset class="buttons">
		<g:submitButton name="generar" class="save" value="${message(code: 'default.button.update.label', default: 'Actualizar Orden')}" onclick="actualizarOrden()" />
		<g:submitButton name="crearmod" class="save" value="${message(code: 'default.button.createMOD.label', default: 'Crear MOD')}" onclick="crearMOD()"/>
		
	</fieldset>

  <div id="mensaje" class="body">
		<g:render template="mensaje"/>
		
  </div>

  
</body>
</html>