//////////////////////////////////////////////////////////////////////////
// Filename: StringSet.java                               				//
// Date: November 8, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Class that contains and manages a set of Strings in			//
//			an array.													//
//////////////////////////////////////////////////////////////////////////

package stringset;

public class StringSet {
	private String[] stringSet;
	private int stringCount;
	
	public StringSet() {				//Constructor that initializes the array and counter
		stringSet  = new String[10];
		stringCount = 0;
	}
	
	public boolean add(String newStr) {	//Attempts to add a new item to the array, returns false if failed(due to too many strings) and true if successful
		if (stringCount == 10)
			return false;
		else {
			stringSet[stringCount] = newStr;
			stringCount++;
			return true;
		}
	}
	
	public void pop() {					//Removes most recently added string to array
		stringCount--;
		stringSet[stringCount] = "";
	}
	
	public int size() {					//Returns how many strings there are in the array
		return stringCount;
	}
	
	public int numChars() {				//Returns total number of characters in all strings
		int chars = 0;
		for (int i = 0; i < stringCount; i++) {
			chars += stringSet[i].length();
		}
		return chars;
	}
	
	public int countStrings(String stringToLookFor) {		//Checks each string to see if it matches the submitted string exactly
		int matches = 0;
		for (int i = 0; i < stringCount; i++) {
			if (stringSet[i].equals(stringToLookFor))
				matches++;
		}
		return matches;
	}	
}
