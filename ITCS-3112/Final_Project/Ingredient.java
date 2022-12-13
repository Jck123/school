package Final_Project;
import java.util.ArrayList;

public class Ingredient {
    private String ingredientName;
    private ArrayList<Unit> unitList = new ArrayList<Unit>();;

    public Ingredient(String name, ArrayList<Unit> unitListInput) {
        ingredientName = name;
        unitList = unitListInput;
    }

    public Ingredient(String name, String amount) {
        ingredientName = name;
        unitList = amountToList(amount);
    }

    public Ingredient convertAmount(int originalServings, int newServings) {
        int qtspCount = 0;
        for (Unit u : unitList) {
            int factor = 0;
            switch(u.getUnit()) {
                case 'G': factor = 3072; break;
                case 'C': factor = 192; break;
                case 'T': factor = 12; break;
                case 't': factor = 4; break;
            }
            qtspCount += (u.getAmount() * factor);
        }

        qtspCount *= ((double)newServings/(double)originalServings);

        ArrayList<Unit> tempUnitList = new ArrayList<Unit>();

        double galCount = qtspCount / 3072;
        qtspCount %= 3072;
        if (qtspCount / 768 > qtspCount / 1024) {
            galCount += (qtspCount / 768) * .25;
            qtspCount %= 768;
        } else {
            galCount += (qtspCount / 1024) * .33;
            qtspCount %= 1024;
        }
        if (galCount > 0)
            tempUnitList.add(new Unit(galCount, 'G'));

        double cupCount = qtspCount / 192;
        qtspCount %= 192;
        if (qtspCount / 48 > qtspCount / 64) {
            cupCount += (qtspCount / 48) * .25;
            qtspCount %= 48;
        } else {
            cupCount += (qtspCount / 64) * .33;
            qtspCount %= 64;
        }
        if (cupCount > 0)
            tempUnitList.add(new Unit(cupCount, 'C'));

        double tbspCount = qtspCount / 12;
        qtspCount %= 12;
        tbspCount += (qtspCount / 3) * 0.25;
        qtspCount %= 3;
        if (tbspCount > 0)
            tempUnitList.add(new Unit(tbspCount, 'T'));

        double tspCount = qtspCount / 4;
        qtspCount %= 4;
        tspCount += qtspCount * 0.25;
        if (tspCount > 0)
            tempUnitList.add(new Unit(tspCount, 't'));

        return new Ingredient(ingredientName, tempUnitList);
    }

    public String amountToString() {
        String output = "";

        for(Unit u : unitList) {
            output += u.toString();
        }

        return output;
    }

    public static ArrayList<Unit> amountToList(String input) {
        char[] charInput = input.toCharArray();
        String strVal = "";
        ArrayList<Unit> output = new ArrayList<Unit>();

        for (char c : charInput) {
            if (Character.isLetter(c) && !strVal.isBlank()) {
                output.add(new Unit(Double.parseDouble(strVal), c));
                strVal = "";
            } else if (Character.isDigit(c) || c == '.')
                strVal += c;
            else
                throw new IllegalArgumentException("Incorrect Format");
        }
        if (output.isEmpty())
            throw new IllegalArgumentException("Incorrect Format");

        return output;
    }

    public String getName() {
        return ingredientName;
    }

    public String toString() {
        String output = ingredientName + " ";

        for (Unit u : unitList)
            output += u.toStringFormat() + " ";

        return output;
    }
}