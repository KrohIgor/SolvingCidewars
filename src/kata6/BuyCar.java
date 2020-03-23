package kata6;

public class BuyCar {
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int[] result = new int[2];
        int counterMonth = 1;
        if (startPriceOld >= startPriceNew) {
            result[1] = startPriceOld - startPriceNew;
            return result;
        }
        double difference = startPriceOld - startPriceNew;
        double available;
        do {
            if (counterMonth % 2 == 0) {
                percentLossByMonth += 0.5;
            }
            difference = difference * (100 - percentLossByMonth) / 100;
            available = difference + savingperMonth * counterMonth;
            counterMonth++;
        }
        while (available < 0);
        result[0] = counterMonth - 1;
        result[1] = (int) Math.round(available);
        return result;
    }
}
