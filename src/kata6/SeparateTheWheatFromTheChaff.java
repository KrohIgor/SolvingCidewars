package kata6;

public class SeparateTheWheatFromTheChaff {
    public static long[] wheatFromChaff(long[] values) {
        long[] result = new long[values.length];
        int indexNegative = 0;
        int indexPositive = values.length - 1;
        long temp;
        boolean lastNumber = false;
        while (indexNegative <= indexPositive) {
            if (indexPositive == indexNegative) {
                lastNumber = true;
            }
            if (values[indexNegative] < 0) {
                result[indexNegative] = values[indexNegative];
                indexNegative++;
                if (lastNumber) {
                    break;
                }
                continue;
            } else {
                temp = values[indexNegative];
            }
            if (values[indexPositive] > 0) {
                result[indexPositive] = values[indexPositive];
                indexPositive--;
                if (lastNumber) {
                    break;
                }
            } else {
                result[indexPositive] = temp;
                result[indexNegative] = values[indexPositive];
                indexNegative++;
                indexPositive--;
            }
        }
        return result;
    }
}
