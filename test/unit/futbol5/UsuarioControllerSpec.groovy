package futbol5

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UsuarioController)
@Mock(Usuario)
class UsuarioControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "listado de usuarios"() {
        given: "existen 10 usuarios"
            10.times{
                new Usuario(
                    nombre: "Usuario_${it}",
                    email: "Usuario_${it}@mail.com"
                ).save(failOnError: true)
            }

        when: "se pide la lista de usuarios"
            def model = controller.index();

        then: "el modelo retornado contiene todos los elementos"
            model.usuarios.size() == 10
            model.usuarios.every { it.nombre.startsWith('Usuario_') }
    }

    void "crear usuario"() {
        given:
            def count = Usuario.count()

        when:
            params.nombre = 'pepe'
            params.email = 'pepe@mail.com'
            def modelo = controller.save()

        then:
            modelo.usuario.nombre == 'pepe'
            Usuario.count() == count + 1
    }

    void "borrar usuario"() {
        given:
            def usuario = new Usuario(
                nombre: "Usuario_1",
                email: "Usuario_1@mail.com"
            ).save(failOnError: true)
            def count = Usuario.count()

        when:
            controller.delete(usuario)

        then:
            def model = controller.index();
            model.usuarios.size() == count - 1
    }
}
