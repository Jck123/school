//////////////////////////////////////////////////////////////////////////
// Filename: TriangleOfSquares.java                                     //
// Date: September 27, 2020                                             //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program will take a number from the user and make a			//
//			triangle of squared numbers maxing out at the input			//
//			the user has provided.										//
//////////////////////////////////////////////////////////////////////////

package triangleofsquares;

import java.util.Scanner;

public class TriangleOfSquares {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int in;													//User input
		String out = "";										//String that will contain the output
		System.out.print("Enter a number between 1 and 9: ");
		in = input.nextInt();
		if (in >= 1 && in <= 9) {								//Makes sure the input stays within 1 and 9(inclusive)
			for(int i = 1; i <= in; i++) {						//Counts up for each individual line to output
				for (int j = in; j > 0; j--) {					//Counts down for each individual squared number on the specific line
					if (i >= j)									//Checks the line number if it's time to print the specific squared number yet
						out += j * j + " ";						//Adds the squared number and a space
					else {
						for (int k = 0; k <= (j * j + "").length(); k++)	//Adds a space for each character the invisible number will take
							out += " ";
					}
				}
				System.out.println(out);						//Wraps up the package with a bow and prints it
				out = "";										//Resets the output line to prepare for next line
			}
			
			for(int i = in - 1; i > 0; i--) {					//Does same as above for loop, but backwards to make up for the bottom half of the triangle
				for (int j = in; j > 0; j--) {
					if (i >= j)
						out += j * j + " ";
					else {
						for (int k = 0; k <= (j * j + "").length(); k++)
							out += " ";
					}
				}
				System.out.println(out);
				out = "";
			}
		}
		else
			System.out.println("Please only input a number between 1 and 9.");	//Naughty zone for people who don't follow instructions
	}
}