<%@ page import="com.koomoni.dto.*" %>
<%@ page import="championweb.Zona" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="almacen.relacion.list"  /></title>
		
		<g:javascript>
			function getTexto(){
				$("#descripcion").text($("#claveAlmacen option:selected").text());
				$('input[name=descripcion]').val($("#claveAlmacen option:selected").text());
			}
			
			function editar(idZona,idAlmacen){
				$('#zona').val(idZona).trigger('change');
				$('#claveAlmacen').val(idAlmacen).trigger('change');
				
				$('#claveAlmacen').prop('disabled', 'disabled');
				
				getTexto();
				$('#almacenUpdate').val(idAlmacen);
			}
		</g:javascript>
		
	</head>
	<body>
	
		<a href="#list-almacen" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
	
		<div id="list-almacen" class="content" role="main">
			<h1><g:message code="almacen.relacion.list"/></h1>
			<g:hasErrors bean="${almacenInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${almacenInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="relacionarSave" >
				<fieldset class="formRelacion">
					<g:render template="formRelacion"/>
				</fieldset>
			</g:form>
		</div>
		
		<div id="list-almacen" class="content scaffold-list" role="main">
			
			<table>
			<thead>
			  <tr>
			    <g:sortableColumn property="claveAlmacen" title="${message(code: 'almacen.clave.label', default: 'Clave de Almacén')}" />
			    <g:sortableColumn property="descripcion" title="${message(code: 'almacen.label', default: 'Almacén')}" />
			    <g:sortableColumn property="zona" title="${message(code: 'almacen.zona.label', default: 'Zona')}" />
			    <th>&nbsp;</th>
			  </tr>
			 </thead>
			 <tbody>
			  	<g:each in="${almacenInstanceList}" status="i" var="almacenInstance">
			  	<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			  		<td>${fieldValue(bean: almacenInstance, field: "claveAlmacen")}</td>
			    	<td>${fieldValue(bean: almacenInstance, field: "descripcion")}</td>
			    	<td>${fieldValue(bean: almacenInstance, field: "zona.nombreZona")}</td>
			    	<td><a href="#" onclick="editar('${almacenInstance.zona.id}','${almacenInstance.claveAlmacen.toString()}');">[EDITAR]</a></td>
			    </tr>
			  	</g:each>
			 </tbody>
			</table>
			
		</div>
		
	
	</body>
</html>