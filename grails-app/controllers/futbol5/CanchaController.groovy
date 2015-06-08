package futbol5

import grails.rest.RestfulController

class CanchaController extends RestfulController {
    static responseFormats = ['json','xml']

    def index() {
        render [ canchas: Cancha.list() ] as JSON
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
