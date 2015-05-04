package futbol5

class Cancha {

    String nombre
    String direccion
    String telefono
    String precio

    static constraints = {
        nombre(nullable:false, blank:false, unique:true)
        direccion(nullable:false, blank:false)
        telefono(nullable:false, blank:false)
        precio(nullable:false, blank:false)
    }
}
