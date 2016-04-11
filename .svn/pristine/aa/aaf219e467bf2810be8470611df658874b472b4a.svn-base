<script type="text/javascript">

/*
*
*FUNCIONALIDAD PARA CONTRATOS
*
*/	 
	
	function searchContrato(){
		$.ajax({
			type: 'POST',
			url: ajaxContratos,
			dataType: 'json',
			data:$('#search_Contrato').serialize(),
			success:function(data){
			
				if(data.result.code == 'ERROR'){
					alert(data.result.message);
					return false;
				}
			
				if(data.result.code == 'OK'){
					var resultados = 1 * data.result.contratoListTotal;
					var html = "<br>";

					html+="<table id='contrato-solicitud'>";
					html+="<thead>";
					html+="<tr>";
					html+="<th><g:message code="contrato.numContrato.label" default=''/></th>";
					html+="<th><g:message code="contrato.nombreCliente.label" default='Responsable' /></th>";
					html+="<th>&nbsp;</th>";
					html+="</tr>";
					html+="</thead>";
					html+="</table>";
					$("#contratos_encontrados").html(html);
					
					var html2 = "";
					var contr = "";
					for(var i=0; i < resultados; i++){
						contr = data.result.contratoList[i].numContrato+" - "+data.result.contratoList[i].nombreCliente;
						html2 += "<tr><td>"+data.result.contratoList[i].numContrato+"</td>";
						html2 += "<td>"+data.result.contratoList[i].nombreCliente+"</td>";
						html2 += "<td> <span onclick='selectContrato("+data.result.contratoList[i].id+");' class='ui-icon ui-icon-plus'></span> </td></tr>";
						
					}

					$("#contrato-solicitud").append(html2);
					
				}
				
			},
			error:function(request, status, error) {
					alert('ERROR: '+error+' '+request);
	              }	 
		});
	}

	function selectContrato(idContrato){
		$.ajax({
			type: 'POST',
			url: ajaxGetContrato,
			dataType: 'json',
			data:"id="+idContrato,
			success:function(data){
			
				if(data.result.code == 'ERROR'){
					alert(data.result.message);
					return false;
				}
			
				if(data.result.code == 'OK'){
					$("#contrato_id").val( data.result.contratoInstance.id);
					$("#contrato_nombre").val( data.result.contratoInstance.numContrato);
					$("#dialog-contrato").dialog( "close" );
				}
				
			},
			error:function(request, status, error) {
					alert('ERROR: '+error+' '+request);
	              }	 
		});
	}


