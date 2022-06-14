package machines;

import com.logic.machines.Machine;
import com.logic.machines.PersonenAuto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPersonenAuto {
     final Machine testAuto = new PersonenAuto();

    @BeforeEach
    public void start(){
        testAuto.getProperty(1).setPropertyValue("100");
    }

    @Test
    public void testHuurGV() {
        double expected = 250;
        double actual = testAuto.getTotaalPrijs(5, false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHuurWV() {
        double expected = 255;
        double actual = testAuto.getTotaalPrijs(5, true);
        Assertions.assertEquals(expected, actual);
    }
}
