package domain

object pescado : comestible{

    override fun afectarHambreDe(gary : gary, raciones : Int){
        gary.hambre -= raciones * 4
    }
}