package kata5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Tour {

    public static int tour(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
        ArrayList<String[]> list = new ArrayList<>();
        int countNotKnowCity = 0;
        for (int i = 0; i < arrFriends.length; i++) {
            String str = arrFriends[i];
            boolean knowCity = false;
            for (String[] ftwn : ftwns) {
                if (str.equals(ftwn[0])) {
                    knowCity = true;
                    break;
                }
            }
            if (!knowCity) {
                String[] strings = new String[]{arrFriends[i], "" + ftwns[0][1].charAt(0) + arrFriends[i].charAt(1)};
                list.add(strings);
                h.put(list.get(i)[1], h.get(list.get(i - 1)[1]));
                countNotKnowCity++;
            } else {
                list.add(ftwns[i - countNotKnowCity]);
            }
        }
        double tour = h.get(list.get(0)[1]);
        for (int i = 1; i < list.size() - 1; i++) {
            String key = list.get(i)[1];
            String keyLast = list.get(i - 1)[1];
            double hypotenuse = h.get(key);
            double cathet = h.get(keyLast);
            tour += Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(cathet, 2));
        }
        tour += h.get(list.get(list.size() - 1)[1]);
        return (int) tour;
    }
}
