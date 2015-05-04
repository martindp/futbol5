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
                        nombre: "Cancha_${it}",
                        direccion: "dir",
                        telefono: "telll",
                        precio: ${it}
                    ).save(failOnError: true)
                }

            when: "se pide la lista de canchas"
            def model = controller.index();

            then: "el modelo retornado contiene todos los elementos"
            model.canchas.size() == 10
            model.canchas.every { it.nombre.startsWith('Cancha_') }
        }
    void "crear cancha"() {
                given: "una cancha"
                        def cancha = new Cancha(
                            nombre: "Cancha1",
                            direccion: "dir",
                            telefono: "telll",
                            precio: ${it}
                        )


                when: "se crea una cancha"
                controller.save(cancha);
                def model = controller.index();

                then: "el modelo retornado contiene la cancha creada"
                model.canchas.any { it.nombre.startsWith('Cancha1') }
            }

}
