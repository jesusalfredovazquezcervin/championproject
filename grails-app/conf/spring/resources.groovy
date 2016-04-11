import championweb.proy.ProyectoMarshaller
import championweb.utils.marshalling.CustomObjectMarshallers

// Place your Spring DSL code here
beans = {
	customObjectMarshallers( CustomObjectMarshallers ) {
		marshallers = [
				new ProyectoMarshaller()
		]
	}
	
	/*securityEventListener(com.advancemx.nap.SecurityEventListener) {bean ->
		bean.autowire = 'byName'
	}
	
	authenticationFailureListener(com.advancemx.nap.AuthenticationFailureListener) {bean ->
		bean.autowire = 'byName'
	}
	
	authenticationSuccessListener(com.advancemx.nap.AuthenticationSuccessListener) {bean ->
		bean.autowire = 'byName'
	}
	
	abstractAuthenticationFailureListener(com.advancemx.nap.AbstractAuthenticationFailureListener) {bean ->
		bean.autowire = 'byName'
	}*/
}
