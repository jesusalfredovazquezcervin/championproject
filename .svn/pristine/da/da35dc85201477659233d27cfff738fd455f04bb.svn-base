<%@page import="championweb.SolicitudPartida"%>
<%@ page import="championweb.Solicitud" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'solicitud.label', default: 'Solicitud')}" />
		<g:set var="idSolicitudTMP" value="${tmpID}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
		
		
		<script>
		$(document).ready(function() {
			${remoteFunction(
				controller:'clasificacionProd',
			    action:'solicitudClasificacion',
			    update:'clasificacion-partidas',
			    onLoading:'buscando(true)',
			    onComplete:'buscando(false)',
				params:[idsolicitud:solicitudInstance.id])
			}
		});
					
			$(function(){
		//MODALES INFORMACION GENERAL	
			
				$( "#dialog-proyectos" ).dialog({
				  	  autoOpen: false,
				        modal: true,
				        height: 550,
				        width: 650,
				        stack: false,
				        buttons: {
				          Aceptar: function() {
				            $( this ).dialog( "close" );
				          }
				        }
				 });

				
				$( "#dialog-contrato" ).dialog({
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

				$( "#dialog-almacen" ).dialog({
				  	  autoOpen: false,
				        modal: true,
				        height: 550,
				        width: 550,
				        stack: false,
				        buttons: {
				          Aceptar: function() {
				            $( this ).dialog( "close" );
				          }
				        }
				 });

				$( "#dialog-receptor" ).dialog({
				  	  autoOpen: false,
				        modal: true,
				        height: 550,
				        width: 650,
				        stack: false,
				        buttons: {
				          Aceptar: function() {
				            $( this ).dialog( "close" );
				          }
				        }
				 });

				
				$("#search-contrato").button({
					icons: {
				        primary: "ui-icon-search"
				      },
				      text: false
				})
				.click(function() {
					$( "#dialog-contrato" ).dialog("open");
			        return false;
			      });

				
				$("#lista-proyectos").button({
					icons: {
				        primary: "ui-icon-search"
				      }
				})
				.click(function() {
					$( "#dialog-proyectos" ).dialog("open");
			        return false;
			      });

				
				$("#search-almacen").button({
					icons: {
				        primary: "ui-icon-search"
				      },
				      text: false
				})
				.click(function() {
					$( "#dialog-almacen" ).dialog("open");
			        return false;
			      });

				
				$("#search-receptor").button({
					icons: {
				        primary: "ui-icon-search"
				      },
				      text: false
				})
				.click(function() {
					$( "#dialog-receptor" ).dialog("open");
			        return false;
			      });

				
				$("#search-stock").button({
					icons: {
				        primary: "ui-icon-note"
				      }
				}).click(function() {
					$( "#dialog-stock" ).dialog("open");
			        return false;
			      });
				


				$("#clasificar-producto").button({
					icons: {
				        primary: "ui-icon-tag"
				      }
				}).click(function() {
					$( "#dialog-clasificacion" ).dialog("open");
			        return false;
			      });
				
				//MODALES CUERPO DE LA SOLICITUD
				
				$("#dialog-programa").dialog({
					  	  autoOpen: false,
					        modal: true,
					        height: 710,
					        width: 680,
					        stack: false,
					        buttons: {
					        	Aceptar: function() {
					        		$( this ).dialog( "close" );
							  	}
					         
					        }
				});

				$( "#dialog-loading-programa" ).dialog({
				  	  autoOpen: false,
				        modal: true,
				        height: 180,
				        width: 380,
				        stack: false,
				        buttons:{
							Ok:function(){
								$( "#dialog-loading-programa" ).dialog("close");
								$( "#dialog-programa" ).dialog("open");	
							}

						}
				});

				$("#add-programa").button({
					icons: {
				        primary: "ui-icon-document"
				      }
				})
				.click(function() {
					//$('#form_programa')[0].reset();
					//$("#progressbar-programa").hide();
					$('#idSol').val($('#tmpID').val());	
					$( "#dialog-programa" ).dialog("open");
			        return false;
			      });


				$("#dialog-stock").dialog({
				  	  autoOpen: false,
				        modal: true,
				        height: 610,
				        width: 700,
				        stack: false,
				        buttons: {
				        	Aceptar: function() {
				        		$( this ).dialog( "close" );
						  	}
				         
				        }
				});	

				$("#dialog-clasificacion").dialog({
				  	  autoOpen: false,
				        modal: true,
				        height: 710,
				        width: 780,
				        stack: false,
				        buttons: {
				        	Aceptar: function() {
				        		$( this ).dialog( "close" );
						  	}
				         
				        }
				});


				$( "#progressbar-resultados-prod" ).progressbar({
				      value: true
				 }).hide();
				
			});//FIN DE FUNCTION


			

			function loadingProds(val){
				
				$( "#progressbar-resultados-prod" ).progressbar( "option", "value", val );

				if(val){
					$( "#progressbar-resultados-prod" ).hide();
					}else{
						$( "#progressbar-resultados-prod" ).show();
					}
				
			}

			function clearProds(){
					$('#resultadosProducto').html('');
				}

			function saveSol(){
					$('#solicitudfrm').submit();
				}

			function refreshClasificacion(){
				${remoteFunction(
						controller:'clasificacionProd',
					    action:'solicitudClasificacion',
					    update:'clasificacion-partidas',
					    onLoading:'buscando(true)',
					    onComplete:'buscando(false)',
						params:[idsolicitud:solicitudInstance.id])
					}

				obtenerPartidas();
			}

			function cambiaEstatusSolicitud(sel){
				var s = sel.value
				var r = true
					
				if(s==4)
					r = confirm("¿Desea cancelar la solicitud?");

				if(r){
					${remoteFunction(
							controller:'solicitud',
						    action:'cambiaEstatusSolicitud',
						    /*update:'clasificacion-partidas',*/
						    onLoading:'buscando(true)',
						    onComplete:'buscando(false)',
							params: '\'idsolicitud=\'+\''+ solicitudInstance.id +'\'+\'&estatus=\'+s')
						}
				}
				
			}

			function cambiaEstatusPartidas(estatus, proveedor, solicitud){
				if(estatus.value>0){
					${remoteFunction(
							controller:'clasificacionProd',
						    action:'cambiaEstatusPartidas',
						    onLoading:'buscando(true)',
						    /*onLoaded:'buscando(false)',*/
							after:'refreshClasificacion()',
							params: '\'estatus=\'+estatus.value+\'&proveedor=\'+proveedor+\'&solicitud=\'+solicitud')
						}
				}
			}
		
		</script>
	</head>
	
	<body>
		<input type="hidden" id="idsolicitud" name="idsolicitud" value="${solicitudInstance.id}"/>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="solicitud.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-solicitud" class="content scaffold-create" role="main">
			<h1><g:message code="solicitud.new.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${solicitudInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${solicitudInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" name="solicitudfrm">
				<fieldset class="form">
					<g:render template="formEdit"/>
				</fieldset>
				<!-- fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset-->
			</g:form>
		</div>
		
		
		
		<!-- MODALES EN LA SOLICITUD -->
		
		<!-- MODALES DE LA PARTE GENERAL (INFORMACION GENERAL) -->
		<g:render template="modals_general_edit"/>
		
		<!-- MODALES DEL CUERPO DE LA SOLICITUD -->
		<g:render template="modals_body_edit"></g:render>
		
		<!-- PARTIDAS -->
		<fieldset id="fs02">
		<legend>Productos y materiales solicitados</legend>
			<div id="partidasList" name="partidasList" style="max-height:300px; overflow:scroll; font-size: 95%;" >
				<table>
				<thead>
					<tr>
					
						<th>Partida</th>
					
						<th>Clave</th>
					
						<th>Descripción</th>
						
						<th>Cantidad</th>
					
						<th>Unidad/Medida</th>
						
					</tr>
				</thead>
				<tbody>
					<g:each in="${SolicitudPartida.findAllBySolicitud(solicitudInstance)}" var="partidaInstance" status="i">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${i + 1}</td>
						<td>${partidaInstance.cveProducto }</td>
						<td>${partidaInstance.descProducto }</td>
						<td>${partidaInstance.cantidad }</td>
						<td>${partidaInstance.unidad }</td>
					
					</tr>
					</g:each>
					
				</tbody>
			</table>
			</div>
			<button id="clasificar-producto"><g:message code="solicitud.clasificar.label" default="Clasificar" /></button>
		</fieldset>
		<br>
		<fieldset class="buttons">
		</fieldset>
	</body>
</html>
