class UrlMappings {

	static mappings = {

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/cancha"(controller:"cancha", action:"index", method:"GET")

        "/"(controller:"home", action:"index")
        "500"(view:'/error')
	}
}
