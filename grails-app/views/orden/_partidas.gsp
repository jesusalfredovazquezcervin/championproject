<script>
  $(function() {
    $( document ).tooltip({
	  show: {
	    effect: "fast"
	  },
      position: {
        my: "center bottom-20",
        at: "center top",
        using: function( position, feedback ) {
          $( this ).css( position );
          $( "<div>" )
            .addClass( "arrow" )
            .addClass( feedback.vertical )
            .addClass( feedback.horizontal )
            .appendTo( this );
        }
      }
    });
  });
  </script>
  <style>
  .ui-tooltip, .arrow:after {
    background: #E6E6E6;
    border: 2px solid white;
  }
  .ui-tooltip {
    padding: 10px 20px;
    color: #D07736;
    font: bold 12px Roboto,"Helvetica Neue", Sans-Serif;
    text-transform: uppercase;
    box-shadow: 0 0 7px #999;
  }
  .arrow {
    width: 70px;
    height: 16px;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -35px;
    bottom: -16px;
  }
  .arrow.top {
    top: -16px;
    bottom: auto;
  }
  .arrow.left {
    left: 20%;
  }
  .arrow:after {
    content: "";
    position: absolute;
    left: 20px;
    top: -20px;
    width: 25px;
    height: 25px;
    box-shadow: 6px 5px 9px -9px black;
    -webkit-transform: rotate(45deg);
    -moz-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    -o-transform: rotate(45deg);
    tranform: rotate(45deg);
  }
  .arrow.top:after {
    bottom: -20px;
    top: auto;
  }
  </style>

<g:message code="${flash.message}" args="${flash.args}"
           default="${flash.default}"/>

<g:hiddenField name="subtotal" value="${subtotal}"/>
<fieldset id="fs02">
	<legend>PARTIDAS</legend>
	${flash.message}
	<table style="font-size: 90%;">
		<thead>
			<tr>
				<th>Cant</th>
				<th>Costo/uni</th>
				<th>Almacén</th>
				<th>Producto</th>
				<th>Unidad</th>
				<th>- Descuento <label id="descuentoHeader">
						<g:formatNumber number="${(descuento*100).toInteger()}" type="number" />
					</label>%
				</th>
				<th>- Otros ${other}%</th>
				<th>+ ISR ${isr}%</th>
				<th>+ IVA ${iva}%</th>
				
				<th>Total por partida</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${ordenInstance.partidas?.sort{a,b->a.cveProducto<=>b.cveProducto}}" status="i" var="partida">
				<tr>
				${ }
					<td><g:field type="number" name="cantidad_${partida.id}" onKeyUp="recalcularTotal(${partida.id})" min="1" max="1000" value="${partida.cantidad}"/></td>
					<td><g:field type="text" name="costounit${partida.id}" size="5" value="${partida.costoUnidad}" onKeyUp="recalcularTotal(${partida.id})"/></td>
					<td>${partida.almacen?.descripcion}</td>
					<td title="${partida.descProducto}">${partida.cveProducto}</td>
					<td>${partida.unidad}</td>
					<td><label id="descuento${partida.id}"><g:formatNumber number="${((descuento)* (partida.cantidad*partida.costoUnidad))}" type="number" /></label></td><!-- DESCUENTO por PARTIDA -->
					<td><label id="otros${partida.id}"><g:formatNumber number="${((other/100)* (partida.cantidad*partida.costoUnidad))}" type="number" /></label></td> <!-- OTROS -->
					<td><label id="isr${partida.id}"><g:formatNumber number="${((isr/100)* (partida.cantidad*partida.costoUnidad))}" type="number" /></label></td> <!-- ISR RET -->
				
					
					<td><label id="iva${partida.id}"><g:formatNumber number="${((iva/100)* (partida.cantidad*partida.costoUnidad))}" type="number" /></label></td>
					
					<td><label id="total_partida${partida.id}"><g:formatNumber number="${(partida.costoUnidad*partida.cantidad)-( ((descuento) * (partida.costoUnidad*partida.cantidad)))-(((other/100) * (partida.costoUnidad*partida.cantidad)))+((isr/100)* (partida.cantidad*partida.costoUnidad))+((iva/100)* (partida.cantidad*partida.costoUnidad)) }" type="number"  /></label></td>
					
					<td><span onclick='deletePartidaOrden(${partida.id});' class='ui-icon ui-icon-closethick'></span></td>
					
				</tr>
			</g:each>
				<tr>
					<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>					
					<td>Subtotal</td>
					<td>
						<label id="subt"><g:formatNumber number="${subtotal}" type="number" /></label>
					</td>
				</tr>
				
				<tr>
					<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>					
					<td>- Desc Fin <label id="descuentoFinanHeader"><g:formatNumber number="${descFin}" type="number" /></label>%
					</td>
					<td>						
						<label id="descuentoFinan"><g:formatNumber number="${(subtotal*(descFin/100)).trunc(2)}" type="number" /></label>
					</td>
				</tr>
				<tr>
					<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>					
					<td>Total</td>
					<td>
						<label id="granTotal"><g:formatNumber number="${total}" type="number" /></label>
					</td>
				</tr>
				
		</tbody>
	</table>
