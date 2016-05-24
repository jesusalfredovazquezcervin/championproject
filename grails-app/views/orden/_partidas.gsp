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
				<th>Descuento %<label id="descuentoHeader"></label> </th>
				<th>IVA </th>		
				<th>Otros %</th>
				<th>Ret ISR %</th>
				<th>Ret IVA %</th>				
				<th>Total</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${ordenInstance.partidas?.sort{a,b->a.cveProducto<=>b.cveProducto}}" status="i" var="partida">
				<tr>		
					<td><g:field type="number" name="cantidad_${partida.id}" onKeyUp="recalcularTotal(${partida.id})" min="1" max="1000" value="${partida.cantidad}"/></td>
					<td><g:field type="text" name="costounit${partida.id}" size="15" value="${partida.costoUnidad}" onKeyUp="recalcularTotal(${partida.id})"/></td>
					<td>${partida.almacen?.descripcion}</td>
					<td title="${partida.descProducto}">${partida.cveProducto}</td>
					<td>${partida.unidad}</td>
					<td><g:field type="text" id="descuento${partida.id}" name="descuento${partida.id}" onKeyUp="recalcularTotal(${partida.id})" value="${partida.descuento}" size="5"/> </td>
					<td><g:field type="text"  id="ivalinea${partida.id}" name="ivalinea${partida.id}" onKeyUp="recalcularTotal(${partida.id})" value="${partida.IVA}" size="5"/></td>
					<td><g:field type="text"  id="otros${partida.id}" name="otros${partida.id}" onKeyUp="recalcularTotal(${partida.id})" value="${partida.otros}" size="5"/></td>
					<td><g:field type="text"  id="retisr${partida.id}" name="retisr${partida.id}" onKeyUp="recalcularTotal(${partida.id})" value="${partida.isrRet}" size="5"/></td>
					<td><g:field type="text"  id="retiva${partida.id}" name="retiva${partida.id}" onKeyUp="recalcularTotal(${partida.id})" value="${partida.retIVA}" size="5"/></td>
					 						
					<td><label id="total_partida${partida.id}">
					<g:formatNumber
number="${((partida.costoUnidad*partida.cantidad)-((partida.costoUnidad*partida.cantidad) * (partida.descuento/100))) + ((partida.IVA/100) * ((partida.costoUnidad*partida.cantidad)-((partida.costoUnidad*partida.cantidad) * (partida.descuento/100)))) + ((partida.otros/100) *((partida.costoUnidad*partida.cantidad)-((partida.costoUnidad*partida.cantidad) * (partida.descuento/100)))) + ((partida.retIVA/100) * ((partida.costoUnidad*partida.cantidad)-((partida.costoUnidad*partida.cantidad) * (partida.descuento/100)))) + ((partida.isrRet/100) * ((partida.costoUnidad*partida.cantidad)-((partida.costoUnidad*partida.cantidad) * (partida.descuento/100)))) }"					 
					
			type="number"  /></label></td>
					<td><span onclick='verResumen(${partida.id});' class='ui-icon ui-icon-plus'></span></td>
					<td><span onclick='deletePartidaOrden(${partida.id});' class='ui-icon ui-icon-closethick'></span></td>			
