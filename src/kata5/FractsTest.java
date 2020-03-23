package kata5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractsTest {
    @Test
    public void test_fractions() throws Exception {
        long[][] lst;
        lst = new long[][]{{89, 131}, {15, 1340}, {57, 154}, {68, 348}, {1, 4}};
        assertEquals("(159784548,235188492)(2632707,235188492)(87050286,235188492)(45956372,235188492)(58797123,235188492)", Fracts.convertFrac(lst));
    }

    @Test
    public void test_fractions2() throws Exception {
        long[][] lst;
        lst = new long[][]{{89, 131}, {15, 1340}, {57, 154}, {68, 348}, {1, 4}};
        assertEquals("(159784548,235188492)(2632707,235188492)(87050286,235188492)(45956372,235188492)(58797123,235188492)", Fracts2.convertFrac(lst));
    }
}
