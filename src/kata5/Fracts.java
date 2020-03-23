package kata5;

import java.math.BigInteger;

public class Fracts {

    public static String convertFrac(long[][] lst) {
        StringBuilder sb = new StringBuilder();
        if (lst.length != 0) {
            for (long[] fraction : lst) {
                if (fraction[0] > 1) {
                    fractionReduction(fraction);
                }
            }
            leadToACommonDenominator(lst);
            for (long[] fraction : lst) {
                sb.append('(').append(fraction[0]).append(',').append(fraction[1]).append(')');
            }
        }
        return sb.toString();
    }

    private static void fractionReduction(long[] fraction) {
        for (int i = 2; i <= fraction[0]; i++) {
            if (BigInteger.valueOf(i).isProbablePrime((int) Math.log(i))) {
                while (fraction[0] % i == 0 && fraction[1] % i == 0) {
                    fraction[0] /= i;
                    fraction[1] /= i;
                }
            }
        }
    }

    private static void leadToACommonDenominator(long[][] lst) {
        long[] denominators = new long[lst.length];
        for (int i = 0; i < lst.length; i++) {
            denominators[i] = lst[i][1];
        }
        long commonDenominator = denominators[0];
        for (int i = 1; i < denominators.length; i++) {
            long productOfDenominators = commonDenominator * denominators[i];
            for (int j = 2; j <= denominators[i]; j++) {
                if (BigInteger.valueOf(j).isProbablePrime((int) Math.log(j))) {
                    while (commonDenominator % j == 0 && denominators[i] % j == 0) {
                        productOfDenominators /= j;
                        commonDenominator /= j;
                        denominators[i] /= j;
                    }
                }
            }
            commonDenominator = productOfDenominators;
        }
        for (long[] fraction : lst) {
            fraction[0] = fraction[0] * (commonDenominator / fraction[1]);
            fraction[1] = commonDenominator;
        }
    }
}
