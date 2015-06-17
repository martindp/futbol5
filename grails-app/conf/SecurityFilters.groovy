import futbol5.Usuario

class SecurityFilters {

    def errorAuth=[error: '401', message: 'No esta autorizado para acceder a este recurso']
    def filters = {
        authorization(controller: '*', action: '*') {
            before = {

            def token = params.access_token

            def user = null
            if(token)
            user = Usuario.findAllByAccess_token(token)

            if(controllerName == "cancha"){
                if(!user){
                render errorAuth
                return false
                }

            }

            if(controllerName == "usuario"){
                render errorAuth
                return false
            }

            if(controllerName == "reserva"){
                render errorAuth
                return false
            }

            return true
            }
       }

   }
}