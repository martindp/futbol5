class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/api/canchas"(resources: 'cancha')
		"/api/clientes"(resources: 'client')
		"/api/login"(controller:"login", action:"login", method:"GET")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}