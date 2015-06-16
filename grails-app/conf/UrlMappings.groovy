class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

"/api/reservas"(resources: 'reserva')

		"/api/canchas"(resources: 'cancha')
		"/api/clientes"(resources: 'client')
		"/api/barrios"(resources: 'barrio')
		"/api/login"(controller:"login", action:"login", method:"GET")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}