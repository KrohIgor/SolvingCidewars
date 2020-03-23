package kata6;

import java.util.Arrays;

public class SumFractions {
    public static String sumFracts(int[][] l) {
        if (l.length == 0){
            return null;
        }
        int commonDenominator = calculateTheCommonDenominator(l);
        int numerator = calculateTheNumerator(commonDenominator, l);
        int[] result = reduceTheFraction(numerator, commonDenominator);
        if (result[1] == 1){
            return String.valueOf(result[0]);
        } else {
            return Arrays.toString(result);
        }
    }

    private static int[] reduceTheFraction(int numerator, int commonDenominator) {
        for (int i = 9; i > 1; i--) {
            while (numerator % i == 0 && commonDenominator % i == 0){
                numerator /= i;
                commonDenominator /= i;
            }
            if (numerator < 2 || commonDenominator < 2) {
                break;
            }
        }
        return new int[]{numerator, commonDenominator};
    }

    private static int calculateTheNumerator(int commonDenominator, int[][] l) {
        int sumNumerators = 0;
        for (int[] fraction : l) {
            sumNumerators += fraction[0] * (commonDenominator / fraction[1]);
        }
        return sumNumerators;
    }

    private static int calculateTheCommonDenominator(int[][] l) {
        int composition = 1;
        for (int[] fraction : l) {
            composition *= fraction[1];
        }
        return composition;
    }
}
