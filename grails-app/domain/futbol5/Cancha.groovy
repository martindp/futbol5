package futbol5


class Cancha {

    String nombre
    String direccion
    String telefono
    String precio
    Barrio barrio
    Usuario admin

    static hasMany = [reservas: Reserva]

    static constraints = {
        nombre(nullable:false, blank:false, unique:true)
        direccion(nullable:false, blank:false)
        telefono(nullable:false, blank:false)
        precio(nullable:false, blank:false)
        barrio(nullable:false, blank:false)
    }
}
