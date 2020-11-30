//////////////////////////////////////////////////////////////////////////
// Filename: SSWindow.java                               				//
// Date: November 30, 2020                                            	//
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Creates the window that specifically manages the			//
//			StringSet class through a GUI.								//
//////////////////////////////////////////////////////////////////////////

package stringsetyetagain;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

public class SSWindow {
	private JTextField inputStr;		//Textfields
	private JTextField searchStrVal;
	
	private JButton searchAction;		//Buttons
	private JButton pushToAdd;
	private JButton pop;
	
	private JLabel numStr;				//Labels
	private JLabel numChar;
	private JLabel searchStrLab;
	private JLabel searchStrResult;
	private JLabel promptToAdd;
	
	private StringSet ss;				//StringSet
	
	public SSWindow() {
		WidgetViewer window = new WidgetViewer(390, 200);	//Window
		
		ButtonEvent action = new ButtonEvent();				//Eventhandler
		
		promptToAdd = new JLabel("Enter a string:");			//Defines buttons and initializes them
		numStr = new JLabel("Number of Strings: 0");
		numChar = new JLabel("Number of Characters: 0");
		searchStrLab = new JLabel("String to search for:");
		searchStrResult = new JLabel("Number of strings with : 0");
		
		inputStr = new JTextField();							//Defines textfields
		searchStrVal = new JTextField();
		
		searchAction = new JButton("Search");					//Defines buttons and initializes them
		pushToAdd = new JButton("Push to add string");
		pop = new JButton("Pop");
		
		searchAction.addActionListener(action);					//Adds event handlers to buttons
		pushToAdd.addActionListener(action);
		pop.addActionListener(action);
		
		window.add(promptToAdd, 10, 10, 100, 20);				//Adds labels to window
		window.add(numStr, 10, 40, 200, 20);
		window.add(numChar, 10, 70, 200, 20);
		window.add(searchStrLab, 10, 100, 120, 20);
		window.add(searchStrResult, 10, 130, 200, 20);
		
		window.add(inputStr, 100, 10, 100, 20);					//Adds textfields to window
		window.add(searchStrVal, 130, 100, 100, 20);
		
		window.add(searchAction, 240, 100, 75, 20);				//Adds buttons to window
		window.add(pushToAdd, 210, 10, 150, 20);
		window.add(pop, 285, 40, 75, 20);
		
		ss = new StringSet();									//Initializes StringSet object
	}
	
	class ButtonEvent extends WidgetViewerActionEvent {			//Event handler
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(pushToAdd)) {				//if user clicked on "add item" button
				ss.add(inputStr.getText());
				inputStr.setText("");
				numStr.setText("Number of Strings: " + ss.size());		//Item is added, and labels are updated accordingly
				numChar.setText("Number of Characters: " + ss.numChars());
			} else if (e.getSource().equals(searchAction))				//If user clicked on "Search" button, one label is changed accordingly
				searchStrResult.setText("Number of strings with " + searchStrVal.getText() + ": " + ss.countStrings(searchStrVal.getText()));
			else if (e.getSource().equals(pop)) {						//If user clicked on "Pop" button
				ss.pop();												//Most recent string is removed, and labels are changed accordingly
				numStr.setText("Number of Strings: " + ss.size());
				numChar.setText("Number of Characters: " + ss.numChars());
			}
		}
	}
}
