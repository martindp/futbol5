package futbol5

class Barrio {

    String nombre

    static constraints = {
    	nombre(nullable:false, blank:false, unique:true)
    }
}
