//////////////////////////////////////////////////////////////////////////
// Filename: StringUtils.java                                     		//
// Date: October 19, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program sets up the StringUtils class and the methods		//
//			genGauge, copy, cut, and paste								//
//////////////////////////////////////////////////////////////////////////

public class StringUtils {
	public static void genGauge(String currentString) {		//Pre-made method that prints out string and formats it for easy analysis
		System.out.println(currentString);
		int c = 0;
		int l = currentString.length();
		String genGauge = "";
		while(c < l) {
			genGauge = genGauge + c;
			if (c < 9) {c++;}
			else {c = 0; l = l - 10;}
		}
		System.out.println(genGauge);
	}

	public static String copy(String currentString, int startPosition, int onePastLastPosition) {
		return currentString.substring(startPosition, onePastLastPosition);		//Method that takes a certain part of a string and returns that part
	}
	
	public static String cut(String currentString, int  startPosition, int onePastLastPosition) {
		String newString = "";													//Method that removes part of a certain string and returns a new one
		
		for (int i = 0; i < currentString.length(); i++) {
			if (!(i >= startPosition && i < onePastLastPosition)) {				//Checks if i is NOT in between the starting and ending positions
				newString += currentString.charAt(i);							//Adds character to string if outside specified area
			}
		}
		
		return newString;
	}
	
	public static String paste(String currentString, int insertBefore, String stringToInsert) {		//Method that adds a string inside of another string before a specified position
		return currentString.substring(0, insertBefore) + stringToInsert + currentString.substring(insertBefore);
	}
}
