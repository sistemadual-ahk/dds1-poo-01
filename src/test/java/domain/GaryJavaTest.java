package domain;

import org.junit.Assert;
import org.junit.Test;

public class GaryJavaTest {

    @Test
    public void camina(){
        gary gary = domain.gary.INSTANCE;
        gary.camina(100);
        Assert.assertEquals(9, gary.getEnergia());
        Assert.assertEquals(14, gary.getHambre());
    }

    @Test
    public void comeCeso(){
        gary gary = domain.gary.INSTANCE;
        gary.come(1, ceso.INSTANCE);
        Assert.assertEquals(12, gary.getHambre());
    }
}
