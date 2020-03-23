package kata6;

public class TextingWithAnOld_SchoolMobilePhone {

    public static String sendMessage(String message) {
        StringBuilder resultString = new StringBuilder();
        boolean registerSwitched = false;
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isDigit(ch) || "*#".indexOf(ch) != -1) {
                repeatButtonCheck(resultString, ch);
                resultString.append(ch).append('-');
            } else if (Character.isAlphabetic(ch)) {
                registerSwitched = isRegisterSwitched(resultString, registerSwitched, ch);
                buttonSelection(resultString, ch);
            } else {
                inputPunctuationMark(resultString, ch);
            }
        }
        return resultString.toString();
    }

    public static boolean isRegisterSwitched(StringBuilder resultString, boolean registerSwitched, char ch) {
        if (!registerSwitched && Character.isUpperCase(ch)) {
            registerSwitched = true;
            resultString.append('#');
        }
        if (registerSwitched && Character.isLowerCase(ch)) {
            registerSwitched = false;
            resultString.append('#');
        }
        return registerSwitched;
    }

    private static void buttonSelection(StringBuilder resultString, char ch) {
        ch = Character.toLowerCase(ch);
        if ("abc".indexOf(ch) != -1) {
            addButton(resultString, ch, '2', "abc", "2");
        } else if ("def".indexOf(ch) != -1) {
            addButton(resultString, ch, '3', "def", "3");
        } else if ("ghi".indexOf(ch) != -1) {
            addButton(resultString, ch, '4', "ghi", "4");
        } else if ("jkl".indexOf(ch) != -1) {
            addButton(resultString, ch, '5', "jkl", "5");
        } else if ("mno".indexOf(ch) != -1) {
            addButton(resultString, ch, '6', "mno", "6");
        } else if ("pqrs".indexOf(ch) != -1) {
            addButton(resultString, ch, '7', "pqrs", "7");
        } else if ("tuv".indexOf(ch) != -1) {
            addButton(resultString, ch, '8', "tuv", "8");
        } else if ("wxyz".indexOf(ch) != -1) {
            addButton(resultString, ch, '9', "wxyz", "9");
        }
    }

    private static void addButton(StringBuilder resultString, char ch, char c, String charsOnButton, String button) {
        repeatButtonCheck(resultString, c);
        int quantity = charsOnButton.indexOf(ch);
        resultString.append(button.repeat(Math.max(0, quantity + 1)));
    }

    public static void inputPunctuationMark(StringBuilder resultString, char ch) {
        if (".,?!".indexOf(ch) != -1) {
            addButton(resultString, ch, '1', ".,?!", "1");
        } else if ("'-+=".indexOf(ch) != -1) {
            addButton(resultString, ch, '*', "'-+=", "*");
        } else if (' ' == ch) {
            addButton(resultString, ch, '0', " ", "0");
        }
    }

    public static void repeatButtonCheck(StringBuilder resultString, char button) {
        if (resultString.length() != 0 && button == resultString.charAt(resultString.length() - 1)) {
            resultString.append(' ');
        }
    }
}
