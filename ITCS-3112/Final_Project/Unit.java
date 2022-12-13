package Final_Project;

public class Unit {
    private double amount;
    private char unit;

    public Unit(double amt, char u) {
        if (u == 'G' || u == 'C' || u == 'T' || u == 't') {
            amount = amt;
            unit = u;
        } else
            throw new IllegalArgumentException("Needs to be valid unit");
    }

    public double getAmount() {
        return amount;
    }

    public char getUnit() {
        return unit;
    }

    public String toString() {
        return ((amount % 1 == 0) ? String.valueOf((int)amount) : String.valueOf(amount)) + "" + unit;
    }

    public String toStringFormat() {
        String formatUnit = "";
        switch(unit) {
            case 'G': formatUnit = "gal"; break;
            case 'C': formatUnit = "cup(s)"; break;
            case 'T': formatUnit = "tbsp"; break;
            case 't': formatUnit = "tsp"; break;
        }

        int intAmount = (int)amount;
        
        if (amount - intAmount == 0.0)
            return intAmount + " " + formatUnit;
        
        char[] decAmount =  String.valueOf(amount - intAmount).toCharArray();
        String fracAmount = "";
        if (decAmount[decAmount.length - 1] == '5') {
            if (decAmount.length == 3)
                fracAmount = "1/2";
            else
                fracAmount = (int)((amount - intAmount) * 4) + "/4";
        } else
            fracAmount = Math.round((amount - intAmount) * 3) + "/3";
            
        String formatAmount = (intAmount > 0) ? intAmount + " " + fracAmount : fracAmount;

        return formatAmount + " " + formatUnit;
    }
}