/*
*
*FUNCIONALIDAD PARA PROYECTOS
*
*/	 
	
	function selectProyecto(id){
		$.ajax({
			type: 'POST',
			url: ajaxGetProyecto,
			dataType: 'json',
			data:"id="+id,
			success:function(data){
			
				if(data.result.code == 'ERROR'){
					alert(data.result.message);
					return false;
				}
			
				if(data.result.code == 'OK'){
					var htmlpr = "<br>Proyecto: <strong>"+data.result.proyectoInstance.nombre+"</strong>&nbsp;";
						htmlpr+= "<input type='hidden' id='proyectoadd_id' value='"+data.result.proyectoInstance.id+"'>";
						htmlpr+= "-&nbsp;Prorrateo:&nbsp;<input type='number' id='proyectoadd_prorrateo' min='0' max='100' value='0' size='3'>% "
						htmlpr+= "&nbsp;<button id='add-proyectosol' name='add-proyectosol'>Agregar</button><br><br>"
					$("#addProyecto").html(htmlpr);
					addFuncProyectosol();
				}
				
			},
			error:function(request, status, error) {
					alert('ERROR: '+error+' '+request);
	              }	 
		});
	}
	
	function deleteProyectoTemp(id){
		$.ajax({
			type: 'POST',
			url: ajaxDelProyecto,
			dataType: 'json',
			data:"proyid="+id+"&tmpID="+$('#tmpID').val(),
			success:function(data){
			
				if(data.result.code == 'ERROR'){
					alert(data.result.message);
					return false;
				}
			
				if(data.result.code == 'OK'){
					var html = "";
					
					 html += "<caption style='background-color: #95a5a6; color: white;'>Proyectos en la solicitud</caption>"
				 	 html += "<thead>"
					 html += "<tr>"
					 html += "<th><g:message code="proyecto.nombre.label" default="Nombre"/></th>"
					 html += "<th><g:message code="proyecto.responsable.label" default="Responsable" /></th>"
					 html += "<th><g:message code="proyecto.tipoProyecto.label" default="Tipo Proyecto" /></th>"
					 html += "<th><g:message code="proyecto.prorrateo.label" default="Prorrateo" /></th>"
					 html += "<th>&nbsp;</th>"
					 html += "<th>&nbsp;</th>"
				 	 html += "</tr>"
				 	 html += "</thead>"
					
					$("#proyectos-solicitud").html(html);
					
					$("#proyectos-solicitud").empty();
		 			var resultados = 1 * data.result.tmpProySolicitudTotal;
		 			var idProyecto = 0;
		 			var nomProyectos = "";
		 			
		 			for(var i=0;i < resultados;i++){
		 			
		 				idProyecto = data.result.tmpProySolicitudList[i].idProyecto;
		 			
		 				 html += "<tr><td>"+data.result.tmpProySolicitudList[i].nombre+"</td>"
						 html += "<td>"+data.result.tmpProySolicitudList[i].responsable+"</td>"
						 html += "<td>"+data.result.tmpProySolicitudList[i].tipoProyecto+"</td>"
						 html += "<td>"+data.result.tmpProySolicitudList[i].prorrateo+"</td>"
						 html+="<td> <span onclick='selectProyecto("+idProyecto+")' class='ui-icon ui-icon-pencil'></span> </td>";
						 html+="<td> <span onclick='deleteProyectoTemp("+idProyecto+")' class='ui-icon ui-icon-closethick'></span> </td></tr>";
						 
						 nomProyectos+= i>0?", ":"";
						 nomProyectos+= data.result.tmpProySolicitudList[i].nombre;
						 
		 			}
		 			
		 			$("#proyectos-solicitud").append( html );
		 			$("#proyectos_txt").val( nomProyectos );
				}
				
			},
			error:function(request, status, error) {
					alert('ERROR: '+error+' '+request);
	              }	 
		});
	}	 
		 
	function addProyectoTemp(id, prorrateo){
		$.ajax({
			type: 'POST',
			url: ajaxAddPoyecto,
			dataType: 'json',
			data:"proyid="+id+"&tmpID="+$('#tmpID').val()+"&prorrateo="+prorrateo,
			success:function(data){
			
				if(data.result.code == 'ERROR'){
					alert(data.result.message);
					return false;
				}
			
				if(data.result.code == 'OK'){
					var html = "";
					
					 html += "<caption style='background-color: #95a5a6; color: white;'>Proyectos en la solicitud</caption>"
				 	 html += "<thead>"
					 html += "<tr>"
					 html += "<th><g:message code="proyecto.nombre.label" default="Nombre"/></th>"
					 html += "<th><g:message code="proyecto.responsable.label" default="Responsable" /></th>"
					 html += "<th><g:message code="proyecto.tipoProyecto.label" default="Tipo Proyecto" /></th>"
					 html += "<th><g:message code="proyecto.prorrateo.label" default="Prorrateo" /></th>"
					 html += "<th>&nbsp;</th>"
					 html += "<th>&nbsp;</th>"
				 	 html += "</tr>"
				 	 html += "</thead>"
					
					$("#proyectos-solicitud").html(html);
					
					$("#proyectos-solicitud").empty();
		 			var resultados = 1 * data.result.tmpProySolicitudTotal;
		 			var idProyecto = 0;
		 			var nomProyectos = "";
		 			
		 			for(var i=0;i < resultados;i++){
		 			
		 				idProyecto = data.result.tmpProySolicitudList[i].idProyecto;
		 			
		 				 html += "<tr><td>"+data.result.tmpProySolicitudList[i].nombre+"</td>"
						 html += "<td>"+data.result.tmpProySolicitudList[i].responsable+"</td>"
						 html += "<td>"+data.result.tmpProySolicitudList[i].tipoProyecto+"</td>"
						 html += "<td>"+data.result.tmpProySolicitudList[i].prorrateo+"</td>"
						 html+="<td> <span onclick='selectProyecto("+idProyecto+")' class='ui-icon ui-icon-pencil'></span> </td>";
						 html+="<td> <span onclick='deleteProyectoTemp("+idProyecto+")' class='ui-icon ui-icon-closethick'></span> </td></tr>";
						 
						 nomProyectos+= i>0?", ":"";
						 nomProyectos+= data.result.tmpProySolicitudList[i].nombre;
						 
		 			}
		 			
		 			 $("#proyectos_txt").val( nomProyectos );
		 			$("#proyectos-solicitud").append( html );
				}
				
			},
			error:function(request, status, error) {
					alert('ERROR: '+error+' '+request);
	              }	 
		
		});
	}
		 
	function listProyectos(){
			 $.ajax({
			 	type: 'POST',
			 	url: ajaxProyectos,
			 	dataType: 'json',
			 	
			 	data: $('#searchProyectos').serialize(),
				
				success: function(data) {
				
					var resultados = 1 * data.result.proyectoInstanceTotal;
					var html = "";
					for(var i=0;i < resultados;i++){
						html+="<tr>";
						html+="<td>"+data.result.proyectoInstanceList[i].nombre+"</td>";
						html+="<td>"+data.result.proyectoInstanceList[i].responsable+"</td>";
						html+="<td>"+data.result.proyectoInstanceList[i].tipoProyecto+"</td>";
						html+="<td> <span onclick='selectProyecto("+data.result.proyectoInstanceList[i].id+")' class='ui-icon ui-icon-plus'></span>  </td>";
						html+="</tr>"
					}
					html+="</table>";
					
					$("#proyectosList").html("<table id='proyectos-res' ><thead><tr>"+
														"<th><g:message code="proyecto.nombre.label" default="Nombre"/></th>"+
														"<th><g:message code="proyecto.responsable.label" default="Responsable" /></th>"+
														"<th><g:message code="proyecto.tipoProyecto.label" default="Tipo Proyecto" /></th>"+
														"<th>&nbsp;</th>"+
													"</tr></thead>" +
               								html);
				},
				error: function(request, status, error) {
					alert('no pasa '+error+' '+request);
	                }	 
			 });
		 }

