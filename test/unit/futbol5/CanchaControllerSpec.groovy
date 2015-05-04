package futbol5

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CanchaController)
@Mock(Cancha)
class CanchaControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "listado de canchas"() {
        given: "existen 10 canchas"
            10.times{
                new Cancha(
                    nombre: "Cancha_${it}",
                    direccion: "dir",
                    telefono: "telll",
                    precio: "${it}"
                ).save(failOnError: true)
            }

        when: "se pide la lista de canchas"
            def model = controller.index();

        then: "el modelo retornado contiene todos los elementos"
            model.canchas.size() == 10
            model.canchas.every { it.nombre.startsWith('Cancha_') }
    }

    void "crear cancha"() {
        given:
            def count = Cancha.count()

        when:
            params.nombre = 'pepe'
            params.direccion = 'dir'
            params.telefono = '123'
            params.precio = '100'
            def modelo = controller.save()

        then:
            modelo.cancha.nombre == 'pepe'
            Cancha.count() == count + 1
    }

    void "borrar cancha"() {
        given:
            def cancha = new Cancha(
                nombre: "Cancha_1",
                direccion: "dir",
                telefono: "telll",
                precio: "1"
            ).save(failOnError: true)
            def count = Cancha.count()

        when:
            controller.delete(cancha)

        then:
            def model = controller.index();
            model.canchas.size() == count - 1
    }

}
