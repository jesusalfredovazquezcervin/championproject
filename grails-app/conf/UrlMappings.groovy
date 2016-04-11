class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

//		"/"(view:"/index")
		"/"(controller:"index")
		"500"(view:'/error')
		"404"(view:'/404')
		"/login"(view:"/login")
		"/recovery"(controller:"recoveryLink",action:"create")
	}
}
