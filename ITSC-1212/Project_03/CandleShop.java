import java.util.Scanner;

public class CandleShop {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int candleType = 1;
        String candleName = "";
        int burnTime = 0;
        double candleCost = 0.0;
        Candle candle1 = new Candle("", 0,0,0);
        Candle candle2 = new Candle("", 0,0,0);
        Candle candle3 = new Candle("", 0,0,0);


        System.out.println("Welcome to the Candle Shop Program!");
        System.out.println("*Initiaizing set up mode...*");
        Thread.sleep(1500);
        System.out.println("*INITIALIZATION COMPLETE*\nWelcome, admin!\nPlease enter in today's candles");
        
        while (candleType <= 3) {
            System.out.print("Enter the name of candle type " + candleType + ": ");
            candleName = input.nextLine();
            System.out.print("Enter the cost of candle type " + candleType + ": $");
            candleCost = (double)((int)(input.nextDouble() * 100)) / 100;
            System.out.print("Enter the burn time of candle type " + candleType + " in minutes: ");
            burnTime = input.nextInt();
            if (candleCost > 0 && burnTime > 0) {
                switch(candleType) {
                    case 1:
                        candle1 = new Candle(candleName, candleType, candleCost, burnTime);
                        break;
                    case 2:
                        candle2 = new Candle(candleName, candleType, candleCost, burnTime);
                        break;
                    case 3:
                        candle3 = new Candle(candleName, candleType, candleCost, burnTime);
                        break;
                }
                candleType++;       
            } else {
                System.out.println("Sorry, invalid input recieved, please try again...");
            }
            input.nextLine();
        }
        System.out.println("*SYSTEM SETUP COMPLETE*\n*Initializing shop mode...");
        Thread.sleep(2000);
        System.out.println("*INITIALIZATION COMPLETE*\nWelcome to Bob's Candle Shop!\nWe have 3 different candles here for purchase today! They are...\n" 
                        + candle1.toString() + "\n" 
                        + candle2.toString() + "\n" 
                        + candle3.toString());
        
        
        int buyCandle1 = 0;
        int buyCandle2 = 0;
        int buyCandle3 = 0;
        int totalCandles = 0;
        int purchaseAmt = 0;
        int burnTimeTotal;
        double subtotalCost = 0.0;
        double totalCost = 0.0;
        double discount = 0.0;
        char symbol = '%';

        candleType = 1;

        while (candleType <= 3) {
            System.out.print("Enter how many type " + candleType + " candles you would like to buy: ");
            purchaseAmt = input.nextInt();
            if(purchaseAmt >= 0) {
                switch (candleType) {
                    case 1:
                        buyCandle1 = purchaseAmt;
                        break;
                    case 2:
                        buyCandle2 = purchaseAmt;
                        break;
                    case 3:
                        buyCandle3 = purchaseAmt;
                        break;
                }
                candleType++;
            } else {
                System.out.println("Invalid input, please try again...");
            }
        }

        int loopMax = 0;
        System.out.println("Histogram of candles purchased:");
        for (int i = 1; i <= 3; i++) {
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
                System.out.print(symbol);
            }
            System.out.println();
        }
        subtotalCost = (double)((int)(100 * (candle1.getCost() * buyCandle1 + candle2.getCost() * buyCandle2 + candle3.getCost() * buyCandle3))) / 100;
        if (subtotalCost > 20)
            discount = 0.05;
        if (subtotalCost > 35)
            discount = 0.07;
        if (subtotalCost > 55)
            discount = 0.1;
        if (subtotalCost > 100)
            discount = 0.2;
        totalCost = (double)((int)(100 * (subtotalCost * (1 - discount)))) / 100;
        totalCandles = buyCandle1 + buyCandle2 + buyCandle3;
        burnTimeTotal = candle1.getTime() * buyCandle1 + candle2.getTime() * buyCandle2 + candle3.getTime() * buyCandle3;
        System.out.println("Subtotal: " + subtotalCost + "\nDiscount: " + (discount * 100) + "%\nTotal: $" + totalCost);
        System.out.println("You've purchased " + totalCandles + " candles and earned " + (totalCandles / 10) + " point(s)!");
        System.out.println("Your purchased candles will burn for a consective " + burnTimeTotal + " minutes at a rate of $" + (((double)((int)((totalCost / burnTimeTotal) * 100))) / 100) + "/min");

        input.close();
    }
}