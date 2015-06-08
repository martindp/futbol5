class UrlMappings {

	static mappings = {

        "/cancha"(controller:"cancha", action:"index", method:"GET")

        "/"(controller:"home", action:"index")
        "500"(view:'/error')
	}
}
