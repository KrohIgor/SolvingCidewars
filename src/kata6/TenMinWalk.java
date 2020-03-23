package kata6;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        boolean walkOut = false;
        if (walk.length == 10){
            int counterNAndS = 0;
            int counterWAndE = 0;
            for (char c : walk) {
                switch (c) {
                    case 'n':
                        counterNAndS++;
                        break;
                    case 's':
                        counterNAndS--;
                        break;
                    case 'w':
                        counterWAndE++;
                        break;
                    case 'e':
                        counterWAndE--;
                        break;
                }
            }
            if (counterNAndS == 0 && counterWAndE == 0) {
                walkOut = true;
            }
        }
        return walkOut;
    }
}
