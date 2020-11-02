//////////////////////////////////////////////////////////////////////////
// Filename: AverageCalculatorMain.java                                 //
// Date: November 1, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Tests the AverageCalculator class and displays results		//
//////////////////////////////////////////////////////////////////////////

package averagecalculator;

public class AverageCalculatorMain {

	public static void main(String[] args) {
		AverageCalculator calc1 = new AverageCalculator();		//Creates two new AverageCalculator objects
		AverageCalculator calc2 = new AverageCalculator();
		
		calc1.add(3);											//Adds one number to calc1
		System.out.println("Sum: " + calc1.getSum() +			//Displays statistics about calc1 using the methods included with the AverageCalculator class
						"\nCount: " + calc1.getCount() +
						"\nAverage: " + calc1.getAverage());
		
		calc2.add(6);											//Adds three numbers to calc2
		calc2.add(3);
		calc2.add(8);
		System.out.println("Sum: " + calc2.getSum() +			//Same thing as above, but calc2
						"\nCount: " + calc2.getCount() +
						"\nAverage: " + calc2.getAverage());
		
	}

}