/*
*
*FUNCIONALIDAD PARA ALMACEN
*
*/	 
		 
	function searchAlmacen(){

			 $.ajax({
					type: 'POST',
					url: ajaxAlmacenes,
					dataType: 'json',
					data:$('#search_almacen').serialize(),
					success:function(data){
					
						if(data.result.code == 'ERROR'){
							alert(data.result.message);
							return false;
						}
					
						if(data.result.code == 'OK'){
							var resultados = 1 * data.result.almacenTotal;
							var html = "<br>";

							html +="<table id='almacenes-solicitud'>";
							html +="<thead>";
							html +="<tr>";
							html +="<th><g:message code="almacen.label" default=''/></th>";
							html +="<th>&nbsp;</th>";
							html +="</tr>";
							html +="</thead>";
							html +="</table>";

							
							$("#almacenes_encontrados").html(html);
							
							var html2 = "";
							var contr = "";
							for(var i=0; i < resultados; i++){
								html2 += "<tr><td>"+data.result.almacenList[i].descripcion+"</td>";
								html2 += "<td> <span onclick='selectAlmacen("+data.result.almacenList[i].id+");' class='ui-icon ui-icon-plus'></span> </td></tr>";
								
							}

							$("#almacenes-solicitud").append(html2);
							
						}
						
					},
					error:function(request, status, error) {
							alert('ERROR: '+error+' '+request);
			              }	 
				});
		}


	function selectAlmacen(idAlmacen){
			$.ajax({
				type: 'POST',
				url: ajaxGetAlmacen,
				dataType: 'json',
				data:"id="+idAlmacen,
				success:function(data){
				
					if(data.result.code == 'ERROR'){
						alert(data.result.message);
						return false;
					}
				
					if(data.result.code == 'OK'){
						$("#lugarentrega_id").val( data.result.almacenInstance.id);
						$("#lugarentrega_nombre").val( data.result.almacenInstance.descripcion);
						$("#dialog-almacen").dialog( "close" );
					}
					
				},
				error:function(request, status, error) {
						alert('ERROR: '+error+' '+request);
		              }	 
			});
		}

/*
*
*FUNCIONALIDAD PARA QUIEN RECIBE
*
*/	 

	function searchReceptor(){

		$.ajax({
			type: 'POST',
			url: ajaxReceptores,
			dataType: 'json',
			data:$('#search_receptor').serialize(),
			success:function(data){
			
				if(data.result.code == 'ERROR'){
					alert(data.result.message);
					return false;
				}
			
				if(data.result.code == 'OK'){
					var resultados = 1 * data.result.receptorTotal;
					var html = "<br>";

					html +="<table id='receptores-solicitud'>";
					html +="<thead>";
					html +="<tr>";
					html +="<th><g:message code="receptor.nombres.label" default=''/></th>";
					html +="<th>&nbsp;</th>";
					html +="</tr>";
					html +="</thead>";
					html +="</table>";

					
					$("#receptores_encontrados").html(html);
					
					var html2 = "";
					var contr = "";
					for(var i=0; i < resultados; i++){
						html2 += "<tr><td>"+data.result.receptorList[i].nombres+" "+data.result.receptorList[i].apellidoP+"</td>";
						html2 += "<td> <span onclick='selectReceptor("+data.result.receptorList[i].id+");' class='ui-icon ui-icon-plus'></span> </td></tr>";
						
					}

					$("#receptores-solicitud").append(html2);
					
				}
				
			},
			error:function(request, status, error) {
					alert('ERROR: '+error+' '+request);
	              }	 
		});

	}	

	function selectReceptor(idReceptor){
		$.ajax({
			type: 'POST',
			url: ajaxGetReceptor,
			dataType: 'json',
			data:"id="+idReceptor,
			success:function(data){
			
				if(data.result.code == 'ERROR'){
					alert(data.result.message);
					return false;
				}
			
				if(data.result.code == 'OK'){
					$("#receptor_id").val( data.result.receptorInstance.id);
					$("#receptor_nombre").val( data.result.receptorInstance.nombres+" "+data.result.receptorInstance.apellidoP);
					$("#dialog-receptor").dialog( "close" );
				}
				
			},
			error:function(request, status, error) {
					alert('ERROR: '+error+' '+request);
	              }	 
		});
	}

	
