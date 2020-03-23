package kata5;

import java.math.BigInteger;

public class Fracts2 {

    public static String convertFrac(long[][] lst) {
        if (lst.length == 0 ){
            return "";
        }
        long maxDenominator = lst[0][1];
        for (long[] fraction : lst) {
            if (fraction[1] > maxDenominator) {
                maxDenominator = fraction[1];
            }
        }
        boolean commonDenominatorOneOfTheListDenominators = true;
        for (long[] fraction : lst) {
            if (maxDenominator % fraction[1] != 0) {
                commonDenominatorOneOfTheListDenominators = false;
                break;
            }
        }
        long commonDenominator = 1;
        if (commonDenominatorOneOfTheListDenominators) {
            for (long[] fraction : lst) {
                fraction[0] = fraction[0] * (maxDenominator / fraction[1]);
                fraction[1] = maxDenominator;
            }
        } else {
            for (long[] fraction : lst) {
                commonDenominator *= fraction[1];
            }
            long minNumerator = commonDenominator;
            for (long[] fraction : lst) {
                fraction[0] = fraction[0] * (commonDenominator / fraction[1]);
                fraction[1] = commonDenominator;
                if (fraction[0] < minNumerator) {
                    minNumerator = fraction[0];
                }
            }
            for (long i = minNumerator; i > 1; i--) {
                boolean reductionIsPossible = true;
                for (long[] fraction : lst) {
                    if (fraction[0] % i != 0 || fraction[1] % i != 0) {
                        reductionIsPossible = false;
                        break;
                    }
                }
                if (reductionIsPossible) {
                    for (long[] fraction : lst) {
                        fraction[0] /= i;
                        fraction[1] /= i;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (long[] fraction : lst) {
            sb.append('(').append(fraction[0]).append(',').append(fraction[1]).append(')');
        }
        return sb.toString();
    }
}
