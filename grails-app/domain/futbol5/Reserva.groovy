package futbol5

class Reserva {

    Cancha cancha
    Usuario usuario
    Date fecha
    int hora

    static constraints = {
        cancha(nullable:false, blank:false)
        usuario(nullable:false, blank:false)
        fecha(nullable:false, blank:false)

    }
}
