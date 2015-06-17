class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/api/canchas"(resources: 'cancha')
		"/api/reservas"(resources: 'reserva')
		"/api/barrios"(resources: 'barrio')
		"/api/usuarios"(resources: 'usuario')

		"/api/login"(controller:"login", action:"login", method:"GET")

        "500"(controller:"error", action:"errorServer", method:"GET")
        "404"(controller:"error",action:"errorNotFound",method:"GET")
        "/**"(controller:"error",action:"errorNotFound",method:"GET")
	}
}