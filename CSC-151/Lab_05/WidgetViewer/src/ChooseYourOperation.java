//////////////////////////////////////////////////////////////////////////
// Filename: ChooseYourOperation.java                                  	//
// Date: September 20, 2020                                             //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program will generate two random integers and request		//
//			an operation number. That number is then converted			//
//			into an integer and goes through a series of tests			//
//			to determine which operation the two random numbers			//
//			will use in arithmetic										//
//////////////////////////////////////////////////////////////////////////

//Note: This program uses a modified version of the WidgetViewer.java script.
//Please look on line 181 of WidgetViewer.java for the changes

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChooseYourOperation {
	public static void main(String[] args) {
		WidgetViewer wv = new WidgetViewer(250, 150);		//Creates window
		int x = 1 + (int)(Math.random() * 9);				//Generates random numbers between 1 and 9(inclusive)
		int y = 1 + (int)(Math.random() * 9);
		JLabel xLabel = new JLabel(x + "");					//Creates elements and converts to string if needed
		JLabel yLabel = new JLabel(y + "");
		JLabel prompt = new JLabel("Enter a number");
		JTextField input = new JTextField();
		JLabel result = new JLabel("");
		wv.add(xLabel, 85, 10, 10, 10);						//Adds elements to window
		wv.add(yLabel, 150, 10, 10, 10);
		wv.add(prompt, 80, 20, 100, 20);
		wv.add(input, 97, 40, 50, 20);
		wv.addButtonAndWait("Click here after entering a number");
		int in = Integer.parseInt(input.getText().trim());	//Trims whitespace, converts to int, and puts it into a variable for easy use
		if (in >= 1 && in <= 10)							//Between 1 and 10(inclusive
			result.setText(x * y + "");
		else if (in % 4 == 0)								//Divisible by 4
			result.setText((x + y) + "");
		else if (in % 5 == 0)								//Divisible by 5
			result.setText(((float)y / x) + "");
		else if (in % 2 == 0)								//Even number
			result.setText(y / x + "");
		else
			result.setText((y - x) + "");
		wv.add(result);										//Displays result
	}
}
