package futbol5

class Usuario {

    String password
    String email
    String access_token

    static hasMany = [
               roles: String,
               reservas: Reserva
    ]

    static constraints = {
        password(nullable:false, blank:false)
        email(nullable:false, blank:false, unique:true)
        access_token(nullable:false, blank:false)
    }
}
