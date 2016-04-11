package championweb.proy

import grails.converters.JSON
import championweb.Proyecto

class ProyectoMarshaller {
	
	void register(){
		JSON.registerObjectMarshaller( Proyecto ){ Proyecto proyecto->
			return[
					id:proyecto.id,
					nombre:proyecto.nombre,
					tipoProyecto:proyecto.tipoProyecto,
					descripcion:proyecto.descripcion,
					almacen:proyecto.almacen.descripcion,
					responsable:proyecto.responsable.nombres
				]
		}
	}

}
