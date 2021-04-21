fun main(){

    val nombreCompleto1 = NombreCompleto("Carlos","Tena")
    val nombreCompleto2 = NombreCompleto("Juan","Limon")

    val Mascota1 = Mascota("Bulldog", "inglés",12)
    val Mascota2 = Mascota("Border ","Collie",15)

    Mascota1.setchip(689)
    Mascota2.setchip(934)

    val Persona1 = Persona(nombreCompleto1, Mascota1, Mascota2)
    val Persona2 = Persona(nombreCompleto2, Mascota1=null, Mascota2=null)

    Persona1.edad=45
    Persona2.edad=36
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

        print("Soy ${nombreCompleto.nombre} con DNI $DNI")

        if (Mascota1 == null) {
            Mascota1 = Mascota2
            Mascota2 = null
        }

        Mascota1?.let {
            print(" y soy dueño de ${it.nombreMascota}")
        } ?: run {
            print(" y no tengo mascota")
        }

        Mascota2?.let {
            print(" y dueño de ${it.nombreMascota}")
        }
        println("")
    }
}


class NombreCompleto( var nombre: String,var apellido: String){

}

class NombreMascota( var nombre: String){

}

class Mascota (var nombreMascota: String, var razaMascota: String, var edadMascota: Int){
    private var numeroChip : Int? = null

    fun setchip (numeroChip: Int){
        this.numeroChip = numeroChip
    }
}

