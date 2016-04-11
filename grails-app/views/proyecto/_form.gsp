<%@ page import="championweb.Proyecto" %>



<div class="fieldcontain ${hasErrors(bean: proyectoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="proyecto.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="100" size="80" required="" value="${proyectoInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: proyectoInstance, field: 'tipoProyecto', 'error')} required">
	<label for="tipoProyecto">
		<g:message code="proyecto.tipoProyecto.label" default="Tipo Proyecto" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="tipoProyecto" maxlength="100" required="" value="${proyectoInstance?.tipoProyecto}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: proyectoInstance, field: 'almacen', 'error')} required">
	<label for="almacen">
		<g:message code="proyecto.almacen.label" default="Almacen" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="almacen" name="almacen.id" from="${championweb.Almacen.list()}" optionKey="id" required="" value="${proyectoInstance?.almacen?.id}" optionValue="descripcion" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: proyectoInstance, field: 'responsable', 'error')} required">
	<label for="responsable">
		<g:message code="proyecto.responsable.label" default="Responsable" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="responsable" name="responsable.id" from="${championweb.Responsable.list()}" optionKey="id" required="" value="${proyectoInstance?.responsable?.id}" optionValue="nombreCompleto" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: proyectoInstance, field: 'zona', 'error')} required">
	<label for="zona">
		<g:message code="proyecto.zona.label" default="Zona" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="zona" name="zona.id" from="${championweb.Zona.list()}" optionKey="id" required="" value="${proyectoInstance?.zona?.id}" optionValue="nombreZona" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: proyectoInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="proyecto.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="descripcion" maxlength="250" required="" value="${proyectoInstance?.descripcion}"/>
</div>
