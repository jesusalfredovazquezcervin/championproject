
<%@ page import="championweb.ObservacionesContrato" %>
			<script>
			 $(function() {
				    var icons = {
				      header: "ui-icon-circle-arrow-e",
				      activeHeader: "ui-icon-circle-arrow-s"
				    };
				    $( "#acordion-obs" ).accordion({
				      icons: icons
				    });

				    $( "#tabs-contrato" ).tabs();

			});

			</script>
			
			<!-- SECCION DE OBSERVACIONES -->
			<div id="acordion-obs">
			<g:each in="${observacionesContratoInstanceList}" status="i" var="observacionesContratoInstance">
			<h3>
				<g:message code="observacionesContrato.accordion.label" args="${[observacionesContratoInstance?.responsable]}"/> <g:formatDate format="dd-MM-yyyy" date="${observacionesContratoInstance?.fecha}"/>
			</h3>
			<div>
			   <g:textArea style="width:100%; height:80px;" readonly="true" name="observacion" value="${observacionesContratoInstance?.observacion}" /><br>
			</div>
			</g:each>
			</div>
			<!-- SECCION DE OBSERVACIONES -->
			
