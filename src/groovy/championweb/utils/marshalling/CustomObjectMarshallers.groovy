package championweb.utils.marshalling

class CustomObjectMarshallers {
	List marshallers = []

	def register(){
		marshallers.each{it.register()}
	}
}
