package futbol5

import grails.rest.RestfulController
import grails.converters.JSON

class CanchaController extends RestfulController {
    static responseFormats = ['json','xml']

    def index() {
        render 'lklklk' as JSON
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
