package Final_Project;
import java.util.ArrayList;
import java.util.Scanner;

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

        System.out.println("Please make sure you have the following ingredients:");
        System.out.println(ingredientsToString(newIngreList));
        System.out.println("Press Enter to proceed through the steps...");
        sc.nextLine();

        for (Step s : stepList) {
            s.executeStep();
        }
    }
}