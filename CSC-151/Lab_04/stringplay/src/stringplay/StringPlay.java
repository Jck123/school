//////////////////////////////////////////////////////////////////////////
// Filename: StringPlay.java                                          	//
// Date: September 13, 2020                                             //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program will take a line from user and put the string		//
//			through a series of alterations and displaying those		//
//			alterations													//
//////////////////////////////////////////////////////////////////////////

package stringplay;

import java.util.Scanner;

public class StringPlay {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a line of text:");
		String str = input.nextLine();
		if (str.length() < 7)
			System.out.println("The input is too short");
		else {
			if (str.equals(str.trim()))								//Checks for whitespaces by comparing trimmed and non-trimmed strings
				System.out.println("The original string has no leading or trailing whitespace");
			else
				System.out.println("The original string has leading or trailing whitespace");
			String sub1 = str.substring(0, 2);						//Takes first 2 chars
			String sub2 = str.substring(str.length() - 5);			//Takes last 5 chars
			String strMain = str.substring(2, str.length() - 5);	//Takes leftover string
			System.out.println("First 2 and last 5 chars swapped: " + sub2 + strMain + sub1);
			System.out.println("To upper case: " + str.toUpperCase());	//Converts entire string to upper case
			if ((str.length() % 2) == 0)							//Checks for even number of chars
				System.out.println("The two middle characters are " + str.charAt(str.length() / 2 - 1) + str.charAt(str.length() / 2));
			else
				System.out.println("The line has an odd number of characters.");
			System.out.println("compareTo lower case version: " + str.compareTo(str.toLowerCase()));
			System.out.println("Does the first half equal the last half? " + 
			str.substring(0, (int)(Math.floor(str.length() / 2))).equalsIgnoreCase(str.substring((int)(Math.ceil(str.length() / 2)))));
			int eIndex = str.toLowerCase().indexOf('e');		//Finds first instance of 'e' AFTER converting all chars to lowercase
			int sIndex = str.toLowerCase().indexOf('s');		//Finds first instance of 's' AFTER converting all chars to lowercase
			int firstCharIndex = 0;								//First e, E, s, S index
			String str1 = "";
			if (eIndex == -1 && sIndex == -1)					//Checks if neither s nor e showed up
				str1 = str;
			else if (eIndex == -1 || sIndex == -1) {			//Checks if only s or e showed up
				if (eIndex < sIndex)							//Checks if e was the -1(char not found)
					firstCharIndex = sIndex;
				else
					firstCharIndex = eIndex;
				str1 = str.substring(0, firstCharIndex) + str.substring(firstCharIndex + 1);
			}
			else {												//Assumes both s and e showed up
				if (eIndex > sIndex)							//Checks if s was the first char between e and s
					firstCharIndex = sIndex;
				else
					firstCharIndex = eIndex;
				str1 = str.substring(0, firstCharIndex) + str.substring(firstCharIndex + 1);
			}
			System.out.println("The input with the first 'e', 'E', 's', or 'S' removed: " + str1);	//Wraps it all up
		}
	}
}
