//////////////////////////////////////////////////////////////////////////
// Filename: StringSet.java                               				//
// Date: November 30, 2020                                            	//
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Class that contains and manages a set of Strings in			//
//			an array.													//
//////////////////////////////////////////////////////////////////////////

package stringsetyetagain;

import java.util.ArrayList;

public class StringSet extends ArrayList<String> {
	
	public StringSet() {				//Constructor
	}
	
	public boolean add(String newStr) {	//Attempts to add a new item to the array, returns false if failed(due to too many strings) and true if successful
		return super.add(newStr);
	}
	
	public void pop() {					//Removes most recently added string to array
		if(super.size() > 0)
			super.remove(size() - 1);
	}
	public int size() {					//Returns how many strings there are in the array
		return super.size();
	}
	
	public int numChars() {				//Returns total number of characters in all strings
		int chars = 0;
		for (int i = 0; i < super.size(); i++) {
			chars += super.get(i).length();
		}
		return chars;
	}
	
	public int countStrings(String stringToLookFor) {		//Checks each string to see if it matches the submitted string exactly
		int matches = 0;
		for (int i = 0; i < super.size(); i++) {
			if (super.get(i).equals(stringToLookFor))
				matches++;
		}
		return matches;
	}	
}