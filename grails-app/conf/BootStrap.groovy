import futbol5.Cancha

class BootStrap {


    def init = { servletContext ->
    Cancha c1 = new Cancha(nombre: "ElCordon", direccion: "Chana 2059", telefono: "099764471", precio: "140")  
    Cancha c2 = new Cancha(nombre: "ElGalpon", direccion: "18 de Julio 283", telefono: "099492304", precio: "140") 
    Cancha c3 = new Cancha(nombre: "TuCancha", direccion: "8 de Octubre 5832", telefono: "0991469834", precio: "140") 
    Cancha c4 = new Cancha(nombre: "ElGalpon2", direccion: "Paraguay 1200", telefono: "099583167", precio: "140") 
    Cancha c5 = new Cancha(nombre: "LACentral", direccion: "Cuareim 1738", telefono: "099321473", precio: "140") 
    Cancha c6 = new Cancha(nombre: "Unionsita", direccion: "20 de febrero 1839", telefono: "0999746589", precio: "140") 

    c1.save()
    c2.save()
    c3.save()
    c4.save()
    c5.save()
    c6.save()
    }

    def destroy = {
    }
}
