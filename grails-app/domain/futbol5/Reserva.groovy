package futbol5

class Reserva {

    Cancha cancha
    Client cliente
    Date fecha

    static constraints = {
        cancha(nullable:false, blank:false)
        cliente(nullable:false, blank:false)
        fecha(nullable:false, blank:false)
    }
}
