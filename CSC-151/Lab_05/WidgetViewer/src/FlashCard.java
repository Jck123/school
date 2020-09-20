//////////////////////////////////////////////////////////////////////////
// Filename: FlashCard.java                                          	//
// Date: September 20, 2020                                             //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program will generate two random numbers and ask			//
//			the user to solve the on screen equation. The program		//
//			will then check if the answer given is correct and			//
//			display result												//
//////////////////////////////////////////////////////////////////////////

import javax.swing.JLabel;
import javax.swing.JTextField;
								//Note: I am using a modified version of WidgetViewer.java. I made the edit on line 161
public class FlashCard {
	public static void main(String[] args) {
		WidgetViewer wv = new WidgetViewer(300, 150);
		double randNum1 = (double)((int)(Math.random() * 100)) / 10;		//Generates random double and trims extra numbers
		double randNum2 = (double)((int)(Math.random() * 100)) / 10;
		double answer = (double)((int)((randNum1 + randNum2) * 10)) / 10;	//Prevents program from bugging and thinking "0.500000000001"
		JLabel flashQuestion = new JLabel("What is " + randNum1 + " + " + randNum2);	//Asking the BIG question
		int x;		//Placeholder for x coordinate to place answer label on
		JTextField input = new JTextField(1);						//Creates elements for panel
		JLabel flashAnswer = new JLabel();
		wv.add(flashQuestion, 95, 10, 100, 20);						//Adds elements to panel
		wv.add(input);
		wv.addButtonAndWait("Click here to check answer!");			//Adds button and waits for button to be pressed to continue running code
		if (Double.parseDouble(input.getText().trim()) == answer) {	//Trims out whitespace, converts to double and checks if answer is correct
			flashAnswer.setText("That's right. Good job!");
			x = 87;													//Sets x coordinate based on message that pops up
		}
		else {
			flashAnswer.setText("Sorry, the correct answer is " + answer);
			x = 50;
		}
		wv.add(flashAnswer, x, 50, 200, 20);	//Displays results
	}
}
