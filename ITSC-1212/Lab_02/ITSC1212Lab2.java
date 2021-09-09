public class ITSC1212Lab2 {
    public static void main(String[] args) {
        //Part A
        /*
        //short x = 0;
        //short y = 2000;
        //int z = 100000;

        char a = 'a';
        char b = 'b';

        boolean boo = true;

        //I think these will add together just fine because of type casting
        //System.out.println(x + y + z);
        //The number 195 was printed because that is the integer value of the characters, 97 and 98.
        //System.out.println(a + b);
        //System.out.println(x < y); //true
        //System.out.println(y > z); //false
        //System.out.println(z < a); //false

        // >  |  Greater than
        // >= |  Greater than or equal to
        // <  |  Less than
        // <= |  Less than or equal to
        // == |  Equal to
        // != |  Not equal to
        */
        //Part B
        /*
        int ex = (int) 4.0;
        System.err.println(ex); //This works because we are explicitly converting this double to int, if we put in 4.9, then it will just remove the decimal part and be 4 still

        double x = 8.8;
        double y = 2.2;

        System.out.println(x / y);
        System.out.println(x / (int) y);    //Due to the fact this casting only removes the decimal, rounding down, it can drastically shift the output value.
        System.out.println((int) x / y);
        System.out.println((int) (x / y));

        double cost = 10.10;
        double paid = 12.33;
        double change = paid - cost;
        System.out.println("The change owed on this transaction is: " + (double) ((int) (change * 100)) / 100);
        */
        //Part C

        //int totalDays = 62;
        //int weeks = 62 / 7;
        //int remainderDays = 62 % 7;

        //System.out.println(totalDays + "  days can be shortedned into " + weeks + " weeks and " + remainderDays + " days");
        /*
        int totalDays = 11111;
        int weeks = totalDays / 7;
        int remainderDays = totalDays % 7;
        int years = weeks / 52;
        int remainderWeeks = weeks % 52;
        */
        int totalDays = 11111;
        int years = totalDays / 365;
        int weeks = (totalDays % 365) / 7;
        int remainderDays = (totalDays % 365) % 7;
        
        System.out.println("Number of total days: " + totalDays);
        System.out.println("Years: " + years);
        System.out.println("Weeks: " + weeks);
        System.out.println("Days: " + remainderDays);
    }
}