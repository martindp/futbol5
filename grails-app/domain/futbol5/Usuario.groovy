package futbol5

class Usuario {

    String nombre
    String email

    static constraints = {
        nombre(nullable:false, blank:false)
        email(nullable:false, blank:false, unique:true)
    }
}
