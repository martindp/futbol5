package futbol5

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CanchaController)
class CanchaControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "listado de canchas"() {
            given: "existen 10 canchas"
                10.times{
                    new Cancha(
                        nombre: "Cancha_${it}"
                        direccion: "dir"
                        telefono: "tel"
                        precio: ${it}
                    ).save(failOnError: true)
                }

            when: "se pide la lista de canchas"
            def model = controller.index();

            then: "el modelo retornado contiene todos los elementos"
            model.usuarios.size() == 10
            model.usuarios.every { it.nombre.startsWith('Cancha_') }
        }

    void "test hello"() {
            when:
            controller.hello()

            then:
            response.text == 'hello'
        }

    void 'test index'() {
            when:
            controller.index()

            then:
            response.redirectedUrl == '/cancha/hello'
        }
}
