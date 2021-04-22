fun main(){
    val Mascota1 = Mascota("Bulldog", "inglés",2)
    val Mascota2 = Mascota("Border ","Collie",1)


    val nombreCompleto1 = NombreCompleto("Estefano","Sandulescu")
    val nombreCompleto2 = NombreCompleto("Juan","Limon")



    val Persona1 = Persona(nombreCompleto1, Mascota1, Mascota2)
    val Persona2 = Persona(nombreCompleto2, Mascota1=null, Mascota2=null)

    Persona1.edad=45
    Persona2.edad=36

    Mascota1.edadMascota =2
    Mascota2.edadMascota =1

    Persona1.setDni("12345678B")
    Persona2.setDni("23459765T")

    Persona1.EspecificarMascota()
    Persona2.EspecificarMascota()
}

class Persona(var nombreCompleto : NombreCompleto, var Mascota1: Mascota? = null, var Mascota2: Mascota? = null) {
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


    fun EspecificarMascota(){

        print("Soy ${nombreCompleto.nombre} ${nombreCompleto.apellido} con DNI-$DNI. ")

        Mascota1?.let {
            print("Soy dueño de: ${it.nombreMascota} que tienen ${it.edadMascota} años ")
        } ?: run {
            print(" y todavia no tengo mascota :(")
        }
        println("")
        Mascota2?.let {
            print("y tambien de ${it.nombreMascota} que tiene ${it.edadMascota} año")
        }
        println("")
    }
}


class NombreCompleto( var nombre: String,var apellido: String){

}

class NombreMascota( var nombre: String){

}

class Mascota (var nombreMascota: String, var razaMascota: String, var edadMascota: Int){

}

