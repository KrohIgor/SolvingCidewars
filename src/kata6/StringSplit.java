package kata6;

public class StringSplit {
    public static String[] solution(String s) {
        String[] stringSplit;
        if (s.length() == 0) {
            stringSplit = new String[0];
            return stringSplit;
        } else {
            if (s.length() % 2 == 0) {
                stringSplit = new String[s.length() / 2];
            } else {
                stringSplit = new String[s.length() / 2 + 1];
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (i % 2 == 1 || i == s.length() - 1) {
                stringSplit[i / 2] = str.toString();
                str = new StringBuilder();
            }
        }
        if (stringSplit[stringSplit.length - 1].length() == 1) {
            stringSplit[stringSplit.length - 1] += '_';
        }
        return stringSplit;
    }
}
