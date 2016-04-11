<%@page import="championweb.SolicitudStock"%>
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



</script>

	<!-- MODAL EN EL BOTON DE PROGRAMAS DE TRABAJO -->
	<div id="dialog-programa" title="${message(code: 'solicitud.programa.modal.header', default: 'Programa')}">
		<form action="" id="form_programa" name="form_programa" enctype="multipart/form-data">
		<input type="hidden" name="idSol" id="idSol">
			<div align="center">
				<label>Observaciones</label>
				<textarea rows="100" cols="100" name="obs_programa" id="obs_programa" style="width:600px; height:50px;" disabled >${solicitudInstance.obsPrograma}</textarea>
				
				<g:if test="${solicitudInstance.pathMant}">
				<fieldset id="fs02">
					<legend>Archivo Mantenimiento</legend>
					<div id="file_mant"><a href="${createLink(controller:'solicitud',action:'downloadPrograma') }?id=${solicitudInstance.id}&tipoFile=pathMant"><strong>Descargar archivo</strong></a></div>
				</fieldset>
				</g:if>	
				
				<g:if test="${solicitudInstance.pathInstal}">
				<fieldset id="fs02">
					<legend>Archivo Instalaci&oacute;n</legend>
					<div id="file_ins">
						<a href="${createLink(controller:'solicitud',action:'downloadPrograma') }?id=${solicitudInstance.id}&tipoFile=pathInstal"><strong>Descargar archivo</strong></a>
					</div>
				</fieldset>	
				</g:if>
				
				<g:if test="${solicitudInstance.pathDesin}">
				<fieldset id="fs02">
					<legend>Archivo Desinstalaci&oacute;n</legend>
					<div id="file_des">
						<a href="${createLink(controller:'solicitud',action:'downloadPrograma') }?id=${solicitudInstance.id}&tipoFile=pathDesin"><strong>Descargar archivo</strong></a>
					</div>
				</fieldset>	
				</g:if>
				
				<g:if test="${solicitudInstance.pathEval}">
				<fieldset id="fs02">
					<legend>Archivo Evaluaciones</legend>
					<div id="file_eval">
						<a href="${createLink(controller:'solicitud',action:'downloadPrograma') }?id=${solicitudInstance.id}&tipoFile=pathEval"><strong>Descargar archivo</strong></a>
					</div>
				</fieldset>	
				</g:if>
				
				<g:if test="${solicitudInstance.pathIny}">
				<fieldset id="fs02">
					<legend>Archivo Inyecci&oacute;n de producto qu&iacute;mico</legend>
					<div id="file_iny">
						<a href="${createLink(controller:'solicitud',action:'downloadPrograma') }?id=${solicitudInstance.id}&tipoFile=pathIny"><strong>Descargar archivo</strong></a>
					</div>
				</fieldset>	
				</g:if>
			</div>
		</form>
	</div>
	
	<div id="dialog-loading-programa" title="Cargando archivos de programa">
		<div id="progressbar-programa"><div class="progress-label-programa">Cargando...</div></div>
	</div>
	
	<!-- BUSQUEDA DE STOCK EN ALMACEN -->
	<div id="dialog-stock"  title="${message(code: 'solicitud.stock.edit.label', default: 'Stock')}">
		<div id="stock-list" style="height:200px; overflow:scroll; font-size: 90%;">
			 <table>
				 <thead>
				   <tr>
				   	  <th>Clave</th>
				      <th>Nombre</th>
				      <th>Almac&eacute;n</th>
				      <th>Cant. Seleccionada</th>
				   </tr>
				 </thead>
				 <tbody>
				<g:each in="${SolicitudStock.findAllBySolicitud(solicitudInstance)}"  status="i" var="productoInstance">
				   <g:if test="${productoInstance}">
				      <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
				       	 <td>${productoInstance.cveProducto}</td>
				         <td>${productoInstance.nombreProducto}</td>
				         <td>${productoInstance.cveAlmacen}</td>
				         <td>${productoInstance.cantidad}</td>
				      </tr>
				   </g:if>
				</g:each>
				</tbody>
			</table>
		</div>
		
	</div>
	
	<div id="dialog-clasificacion"  title="${message(code: 'solicitud.clasificar.label', default: 'Clasificar')}">
		<g:render template="/clasificacionProd/buscarProveedor"></g:render>
	</div>
	
	
	
	