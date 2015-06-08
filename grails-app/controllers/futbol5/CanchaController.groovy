package futbol5

import grails.rest.RestfulController

class CanchaController extends RestfulController {

    def index() {
        [ canchas: Cancha.list() ]
    }

    def save(){
        def c = new Cancha(
            nombre: params.nombre,
            direccion: params.direccion,
            telefono: params.telefono,
            precio: params.precio
        ).save(failOnError: true)
        [ cancha: c ]
    }

    def delete(cancha){
        cancha.delete()
    }
}
