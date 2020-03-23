package kata6;

import static org.junit.Assert.*;
import org.junit.Test;


public class CarboatTest {

    @Test
    public void BasicTests() {
        assertEquals("[[M: 37 B: 5 C: 4][M: 100 B: 14 C: 11]]",
                Carboat.howmuch(9990, 9991));
        assertEquals("[]",
                Carboat.howmuch(2950, 2950));
    }

}

