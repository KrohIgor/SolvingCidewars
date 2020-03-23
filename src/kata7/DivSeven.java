package kata7;

public class DivSeven {
    public static long[] seven(long m) {
        // your code
        int counterStep = 0;
        while (m > 99){
            m = m / 10 - m % 10 * 2;
            counterStep++;
        }
        return new long[]{m, counterStep};
    }
}
