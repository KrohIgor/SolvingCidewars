package kata5;

import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {

    public static List<long[]> removNb(long n) {
        List<long[]> list = new ArrayList<>();
        long sum = sum(n);
        findNumbersAndAddInList(n, list, sum);
        sortList(list);
        return list;
    }

    public static void findNumbersAndAddInList(long n, List<long[]> list, long sum) {
        long firstNumber = sum / n;
        while (firstNumber < n) {
            long sumNumbers = firstNumber + n;
            firstNumber = sum / n;
            n = (sum - sumNumbers) / firstNumber;
            if ((sum - firstNumber - n) == firstNumber * n) {
                list.add(new long[]{firstNumber, n});
                list.add(new long[]{n, firstNumber});
            }
        }
    }

    public static void sortList(List<long[]> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i)[0] > list.get(i+1)[0]){
                list.add(i,list.get(i+1));
                list.remove(i+2);
            }
        }
    }

    private static long sum(long n) {
        long sum = 0;
        for (long i = n; i >= 1; i--) {
            sum += i;
        }
        return sum;
    }
}
