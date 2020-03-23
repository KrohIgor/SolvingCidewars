package kata8;

public class FirstNonConsecutive {
    static Integer find(final int[] array) {
        int last = array[0];
        Integer number = null;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - last == 1){
                last = array[i];
            } else {
                number = array[i];
                break;
            }
        }
        return number;
    }
}
