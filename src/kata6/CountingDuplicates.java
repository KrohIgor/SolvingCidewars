package kata6;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        StringBuilder sb = new StringBuilder();
        String lowerCaseText = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char c = lowerCaseText.charAt(i);
            for (int j = 0; j < text.length(); j++) {
                if (j!=i && lowerCaseText.charAt(j) == c && (sb.toString().indexOf(lowerCaseText.charAt(j))) < 0){
                    sb.append(lowerCaseText.charAt(j));
                }
            }
        }
        return sb.length();
    }
}
