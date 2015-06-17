package futbol5

class Usuario {

    String nombre
    String apellido
    String email
    String access_token

    static hasMany = [
               roles: String,
               reservas: Reserva
    ]

    static constraints = {
        nombre(nullable:false, blank:false)
        apellido(nullable:false, blank:false)
        email(nullable:false, blank:false, unique:true)
        access_token(nullable:false, blank:false)
    }
}
