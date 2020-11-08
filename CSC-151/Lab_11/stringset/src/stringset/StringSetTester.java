//////////////////////////////////////////////////////////////////////////
// Filename: StringSetTester.java                              			//
// Date: November 8, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Tests the StringSet class and displays results				//
//////////////////////////////////////////////////////////////////////////

package stringset;

import java.util.Scanner;

public class StringSetTester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringSet set1 = new StringSet();
		
		System.out.println("How many strings will you enter?");		//Asks user to enter how many strings they will enter
		int numStr = input.nextInt();
		input.nextLine();											//Cleans additional stuff after reading the int(mainly the \n)
		System.out.println("Enter each string, seperating them with the 'Enter' key");
		for (int i = 0; i < numStr; i++) {							//User enters in their strings here and they're added to StringSet
			if (!set1.add(input.nextLine())) {
				System.out.println("String set at capacity! Using first 10 strings provided");		//Stops user from entering in more than 10 strings
				break;
			}
		}
		System.out.println("Enter a string you would like to search the StringSet for");		//Searches StringSet for string entered by user
		String search = input.nextLine();
		System.out.println("There are " + set1.size() + " strings in this StringSet\n" + 		//Prints results
							"There are " + set1.numChars() + " characters in this StringSet\n" + 
							"There are " + set1.countStrings(search) + " instances of " + search + " in this StringSet");
	}

}
