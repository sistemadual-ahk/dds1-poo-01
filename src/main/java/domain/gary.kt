package domain

object gary {
    var color : String? = "Naranja"
    var hambre : Int = 10
    var energia : Int = 10

    fun come(algunasRaciones : Int){
        this.hambre -= algunasRaciones
    }

    fun come(algunasRaciones: Int, comida : comestible){
        comida.afectarHambreDe(this, algunasRaciones)
    }

    fun dormi(unosMinutos : Int){
        this.energia += 2 * (unosMinutos/30)
    }

    fun camina(unosMetros : Int){
        this.energia -= 1 * (unosMetros/70)
        this.hambre += 2 * (unosMetros/40)
    }
}