package Final_Project;
import java.util.Scanner;

public class TimerStep extends Step {
    private String timerText;
    private int seconds;

    public TimerStep(String text, int sec) {
        timerText = text;
        seconds = sec;
    }

    public String getText() {
        return timerText;
    }

    public int getSec() {
        return seconds;
    }

    public void executeStep() {
        Scanner s = new Scanner(System.in);
        
        for (int sec = seconds; sec >= 0; sec--) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                    + timerText + ": " + formatTime(sec));
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
        }

        int buffer = 0;
        try {buffer = System.in.available();} catch (Exception e) {}
        for(int i = 0; i < buffer; i++)
            try {System.in.read();} catch (Exception e) {}

        System.out.print("Press Enter to proceed to next step...");
        s.nextLine();
    }

    private String formatTime(int sec) {
        int hours = 0;
        int minutes = 0;
        minutes = sec / 60;
        sec %= 60;
        hours = minutes / 60;
        minutes %= 60;
        String strHours = (hours > 0) ? hours + ":" : "";
        String strMinutes = (minutes > 9) ? String.valueOf(minutes) : "0" + minutes;
        String strSeconds = (sec > 9) ? String.valueOf(sec) : "0" + sec; 

        return strHours + strMinutes + ":" + strSeconds;
    }

    public String toString() {
        return ((timerText.length() <= 20) ? timerText : timerText.substring(0, 20)) + "...\t\t" + formatTime(seconds);
    }
}
