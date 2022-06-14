package machines;

import com.logic.machines.Boormachine;
import com.logic.machines.Machine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBoormachine {

    @Test
    public void testHuurGV() {
        Machine testBoormachine = new Boormachine();
        double expected = 25;
        double actual = testBoormachine.getTotaalPrijs(5, false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHuurWV() {
        Machine testBoormachine = new Boormachine();
        double expected = 30;
        double actual = testBoormachine.getTotaalPrijs(5, true);
        Assertions.assertEquals(expected, actual);
    }
}
