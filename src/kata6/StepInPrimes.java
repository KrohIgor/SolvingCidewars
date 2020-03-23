package kata6;

import java.math.BigInteger;

public class StepInPrimes {

    public static long[] step(int g, long m, long n) {
        if (n - m < g) {
            return null;
        }
        for (long i = m; i <= n - g; i++) {
            if (BigInteger.valueOf(i).isProbablePrime((int) Math.log(i)) &&
                    BigInteger.valueOf(i + g).isProbablePrime((int) Math.log(i + g))) {
                return new long[]{i, i + g};
            }
        }
        return null;
    }
}
