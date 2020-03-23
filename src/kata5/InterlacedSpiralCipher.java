package kata5;

public class InterlacedSpiralCipher {
    public static String encode(String s) {
        int lengthArray = (int) Math.ceil(Math.sqrt(s.length()));
        char[][] chars = new char[lengthArray][lengthArray];
        fillTheArrayWithCharactersFromTheString(chars, s);
        StringBuilder result = new StringBuilder();
        for (char[] aChar : chars) {
            for (int j = 0; j < chars[0].length; j++) {
                result.append(aChar[j]);
            }
        }
        return result.toString();
    }

    private static void fillTheArrayWithCharactersFromTheString(char[][] chars, String s) {
        int numberOfChars = chars.length;
        int counterSquares = 0;
        int counterChars = 0;
        int counterCharsInSquares = (numberOfChars - 1) * 4;
        int step = counterCharsInSquares;
        for (int i = 0; i < chars.length * chars.length; i++) {
            if (i == counterCharsInSquares) {
                counterSquares++;
                counterChars = 0;
                step -= 8;
                counterCharsInSquares += step;
            }
            if (i % 4 == 0) {
                if (i < s.length()) {
                    chars[counterSquares][counterChars / 4 + counterSquares] = s.charAt(i);
                } else {
                    chars[counterSquares][counterChars / 4 + counterSquares] = ' ';
                }
            } else if (i % 4 == 1) {
                if (i < s.length()) {
                    chars[counterChars / 4 + counterSquares][numberOfChars - 1 - counterSquares] = s.charAt(i);
                } else {
                    chars[counterChars / 4 + counterSquares][numberOfChars - 1 - counterSquares] = ' ';
                }
            } else if (i % 4 == 2) {
                if (i < s.length()) {
                    chars[numberOfChars - 1 - counterSquares][numberOfChars - 1 - counterChars / 4 - counterSquares] = s.charAt(i);
                } else {
                    chars[numberOfChars - 1 - counterSquares][numberOfChars - 1 - counterChars / 4 - counterSquares] = ' ';
                }
            } else {
                if (i < s.length()) {
                    chars[numberOfChars - 1 - counterChars / 4 - counterSquares][counterSquares] = s.charAt(i);
                } else {
                    chars[numberOfChars - 1 - counterChars / 4 - counterSquares][counterSquares] = ' ';
                }
            }
            counterChars++;
        }
    }

    public static String decode(String s) {
        int lengthArray = (int) Math.ceil(Math.sqrt(s.length()));
        char[][] chars = new char[lengthArray][lengthArray];
        initializingArray(s, lengthArray, chars);
        return decodeOfArray(chars).strip();
    }

    private static String decodeOfArray(char[][] chars) {
        int numberOfChars = chars.length;
        int counterSquares = 0;
        int counterChars = 0;
        int counterCharsInSquares = (numberOfChars - 1) * 4;
        int step = counterCharsInSquares;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length * chars.length; i++) {
            if (i == counterCharsInSquares) {
                counterSquares++;
                counterChars = 0;
                step -= 8;
                counterCharsInSquares += step;
            }
            if (i % 4 == 0) {
                result.append(chars[counterSquares][counterChars / 4 + counterSquares]);
            } else if (i % 4 == 1) {
                result.append(chars[counterChars / 4 + counterSquares][numberOfChars - 1 - counterSquares]);
            } else if (i % 4 == 2) {
                result.append(chars[numberOfChars - 1 - counterSquares][numberOfChars - 1 - counterChars / 4 - counterSquares]);
            } else {
                result.append(chars[numberOfChars - 1 - counterChars / 4 - counterSquares][counterSquares]);
            }
            counterChars++;
        }
        return result.toString();
    }

    public static void initializingArray(String s, int lengthArray, char[][] chars) {
        int counterLine = 0;
        int counterColumn = 0;
        for (int i = 0; i < s.length(); i++) {
            chars[counterLine][counterColumn] = s.charAt(i);
            counterColumn++;
            if (counterColumn == lengthArray) {
                counterColumn = 0;
                counterLine++;
            }
        }
    }
}
