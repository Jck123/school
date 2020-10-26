//////////////////////////////////////////////////////////////////////////
// Filename: SelectionSort.java                                     	//
// Date: October 26, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program creates 3 different arrays to sort and counts		//
//			how many comparisons and swaps each one made				//
//////////////////////////////////////////////////////////////////////////

package selectionsort;

public class SelectionSort {

	public static void selectionSort(double[] list) {
		int comparisonCnt = 0;
		int swapCnt = 0;
		
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			double currentMin = list[i];
		    int currentMinIndex = i;

		    for (int j = i + 1; j < list.length; j++) {
		    	if (currentMin > list[j]) {
		    		currentMin = list[j];
		    		currentMinIndex = j;
		        }
		    	comparisonCnt++;		//Counts every comparison
		    }

		    // Swap list[i] with list[currentMinIndex] if necessary;
		    if (currentMinIndex != i) {
		    	list[currentMinIndex] = list[i];
		        list[i] = currentMin;
		        swapCnt++;				//Counts every swap
		    }
		}
		System.out.println("Array Size: " + list.length);
		System.out.println("Comparisons made: " + comparisonCnt);
		System.out.println("Swaps made: " + swapCnt);
	}
	
	public static void main(String[] args) {
		final int NUM_ELEMENTS = 4000;
		double[] lo2Hi	= new double[NUM_ELEMENTS];
		double[] hi2Lo 	= new double[NUM_ELEMENTS];
		double[] random = new double[NUM_ELEMENTS];
		
		for (int i = 1; i < lo2Hi.length; i++) {
			lo2Hi[i] = lo2Hi[i - 1] + (Math.random() * 10 + 1);		//Takes last number(first one is always 0) and adds a random number 1 to 10
		}
		
		for (int i = hi2Lo.length - 2; i >= 0; i--) {				//Same thing as above, but index decrements
			hi2Lo[i] = hi2Lo[i + 1] + (Math.random() * 10 + 1);
		}
		
		for (int i = 0; i < random.length; i++) {					//Random numbers between 0 and 1
			random[i] = Math.random();
		}
		System.out.println("lo2Hi");
		selectionSort(lo2Hi);
		System.out.println("hi2Lo");
		selectionSort(hi2Lo);
		System.out.println("random");
		selectionSort(random);
	}
}