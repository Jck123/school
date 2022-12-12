package Final_Project;

import java.util.Scanner;

public class TextStep extends Step {
    private String text;

    public TextStep(String input) {
        text = input;
    }

    public void executeStep() {
        Scanner s = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                            + text);
        System.out.println("\nPress Enter to proceed to the next step...");
        s.nextLine();
    }

}
