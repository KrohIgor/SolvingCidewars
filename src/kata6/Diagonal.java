package kata6;

import java.math.BigInteger;

public class Diagonal {
    public static BigInteger diagonal(int n, int p) {
        BigInteger[][] triangle = createTriangle(n, p);
        BigInteger result = BigInteger.valueOf(0);
        for (BigInteger[] bigIntegers : triangle) {
            result = result.add(bigIntegers[p]);
        }
        return result;
    }

    private static BigInteger[][] createTriangle(int n, int p) {
        BigInteger[][] triangle = new BigInteger[n + 1 - p][];
        int column = n + 1;
        for (int i = 0; i < n + 1 - p; i++) {
            triangle[i] = new BigInteger[p + 1];
            for (int j = 0; j < p + 1; j++) {
                if (column > p) {
                    if (i == 0 || j == 0) {
                        triangle[i][j] = BigInteger.valueOf(1);
                    } else {
                        triangle[i][j] = triangle[i][j - 1].add(triangle[i - 1][j]);
                    }
                } else {
                    break;
                }
            }
            column--;
        }
        return triangle;
    }
}
