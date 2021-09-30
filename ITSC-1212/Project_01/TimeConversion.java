public class TimeConversion {
    
    /**
     * Constructor
     */
    TimeConversion(){

    }


    /**
     * TO DO: showDecaseconds method
     * Given a number of seconds calculates 
     * and display decaseconds
    */
    // add your code here
   
    public void showDecaseconds(int sec) {
        System.out.println("A decasecond is ten seconds");      //Divides input seconds by 10
        System.out.println("\t" + sec + " second(s) is " + ((double)sec / 10.0) + " decaseconds");
    }

    /**
     * TO DO: showJiffies method
     * Given a number of seconds calculates 
     * and display jiffies
    */
    // add your code here

    public void showJiffies(int sec) {                          //Multiplies input seconds by 100
        System.out.println("A jiffy is a unit of time used in computer operating systems. It is 10 milliseconds");
        System.out.println("\t" + sec + " second(s) is " + (sec * 100) + " jiffies");
    }

    /** 
     * TO DO: showNewYorkMinutes method
     * Given a number of seconds calculates 
     * and display New York minutes
    */
    // add your code here

    public void showNewYorkMinutes(int sec) {                   //Multiplies input seconds by 20
        System.out.println("A New York minute is the period of time between the traffic lights turning green and the cab behind you honking. It is 1/20th of 1 second");
        System.out.println("\t" + sec + " second(s) is " + (sec * 20) + " New York minutes");
    }

    /**
     * TO DO: showNanoCenturies method
     * Given a number of seconds calculates 
     * and display Nanocenturies
    */ 
    // add your code here

    public void showNanoCenturies(int sec) {                    //Divides input seconds by 3.156
        System.out.println("A nanocentury is a computing measurement coined from the expression -  \"never to let the user wait more than a few nanocenturies for a response\". It is 3.156 seconds");
        System.out.println("\t" + sec + " second(s) is " + ((double)sec / 3.156) + " nanocenturies");
    }

     /**
     * TO DO: showScaramuccis method
     * Given a number of seconds calculates 
     * and display Scaramuccis
    */ 
    // add your code here

    public void showScaramuccis(int sec) {                  //Divides input seconds by 950400
        System.out.println("A scaramucci is the tenure of former White House Communications Director Anthony Scaramucci. It is 11 days.");
        System.out.println("\t" + sec + " second(s) is " + ((double)sec / 950400.0) + " Scaramuccis");
    }


    
}//end class