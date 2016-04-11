<%@ page import="championweb.Zona" %>

 <style>
  #progressbar-stock .ui-progressbar-value {
    background-color: #ccc;
  }
  
  	
  
  </style>

<g:javascript>
	var ajaxSavePrograma  = "${createLink(controller:'solicitud',action:'saveTmpProgramaFiles')}";
	var downloadFile  	  = "${createLink(controller:'solicitud',action:'downloadProgramaTMP') }";
	var saveStockList	  = "${createLink(controller:'solicitud',action:'saveStockList') 	   }";
</g:javascript>

<script type="text/javascript">
/*
*
*FUNCIONALIDAD PARA -PROGRAMA DE TRABAJO
*
*/
$(function(){
	$( "input[type=file]" ).button({
		icons: {
    	    primary: "ui-icon-locked"
    	}
	});
});



//PARA EL PROGRESSBAR
$(function() {
	var progressbar = $( "#progressbar-programa" ),
    progressLabel = $( ".progress-label-programa" );
    
	progressbar.progressbar({
    	change: function() {
            progressLabel.text(  Math.round( (progressbar.progressbar( "value" )/progressbar.progressbar( "option", "max" ))*100 ) + "%" );
          },
         complete: function() {
        	  //progressLabel.text( "¡Carga finalizada!" );
          }
    });


	$( "#progressbar-stock" ).progressbar({
	      value: true
	    }).hide();
    
  });

function loading(val){
	
	$( "#progressbar-stock" ).progressbar( "option", "value", val );

	if(val){
		$( "#progressbar-stock" ).hide();
		}else{
			$( "#progressbar-stock" ).show();
		}
	
}

function progressHandlingFunction(e){
    if(e.lengthComputable){
        //console.log({value:e.loaded,max:e.total});
        $('#progressbar-programa').progressbar( "option", {
            value:  e.loaded, 
            max:e.total
          });
    }
}

function savePrograma(){
	var formData = new FormData($('#form_programa')[0]);
	$( "#dialog-loading-programa" ).dialog("open");
	$( "#dialog-programa" ).dialog("close");	
	
	$.ajax({
		type: 'POST',
		url: ajaxSavePrograma,
		dataType: 'json',
		cache: false,
		contentType: false,
	    processData: false,
		data:formData,
		 xhr: function() {  
	            var myXhr = $.ajaxSettings.xhr();
	            if(myXhr.upload){
	                myXhr.upload.addEventListener('progress',progressHandlingFunction, false); 
	            }
	            return myXhr;
	        },
		success:function(data){
		
			if(data.result.code == 'ERROR'){
				alert(data.result.message);
				console.log("Error al cargar programa"+data.result.message);
			}
		
			if(data.result.code == 'OK'){

				if(data.result.tmpPrograma.pathMant){
					link1 = downloadFile+"?idtmpfile="+data.result.tmpPrograma.id+"&tipoTmpFile=pathMant";
					$("#file_mant").html("<a href="+link1+"><strong>Descargar archivo</strong></a>");
					console.log(link1);
				}

				if(data.result.tmpPrograma.pathInstal){
					link1 = downloadFile+"?idtmpfile="+data.result.tmpPrograma.id+"&tipoTmpFile=pathInstal";
					$("#file_ins").html("<a href="+link1+"><strong>Descargar archivo</strong></a>");
					console.log(link1);
				}

				if(data.result.tmpPrograma.pathDesin){
					link1 = downloadFile+"?idtmpfile="+data.result.tmpPrograma.id+"&tipoTmpFile=pathDesin";
					$("#file_des").html("<a href="+link1+"><strong>Descargar archivo</strong></a>");
					console.log(link1);
				}

				if(data.result.tmpPrograma.pathEval){
					link1 = downloadFile+"?idtmpfile="+data.result.tmpPrograma.id+"&tipoTmpFile=pathEval";
					$("#file_eval").html("<a href="+link1+"><strong>Descargar archivo</strong></a>");
					console.log(link1);
				}

				if(data.result.tmpPrograma.pathIny){
					link1 = downloadFile+"?idtmpfile="+data.result.tmpPrograma.id+"&tipoTmpFile=pathIny";
					$("#file_iny").html("<a href="+link1+"><strong>Descargar archivo</strong></a>");
					console.log(link1);
				}
				
				
			}
			
		},
		error:function(request, status, error) {
			alert("Error al cargar los archivos, intente de nuevo");
			console.log("Error al cargar programa"+error+' '+request);
        }	 
	});
}

