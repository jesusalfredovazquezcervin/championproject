 <script type="text/javascript">
 $(function() {
 $( "#dialog-proveedores" ).dialog({
     autoOpen: false,
     height: 450,
     width: 750,
     modal: true,
     buttons: {
       "Buscar": function() {
    	   $('#searchProvedoresForm').submit();
       },
       Cancel: function() {
         $( this ).dialog( "close" );
       }
     },
     close: function() {
      
     }
   });

   $( "#modalProveedores" )
     .click(function() {
		var idp = $.trim($('#proveedor').val())
		if(idp){
				$('#claveP').val(idp);
				$( "#dialog-proveedores" ).dialog( "open" );
				$('#searchProvedoresForm').submit();
			}else
		       $( "#dialog-proveedores" ).dialog( "open" );
     });
 });


//PARA EL PROGRESSBAR
 $(function() {
 	$( "#progressbar-proveedores" ).progressbar({
 	      value: true
 	    }).hide();
     
   });

 function loading(val){
		
		$( "#progressbar-proveedores" ).progressbar( "option", "value", val );
		
		if(val){
			$( "#progressbar-proveedores" ).hide();
			$('#tblProveedores').show()
			}else{
				$( "#progressbar-proveedores" ).show();
				$('#tblProveedores').hide()
			}
		
	}

	function setDescuento(){
		console.debug('desc-->  ' + $('#desc').val());
		var desc= $('#desc').val();
		$("#descuentoHeader").text(desc);
		 
		}
	function setDescuentoFinan(){
		console.debug('desc-->  ' + $('#descFinal').val());
		var desc= $('#descFinal').val();
		$("#descuentoFinanHeader").text(desc);
		 
		}
	
 </script>
 
  <fieldset id="fs02" style="padding-left: 1px;">
  	<legend>DATOS GENERALES</legend>
	<table style="font-size: 90%;" >
			<tr>
				<g:hiddenField name="idOrden" value="${ordenInstance.id}" />
				<g:hiddenField name="idP" value="${datosProveedor.clave}"/>
				<g:hiddenField name="iva" value="${iva}"/>
				<g:hiddenField name="isr" value="${isr}"/>
				<g:hiddenField name="descuento" value="${descuento}"/>
				<g:hiddenField name="descFin" value="${descFin}"/>
				<g:hiddenField name="other" value="${other}"/>
				<g:hiddenField name="subtotal" value="${subtotal}"/>
				<g:hiddenField name="total" value="${total}"/>
				<g:hiddenField name="partidasid" value="${partidasid}"/>
				
				<td>Orden</td>
				<td><g:field type="text" name="orden" value="Directa" readonly=""/></td>
				<td>Número Ord SAE</td>
				<td><g:field type="text" name="numero" value="${ordenInstance.ordenSAE}"/></td>
				<td>Fecha</td>
				<td><g:field type="date" name="fecha" value="${ordenInstance.fecha?.format("yyyy-MM-dd")}"/></td>
			
				
				<td>Proveedor</td>
				<td>
					<div style="overflow: hidden;">
						<span id="modalProveedores" class='ui-icon ui-icon-search' style="float: right; margin-right: 80px; margin-top: 2px; "></span>
						<g:field type="text" name="proveedor" size="5" style="display: block;" value="${ordenInstance.provSAE}"/>												
					</div>
				</td>
			</tr>
			<tr>
				<td>RFC</td>
				<td><g:field type="text" name="rfc" readonly="" value="${datosProveedor.rfc}"/></td>
				<td>Nombre</td>
				<td colspan="3"><g:field type="text" name="nombre" readonly="" value="${datosProveedor.nombre}"/></td>
				<td>Ref. Proveedor</td>
				<td><g:field type="text" name="refproveedor" /></td>
			</tr>
			<tr>
				<td>Calle</td>
				<td colspan="3"><g:field type="text" name="calle" readonly="" value="${datosProveedor.calle}"/></td>
				<td>Num. Ext.</td>
				<td><g:field type="text" name="numext" readonly="" value="${datosProveedor.numext}"/></td>
				<td>Esquema</td>
				<td><g:field type="number" name="esquema" min="0" max="100" value="${ordenInstance.esquema.toInteger()}"/></td>
			</tr>
			<tr>
				<td>Colonia</td>
				<td colspan="3"><g:field type="text" name="colonia"  readonly="" value="${datosProveedor.colonia}"/></td>
				<td>Num. Int.</td>
				<td><g:field type="text" name="numint" readonly="" value="${datosProveedor.numint}"/></td>
				<td>Descuento</td>
				<td>				
					<g:field type="number" name="desc" min="0" max="100"  value="${ordenInstance.descuento.toInteger()}"  onChange="setDescuento()" /> 
				</td>
			</tr>
			<tr>
				<td>Código Postal</td>
				<td><g:field type="text" name="cp" readonly="" value="${datosProveedor.codigo}"/></td>
				<td>Población</td>
				<td><g:field type="text" name="poblacion" readonly="" value="${datosProveedor.localidad}"/></td>
				<td>País</td>
				<td><g:field type="text" name="pais" readonly="" value="${datosProveedor.cve_pais}"/></td>
				<td>Desc. Fin.</td>
				<td><g:field type="number" name="descFinal" min="0" max="100" value="${ordenInstance.descFinal.toInteger()}"   onChange="setDescuentoFinan()"/></td>
			</tr>
			<tr>
				<td>Entregar a</td>
				<td colspan="3"><g:field type="text" name="entregar" /></td>
				<td>Fecha Rec.</td>
				<td><g:field type="date" name="fechaRec" value="${ordenInstance.fechaRec?.format("yyyy-MM-dd")}"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>Almacén</td>
				<td><g:field type="text" name="almacen" value="${ordenInstance.almacen?.descripcion}" readonly=""/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Moneda</td>
				<td colspan="3">
					<select style="width: 150px;" id="moneda" name="moneda">
						<g:if test="${ordenInstance.moneda==1}">
							<option value="1" selected="selected" >Pesos MXN</option>
							<option value="2" >Dolar USD</option>
						</g:if>
						<g:elseif test="${ordenInstance.moneda==2}">
						  <option value="1">Pesos MXN</option>
						  <option value="2" selected="selected">Dolar USD</option>
						</g:elseif>
						
					</select>
				</td>
				<td>Tipo de cambio</td>
				<td><g:field type="text" name="tipoCambio" value="${ordenInstance.tipoCambio}" /> </td>
				<td></td>
				<td></td>
			</tr>
	</table>
	  	
  </fieldset>
  
  
<div id="dialog-proveedores" title="Buscar Proveedor" style="font-size: 90%;">
  <p class="validateTips">Ingrese alguno de los parametros para la b&uacute;squeda</p>

  <g:formRemote id="searchProvedoresForm" name="searchProvedoresForm" url="[controller: 'orden', action:'getProveedor']" update="resultadosProveedores" onLoading="loading(false)" onLoaded="loading(true)">
  	<fieldset>
    <label for="name">Clave</label>
    <input type="text" name="claveP" id="claveP" class="text ui-widget-content ui-corner-all">
    <label for="email">Nombre</label>
    <input type="text" name="nombreP" id="nombreP" value="" class="text ui-widget-content ui-corner-all">
    <label for="password">RFC</label>
    <input type="text" name="rfcP" id="rfcP" value="" class="text ui-widget-content ui-corner-all">
  	</fieldset>
  </g:formRemote>
  
  <div id="progressbar-proveedores"></div>
  <div id="resultadosProveedores" style="width:720px; height: 400px; overflow: scroll; font-size: 90%;"></div>
  	
</div>
