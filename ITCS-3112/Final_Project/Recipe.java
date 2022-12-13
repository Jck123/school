package Final_Project;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Recipe {
    private int servings;
    private String recipeName;
    private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
    private ArrayList<Step> stepList = new ArrayList<Step>();

    public Recipe() {
        servings = 1;
        recipeName = "";
    }

    public Recipe(String name, int serves) {
        recipeName = name;
        servings = serves;
    }

    public void addStep(Step newStep) {
        stepList.add(newStep);
    }

    public void addStep(Step[] newSteps) {
        for(Step s : newSteps)
            stepList.add(s);
    }

    public void removeStep(int stepIndex) {
        stepList.remove(stepIndex);
    }

    public void addIngredient(Ingredient input) {
        ingredientList.add(input);
    }

    public void addIngredient(Ingredient[] inputs) {
        for(Ingredient i : inputs)
            ingredientList.add(i);
    }

    public void removeIngredient(int ingrIndex) {
        ingredientList.remove(ingrIndex);
    }

    public String getName() {
        return recipeName;
    }

    public void setName(String name) {
        recipeName = name;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int newServings) {
        servings = newServings;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredientList;
    }

    public ArrayList<Step> getSteps() {
        return stepList;
    }

    public static String ingredientsToString(ArrayList<Ingredient> ingredients) {
        String output = "";

        for (Ingredient i : ingredients) {
            output += i.toString() + "\n";
        }

        return output;
    }

    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please make sure you have the following ingredients:");
        System.out.println(ingredientsToString(ingredientList));
        System.out.println("Press Enter to proceed through the steps...");
        sc.nextLine();

        for (Step s : stepList) {
            s.executeStep();
        }
    }

    public void execute(int newServings) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Ingredient> newIngreList = new ArrayList<Ingredient>();
        for (Ingredient i : ingredientList) {
            newIngreList.add(i.convertAmount(servings, newServings));
        }

        System.out.println("\n\n\n\n\n\n\n\nPlease make sure you have the following ingredients:\n");
        System.out.println(ingredientsToString(newIngreList));
        System.out.println("Press Enter to proceed through the steps...");
        sc.nextLine();

        for (Step s : stepList) {
            s.executeStep();
        }
    }

    public boolean exportRecipe() {
        File output = new File(recipeName + ".txt");
        if (output.exists())
            output.delete();

        try {
            output.createNewFile();

            FileWriter txtOutput = new FileWriter(output);

            txtOutput.write(recipeName + "\n" + servings + "\n\n");
            
            for(Ingredient ing : ingredientList) {
                txtOutput.write(ing.getName() + "\n" + ing.amountToString() + "\n");
            }
            txtOutput.write("\n");

            for(Step s : stepList) {
                txtOutput.write(s.getText() + "\n" + ((s.getClass().getSimpleName().compareTo("TimerStep") == 0) ? ((TimerStep)s).getSec() : "N/a") + "\n");
            }

            txtOutput.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean importRecipe(File file) {
        try {
            Scanner input = new Scanner(file);

            this.recipeName = input.nextLine();
            this.servings = Integer.parseInt(input.nextLine());

            input.nextLine();

            while(true) {
                String ingName = input.nextLine();
                if (ingName.isBlank())
                    break;

                String ingAmount = input.nextLine();
                
                ingredientList.add(new Ingredient(ingName, ingAmount));
            }

            while(input.hasNextLine()) {
                String stepText = input.nextLine();

                String stepTime = input.nextLine();

                Step importStep;
                if (stepTime.compareTo("N/a") == 0)
                    importStep = new TextStep(stepText);
                else
                    importStep = new TimerStep(stepText, Integer.parseInt(stepTime));

                stepList.add(importStep);
            }

            input.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}