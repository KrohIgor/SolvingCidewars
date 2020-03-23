package kata5;

public class Greed {
    public static int greedy(int[] dice) {
        int score = findTriplet(dice);
        return scoreAfterTriplet(dice, score);
    }

    private static int scoreAfterTriplet(int[] dice, int score) {
        for (int number : dice) {
            if (number == 1) {
                score += 100;
            }
            if (number == 5) {
                score += 50;
            }
        }
        return score;
    }

    private static int findTriplet(int[] dice) {
        int score = 0;
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        for (int i = 0; i < dice.length; i++) {
            switch (dice[i]) {
                case 1:
                    counter1++;
                    if (counter1 == 3) {
                        score += 1000;
                        for (int j = i; j >= 0; j--) {
                            if (dice[j] == 1) {
                                dice[j] = 0;
                            }
                        }
                        counter1 = 0;
                    }
                    break;
                case 2:
                    counter2++;
                    if (counter2 == 3) {
                        score += 200;
                        counter2 = 0;
                    }
                    break;
                case 3:
                    counter3++;
                    if (counter3 == 3) {
                        score += 300;
                        counter3 = 0;
                    }
                    break;
                case 4:
                    counter4++;
                    if (counter4 == 3) {
                        score += 400;
                        counter4 = 0;
                    }
                    break;
                case 5:
                    counter5++;
                    if (counter5 == 3) {
                        score += 500;
                        for (int j = i; j >= 0; j--) {
                            if (dice[j] == 5) {
                                dice[j] = 0;
                            }
                        }
                        counter5 = 0;
                    }
                    break;
                case 6:
                    counter6++;
                    if (counter6 == 3) {
                        score += 600;
                        counter6 = 0;
                    }
            }
        }
        return score;
    }
}
