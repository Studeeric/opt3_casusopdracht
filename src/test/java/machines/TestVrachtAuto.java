package machines;

import com.logic.machines.Machine;
import com.logic.machines.VrachtAuto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVrachtAuto {

    @Test
    public void testHuurGV(){
        Machine testVAuto = new VrachtAuto(100, 100);
        double expected = 50;
        double actual = testVAuto.getTotaalPrijs(5, false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHuurWV(){
        Machine testVAuto = new VrachtAuto(100, 100);
        double expected = 55;
        double actual = testVAuto.getTotaalPrijs(5, true);
        Assertions.assertEquals(expected, actual);
    }

}
