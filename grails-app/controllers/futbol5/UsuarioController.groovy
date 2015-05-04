package futbol5

import grails.rest.RestfulController

class UsuarioController extends RestfulController{

    def index() {
        [ usuarios: Usuario.list() ]
    }

    def save(){
        def u = new Usuario(
            nombre: params.nombre,
            email: params.email
        ).save(failOnError: true)
        [ usuario: u ]
    }

    def delete(usuario){
        usuario.delete()
    }
}
