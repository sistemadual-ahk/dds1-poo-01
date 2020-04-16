package domain

import org.junit.Test
import org.junit.Assert.*

class GaryTest {

    @Test
    fun camina() {
        gary.camina(100)
        assertEquals(9, gary.energia)
        assertEquals(14, gary.hambre)
    }

    @Test
    fun comeCeso(){
        gary.come(1, ceso)
        assertEquals(12, gary.hambre)
    }

    @Test
    fun come() {
        gary.come(3)
        assertEquals(9, gary.hambre)
    }

    @Test
    fun dormi() {
        gary.dormi(45)
        assertEquals(11, gary.energia)
    }
}