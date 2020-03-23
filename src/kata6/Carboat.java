package kata6;

import java.util.ArrayList;

public class Carboat {
    public static String howmuch(int m, int n) {
        ArrayList<int[]> list = new ArrayList<>();
        int start;
        int end;
        if (m <= n) {
            start = m;
            end = n;
        } else {
            start = n;
            end = m;
        }
        for (int i = start; i <= end; i++) {
            if ((i - 2) % 7 == 0 && (i - 1) % 9 == 0) {
                int boatPrise = (i - 2) / 7;
                int carPrice = (i - 1) / 9;
                list.add(new int[]{i, boatPrise, carPrice});
            }
        }
        return createResultString(list);
    }

    private static String createResultString(ArrayList<int[]> list) {
        StringBuilder str = new StringBuilder("[");
        if (list.size() > 0) {
            for (int[] array : list) {
                str.append("[M: ").append(array[0]);
                str.append(" B: ").append(array[1]);
                str.append(" C: ").append(array[2]).append("]");
            }
        }
        str.append("]");
        return str.toString();
    }
}
