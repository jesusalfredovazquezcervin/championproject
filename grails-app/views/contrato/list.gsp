
<%@ page import="championweb.Contrato" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contrato.label', default: 'Contrato')}" />
		<title><g:message code="contrato.list.title" args="[entityName]" /></title>
		<link rel="stylesheet" href="${resource(dir: 'css/champion-theme', file: 'jquery-ui-1.10.3.custom.min.css')}" />
		<script src="${resource(dir: 'js', file: 'jquery-ui-1.10.3.custom.min.js')}"></script>
		<script src="${resource(dir: 'js', file: 'datepickerES.js')}"></script>
		
	<style type="text/css">
      @media print {
        body * {
          display:none;
        }

        body .printable {
          display:block;
        }
      }
    </style>
    
	</head>
	<body>
		<a href="#list-contrato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="contrato.create.title" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-contrato" class="content scaffold-list" role="main">
			<h1><g:message code="contrato.list.title" args="[entityName]" /></h1>
			<fieldset class="form" align="center">
					<g:render template="search"/>
			</fieldset>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table id="tbl-contratos">
				<thead>
					<tr>
					
						<g:sortableColumn property="numContrato" title="${message(code: 'contrato.numContrato.label', default: 'Num Contrato')}" />
						
						<g:sortableColumn property="nombreCliente" title="${message(code: 'contrato.nombreCliente.label', default: 'Nombre Cliente')}" />
					
						<g:sortableColumn property="fechaInicio" title="${message(code: 'contrato.fechaInicio.label', default: 'Fecha Inicio')}" />
					
						<g:sortableColumn property="fechaFin" title="${message(code: 'contrato.fechaFin.label', default: 'Fecha Fin')}" />
						
						<g:sortableColumn property="fechaExtendida" title="${message(code: 'contrato.fechaExtendida.label', default: 'Fecha Extendida')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${contratoInstanceList}" status="i" var="contratoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="edit" id="${contratoInstance.id}">${fieldValue(bean: contratoInstance, field: "numContrato")}</g:link></td>
						
						<td>${fieldValue(bean: contratoInstance, field: "nombreCliente")}</td>
					
						<td><g:formatDate format='dd /MM /yyyy' date="${contratoInstance.fechaInicio}" /></td>
						
						<td class="${new Date() > (contratoInstance.extension? new Date():contratoInstance.fechaFin) ? 'caduc':''}"><g:formatDate format='dd /MM /yyyy' date="${contratoInstance.fechaFin}" /></td>
						
						<td class="${new Date() >  (contratoInstance.extension? contratoInstance.extension.sort{it.id}.last().fechaFinal:null)?'caduc':''}"><g:formatDate format='dd /MM /yyyy' date="${contratoInstance.extension? contratoInstance.extension.sort{it.id}.last().fechaFinal :null}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			
			<!--input id="btnSubmit" type="submit" value="Print" onclick="divPrint();" /></p>
    <script type="text/javascript">
      function divPrint() {
    	  var divToPrint=document.getElementById('tbl-contratos');
    	  var head=document.getElementById('grailsLogo');
    	  var a =new String('<link rel="stylesheet" href="/ChampionWEB/static/css/main.css" type="text/css">');
    	  newWin= window.open("");
    	  newWin.document.write(head.outerHTML);
    	  newWin.document.write('<link rel="stylesheet" href="/ChampionWEB/static/css/main.css" type="text/css">');
    	  newWin.document.write(divToPrint.outerHTML);
    	  newWin.print();
    	  //newWin.close();
      }
    </script-->
			
			<div class="pagination">
				<g:paginate total="${contratoInstanceTotal}" params="${[pcliente: pcliente, pcontrato:pcontrato, fechaInicio:fechaInicio, fechaFin:fechaFin]}"/>
			</div>
		</div>
	</body>
</html>
