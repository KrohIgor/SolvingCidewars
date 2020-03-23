package kata6;

import java.util.ArrayList;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        ArrayList<Integer> list = new ArrayList<>();
        int counter;
        for (int element : elements) {
            counter = 0;
            for (int number : list) {
                if (element == number){
                    counter++;
                }
            }
            if (counter < maxOccurrences){
                list.add(element);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        String s = "";
        int a = s.indexOf('a');
        return result;
    }
}