<!-- number="${(((partida.costoUnidad*partida.cantidad)- ((partida.descuento/100) * (partida.costoUnidad*partida.cantidad)) )  +((partida.IVA/100) * (partida.costoUnidad*partida.cantidad) ) ) + ( ((partida.otros/100)*(partida.costoUnidad*partida.cantidad) ) + ((partida.isrRet/100)*(partida.costoUnidad*partida.cantidad) ) + ((partida.retIVA/100)*(partida.costoUnidad*partida.cantidad) ))}" -->					
					
				</tr>
			</g:each>
				<tr>
					<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>					
					<td>Subtotal</td>
					<td>
						<label id="subt"><g:formatNumber number="${subtotal}" type="number" /></label>
					</td>
				</tr>
				
				<tr>
					<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>					<td></td>
					<td>- Desc Fin <label id="descuentoFinanHeader"><g:formatNumber number="${descFin}" type="number" /></label>%
					</td>
					<td>						
						<label id="descuentoFinan"><g:formatNumber number="${(subtotal*(descFin/100)).trunc(2)}" type="number" /></label>
					</td>
				</tr>
				<tr>
					<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>					<td></td>
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
function verResumen(id){
	recalcularTotal(id);
	$( "#dialog-resumen" ).dialog("open");
}
function recalcularTotal(id){

	var descuento = $("#desc").val();
	var cantidadlinea = $("#cantidad_"+id).val();
	var costolinea = $("#costounit"+id).val();	
	var descuentolinea =$("#descuento"+id).val();
	var ivalinea = parseFloat($("#ivalinea"+id).val());
	
	var otroslinea = parseFloat($("#otros"+id).val());
	var retisrlinea = parseFloat($("#retisr"+id).val());
	var retivalinea = parseFloat($("#retiva"+id).val());
	
	//console.debug('cantidad--> ' + cantidadlinea + '  costo-->' + costolinea + '  desc->' + descuentolinea + '   ivalinea->' + ivalinea + '   otros->' + otroslinea + '   retisr->' + retisrlinea + '  retiva->' + retivalinea);
	//console.debug('descuento.text--> ' + $("#desc").text());
	var descFin = $("#descFinal").val();
	var cantidad=$("#cantidad_"+id).val();
	var totPartidaInicial = parseInt($("#total_partida"+id).text());
	
	//AQUI LA LLAMADA DE UPDATE
	${remoteFunction(action:'updatePartida',
		controller:'orden',
		params:'\'id=\'+id+\'&costounidad=\'+$(\"#costounit\"+id).val()+\'&descuento=\'+descuentolinea+\'&cantidad=\'+cantidadlinea+\'&otros=\'+otroslinea+\'&isrRet=\'+retisrlinea+\'&retIVA=\'+retivalinea+\'&IVA=\'+ ivalinea')}
	/*
	var iva=(ivalinea/100) * (  ($("#costounit"+id).val() * $("#cantidad_"+id).val())  );
	var retisr=(retisrlinea/100) * (  ($("#costounit"+id).val() * $("#cantidad_"+id).val())   );
	var otros=(otroslinea/100) * (  ($("#costounit"+id).val() * $("#cantidad_"+id).val())   );
	var retiva=(retivalinea/100) * (  ($("#costounit"+id).val() * $("#cantidad_"+id).val())  );
	var desc =(descuentolinea/100) * (  ($("#costounit"+id).val() * $("#cantidad_"+id).val())  );
	var totalpartidanew=(((costolinea*cantidadlinea)- ((descuentolinea/100) * (costolinea*cantidadlinea)) )  +((ivalinea/100) * (costolinea*cantidadlinea) ) ) - ( ((otroslinea/100)*(costolinea*cantidadlinea) ) + ((retisrlinea/100)*(costolinea*cantidadlinea) ) + ((retivalinea/100)*(costolinea*cantidadlinea) ));
	

$("#total_partida"+id).text(totalpartidanew.toFixed(2));
*/
	//Calculamos el subtotal barriendo todas las filas
	var idArray = $("#partidasid").val().replace('[','').replace(']','').replace(' ','').split(',');
	var arrayLength = idArray.length;
	var nuevosubtotal=0;
	
	for (var i = 0; i < arrayLength; i++) {
		var iva=(ivalinea/100) * (  ($("#costounit"+idArray[i]).val() * $("#cantidad_"+idArray[i]).val())  );
		var retisr=(retisrlinea/100) * (  ($("#costounit"+idArray[i]).val() * $("#cantidad_"+idArray[i]).val())   );
		var otros=(otroslinea/100) * (  ($("#costounit"+idArray[i]).val() * $("#cantidad_"+idArray[i]).val())   );
		var retiva=(retivalinea/100) * (  ($("#costounit"+idArray[i]).val() * $("#cantidad_"+idArray[i]).val())  );
		var desc =(descuentolinea/100) * (  ($("#costounit"+idArray[i]).val() * $("#cantidad_"+idArray[i]).val())  );

		var lq = $("#cantidad_"+idArray[i]).val();
		var lc = $("#costounit"+idArray[i]).val();	
		var ld =$("#descuento"+idArray[i]).val();
		var li = parseFloat($("#ivalinea"+idArray[i]).val());
		
		var lo = parseFloat($("#otros"+idArray[i]).val());
		var rsl = parseFloat($("#retisr"+idArray[i]).val());
		var ril = parseFloat($("#retiva"+idArray[i]).val());
		
		var cst = lc * lq;
		var IVAL = (li/100) * ((cst- ((ld/100) * (cst))));
		var OTROSL=(lo/100) * ((cst- ((ld/100) * (cst))));
		var RETISRL=(rsl/100) * ((cst- ((ld/100) * (cst))));
		var RETIVAL=(ril/100) * ((cst- ((ld/100) * (cst))));
		
		var totalpartidanew=((cst- ((ld/100) * (cst)))  + IVAL ) +  OTROSL + RETISRL + RETIVAL ;
		console.debug ("costo=" + cst + "   desc="+ ((ld/100) * (cst)) + "  [cst-desc]=" + (cst- ((ld/100) * (cst))) + " iva=" + IVAL + "  otros=" + OTROSL  + "  RETISR="+RETISRL + " RETIVA" + RETIVAL);
		 

	$("#total_partida"+idArray[i]).text(totalpartidanew.toFixed(6));

	
	 console.debug (parseFloat($("#total_partida"+idArray[i]).text()));
	    nuevosubtotal+=totalpartidanew;
	     
	    
	}

	
	$("#subt").text(nuevosubtotal.toFixed(6));
	//console.debug("nuevosub->" + nuevosubtotal);
	//Calculamos el desc para el nuevo subtotal
	var nuevoDescuento = nuevosubtotal * (descFin/100)
	$("#descuentoFinan").text(nuevoDescuento.toFixed(6)); 
	//console.debug("nuevodesc->" + nuevoDescuento);

	//Calculamos el nuevo total
	var nuevoTotal= nuevosubtotal-nuevoDescuento;
	$("#granTotal").text(nuevoTotal.toFixed(6));
	//console.debug("nuevoTotal->" + nuevoTotal);
		



	//Llenamos la pantalla de resumen
	$("#lblCantidad").text(cantidadlinea);
	$("#lblCosto").text(costolinea);

	var lblst1 = (cantidadlinea * costolinea).toFixed(6);
	$("#lblst1").text(lblst1);
	$("#lblDescuento").text(descuentolinea + "%");

	var lblParcialDesc = ((descuentolinea/100) * (cantidadlinea*costolinea)).toFixed(6) ;
	$("#lblParcialDesc").text(lblParcialDesc);

	var lblst2 = lblst1 - lblParcialDesc;
	$("#lblst2").text(lblst2);


	$("#lblIVA").text(ivalinea + "%");
	var lblParcialIVA = lblst2 * (ivalinea/100); 
	$("#lblParcialIVA").text(lblParcialIVA);
	var lblst3 = lblst2 + lblParcialIVA;
	$("#lblst3").text(lblst3);

	$("#lblOtros").text(otroslinea + "%");
	var lblParcialOtros = lblst2 * (otroslinea/100); 
	$("#lblParcialOtros").text(lblParcialOtros);
	var lblst4 = lblst3 + lblParcialOtros;
	$("#lblst4").text(lblst4);


	$("#lblRetISR").text(retisrlinea + "%");
	var lblParcialRetISR = lblst2 * (retisrlinea/100); 
	$("#lblParcialRetISR").text(lblParcialRetISR);
	var lblst5 = lblst4 + lblParcialRetISR;
	$("#lblst5").text(lblst5);

	$("#lblRetIVA").text(retivalinea + "%");
	var lblParcialRetIVA = lblst2 * (retivalinea/100); 
	$("#lblParcialRetIVA").text(lblParcialRetIVA);
	var lblst6 = lblst5 + lblParcialRetIVA;
	$("#lblst6").text(lblst6);

}
</script>