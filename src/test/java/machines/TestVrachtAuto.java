package machines;

import com.logic.machines.Machine;
import com.logic.machines.VrachtAuto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVrachtAuto {
    final Machine testVAuto = new VrachtAuto();

    @BeforeEach
    public void start(){
        testVAuto.getProperty(0).setPropertyValue("100");
        testVAuto.getProperty(1).setPropertyValue("100");
    }

    @Test
    public void testHuurGV() {
        double expected = 50;
        double actual = testVAuto.getTotaalPrijs(5, false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHuurWV() {
        double expected = 55;
        double actual = testVAuto.getTotaalPrijs(5, true);
        Assertions.assertEquals(expected, actual);
    }

}
