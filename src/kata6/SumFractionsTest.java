package kata6;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class SumFractionsTest {
    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test1() {
        System.out.println("Fixed Tests sumFracts");
        int[][] a = new int[][] { {1,2}, {2,9}, {3,18}, {4,24}, {6,48} };
        String r = "[85, 72]";
        testing(SumFractions.sumFracts(a), r);
        a = new int[][] { {1, 2}, {1, 3}, {1, 4} };
        r = "[13, 12]";
        testing(SumFractions.sumFracts(a), r);
        a = new int[][] { {1, 3}, {5, 3} };
        r = "2";
        testing(SumFractions.sumFracts(a), r);
        a = new int[][] {};
        r = null;
    }
}
