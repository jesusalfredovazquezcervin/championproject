<%@ page import="com.koomoni.dto.*" %>
<%@ page import="championweb.Zona" %>

<table width="40%" style="border-top: 0px;">

  <tr>
    <td width="30">
		<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'perfil', 'error')} required">
				<label for="almacen">
					<g:message code="almacen.label" default="Almacén" />
					<span class="required-indicator">*</span>
				</label>
				<g:select id="claveAlmacen" onchange="getTexto();" name="claveAlmacen" style="width:200px;height:30px;" from="${resList}" optionKey="id" optionValue="descripcion" required="" class="many-to-one" noSelection="['':'-Seleccione el almacén-']"/>
				<g:field type="hidden" name="descripcion" id="descripcion"/>
				<g:field type="hidden" name="almacenUpdate" id="almacenUpdate"/>
		</div>
		<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'perfil', 'error')} required">
				<label for="zona">
					<g:message code="almacen.zona.label" default="Zona" />
					<span class="required-indicator">*</span>
				</label>
				<g:select id="zona" name="zona" style="width:200px;height:30px;" from="${Zona.list()}" optionKey="id" optionValue="nombreZona" required=""  class="many-to-one" noSelection="['':'-Seleccione la Zona-']" />
		</div>
	</td>
    
    <td valign="middle" width="10" style="padding-right:50px;padding-top:38px;">
    	<button type="submit" onclick="guardar();" class="relacionar"><g:message code="almacen.relacionar.label" default="Relacionar" /></button>
    </td>
  </tr>
  
</table>
		