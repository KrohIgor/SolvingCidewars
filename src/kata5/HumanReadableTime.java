package kata5;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        String hours = "00";
        String minutes = "00";
        String secondsString;
        if (seconds >= 3600){
            int h= seconds / 3600;
            if (h < 10){
                hours = "0" + h;
            } else {
                hours = String.valueOf(h);
            }
            seconds %= 3600;
        }
        if (seconds >= 60){
            int m = seconds / 60;
            if (m < 10){
                minutes = "0" + m;
            } else {
                minutes = String.valueOf(seconds / 60);
            }
            seconds %= 60;
        }
        if (seconds < 10){
            secondsString = "0" + seconds;
        } else {
            secondsString = String.valueOf(seconds);
        }
        return hours + ":" + minutes + ":" + secondsString;
    }
}
