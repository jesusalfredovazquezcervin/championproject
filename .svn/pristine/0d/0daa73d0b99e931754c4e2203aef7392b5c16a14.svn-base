<%@ page import="championweb.Solicitud" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'solicitud.label', default: 'Solicitud')}" />
		<g:set var="idSolicitudTMP" value="${tmpID}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		
		<g:javascript>
			var ajaxContratos  = "${createLink(controller:'contrato', action:'listByAjax')     }";
			var ajaxProyectos  = "${createLink(controller:'proyecto', action:'listByAjax')     }";
			var ajaxAddPoyecto = "${createLink(controller:'solicitud',action:'tmpProyectos')   }";
			var ajaxGetProyecto= "${createLink(controller:'proyecto', action:'showByAjax') 	   }";
			var ajaxDelProyecto= "${createLink(controller:'solicitud',action:'delTmpProyectos')}";
			var ajaxGetContrato= "${createLink(controller:'contrato', action:'getByIdAjax')	   }";
			var ajaxAlmacenes  = "${createLink(controller:'almacen',  action:'getListAjax')    }";
			var ajaxGetAlmacen = "${createLink(controller:'almacen',  action:'getByIdAjax')    }";
			var ajaxReceptores = "${createLink(controller:'receptor', action:'getListAjax')    }";
			var ajaxGetReceptor= "${createLink(controller:'receptor', action:'getByIdAjax')    }";
		</g:javascript>
		
		<script>

			$(function(){
				/*$(':file').change(function(){
				    var file = this.files[0];
				    name = file.name;
				    size = file.size;
				    type = file.type;
				    alert(size);
				});*/

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
				        primary: "ui-icon-search"
				      }
				}).click(function() {
					$( "#dialog-stock" ).dialog("open");
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
							  	},
					          	Guardar: function() {
					            	console.log('SE DIO CLICK EN GUARDAR');
					            	savePrograma();
							    	return false;
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
				        height: 710,
				        width: 700,
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


			function addFuncProyectosol(){
				$("#add-proyectosol").button({
					icons: {
				        primary: "ui-icon-plus"
				      },
				      text: false
				})
				.click(function() {
					var idp = $('#proyectoadd_id').val();
					var prorrateop = $('#proyectoadd_prorrateo').val();
					addProyectoTemp(idp, prorrateop);
					$("#addProyecto").empty();
			        return false;
			      });
			}

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
				var partidas = $("#cantidad_partidas").val();
				if(partidas<1 || (partidas == undefined) ){
					alert("La solicitud no tiene partidas.")
					return false;
				}else{
					var r = confirm("¿Desea crear la solicitud?, una vez creada se enviar\u00e1 un correo al \u00e1rea correspondiente.");
					if (r == true) {
						$('#solicitudfrm').submit();
					} else {
					   return false
					}
				}
				
				
			}
		
		</script>
	</head>
	
	<body>
		<input type="hidden" id="tmpID" name="tmpID" value="${tmpID}"/>
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
					<g:render template="form"/>
				</fieldset>
				<!-- fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset-->
			</g:form>
		</div>
		
		
		
		<!-- MODALES EN LA SOLICITUD -->
		
		<!-- MODALES DE LA PARTE GENERAL (INFORMACION GENERAL) -->
		<g:render template="modals_general"/>
		
		<!-- MODALES DEL CUERPO DE LA SOLICITUD -->
		<g:render template="modals_body"></g:render>
		
		<!-- BUSQUEDA DE PRODUCTOS Y SELECCION PARA PARTIDAS -->
		<fieldset id="fs02">
		<legend>Búsqueda de producto</legend>
			<g:formRemote name="searchProductosSol" url="[controller:'solicitud', action:'searchStock']" on_500="alert('ERROR')" update="resultadosProducto" onLoading="clearProds(); loadingProds(false)" onLoaded="loadingProds(true)">
				<g:hiddenField name="idSolicitudTMP" value="${idSolicitudTMP }"/>
				Nombre de producto&nbsp;<g:field type="search" name="descSearch"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Clave de producto&nbsp;<g:field type="search" name="cveSearch"/>
				<g:submitButton name="buscar" value="Buscar" />
			</g:formRemote>
			<br>
		
			<div id="progressbar-resultados-prod"></div>
			<div id="resultadosProducto" name="resultadosProducto" style="max-height:300px; overflow:scroll; font-size: 95%;" ></div>
					
		</fieldset>
		
		
		<fieldset id="fs02">
		<legend>Productos y materiales solicitados</legend>
					<div id="partidasList" name="partidasList" style="max-height:300px; overflow:scroll; font-size: 95%;" ></div>
		</fieldset>
		<br>
		<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" onclick="saveSol()" />
		</fieldset>
	</body>
</html>
