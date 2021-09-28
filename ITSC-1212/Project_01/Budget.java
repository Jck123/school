public class Budget {
    public static void main(String[] args) {
        //**************//
        //  Project 1   //
        //**************//

        int monthlyRent = 625;      //Defining and initializing monthly costs
        int internetService = 27;
        int groceryBill = 250;
        int funAllowance = 150;

        int hourlyWage = 10;        //Defining and initializing hourly wage

        int monthlyCost = monthlyRent + internetService + groceryBill + funAllowance;   //Puts sum of all monthly costs into one variable

        double breakEvenHours = (double)monthlyCost / hourlyWage;
        double savingHours = (double)(monthlyCost + 100) / hourlyWage;      //Calculating how many hours must be worked monthly

        System.out.println("Hourly Wage: $" + hourlyWage + "/hr");          //Formats and outputs everything
        System.out.println("Monthly Costs: \n\tRent: $" + monthlyRent 
                        + "\n\tInternet: $" + internetService 
                        + "\n\tGroceries: $" + groceryBill
                        + "\n\tFun Allowance: $" + funAllowance);
        System.out.println("Total Monthly Costs: $" + monthlyCost);
        System.out.println("Hours required to break even: " + (breakEvenHours / 4) + " hours/week");    //Converts monthly hours needed to weekly hours needed
        System.out.println("Hours required to save $100 every month: " + (savingHours / 4) + " hours/week");
    }
}
