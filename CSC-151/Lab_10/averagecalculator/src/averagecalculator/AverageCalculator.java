//////////////////////////////////////////////////////////////////////////
// Filename: AverageCalculator.java                                     //
// Date: November 1, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Class that holds an array of numbers, returns the sum,		//
//			count, and average of all numbers added.					//
//////////////////////////////////////////////////////////////////////////

package averagecalculator;

public class AverageCalculator {
	private int[] calculatorArray;		//Holds array of numbers added
	private int arrLoc;					//Keeps place of the next location to add a number
	private int sum;					//Holds the sum of all numbers added to the array
	
	public AverageCalculator() {		//Constructor that creates a new calculatorArray and initializes the arrLoc and sum variables
		calculatorArray = new int[50];
		arrLoc = 0;
		sum = 0;
	}
	
	public void add(int newNum) {			//Adds a new number to array
		calculatorArray[arrLoc] = newNum;
		arrLoc++;							//Updates location the next new number will go
		sum += newNum;						//Updates the sum of numbers
		
	}
	
	public int getSum() {					//Accessor method that returns the sum of all numbers added
		return sum;
	}
	
	public int getCount() {					//Accessor method that returns how many numbers that have been added
		return arrLoc;
	}
	
	public double getAverage() {			//Method that returns the average of all numbers that have been added
		if (arrLoc == 0)
			return 0;
		else
		return (double)sum/(double)(arrLoc);
	}
}
