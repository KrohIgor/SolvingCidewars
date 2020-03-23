package kata6;

public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        if (h > 0 && bounce > 0 && bounce < 1 && window < h) {
            return (int) (Math.log(window / h) / Math.log(bounce)) * 2 + 1;
        } else {
            return -1;
        }
    }
}
