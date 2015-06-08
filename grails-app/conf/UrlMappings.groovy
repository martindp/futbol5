class UrlMappings {

	static mappings = {

		// RESTful list mapping
		name restEntityList: "/$controller"(parseRequest: true) {
			action = [GET: "index", POST: "save"]
		}

	}
}
