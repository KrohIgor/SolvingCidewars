package kata6;

public class DuplicateEncoder {

    static String encode(String word) {
        StringBuilder string = new StringBuilder(word.toLowerCase());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = string.charAt(i);
            StringBuilder temp = new StringBuilder(string);
            temp.deleteCharAt(i);
            if (temp.toString().indexOf(ch) == -1) {
                result.append('(');
            } else {
                result.append(')');
            }
        }
        return result.toString();
    }
}
