package kata8;

public class Watermelon {
    public static void main(String[] args) {
        System.out.println(4 + " - " + divide(4));
        System.out.println(2 + " - " + divide(2));
        System.out.println(5 + " - " + divide(5));
        System.out.println(88 + " - " + divide(88));
        System.out.println(100 + " - " + divide(100));
        System.out.println(67 + " - " + divide(67));
        System.out.println(90 + " - " + divide(90));
        System.out.println(10 + " - " + divide(10));
        System.out.println(99 + " - " + divide(99));
        System.out.println(32 + " - " + divide(32));
    }
    public static boolean divide(int weight) {
        // your code here
        if(weight >= 2 && weight % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
}
