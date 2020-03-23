package kata5;

import java.util.ArrayList;
import java.util.Arrays;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        for (int i = 0; i < list.size() - 1; i++) {
            String string = list.get(i);
            String stringNext = list.get(i + 1);
            string = string.toUpperCase();
            stringNext = stringNext.toUpperCase();
            if (string.equals(Directions.NORTH.toString()) && stringNext.equals(Directions.SOUTH.toString())) {
                list.remove(i);
                list.remove(i);
                i = -1;
            } else if (string.equals(Directions.SOUTH.toString()) && stringNext.equals(Directions.NORTH.toString())) {
                list.remove(i);
                list.remove(i);
                i = -1;
            } else if (string.equals(Directions.EAST.toString()) && stringNext.equals(Directions.WEST.toString())) {
                list.remove(i);
                list.remove(i);
                i = -1;
            } else if (string.equals(Directions.WEST.toString()) && stringNext.equals(Directions.EAST.toString())) {
                list.remove(i);
                list.remove(i);
                i = -1;
            }
        }
        String[] array = new String[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    enum Directions {
        NORTH, SOUTH, EAST, WEST
    }
}
