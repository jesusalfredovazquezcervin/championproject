<script>
$(function(){
	
$("#buscar-proveedor").button({
	icons: {
        primary: "ui-icon-search"
      }});

$( "#progressbar-proveedores" ).progressbar({
	value: false
	}).hide();
      
});


function buscando(show){
	if(show)
		$( "#progressbar-proveedores" ).show();
	else
		$( "#progressbar-proveedores" ).hide();
}

function obtenerPartidas(){
	${remoteFunction(
		controller:'clasificacionProd',
	    action:'getPartidasSinProveedor',
	    update:'partidas-sinprov',
	    onLoading:'buscando(true)',
	    onComplete:'buscando(false)',
		params:[idsolicitud:solicitudInstance.id])
	}
}

</script>

<div id="dialog-proveedores" title="Buscar Proveedor" style="font-size: 90%;">
  <p class="validateTips">Ingrese alguno de los parametros para la b&uacute;squeda</p>

  <g:formRemote id="searchProvedoresForm" name="searchProvedoresForm" url="[controller: 'clasificacionProd', action:'buscarProveedor']" update="resultadosProveedores" 
  onLoading="buscando(true)" onLoaded="buscando(false)" onFailure="alert('Ha ocurrido un error')" >
  	<fieldset>
    <label for="name">Clave</label>
    <input type="text" name="claveP" id="claveP" class="text ui-widget-content ui-corner-all">
    <label for="email">Nombre</label>
    <input type="text" name="nombreP" id="nombreP" value="" class="text ui-widget-content ui-corner-all">
    <label for="password">RFC</label>
    <input type="text" name="rfcP" id="rfcP" value="" class="text ui-widget-content ui-corner-all">
    <button id="buscar-proveedor" type="submit" style="height: 25px; width: 31px; bottom: 1px;"></button>
  	</fieldset>
  </g:formRemote>
  
  <div id="progressbar-proveedores"></div>
  <div id="resultadosProveedores" style="height: 100px; overflow: scroll; font-size: 90%;"></div>
  <br>
  <div style="text-align: center; " align="center">
  	<label id="prov-seleccionado" ></label>
  </div>
  <div id="partidas-sinprov" style="font-size: 90%;"></div><br>
  <div id="clasificacion-partidas" style="font-size: 90%;"></div>	
</div>