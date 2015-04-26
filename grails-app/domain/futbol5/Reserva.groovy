package futbol5

class Reserva {

    Usuario usuario
    Cancha cancha
    Date fechaHora

    static constraints = {
    usuario(nullable:false, blank:false)
    cancha(nullable:false, blank:false)
    fechaHora(nullable:false, blank:false)
    }
}
