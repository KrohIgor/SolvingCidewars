package kata6;

import java.util.ArrayList;

public class FindOdd {
    public static int findIt(int[] a) {
        int odd = a[0];
        ArrayList<Integer> list = new ArrayList<>();
        int counter;
        boolean numberChecked;
        for (int i = 0; i < a.length; i++) {
            numberChecked = false;
            counter = 1;
            for (int j : list) {
                if (a[i] == j){
                    numberChecked = true;
                    break;
                }
            }
            if (!numberChecked) {
                int temp = a[i];
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] == temp){
                        counter++;
                    }
                }
                if (counter % 2 == 1){
                    odd = temp;
                    break;
                }
                list.add(temp);
            }

        }
        return odd;
    }
}
