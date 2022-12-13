package Final_Project;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Main { 
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        ArrayList<Recipe> cookbook = new ArrayList<Recipe>();
        boolean programLoop = true;

        Ingredient ing1 = new Ingredient("Pre-scrambled eggs", "2C");
        Ingredient ing2 = new Ingredient("Butter", "2T");
        Ingredient ing3 = new Ingredient("Salt", "0.25t");
        Ingredient ing4 = new Ingredient("Pepper", "0.25t");

        Step step1 = new TextStep("Put butter into pan");
        Step step2 = new TimerStep("Let it melt", 30);
        Step step3 = new TextStep("Pour pre-scrambled eggs into pan, pour in salt and pepper afterwards");
        Step step4 = new TimerStep("Let them cook", 120);
        Step step5 = new TextStep("Serve and enjoy!");

        Recipe r1 = new Recipe("Scrambled eggs", 1);

        r1.addIngredient(new Ingredient[] {ing1, ing2, ing3, ing4});
        r1.addStep(new Step[] {step1, step2, step3, step4, step5});

        cookbook.add(r1);

        System.out.println("Welcome to the Cookbook Program!");
        
        while(programLoop) {

            int selection;
            while(true) {
                System.out.print( "What would you like to do?\n" +
                                    "[1] Write a recipe\n" +
                                    "[2] Execute a recipe\n" +
                                    "[3] Import a recipe\n" +
                                    "[4] Export a recipe\n" +
                                    "[5] Exit program\n\n" +
                                    "Please select a number from above: ");
                
                
                
                try {
                    selection = input.nextInt();
                    if (selection > 0 && selection < 6) {
                        break;
                    }
                    else
                        System.out.println("Invalid response! Please try again");
                }
                catch (Exception e) {
                    input.nextLine();
                    System.out.println("Invalid input! Please try again\n");
                }
            }
            input.nextLine();
            System.out.println("\n");
            
            switch(selection) {
                case 1:
                    System.out.print("Please provide a name for the recipe: ");
                    String rName = input.nextLine();
                    int rServings;
                    while(true) {
                        System.out.print("Please provide how many this serves: ");
                        try {
                            rServings = input.nextInt();
                            break;
                        } catch (Exception e) {
                            input.nextLine();
                            System.out.println("Invalid input! Please Try again\n");
                        }
                    }
                    Recipe newRecipe = new Recipe(rName, rServings);
                    boolean recipeLoop = true;
                    while(recipeLoop) {
                        System.out.println("Welcome to the Recipe Creator!");
                        System.out.println( "What would you like to do?\n" +
                                            "[1] Add new ingredient\n" +
                                            "[2] Remove ingredient from list\n" +
                                            "[3] Add new timer step\n" +
                                            "[4] Add new text step\n" +
                                            "[5] Remove step\n\n" +
                                            "[6] Save recipe and close\n" +
                                            "[7] Close recipe without saving\n");
                        
                        int optionSelection;
                        while(true) {
                            try {
                                optionSelection = input.nextInt();
                                                
                                if (optionSelection > 0 && optionSelection < 8)
                                    break;
                                else
                                    System.out.println("Invalid number! Please try again\n");
                            } catch (Exception e) {
                                input.nextLine();
                                System.out.println("Invalid input! Please try again\n");
                            }
                        }
                        input.nextLine();
                        switch (optionSelection) {
                            case 1:
                                Ingredient newIng;
                                System.out.print("Input name of ingredient: ");
                                String ingName = input.nextLine();
                                while(true) {
                                    System.out.print("Input how much of this ingredient will be used\n(Example of input: 1.33G2.25C3T1.50t equals\n1 1/3 gal 2 1/4 cups 3 tbsp 1 1/2 tsp): ");
                                    try {
                                        String ingAmount = input.nextLine();
                                        newIng = new Ingredient(ingName, ingAmount);
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input! Please try again\n");
                                    }
                                }
                                newRecipe.addIngredient(newIng);
                                break;
                            case 2:
                                ArrayList<Ingredient> tempIng = newRecipe.getIngredients();
                                if (tempIng.isEmpty()) {
                                    System.out.println("No ingredients to delete!\n");
                                    break;
                                }
                                System.out.println();
                                for (int i = 0; i < tempIng.size(); i++)
                                    System.out.println("[" + (i + 1) + "] " + tempIng.get(i).toString());
                                int ingSelect;
                                while(true) {
                                    System.out.print("\nPlease select an ingredient above to remove(0 to cancel): ");    
                                    try {
                                        ingSelect = input.nextInt();
                                        if (ingSelect >= 0 && ingSelect <= tempIng.size())
                                            break;
                                        else
                                            System.out.println("Invalid input! Please try again\n");
                                    } catch (Exception e) {
                                        System.out.println("Invalid input! Please try again\n");
                                    }
                                }
                                input.nextLine();

                                if (ingSelect != 0)
                                    newRecipe.removeIngredient(ingSelect - 1);
                                break;
                            case 3:
                                TimerStep newTimeStep;
                                System.out.print("Please enter text to be displayed while this timer is displayed: ");
                                String tiStepText = input.nextLine();
                                while(true) {
                                    System.out.print("Please enter how long this timer should be(in seconds): ");
                                    try {
                                        int stepSec = input.nextInt();
                                        newTimeStep = new TimerStep(tiStepText, stepSec);
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Input! Please try again\n");
                                    }
                                    input.nextLine();
                                }
                                newRecipe.addStep(newTimeStep);
                                break;
                            case 4:
                                TextStep newTextStep;
                                System.out.println("What would you like the step to say?");
                                String teStepText = input.nextLine();
                                newTextStep = new TextStep(teStepText);
                                newRecipe.addStep(newTextStep);
                                break;
                            case 5:
                                ArrayList<Step> tempStep = newRecipe.getSteps();
                                if (tempStep.isEmpty()) {
                                    System.out.println("No steps to delete!\n");
                                    break;
                                }
                                System.out.println();
                                for (int i = 0; i < tempStep.size(); i++)
                                    System.out.println("[" + (i + 1) + "] " + tempStep.get(i).toString());
                                int stepSelect;
                                while(true) {
                                    System.out.print("\nPlease select a step above to remove(0 to cancel): ");    
                                    try {
                                        stepSelect = input.nextInt();
                                        if (stepSelect >= 0 && stepSelect <= tempStep.size())
                                            break;
                                        else
                                            System.out.println("Invalid input! Please try again\n");
                                    } catch (Exception e) {
                                        System.out.println("Invalid input! Please try again\n");
                                    }
                                }
                                input.nextLine();

                                if (stepSelect != 0)
                                    newRecipe.removeStep(stepSelect - 1);
                                
                                break;
                            case 6:
                                if (!(newRecipe.getIngredients().isEmpty()) && !(newRecipe.getSteps().isEmpty())) {
                                    cookbook.add(newRecipe);
                                    recipeLoop = false;
                                } else
                                    System.out.println("There are no steps or no ingredients to this recipe! Please try again\n");
                                break;
                            case 7:
                                recipeLoop = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    if (cookbook.isEmpty())
                        System.out.println("You have no recipes in your cookbook! Please create or import a recipe first");
                    else {
                        int recipeSelection;
                        int servingsIn;
                        for (int i = 0; i < cookbook.size(); i++)
                            System.out.println("[" + (i + 1) + "] " + cookbook.get(i).getName());
                        while(true) {
                            System.out.print("\nSelect a recipe to exectue: ");
                            try {
                                recipeSelection = input.nextInt();
                            
                            if (recipeSelection > 0 && recipeSelection <= cookbook.size())
                                break;
                            else
                                System.out.println("Invalid number! Please try again\n");
                            } catch (Exception e) {
                                input.nextLine();
                                System.out.println("Invalid input! Please try again\n");
                            }
                        }
                        Recipe r = cookbook.get(recipeSelection - 1);

                        while(true) {
                            System.out.print("How many servings would you like to make? (Default is " + r.getServings() + "):");
                            try {
                                servingsIn = input.nextInt();
                                break;
                            } catch (Exception e) {
                                input.nextLine();
                                System.out.println("Invalid input! Please Try again\n");
                            }
                        }
                        r.execute(servingsIn);
                    }
                    break;
                case 3:
                    File importFile = null;
                    while(true) {
                        System.out.print("Please enter the name of your file(accepted files: *.txt; 0 to cancel): ");
                        
                        try {
                            String inFile = input.nextLine();
                            if (inFile.compareTo("0") == 0)
                                break;
                            importFile = new File(inFile + ".txt");
                            if (importFile.exists())
                                break;
                            else
                                System.out.println("That file does not exist\n");
                        } catch (Exception e) {
                            System.out.println("Invalid input! Please try again\n");
                        }
                    }

                    if (importFile == null)
                        break;

                    Recipe newR = new Recipe();
                    if (newR.importRecipe(importFile)) {
                        cookbook.add(newR);
                        System.out.println("Import successful!");
                    } else
                        System.out.println("Import failed...");
                        
                    break;
                case 4:
                    if (cookbook.isEmpty()) {
                        System.out.println("You have no recipes in your cookbook! Please create a recipe first");
                        break;
                    }

                    int recipeSelection;
                    for (int i = 0; i < cookbook.size(); i++)
                        System.out.println("[" + (i + 1) + "] " + cookbook.get(i).getName());
                    while(true) {
                        System.out.print("\nSelect a recipe to export(0 to cancel): ");
                        try {
                            recipeSelection = input.nextInt();
                            
                            if (recipeSelection >= 0 && recipeSelection <= cookbook.size())
                                break;
                            else
                                System.out.println("Invalid number! Please try again\n");
                        } catch (Exception e) {
                            input.nextLine();
                            System.out.println("Invalid input! Please try again\n");
                        }
                    }
                    input.nextLine();
                    if((recipeSelection) != 0)
                        System.out.println((cookbook.get(recipeSelection - 1).exportRecipe()) ? "Export successful!\n" : "Export failed...\n");

                    break;
                case 5:
                    programLoop = false;
                break;
            }
        }
        
        input.close();
    }
}