package kata6;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsonantValueTest {
    @Test
    public void basicTests() {
        assertEquals(26, ConsonantValue.solve("zodiac"));
        assertEquals(80, ConsonantValue.solve("chruschtschov"));
        assertEquals(38, ConsonantValue.solve("khrushchev"));
        assertEquals(57, ConsonantValue.solve("strength"));
        assertEquals(73, ConsonantValue.solve("catchphrase"));
        assertEquals(103, ConsonantValue.solve("twelfthstreet"));
        assertEquals(80, ConsonantValue.solve("mischtschenkoana"));
    }
}
