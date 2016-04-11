<table id="tblProveedores">
  	<tr>
  		<th>Clave</th>
  		<th>Localidad</th>
  		<th>RFC</th>
  		<th>Nombre</th>
  		<th>&nbsp;</th>
  	</tr>
  
  		<g:each in="${proveedores?.proveedores}" var="proveedorInstance" status="i">
  			<g:if test="${proveedorInstance}">
  				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
		  			<td>${proveedorInstance.id}</td>
		  			<td>${proveedorInstance.localidad}</td>
		  			<td>${proveedorInstance.rfc}</td>
		  			<td>${proveedorInstance.nombre}</td>
		  			<td><span id="modalProveedores" class='ui-icon ui-icon-check' onclick="consultaProv(${proveedorInstance.id});"></span></td>
	  			</tr>
  			</g:if>
  		</g:each>
  	
</table>