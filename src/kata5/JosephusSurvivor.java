package kata5;

import java.util.ArrayList;

public class JosephusSurvivor {
    public static int josephusSurvivor(final int n, final int k) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n ; i++) {
            list.add(i);
        }
        int index = -1;
        for (int i = 0; i < n - 1; i++) {
            if (index + k < list.size()){
                index +=k;
                list.remove(index--);
            } else {
                index -= list.size();
                i--;
            }
        }
        return list.get(0);
    }
}
