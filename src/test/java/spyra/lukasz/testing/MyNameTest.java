package spyra.lukasz.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MyNameTest {

    private static final String MYNAME = "Mrozowska";
    private static final String MOTHERS_NAME = "Mrozowska";
    private static final String FATHERS_NAME = "Mrozowski";


    @Test
    public void checkMyNameIsEqualToMothersName(){

        assertEquals(MOTHERS_NAME, MYNAME);
        assertNotEquals(MOTHERS_NAME, MYNAME);
    }
}
