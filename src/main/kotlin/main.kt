fun main(){
    val mascota1 = Mascota("Bulldog", "inglés",2)
    val mascota2 = Mascota("Border ","Collie",1)

    //opcion 1
    //val listaMacotas = mutableListOf(Mascota1, Mascota2)


    //opcion2
    val listaMacotas = mutableListOf<Mascota>()
    listaMacotas.add(mascota1)
    listaMacotas.add(mascota2)



    val nombreCompleto1 = NombreCompleto("Estefano","Sandulescu")
    val nombreCompleto2 = NombreCompleto("Juan","Limon")



    val Persona1 = Persona(nombreCompleto1, listaMacotas)
    val Persona2 = Persona(nombreCompleto2, null)

    Persona1.edad=45
    Persona2.edad=36

    mascota1.edadMascota =2
    mascota2.edadMascota =1

    Persona1.setDni("12345678B")
    Persona2.setDni("23459765T")

    Persona1.escribirMascotas()
    Persona2.escribirMascotas()
}

class Persona(var nombreCompleto : NombreCompleto, var listaMascotas : MutableList<Mascota>?) {
    // edad es publica, no pongo restricciones a que lo cambien
    var edad = 18
    private var DNI: String? = null

    //Si el DNI private me interesa poner un get y un set
    //Para poder cambiar el DNI que en este caso es una variable privada, necesitamos crear una funcin que sea SET
    fun setDni(DNI: String) {
        if (DNI.length == 9 && DNI[DNI.length - 1].isLetter()) {
            this.DNI = DNI
        }
    }


    fun escribirMascotas() {

        print("Soy ${nombreCompleto.nombre} ${nombreCompleto.apellido} con DNI-$DNI y $edad años. ")

        listaMascotas?.forEach { mascota ->
            print("${mascota.nombreMascota} ")
        }
        if(listaMascotas.isNullOrEmpty()) println("No tengo mascota")

    println("")


    }

}


class NombreCompleto( var nombre: String,var apellido: String){

}

class NombreMascota( var nombre: String){

}

class Mascota (var nombreMascota: String, var razaMascota: String, var edadMascota: Int){

}

