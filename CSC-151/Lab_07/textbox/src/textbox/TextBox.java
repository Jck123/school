//////////////////////////////////////////////////////////////////////////
// Filename: TextBox.java			                                    //
// Date: October 11, 2020                                             	//
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program creates four methods with the same name, but		//
//			differing parameters which each have a different input		//
//			depending on which parameters are used						//
//////////////////////////////////////////////////////////////////////////

package textbox;

public class TextBox {
	public static String textBoxString(int side) {				//Prints box with 'side' width and 'side' height using a predefined character
		String out = "";										//Holds everything
		for (int i = 1; i <= side; i++) {						//Represents rows and counts up
			for (int j = 1; j <= side; j++) {					//Represents columns and counts up
				if (i > 1 && i < side && j > 1 && j < side)		//Checks if the current position is part of the box's side to determine if it's assigned a character
					out += " ";									//Assigns space if position is inside box
				else
					out += "#";									//Assigns predefined character if part of the box's side
			}
			out += "\n";										//Resets after each column is complete
		}
		return out;												//Wraps it up with a bow and ships it off
	}
	
	public static String textBoxString(int side, char bChar) {	//Prints a box with 'side' width and 'side' height using 'bChar' for it's characters to print
		String out = "";
		for (int i = 1; i <= side; i++) {
			for (int j = 1; j <= side; j++) {
				if (i > 1 && i < side && j > 1 && j < side)		//Same exact code as before
					out += " ";
				else
					out += bChar;								//Uses variable character now
			}
			out += "\n";
		}
		return out;
	}
	
	public static String textBoxString(int rows, int cols) {	//Prints box with 'rows' rows and 'cols' columns using a predefined character
		String out = "";										//Same code as first method
		for (int i = 1; i <= rows; i++) {						//Uses 'rows' here instead of 'side'
			for (int j = 1; j <= cols; j++) {					//Uses 'cols' here instead of 'side'
				if (i > 1 && i < rows && j > 1 && j < cols)		//i represents rows, j represents cols
					out += " ";
				else
					out += "#";
			}
			out += "\n";
		}
		return out;
	}
	
	public static String textBoxString(int rows, int cols, char c1, char c2) {	//Prints box with 'rows' rows and 'cols' columns and alternates between two variable characters that are set by the user
		String out = "";										//Same code as method above
		int ch = 0;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (i > 1 && i < rows && j > 1 && j < cols)
					out += " ";
				else
					if (ch == 0) {								//Checks whether to use c1 or c2
						out += c1;								//Uses c1
						ch = 1;									//Sets next char to be used as c2
					} else {
						out += c2;								//Uses c2
						ch = 0;									//Sets next char to be used as c1
					}
			}
			out += "\n";
		}
		return out;
	}
}
