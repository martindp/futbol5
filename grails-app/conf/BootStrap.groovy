import futbol5.Cancha
import futbol5.Barrio

class BootStrap {


    def init = { servletContext ->


    Barrio b1 = new Barrio(nombre: "Cordon")
    Barrio b2 = new Barrio(nombre: "Centro")
    Barrio b3 = new Barrio(nombre: "Union")
    Barrio b4 = new Barrio(nombre: "Pocitos")
    Barrio b5 = new Barrio(nombre: "Punta Gorda")
    Barrio b6 = new Barrio(nombre: "Palermo")

    b1.save()
    b2.save()
    b3.save()
    b4.save()
    b5.save()
    b6.save()

     Cancha c1 = new Cancha(nombre: "ElCordon", direccion: "Chana 2059", telefono: "099764471", precio: "140", barrio: b1,  horarios: [16,17,18,19,20,21,22,23])
     Cancha c2 = new Cancha(nombre: "ElGalpon", direccion: "18 de Julio 283", telefono: "099492304", precio: "140", barrio: b2, horarios: [16,17,18,19,20,21,22,23])
     Cancha c3 = new Cancha(nombre: "TuCancha", direccion: "8 de Octubre 5832", telefono: "0991469834", precio: "140", barrio: b3, horarios: [16,17,18,19,20,21,22,23])
     Cancha c4 = new Cancha(nombre: "ElGalpon2", direccion: "Paraguay 1200", telefono: "099583167", precio: "140", barrio: b4, horarios: [16,17,18,19,20,21,22,23])
     Cancha c5 = new Cancha(nombre: "LACentral", direccion: "Cuareim 1738", telefono: "099321473", precio: "140", barrio: b5, horarios: [16,17,18,19,20,21,22,23])
     Cancha c6 = new Cancha(nombre: "Unionsita", direccion: "20 de febrero 1839", telefono: "0999746589", precio: "140", barrio: b6, horarios: [16,17,18,19,20,21,22,23])

     c1.save()
     c2.save()
     c3.save()
     c4.save()
     c5.save()
     c6.save(flush: true)


}

    def destroy = {
    }
}
