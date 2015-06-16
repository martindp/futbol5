class SecurityFilters {

   def errorAuth=[error: 'error', message: 'No esta autorizado para acceder a este recurso']

   def filters = {

       authorization(controller: '*', action: '*') {
           before = {

           if(controllerName == "cancha"){

           render errorAuth
           return false
           }




           }
       }

   }
}