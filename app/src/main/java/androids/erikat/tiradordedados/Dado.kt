package androids.erikat.tiradordedados

import kotlin.random.Random

class Dado(var lados: Int = 6){ //Si no recibe un valor por parámetro, el total de lados por defecto será 6
    fun tirarDado():Int{
        return (1..lados).random() //Devuelve un número entre 1 y el total de caras del dado
    }
}