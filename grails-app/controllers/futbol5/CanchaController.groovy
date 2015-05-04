package futbol5

import grails.rest.RestfulController

class CanchaController extends RestfulController {

    def index() {
        [ canchas: Cancha.list() ]
    }

    def save(){
        def c = new Cancha(
            nombre: params.nombre,
            direccion: "diredire",
            telefono: "123",
            precio: "100"
        ).save(failOnError: true)
        [ cancha: c ]
    }

    def delete(cancha){
        cancha.delete()
    }
}
