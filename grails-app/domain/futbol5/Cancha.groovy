package futbol5


class Cancha {

    String nombre
    String direccion
    String telefono
    String precio
    Barrio barrio

    static hasMany =
    [
    	reservas: Reserva,
    	horarios: Integer
    ]

    static constraints = {
        nombre(nullable:false, blank:false, unique:true)
        direccion(nullable:false, blank:false)
        telefono(nullable:false, blank:false)
        precio(nullable:false, blank:false)
        barrio(nullable:false, blank:false)
    }
}
