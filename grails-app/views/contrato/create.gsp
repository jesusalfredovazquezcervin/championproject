<%@ page import="championweb.Contrato" %>
<!doctype html>
<html>
	<head>
  		<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  		<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contrato.label', default: 'Contrato')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		
		<script>
		
		  $( document ).ready(function() {


			$("#spinner").bind("ajaxSend", function() {
			   $(this).fadeIn();
			}).bind("ajaxComplete", function() {
			       $(this).fadeOut();
				})

			  
			  $("#formContrato").submit(function() {
						//validando solamente los campos de la observacion
						if($.trim($("#observacion").val())!=''){
							if($.trim($("#responsable").val())==''){
								alert("Falta: Responsable de la observación");
								return false;
							}
						}
				});
		  });
		</script>
	</head>
	<body>
		<a href="#create-contrato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="contrato.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-contrato" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
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
			<g:form name="formContrato" action="save" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
		
	</body>
</html>