</fieldset>


					
<script>
function deletePartidaOrden(idPartida){
	${remoteFunction(action:'deletePartida', 
		controller:'orden',
		params:'\'id=\'+idPartida',
		update:'listado-partidas'
	)}
}

function recalcularTotal(id){
	//console.debug($("#costounit"+id).val());
	var descuento = $("#desc").val();
	console.debug('descuento.val--> ' + $("#desc").val());
	console.debug('descuento.text--> ' + $("#desc").text());
	var descFin = $("#descFinal").val();
	var cantidad=$("#cantidad_"+id).val();
	var totPartidaInicial = parseInt($("#total_partida"+id).text());
	
	//AQUI LA LLAMADA DE UPDATE
	${remoteFunction(action:'updatePartida',
		controller:'orden',
		params:'\'id=\'+id+\'&costounidad=\'+$(\"#costounit\"+id).val()+\'&descuento=\'+descuento+\'&cantidad=\'+cantidad')}
	
	var iva=($("#iva").val()/100).toFixed(2) * (  ($("#costounit"+id).val() * $("#cantidad_"+id).val()).toFixed(2)  );
	var isr=($("#isr").val()/100).toFixed(2) * (  ($("#costounit"+id).val() * $("#cantidad_"+id).val()).toFixed(2)  );
	var desc =($("#desc").val()/100) * (  ($("#costounit"+id).val() * $("#cantidad_"+id).val())  );

	console.debug('descuento * (costo*cant)--> ' +  descuento +  '*' +  '(' + $("#costounit"+id).val() + '*' +  $("#cantidad_"+id).val() + ')' +'=' + desc );
	
	var otros  =($("#other").val()/100).toFixed(2) * (  ($("#costounit"+id).val() * $("#cantidad_"+id).val()).toFixed(2)  );
	$("#iva"+id).text(iva.toFixed(2));
	$("#isr"+id).text(isr.toFixed(2));
	$("#descuento"+id).text(desc.toFixed(2));
	$("#otros"+id).text(otros.toFixed(2));
	var cantidad = $("#cantidad_"+id).val();
	var costo = $("#costounit"+id).val();
	var totalpartidanew= (costo*cantidad)-desc-otros+isr+iva;
	$("#total_partida"+id).text(totalpartidanew.toFixed(2));

	//Calculamos el subtotal barriendo todas las filas
	var idArray = $("#partidasid").val().replace('[','').replace(']','').replace(' ','').split(',');
	var arrayLength = idArray.length;
	var nuevosubtotal=0;
	
	for (var i = 0; i < arrayLength; i++) {
	    //alert(myStringArray[i]);
	    nuevosubtotal+=parseFloat($("#total_partida"+idArray[i]).text());
	    
	}
	$("#subt").text(nuevosubtotal.toFixed(2));
	console.debug("nuevosub->" + nuevosubtotal);
	//Calculamos el desc para el nuevo subtotal
	var nuevoDescuento = nuevosubtotal * (descFin/100)
	$("#descuentoFinan").text(nuevoDescuento.toFixed(2)); 
	console.debug("nuevodesc->" + nuevoDescuento);

	//Calculamos el nuevo total
	var nuevoTotal= nuevosubtotal-nuevoDescuento;
	$("#granTotal").text(nuevoTotal.toFixed(2));
	console.debug("nuevoTotal->" + nuevoTotal);
		
	
}
</script>