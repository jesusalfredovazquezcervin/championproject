<%@ page import="championweb.Contrato" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contrato.label', default: 'Contrato')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
		<link rel="stylesheet" href="${resource(dir: 'css/champion-theme', file: 'jquery-ui-1.10.3.custom.min.css')}" />
		<script src="${resource(dir: 'js', file: 'jquery-ui-1.10.3.custom.min.js')}"></script>
		
		
<script>
  $(function() {

	//Se ejecuta al cargar la pagina, para mostrar las extensiones
	$('#myForm').submit();
	$('#formRemoteObs').submit();

	//Abre el formulario de extensiones
    $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 330,
      width: 650,
      modal: true,
      open: function () {
          $(this).load('../../extContrato/create?contrato.id=${contratoInstance?.id}');
      },
      buttons: {
        Cancelar: function() {
          $( this ).dialog( "close" );
        }
      },
      close: function() {
    	  //ya no es necesario, lo hace en el success del guardado: $('#myForm').submit();
      }
    });
 
    $( "#create-ext" )
      .button()
      .click(function() {
        $( "#dialog-form" ).dialog( "open" );
        return false;
      });

    $( "#add-obs" )
    .button()
    .click(function() {
      $( "#formRemoteSaveObs" ).submit();
    	resetObsForm();
    	
    });

	// DESPUES DE QUE SEA CREA UNA EXTENSION
    $( "#dialog-extcreate" ).dialog({
  	  autoOpen: false,
        modal: true,
        height: 180,
        width: 350,
        buttons: {
          Aceptar: function() {
            $( this ).dialog( "close" );
          }
        }
      });


	//Confirmar borrado de extenion
    $( "#dialog-confirmext-delete" ).dialog({
    	autoOpen: false,
        resizable: false,
        height:140,
        modal: true,
        buttons: {
          "Delete all items": function() {
            $( this ).dialog( "close" );
          },
          Cancel: function() {
        	  $( this ).dialog( "close" );
            	return false;
          }
        }

      });



    $('#formRemoteSaveObs').each (function(){
    	  this.reset();
    	});

  });
  

  	function deleteExt(){
  		 $( "#dialog-confirmext-delete" ).dialog("open");
  	}

	  
	//REFRESCA EL LISTADO DE EXTENSIONES
	  function refreshExt(){
		  $('#myForm').submit();
		}
		
	//REFRESCA EL LISTADO DE OBSERVACIONES
	  function refreshObs(){
		  $('#formRemoteObs').submit();
		}

	//LIMPIA FORMULARIO DE OBSERVACIONES
	function resetObsForm(){
		 $('#formRemoteSaveObs').each (function(){
	    	  this.reset();
	    	});
	}
	
</script>
		
		<g:javascript>
  		var ajaxAction = "${createLink(controller:'extContrato',action:'save')}";
  		
		 function guardarExt(){
			 $.ajax({
			 	type: 'POST',
			 	url: ajaxAction,
			 	dataType: 'json',
			 	
			 	data: $('#extForm').serialize(),
				
				success: function(data) {
					refreshExt();
					$( "#dialog-form" ).dialog("close");
					$( "#dialog-extcreate" ).dialog("open");
					//$('#ajaxMsg').html(data.result.code +" "+data.result.id);
				},
				error: function(request, status, error) {
					alert('Error al guardar '+error+' '+request);
	                       }	 
			 });
		 }
		</g:javascript>
		
		
		<script type="text/javascript">
		$(document).ready(function() {
		    $("#spinner").bind("ajaxSend", function() {
		        $(this).fadeIn();
		    }).bind("ajaxComplete", function() {
		        $(this).fadeOut();
		    })}
		);
		</script>
	</head>
	<body>
		<a href="#edit-contrato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="contrato.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="contrato.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		
<div id="tabs-contrato">
<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
 <ul>
    <li><a href="#edit-contrato">Datos</a></li>
    <li><a href="#obs-sec">Observaciones</a></li>
  </ul>
  
		<div id="edit-contrato" class="content scaffold-edit" role="main">
			<h1><g:message code="contrato.datos.title"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${contratoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${contratoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			
			<g:form method="post" >
				<g:hiddenField name="id" value="${contratoInstance?.id}" />
				<g:hiddenField name="version" value="${contratoInstance?.version}" />
				<fieldset class="form">
					<g:render template="formEdit"/>
				</fieldset>
		
			
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
			
		</div>	
			
			
	<!-- OBSERVACIONES DEL CONTRATO-->	
	<div id="obs-sec" style="padding-left: 21px; padding-right: 21px; " class="content scaffold-edit">	
	<h1><g:message code="contrato.observaciones.title" args="[entityName]" /></h1>
			<!-- SECCION DE NUEVA OBSERVACION -->
			<g:formRemote name="formRemoteSaveObs" id="formRemoteSaveObs"
			              url="[controller: 'observacionesContrato', action: 'save']" 
			              onSuccess="refreshObs();"
			              onFailure="alert('Error al guardar observaciones');">
			    
				<fieldset id="fs02">
				    <legend><g:message code="contrato.observacion.fieldset" default="Fecha observación" /></legend>
				   <g:textArea style="width:100%" name="observacion" value="${observacionesContratoInstance?.observacion}"/><br><br>
				   <label for="responsable">
						<g:message code="contrato.responsableObs.label" default="Responsable de observación" />
					</label>
				   <g:textField name="responsable" size="30" value="${observacionesContratoInstance?.responsable}"/>
				   &nbsp;&nbsp;
				   <label for="fecha">
						<g:message code="contrato.fechaObs.label" default="Fecha observación" />
					</label>
				   <g:datePicker name="fecha" precision="day"  value="${observacionesContratoInstance?.fecha}"  />
					<button id="add-obs"><g:message code="observacionesContrato.form.add" default="Add" /></button>				  
				</fieldset>
				<g:hiddenField name="contrato.id" value="${contratoInstance?.id}"/>
			</g:formRemote>
			<!-- SECCION DE NUEVA OBSERVACION -->
				
				
			<!-- LISTADO DE OBSERVACIONES -->
				<div id="remote-obs" class="myDialogClass">
				</div><br>
			<!-- LISTADO DE OBSERVACIONES -->
		<!-- OBSERVACIONES -->	
	</div>
	<!-- OBSERVACIONES DEL CONTRATO-->
</div>				
				
	<!-- FORMULARIOS OCULTOS PARA REFRESCAR LISTAS -->		
			<g:formRemote name="myForm" update="updateMe" id="myForm"
			              url="[controller: 'extContrato', action: 'list']" onFailure="alert('Error al conseguir las extensiones');">
			    <g:hiddenField name="contrato.id" value="${contratoInstance?.id}" />
			</g:formRemote>

			<g:formRemote name="formRemoteObs" update="remote-obs" id="formRemoteObs"
			              url="[controller: 'observacionesContrato', action: 'listByContrato']" onFailure="alert('Error al conseguir las observacio');">
			    <g:hiddenField name="contrato.id" value="${contratoInstance?.id}" />
			</g:formRemote>


	<!-- DIALOGOS DE CONFIRMACION/ERRROR -->
			<div id="dialog-extcreate" title="${message(code: 'extContrato.modal.header', default: 'Create')}">
			  <br>
			  <p>
			    <span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
			    ${message(code: 'extContrato.created.message')}
			  </p>
			</div>
			
			<div id="dialog-confirmext-delete" title="${message(code: 'extContrato.modal.header', default: 'Delete')}">
			  <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>
			  These items will be permanently deleted and cannot be recovered. Are you sure?</p>
			</div>

	</body>
</html>
