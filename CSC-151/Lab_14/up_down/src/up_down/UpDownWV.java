package up_down;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

public class UpDownWV {
	
	private JLabel lblLeft;		//All the labels
	private JLabel lblRight;
	
	private JButton btnUpUp;	//All the buttons
	private JButton btnUpDown;
	private JButton btnDownDown;
	private JButton btnDownUp;
	
	public UpDownWV() {
		WidgetViewer window = new WidgetViewer(270,150);	//Makes the window
		
		ButtonEvent action = new ButtonEvent();				//Tracks the actions
		
		btnUpUp = new JButton("Up/Up");						//Makes all the buttons
		btnUpDown = new JButton("Up/Down");
		btnDownDown = new JButton("Down/Down");
		btnDownUp = new JButton("Down/Up");
		
		lblLeft = new JLabel("0");							//Makes all the labels
		lblRight = new JLabel("0");
		
		btnUpUp.addActionListener(action);					//Adds listeners to the buttons
		btnUpDown.addActionListener(action);
		btnDownDown.addActionListener(action);
		btnDownUp.addActionListener(action);
		
		window.add(btnUpUp, 10, 30, 110, 20);				//Adds buttons to window
		window.add(btnUpDown, 130, 30, 110, 20);
		window.add(btnDownDown, 10, 60, 110, 20);
		window.add(btnDownUp, 130, 60, 110, 20);
		
		window.add(lblLeft, 10, 10, 110, 20);				//Adds labels to window
		window.add(lblRight, 130, 10, 110, 20);
	}
	
	class ButtonEvent extends WidgetViewerActionEvent {
		@Override
		public void actionPerformed(ActionEvent e) {			//When button is pressed, this method is called
			
			int leftNum = 0;									//Numbers that the left and right labels are increased/decreased by
			int rightNum = 0;
			
			if (e.getSource().equals(btnUpUp)) {				//Checks which button is the caller of the method, then sets the variables accordingly
				leftNum = (int)((Math.random() * 10) + 1);
				rightNum = (int)((Math.random() * 10) + 1);		//Generates random numbers
			} else if (e.getSource().equals(btnUpDown)) {
				leftNum = (int)((Math.random() * 10) + 1);
				rightNum = -(int)((Math.random() * 10) + 1);
			} else if (e.getSource().equals(btnDownDown)) {
				leftNum = -(int)((Math.random() * 10) + 1);
				rightNum = -(int)((Math.random() * 10) + 1);
			} else if (e.getSource().equals(btnDownUp)) {
				leftNum = -(int)((Math.random() * 10) + 1);
				rightNum = (int)((Math.random() * 10) + 1);
			}
			lblLeft.setText(String.valueOf(Integer.parseInt(lblLeft.getText()) + leftNum));		//Takes the current number on the label and increases/decreases based on the randomly generated numbers above.
			lblRight.setText(String.valueOf(Integer.parseInt(lblRight.getText()) + rightNum));
		}
	}
}


