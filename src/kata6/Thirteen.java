package kata6;

public class Thirteen {
    public static long thirt(long n) {
        int[] divisions = new int[]{1, 10, 9, 12, 3, 4};
        int counterStationary = 0;
        while (counterStationary != 3) {
            long sum = 0;
            String stringNumber = String.valueOf(n);
            for (int i = stringNumber.length() - 1; i >= 0; i--) {
                int j = (stringNumber.length() - 1 - i) % 6;
                sum += Long.parseLong(stringNumber.charAt(i) + "") * divisions[j];
            }
            if (sum == n){
                counterStationary++;
            }
            n = sum;
        }
        return n;
    }
}
