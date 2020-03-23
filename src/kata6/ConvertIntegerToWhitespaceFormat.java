package kata6;

public class ConvertIntegerToWhitespaceFormat {
    public static void main(String[] args) {
        System.out.println(whitespaceNumber(2));
    }
    public static String whitespaceNumber(final int n) {
        String numberBinary;
        StringBuilder result = new StringBuilder();
        if (n > 0){
            result.append(' ');
            numberBinary = Integer.toBinaryString(n);
        } else if (n < 0){
            result.append('\t');
            numberBinary = Integer.toBinaryString(-n);
        } else {
            return " \n";
        }
        for (int i = 0; i < numberBinary.length(); i++) {
            if (numberBinary.charAt(i) == '0'){
                result.append(' ');
            } else {
                result.append('\t');
            }
        }
        result.append('\n');
        return result.toString();
    }
}
