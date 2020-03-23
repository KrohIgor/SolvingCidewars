package kata5;

import java.math.BigInteger;

public class SumFct {
    public static BigInteger perimeter(BigInteger n) {
        BigInteger lastNumber = BigInteger.valueOf(1);
        BigInteger thisNumber = BigInteger.valueOf(1);
        BigInteger sumNumberFbonachi = lastNumber.add(thisNumber);
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(n.add(BigInteger.valueOf(-1))) < 0; i = i.add(BigInteger.valueOf(1))) {
            BigInteger nextNumber = lastNumber.add(thisNumber);
            sumNumberFbonachi = sumNumberFbonachi.add(nextNumber);
            lastNumber = thisNumber;
            thisNumber = nextNumber;
        }
        return sumNumberFbonachi.multiply(BigInteger.valueOf(4));
    }
}
