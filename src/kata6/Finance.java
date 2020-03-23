package kata6;

import java.math.BigInteger;

public class Finance {
    public static BigInteger finance(int n) {
        BigInteger result = factorial(n);
        BigInteger week = result;
        for (int i = 1; i <= n; i++) {
            week = week.add(BigInteger.valueOf(n + 1 - i - (i - 1) * 2));
            result = result.add(week);
        }
        return result;
    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 1; i <= n ; i++) {
            result = result.add(BigInteger.valueOf(i));
        }
        return result;
    }
}
