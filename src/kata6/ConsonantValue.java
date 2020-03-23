package kata6;

public class ConsonantValue {
    public static int solve(final String s) {
        int sum = 0;
        int highest = 0;
        boolean vowel = false;
        for (int i = 0; i < s.length(); i++) {
            if ("aeiou".indexOf(s.charAt(i)) >= 0){
                vowel = true;
            }
            if (!vowel){
                sum += s.charAt(i) - 96;
            }
            if (vowel || i == s.length() - 1){
                if (highest < sum){
                    highest = sum;
                }
                sum = 0;
                vowel = false;
            }
        }
        return highest;
    }
}
