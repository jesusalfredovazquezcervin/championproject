<script>

  $(function() {
    $( "#fechaInicio" ).datepicker({dateFormat: 'dd/mm/yy'});
    $( "#fechaFin" ).datepicker({dateFormat: 'dd/mm/yy'});

    $('#pcontrato').keydown(function (event) {
	    var keypressed = event.keyCode || event.which;
	    if (keypressed == 13) {
	        $(this).closest('form').submit();
	    }
	});

    $('#pcliente').keydown(function (event) {
	    var keypressed = event.keyCode || event.which;
	    if (keypressed == 13) {
	        $(this).closest('form').submit();
	    }
	});
    
  });

</script>

<form action="list">
	 <table border="0">
	  <tr style="background: #ffffff;">
	    <td>
	    	<input type="search" size="30" id="pcontrato" name="pcontrato" placeholder="Contrato" value="${pcontrato}" >
	    </td>
	    <td>
	    	Per&iacute;odo:
	    </td>
	    <td rowspan="2" class="tdButton" id="tdButton" onclick="submit();">
			&nbsp;<img src="${resource(dir: 'images/skin/batch_icons/32x32', file: 'search.png')}" alt="CHAMPION"/>
		</td>
	  </tr>
	  <tr style="background: #ffffff;">
	    <td>
	    	<input type="search" size="50" id="pcliente" name="pcliente" placeholder="Cliente" value="${pcliente}" >
	    </td>
	    <td>
	    	<input  placeholder="De" type="text" id="fechaInicio" name="fechaInicio" />
			<input  placeholder="A" type="text" id="fechaFin" name="fechaFin" />
		</td>
	  </tr>
	</table>
</form>