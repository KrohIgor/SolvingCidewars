package kata7;

import java.util.Arrays;

public class AlternateCapitalization {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(capitalize("abcde")));
    }

    public static String[] capitalize(String s){
        // Gorillaz - Do Ya Thing (2010)
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (i % 2 == 0){
                second.append(s.charAt(i));
                first.append((s.charAt(i) + "").toUpperCase());
            } else {
                first.append(s.charAt(i));
                second.append(s.charAt(i) + "".toUpperCase());
            }
        }
        return new String[]{first.toString(), second.toString()};
    }
}
