//////////////////////////////////////////////////////////////////////////
// Filename: TextBoxTester.java                                     	//
// Date: October 11, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program demos the four methods from TextBox.java and		//
//			labels each one												//
//////////////////////////////////////////////////////////////////////////

package textbox;

public class TextBoxTester {
	public static void main(String[] args) {
		System.out.println("textBoxString(int)");
		System.out.println(TextBox.textBoxString(3));
		
		System.out.println("textBoxString(int, char)");
		System.out.println(TextBox.textBoxString(5, '$'));
		
		System.out.println("textBoxString(int, int)");
		System.out.println(TextBox.textBoxString(4, 5));
		
		System.out.println("textBoxString(int, int, char, char)");
		System.out.println(TextBox.textBoxString(3, 5, '+', 'x'));
	}
}
