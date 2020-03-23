package kata6;

public class Order {
    public static String order(String words) {
        if (words.length() == 0) {
            return "";
        }
        String[] array = words.split(" ");
        String[] resultArray = new String[array.length];
        for (String string : array) {
            for (int j = 0; j < string.length(); j++) {
                if ("123456789".indexOf(string.charAt(j)) > -1) {
                    resultArray[Integer.parseInt(string.charAt(j) + "") - 1] = string;
                }
            }
        }
        return String.join(" ", resultArray);
    }
}
