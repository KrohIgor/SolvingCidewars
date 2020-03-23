package kata6;

public class BitCounting {
    public static int countBits(int n) {
        int counterUnit = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                counterUnit++;
            }
            n = n / 2;
        }
        return counterUnit;
    }
}