function refreshStockList(){
	$('#idSolStock').val($('#tmpID').val());
	$('#stock-list-form').submit();
}

function saveStockTMP(producto, almacen, renglon){
	var cantidad = $('#cantidadStock_'+renglon).val();

	if(cantidad <= 0){
			return false;
	}
	
	loading(false);
	$.ajax({
		type: 'POST',
		url: saveStockList,
		dataType: 'json',
		data:"idSol="+$('#tmpID').val()+
				"&cveProducto="+producto+
				"&cveAlmacen="+almacen+
				"&cantidad="+cantidad,
		success:function(data){
		
			if(data.result.code == 'ERROR'){
				alert(data.result.message);
				loading(true);
				return false;
			}
		
			if(data.result.code == 'OK'){
				$('#idSolStock').val($('#tmpID').val());
				$('#stock-list-form').submit();
			}
			
			
		},
		error:function(request, status, error) {
				alert('ERROR: '+error+' '+request);
				loading(true);
              }	 
	});
	
}


</script>

	<!-- MODAL EN EL BOTON DE PROGRAMAS DE TRABAJO -->
	<div id="dialog-programa" title="${message(code: 'solicitud.programa.modal.header', default: 'Programa')}">
		<form action="" id="form_programa" name="form_programa" enctype="multipart/form-data">
		<input type="hidden" name="idSol" id="idSol">
			<div align="center">
				<label>Observaciones</label>
				<textarea rows="100" cols="100" name="obs_programa" id="obs_programa" style="width:600px; height:50px;"></textarea>
				
				<fieldset id="fs02">
					<legend>Archivo Mantenimiento</legend>
					<input type="file" id="arch_mantenimiento" class="" name="arch_mantenimiento">
					<div id="file_mant"></div>
				</fieldset>	
				
				<fieldset id="fs02">
					<legend>Archivo Instalaci&oacute;n</legend>
					<input type="file" id="arch_instalacion" name="arch_instalacion">
					<div id="file_ins"></div>
				</fieldset>	
				
				<fieldset id="fs02">
					<legend>Archivo Desinstalaci&oacute;n</legend>
					<input type="file" id="arch_desinstalacion" name="arch_desinstalacion">
					<div id="file_des"></div>
				</fieldset>	
				
				<fieldset id="fs02">
					<legend>Archivo Evaluaciones</legend>
					<input type="file" id="arch_eval" name="arch_eval">
					<div id="file_eval"></div>
				</fieldset>	
				
				<fieldset id="fs02">
					<legend>Archivo Inyecci&oacute;n de producto qu&iacute;mico</legend>
					<input type="file" id="arch_inyeccion" name="arch_inyeccion">
					<div id="file_iny"></div>
				</fieldset>	
			</div>
		</form>
	</div>
	
	<div id="dialog-loading-programa" title="Cargando archivos de programa">
		<div id="progressbar-programa"><div class="progress-label-programa">Cargando...</div></div>
	</div>
	
	<!-- BUSQUEDA DE STOCK EN ALMACEN -->
	<div id="dialog-stock">
		<g:formRemote name="remote-stock" url="[controller:'almacen', action:'searchStock']" update="remote-stock-list" onLoading="loading(false)" onLoaded="loading(true)" on_500="alert('Error en el servidor')">
			 <g:textField name="desc" placeholder="Nombre" />
			 <g:textField name="cve" placeholder="Clave"/>
			<g:submitButton name="Buscar"/>
		</g:formRemote>
	
		<div id="progressbar-stock"></div><br>
		<div id="remote-stock-list" style="height:200px; overflow:scroll; font-size: 90%;"></div>
		
		<br>
		
		<g:formRemote name="stock-list-form" url="[controller:'solicitud', action:'tmpStockSolicitudList']" update="stock-list" onLoading="loading(false)" onLoaded="loading(true)" on_500="alert('Error en el servidor')">
			 <g:hiddenField name="idSolStock"/>
		</g:formRemote>
		<div id="stock-list" style="height:200px; overflow:scroll; font-size: 90%;"></div>
		
	</div>
	
	
	
	