</script>


	<!-- PROYECTOS -->
	<div id="dialog-proyectos" title="${message(code: 'solicitud.proyecto.modal.header', default: 'Proyectos')}">
	 	<br>
		<form action="#" onsubmit="listProyectos(); return false;" name="searchProyectos" id="searchProyectos">
			<div align="center">
				<input name="pbusqueda" type="text" required="" placeholder="Nombre de proyecto" size="30">
			</div>
		</form>
		
		<br>
		
		<div id="proyectosList">
		<!-- Aca se pinta la lista de proyectos encontrados -->
		</div>
		
		<div id="addProyecto">
		<!-- Aca se pintan los datos del proyecto para agregar el prorrateo -->
		</div>
		
		<div id="proyectosAgregados">
			<table id="proyectos-solicitud">
			 <caption style="background-color: #95a5a6; color: white;">Proyectos en la solicitud</caption>
				<thead>
				<tr>
					<th><g:message code="proyecto.nombre.label" default="Nombre"/></th>
					<th><g:message code="proyecto.responsable.label" default="Responsable" /></th>
					<th><g:message code="proyecto.tipoProyecto.label" default="Tipo Proyecto" /></th>
					<th><g:message code="proyecto.prorrateo.label" default="Prorrateo" /></th>
					<th>&nbsp;</th>
				</tr>
				</thead>
			</table>
		</div>
	</div>
	
	
	<!-- CONTRATOS -->
	<div id="dialog-contrato" title="${message(code: 'solicitud.contrato.modal.header', default: 'Contratos')}">
		<br>
		<form action="#" onsubmit="searchContrato(); return false;" name="search_Contrato" id="search_Contrato">
			<div align="center">
				<input name="pcontrato" type="search" required="" placeholder="Contrato" size="30">
			</div>
		</form>
		
		<div id="contratos_encontrados"><br>
			<table id="proyectos-solicitud">
				<thead>
				<tr>
					<th><g:message code="contrato.numContrato.label" default=""/></th>
					<th><g:message code="contrato.nombreCliente.label" default="Responsable" /></th>
					<th>&nbsp;</th>
				</tr>
				</thead>
			</table>
		</div>
	</div>
	
	
	<!-- LUGAR DE ENTREGA -->
	<div id="dialog-almacen" title="${message(code: 'solicitud.almacen.modal.header', default: 'Almacenes')}">
		<br>
		<form action="#" onsubmit="searchAlmacen(); return false;" name="search_almacen" id="search_almacen">
			<div align="center">
				<input name="palmacen" type="search" required="" placeholder="Almac&eacute;n" size="30">
			</div>
		</form>
		
		<div id="almacenes_encontrados"><br>
			<table id="almacenes-solicitud">
				<thead>
				<tr>
					<th><g:message code="almacen.label" default=""/></th>
					<th>&nbsp;</th>
				</tr>
				</thead>
			</table>
		</div>
	</div>
	
	
	<!-- QUIEN RECIBE -->
	<div id="dialog-receptor" title="${message(code: 'solicitud.receptor.modal.header', default: 'Quien recibe')}">
		<br>
		<form action="#" onsubmit="searchReceptor(); return false;" name="search_receptor" id="search_receptor">
			<div align="center">
				<input name="preceptor" type="search" required="" placeholder="Nombre" size="30">
			</div>
		</form>
		
		<div id="receptores_encontrados"><br>
			<table id="receptores-solicitud">
				<thead>
				<tr>
					<th><g:message code="receptor.nombres.label" default=""/></th>
					<th>&nbsp;</th>
				</tr>
				</thead>
			</table>
		</div>
	</div>
	
	