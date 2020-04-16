package domain

object ceso : comestible{

    override fun afectarHambreDe(gary : gary, raciones : Int){
        gary.hambre -= raciones *2
    }
}