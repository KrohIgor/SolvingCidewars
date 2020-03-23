package kata6;

import java.math.BigInteger;

public class BackWardsPrime {
    public static String backwardsPrime(long start, long end) {
        StringBuilder result = new StringBuilder();
        boolean wasAdd = false;
        for (long i = start; i <= end; i++) {
            BigInteger number = new BigInteger(String.valueOf(i));
            if (number.isProbablePrime((int) i)){
                StringBuilder reversNumber = new StringBuilder(String.valueOf(i)).reverse();
                if (new BigInteger(reversNumber.toString()).isProbablePrime((int)i)
                        && !String.valueOf(number).equals(reversNumber.toString())){
                    result.append(i).append(' ');
                    wasAdd = true;
                }
            }
        }
        if (wasAdd) {
            result.deleteCharAt(result.length()-1);
        }
        return result.toString();
    }
}
