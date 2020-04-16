package domain

object comestibleBalanceada : comestible {

    override fun afectarHambreDe(gary : gary, raciones : Int){
        gary.hambre -= raciones * 3
    }
}