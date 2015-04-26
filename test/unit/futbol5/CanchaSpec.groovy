package futbol5

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Cancha)
class CanchaSpec extends Specification {

    def setup() {}

    def cleanup() {
    }

    void 'Ningun dato de la cancha puede ser nulo'() {

    when: 'Cuando el nombre es nulo'
    def c= new Cancha(direccion:'Direccion1', telefono:'Telefono1', precio:'Precio1')

    then: !c.validate()

    when: 'Cuando la direccion es nula'
        c= new Cancha(nombre:'Cancha1', telefono:'Telefono1', precio:'Precio1')

    then: !c.validate()

    when: 'Cuando el telefono es nulo'
    c= new Cancha(nombre:'Cancha1',  direccion:'Direccion1', precio:'Precio1')

    then: !c.validate()

    when: 'Cuando el precio es nulo'
    c= new Cancha(nombre:'Cancha1',  direccion:'Direccion1', telefono:'Telefono1')

    then: !c.validate()

    when: 'Cuando nada es nulo'
    c= new Cancha(nombre:'Cancha1', direccion:'Direccion1', telefono:'Telefono1', precio:'Precio1')

    then: c.validate()
    }



}
