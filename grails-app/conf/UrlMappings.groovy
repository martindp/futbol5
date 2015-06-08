class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/cancha/index"(controller: 'cancha', action: 'index')

	}
}
