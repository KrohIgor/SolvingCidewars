package kata6;

public class Decode {
    public static String decode(String r) {
        StringBuilder stringBuilderNumber = new StringBuilder();
        StringBuilder stringBuilderChars = new StringBuilder();
        definitionOfConstantAndString(r, stringBuilderNumber, stringBuilderChars);
        int concatenate = Integer.parseInt(stringBuilderNumber.toString());
        if (decodingCheck(concatenate)) {
            return "Impossible to decode";
        }
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder decodeString = new StringBuilder();
        for (int i = 0; i < stringBuilderChars.length(); i++) {
            int numChar = alphabet.indexOf(stringBuilderChars.charAt(i));
            for (int j = 0; j < alphabet.length(); j++) {
                int multiplication = j * concatenate;
                if (multiplication % 26 == numChar) {
                    decodeString.append(alphabet.charAt(j));
                    break;
                }
            }
        }
        return decodeString.toString();
    }

    public static void definitionOfConstantAndString(String r, StringBuilder stringBuilderNumber, StringBuilder stringBuilderChars) {
        for (int i = 0; i < r.length(); i++) {
            if ("1234567890".indexOf(r.charAt(i)) >= 0) {
                stringBuilderNumber.append(r.charAt(i));
            } else {
                stringBuilderChars.append(r.charAt(i));
            }
        }
    }

    public static boolean decodingCheck(int concatenate){
        int counterCoincidence = 0;
        for (int i = 0; i < 26; i++) {
            if ((i * concatenate) % 26 == 0) {
                counterCoincidence++;
            }
        }
        return counterCoincidence > 1;
    }
}
