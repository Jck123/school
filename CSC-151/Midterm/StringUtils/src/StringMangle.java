//////////////////////////////////////////////////////////////////////////
// Filename: StringMangle.java                                     		//
// Date: October 19, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program sets makes use of the StringUtils class and			//
//			allows the user to play with them using currentString		//
//			and clipboard												//
//////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class StringMangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String currentString = "";
		String clipboard = "";
		char in;						//Placeholder for user input
		int start;						//Placeholder for starting position
		int end;						//Placeholder for ending position
		
		System.out.println("Enter a string");
		currentString = input.next();	//Initial string input
		StringUtils.genGauge(currentString);
		System.out.println("Enter c to copy, x to cut, v to paste, q to quit");
		in = input.next().charAt(0);	//Sets up for first loop
		while(in != 'q') {				//Exit condition
			if (in == 'c') {			//Makes use of the copy method
				System.out.println("Enter the starting position");
				start = input.nextInt();
				System.out.println("Enter on past the ending position");
				end = input.nextInt();
				
				clipboard = StringUtils.copy(currentString, start, end);
				System.out.println("The current string is");
				StringUtils.genGauge(currentString);
				System.out.println("The clipboard is");
				System.out.println(clipboard + " and it has a length of " + clipboard.length());
			} 
			else if ( in == 'v') {		//Makes use of the paste method
				System.out.println("Enter the position the past should come before");
				start = input.nextInt();
				
				currentString = StringUtils.paste(currentString, start, clipboard);
				System.out.println("The current string is");
				StringUtils.genGauge(currentString);
				System.out.println("The clipboard is");
				System.out.println(clipboard + " and it has a length of " + clipboard.length());
			}
			else if (in == 'x') {		//Makes use of the cut method
				System.out.println("Enter the starting position");
				start = input.nextInt();
				System.out.println("Enter on past the ending position");
				end = input.nextInt();
				
				currentString = StringUtils.cut(currentString, start, end);
				System.out.println("The current string is");		//Please just let me make another method to do all this (paper said no other methods allowed)
				StringUtils.genGauge(currentString);
				System.out.println("The clipboard is");
				System.out.println(clipboard + " and it has a length of " + clipboard.length());
			}
			System.out.println("Enter c to copy, x to cut, v to paste, q to quit");		//Sets up for next loop
			in = input.next().charAt(0);
		}
	}

}
