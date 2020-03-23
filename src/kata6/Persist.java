package kata6;

public class Persist {
    public static int persistence(long n) {
        String numberString = n + "";
        int counter = 0;
        while (numberString.length() > 1) {
            long number = 1;
            for (int i = 0; i < numberString.length(); i++) {
                number *= Long.parseLong(numberString.charAt(i) + "");
            }
            numberString = number + "";
            counter++;
        }
        return counter;
    }
}
