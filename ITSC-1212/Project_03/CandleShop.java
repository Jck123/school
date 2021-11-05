import java.util.Scanner;

public class CandleShop {
    public static void main(String[] args) throws InterruptedException {
        ////////////////////
        //   Project 3    //
        ////////////////////
        Scanner input = new Scanner(System.in);
        int candleType = 1;                         //Keeps track of candleType we are currently handling
        String candleName = "";                     //Holder values before Candle classes are set
        int burnTime = 0;
        double candleCost = 0.0;
        Candle candle1 = new Candle("", 0,0,0);     //Candle objects
        Candle candle2 = new Candle("", 0,0,0);
        Candle candle3 = new Candle("", 0,0,0);


        System.out.println("Welcome to the Candle Shop Program!");
        System.out.println("*Initiaizing set up mode...*");
        Thread.sleep(1500);                                         //We like to do some extra stuff here
        System.out.println("*INITIALIZATION COMPLETE*\nWelcome, admin!\nPlease enter in today's candles");
        
        while (candleType <= 3) {                                   //Does not progress until all 3 candles have been properly set
            System.out.print("Enter the name of candle type " + candleType + ": ");
            candleName = input.nextLine();                          //Gets name, cost, and burn time
            System.out.print("Enter the cost of candle type " + candleType + ": $");
            candleCost = (double)((int)(input.nextDouble() * 100)) / 100;   //Makes sure the value is rounded down to nearest cent
            System.out.print("Enter the burn time of candle type " + candleType + " in minutes: ");
            burnTime = input.nextInt();
            if (candleCost > 0 && burnTime > 0) {                   //Does not progress until both numbers are greater than 0
                switch(candleType) {
                    case 1:                                         //Sets different candle depending on the value of candleType
                        candle1 = new Candle(candleName, candleType, candleCost, burnTime);
                        break;
                    case 2:
                        candle2 = new Candle(candleName, candleType, candleCost, burnTime);
                        break;
                    case 3:
                        candle3 = new Candle(candleName, candleType, candleCost, burnTime);
                        break;
                }
                candleType++;                                       //Increments candleType ONLY once the previous candleType has passed checks and is set
            } else {
                System.out.println("Sorry, invalid input recieved, please try again...");       //User enters in value of 0 or lower
            }
            input.nextLine();
        }
        System.out.println("*SYSTEM SETUP COMPLETE*\n*Initializing shop mode...");
        Thread.sleep(2000);
        System.out.println("*INITIALIZATION COMPLETE*\nWelcome to Bob's Candle Shop!\nWe have 3 different candles here for purchase today! They are...\n" 
                        + candle1.toString() + "\n" 
                        + candle2.toString() + "\n"                                             //Shop phase starts here
                        + candle3.toString());                                                  //User is shown which candles are for sale here
        
        
        int buyCandle1 = 0;                     //Holds values of how many candles the users wants for each type
        int buyCandle2 = 0;
        int buyCandle3 = 0;
        int totalCandles = 0;                   //Holds sum of all candles purchased
        int purchaseAmt = 0;                    //Temporary holding variable for how many candles the user wants
        int burnTimeTotal;                      //Holds value of consecutive burning time
        double subtotalCost = 0.0;              //Price before discount
        double totalCost = 0.0;                 //Price after discount
        double discount = 0.0;                  //Holds discount
        char symbol = '%';                      //Holds symbol to be used for each type of candle on histogram 

        candleType = 1;                         //Resets candle type

        while (candleType <= 3) {               //Once again, does not progress until all 3 candles have been processed properly
            System.out.print("Enter how many type " + candleType + " candles you would like to buy: ");
            purchaseAmt = input.nextInt();
            if(purchaseAmt >= 0) {              //Verifies user did not enter negative value
                switch (candleType) {
                    case 1:
                        buyCandle1 = purchaseAmt;   //Sets input to variable depending which candle is being handled
                        break;
                    case 2:
                        buyCandle2 = purchaseAmt;
                        break;
                    case 3:
                        buyCandle3 = purchaseAmt;
                        break;
                }
                candleType++;                       //Increments ONLY after previous candle type has been properly processed
            } else {
                System.out.println("Invalid input, please try again...");
            }
        }

        int loopMax = 0;                            //Holds number of candles purchased for that type
        System.out.println("Histogram of candles purchased:");
        for (int i = 1; i <= 3; i++) {              //Sets symbol and loopMax to a differnt value depending on i, which represents candleType
            switch (i) {
                case 1:
                    System.out.print(buyCandle1 + " type 1 (" + candle1.getName() + ") candles: ");
                    symbol = '*';
                    loopMax = buyCandle1;
                    break;
                case 2: 
                    System.out.print(buyCandle1 + " type 2 (" + candle2.getName() + ") candles: ");
                    symbol = '^';
                    loopMax = buyCandle2;
                    break;
                case 3: 
                    System.out.print(buyCandle1 + " type 3 (" + candle3.getName() + ") candles: ");
                    symbol = '$';
                    loopMax = buyCandle3;
                    break;
            }
            for (int j = 0; j < loopMax; j++) {
                System.out.print(symbol);           //Prints proper number of symbols depending on how many of each chandle was purchased
            }
            System.out.println();
        }
        subtotalCost = (double)((int)(100 * (candle1.getCost() * buyCandle1 + candle2.getCost() * buyCandle2 + candle3.getCost() * buyCandle3))) / 100;
        if (subtotalCost > 20)          //Calculates subtotal and rounds down to nearest cent
            discount = 0.05;
        if (subtotalCost > 35)
            discount = 0.07;            //Increases discount based on the value of the subtotalCost
        if (subtotalCost > 55)          //Seperated if statements to make things easier to read(at least for me)
            discount = 0.1;
        if (subtotalCost > 100)
            discount = 0.2;
        totalCost = (double)((int)(100 * (subtotalCost * (1 - discount)))) / 100;   //Calculates totalCost and rounds down to nearest cent
        totalCandles = buyCandle1 + buyCandle2 + buyCandle3;                        //Calculates sum of all candles bought
        burnTimeTotal = candle1.getTime() * buyCandle1 + candle2.getTime() * buyCandle2 + candle3.getTime() * buyCandle3;   //Calculates consecutive burning time
        System.out.println("Subtotal: " + subtotalCost + "\nDiscount: " + (discount * 100) + "%\nTotal: $" + totalCost);
        System.out.println("You've purchased " + totalCandles + " candles and earned " + (totalCandles / 10) + " point(s)!");       //Prints everything out, all nice and neat
        System.out.println("Your purchased candles will burn for a consective " + burnTimeTotal + " minutes at a rate of $" + (((double)((int)((totalCost / burnTimeTotal) * 100))) / 100) + "/min");

        input.close();      //Removes that stupid warning
    }
}