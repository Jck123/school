//////////////////////////////////////////////////////////////////////////
// Filename: OrganizingGUI.java                                 		//
// Date: December 3, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          GUI that controls the calendar class with event classes.	//
//////////////////////////////////////////////////////////////////////////

package eventorganizingrevamped;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class OrganizingGUI {
	private JButton btnSortDate;						//All the things
	private JButton btnSortProfit;
	private JButton btnReset;
	private JButton btnCreate;
	private JButton btnSell;
	
	private JLabel lblTicketsSold;
	private JLabel lblEventName;
	private JLabel lblResponse;
	
	private JTextField txtfTicketsSold;
	private JTextField txtfEventName;
	
	private JTextArea txtaEventCalendar;
	
	private TRAPSCalendar calendar;						//The item this program is centered around
	
	private JLabel lblEventName1;						//Event creating labels
	private JLabel lblEventVenue;
	private JLabel lblVenueCapacity;
	private JLabel lblEventDate;
	private JLabel lblInitTicketsSold;
	private JLabel lblTicketPrice;
	private JLabel lblOverhead;
	
	private JTextField txtfEventName1;					//Event creating textfields
	private JTextField txtfEventVenue;
	private JTextField txtfVenueCapacity;
	private JTextField txtfEventDate;
	private JTextField txtfInitTicketsSold;
	private JTextField txtfTicketPrice;
	private JTextField txtfOverhead;
	
	public OrganizingGUI() {
		WidgetViewerV2 window = new WidgetViewerV2(1000, 375, true, Color.LIGHT_GRAY, "TRAPSCalendar Program");
		
		ButtonEvent action = new ButtonEvent();
		
		btnSortDate = new JButton("Sort by date");
		btnSortProfit = new JButton("Sort by profit");
		btnReset = new JButton("Reset Calender");
		btnCreate = new JButton("Add Event");						//Stuff is made
		btnSell = new JButton("Sell tickets");
		
		lblTicketsSold = new JLabel("Tickets to Sell:");
		lblEventName = new JLabel("Event to Sell to:");
		lblResponse = new JLabel("Welcome to the TRAPSCalendar Program!");
		
		txtfTicketsSold = new JTextField();
		txtfEventName = new JTextField();
		
		txtaEventCalendar = new JTextArea();
		
		lblEventName1 = new JLabel("Event Name: (Required)");		//Event Labels
		lblEventVenue = new JLabel("Event Venue: (Required)");
		lblVenueCapacity = new JLabel("Event Venue Capacity:");
		lblEventDate = new JLabel("Event Date:");
		lblInitTicketsSold = new JLabel("Tickets Sold:");
		lblTicketPrice = new JLabel("Ticket Price:");
		lblOverhead = new JLabel("Overhead Costs:");
		
		txtfEventName1 = new JTextField();							//Event TextFields
		txtfEventVenue = new JTextField();
		txtfVenueCapacity = new JTextField();
		txtfEventDate = new JTextField();
		txtfInitTicketsSold = new JTextField();
		txtfTicketPrice = new JTextField();
		txtfOverhead = new JTextField();
		
		btnSortDate.addActionListener(action);						//Buttons given action listeners
		btnSortProfit.addActionListener(action);
		btnReset.addActionListener(action);
		btnCreate.addActionListener(action);
		btnSell.addActionListener(action);
		
		window.add(txtaEventCalendar, 10, 10, 965, 180);			//All the stuff is added
		window.add(lblEventName, 10, 200, 110, 20);
		window.add(txtfEventName, 100, 200, 150, 20);
		window.add(lblTicketsSold, 10, 230, 100, 20);
		window.add(txtfTicketsSold, 100, 230, 50, 20);
		window.add(btnSortDate, 445, 200, 170, 20);
		window.add(btnSortProfit, 625, 200, 170, 20);
		window.add(btnSell, 265, 200, 170, 20);
		window.add(btnCreate, 850, 310, 125, 20);
		window.add(btnReset, 805, 200, 170, 20);
		window.add(lblResponse, 155, 230, 820, 20);
		
		window.add(lblEventName1, 10, 260, 140, 20);				//Event creating labels
		window.add(lblEventVenue, 150, 260, 140, 20);
		window.add(lblVenueCapacity, 290, 260, 140, 20);
		window.add(lblEventDate, 430, 260, 140, 20);
		window.add(lblInitTicketsSold, 570, 260, 140, 20);
		window.add(lblTicketPrice, 710, 260, 140, 20);
		window.add(lblOverhead, 850, 260, 140, 20);
		
		window.add(txtfEventName1, 10, 280, 130, 20);				//Event creating textFields
		window.add(txtfEventVenue, 150, 280, 130, 20);
		window.add(txtfVenueCapacity, 290, 280, 130, 20);
		window.add(txtfEventDate, 430, 280, 130, 20);
		window.add(txtfInitTicketsSold, 570, 280, 130, 20);
		window.add(txtfTicketPrice, 710, 280, 130, 20);
		window.add(txtfOverhead, 850, 280, 125, 20);

		txtaEventCalendar.setEditable(false);						//Stops user from changing calendar
		
		calendar = new TRAPSCalendar();								//Initializes calendar object
	}
	
	class ButtonEvent extends WidgetViewerActionEvent {
		@Override
		public void actionPerformed(ActionEvent e) {				//Sort by date
			if (e.getSource() == btnSortDate) {
				refreshCalendar(calendar.sortByDate());
			}
			else if (e.getSource() == btnSortProfit) {				//Sort by profit
				refreshCalendar(calendar.sortByProfit());
			}
			else if (e.getSource() == btnReset) {					//Sort by order entered
				refreshCalendar(calendar.list());
			}
			else if (e.getSource() == btnSell) {					//Sells tickets
				if (isNumeric(txtfTicketsSold.getText())) {			//Makes sure the input is an integer
					if (calendar.get(txtfEventName.getText()) != null) {		//Makes sure there's an event that matches
						if (calendar.get(txtfEventName.getText()).sellTickets(Integer.parseInt(txtfTicketsSold.getText()))) {		//Checks if tickets are sold and does so
							lblResponse.setText("Tickets successfully sold!");
							refreshCalendar(calendar.list());
							txtfEventName.setText("");
							txtfTicketsSold.setText("");						//Resets TextFields
						} else
							lblResponse.setText("Sorry! You cannot sell that many tickets!");		//Too many tickets sold
					} else
						lblResponse.setText("Sorry, that event does not exist! Check your spelling or make an event.");		//No matched event name
				} else
					lblResponse.setText("Sorry, please enter a valid integer to sell tickets.");							//No integer entered
			}
			else if (e.getSource() == btnCreate) {					//Creating an event
				if (!txtfEventName1.getText().isEmpty() && !txtfEventVenue.getText().isEmpty()) { //Checks if both Event Name and Venue are filled as a minimum
					
					if (!isNumeric(txtfVenueCapacity.getText()))		//Checks if valid information was input, otherwise converts to default null values
						txtfVenueCapacity.setText("0");
					if (!isNumeric(txtfEventDate.getText()))
						txtfEventDate.setText("");
					if (!isNumeric(txtfInitTicketsSold.getText()))
						txtfInitTicketsSold.setText("0");
					if (!isNumeric(txtfTicketPrice.getText()))
						txtfTicketPrice.setText("0");
					if (!isNumeric(txtfOverhead.getText()))
						txtfOverhead.setText("0");								//Creates event and adds to calendar
					calendar.add(new Event(txtfEventName1.getText(), txtfEventVenue.getText(), Integer.parseInt(txtfVenueCapacity.getText()), txtfEventDate.getText(), Integer.parseInt(txtfInitTicketsSold.getText()), Integer.parseInt(txtfTicketPrice.getText()), Integer.parseInt(txtfOverhead.getText())));
					refreshCalendar(calendar.list());
					
					txtfEventName1.setText("");									//Resets TextFields
					txtfEventVenue.setText("");
					txtfVenueCapacity.setText("");
					txtfEventDate.setText("");
					txtfInitTicketsSold.setText("");
					txtfTicketPrice.setText("");
					txtfOverhead.setText("");
				} else
					lblResponse.setText("Sorry, you need to enter both an Event Name and Venue at minimum!");		//User didn't enter at least Event Name and Venue
			}
		}
	}
	
	public void refreshCalendar(ArrayList<Event> calendar) {		//Custom function that refreshes the TextArea based on the input
		txtaEventCalendar.setText("");
		for (Event e : calendar) {
			txtaEventCalendar.append(e.toString() + "\n");
		}
	}
	
	public boolean isNumeric(String s) {		//Custom function to check if inputs are valid numbers and not empty
		if (s.isEmpty()) return false;
		for (char c : s.toCharArray()) {		//Checks each individual character
			if (!Character.isDigit(c)) return false;
		}
		return true;
	}
}
