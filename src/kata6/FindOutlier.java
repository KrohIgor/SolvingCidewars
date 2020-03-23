package kata6;

public class FindOutlier {
    static int find(int[] integers) {
        int counterEvenNumbers = 0;
        int counterOddNumbers = 0;
        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0) {
                counterEvenNumbers++;
            } else {
                counterOddNumbers++;
            }
        }
        boolean arrayEvenNumbers = counterEvenNumbers > counterOddNumbers;
        for (int integer : integers) {
            if (arrayEvenNumbers) {
                if (integer % 2 != 0) {
                    return integer;
                }
            } else {
                if (integer % 2 == 0) {
                    return integer;
                }
            }
        }
        return 0;
    }
}
