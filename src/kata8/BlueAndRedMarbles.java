package kata8;

public class BlueAndRedMarbles {
    public static void main(String[] args) {
        System.out.println(guessBlue(5,5,2,3));
    }
    public static double guessBlue(int blueStart, int redStart, int bluePulled, int redPulled) {
        return (double) (blueStart - bluePulled) / (blueStart + redStart - bluePulled - redPulled);
        // Place your code here
    }
}
