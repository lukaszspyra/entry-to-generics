package spyra.lukasz.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RangeTest {

    private static final long LOWER_BOUND = 15L;
    private static final long UPPER_BOUND = 20L;

    @Test
    public void checkIfIsInARange(){

        Range range = new Range(LOWER_BOUND, UPPER_BOUND);

        Assertions.assertTrue(range.isInRange(10L));

    }


}
