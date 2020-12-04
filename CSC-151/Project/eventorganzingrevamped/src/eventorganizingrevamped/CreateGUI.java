package eventorganizingrevamped;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CreateGUI {
	private WidgetViewerV2 window;
	
	private JButton btnAddEvent;
	
	private JLabel lblEventName;
	private JLabel lblEventVenue;
	private JLabel lblVenueCapacity;
	private JLabel lblEventDate;
	private JLabel lblTicketsSold;
	private JLabel lblTicketPrice;
	private JLabel lblOverhead;
	private JLabel lblResponse;
	
	private JTextField txtfEventName;
	private JTextField txtfEventVenue;
	private JTextField txtfVenueCapacity;
	private JTextField txtfEventDate;
	private JTextField txtfTicketsSold;
	private JTextField txtfTicketPrice;
	private JTextField txtfOverhead;
	
	private Event evt0;
	
	public CreateGUI() {
		window = new WidgetViewerV2(280, 320, true, Color.LIGHT_GRAY, "Add Event");
		
		ButtonEvent action = new ButtonEvent();
		
		btnAddEvent = new JButton("Add Event");
		
		lblEventName = new JLabel("Event Name: (Required)");
		lblEventVenue = new JLabel("Event Venue: (Required)");
		lblVenueCapacity = new JLabel("Event Venue Capacity:");
		lblEventDate = new JLabel("Event Date:");
		lblTicketsSold = new JLabel("Tickets Sold:");
		lblTicketPrice = new JLabel("Ticket Price:");
		lblOverhead = new JLabel("Overhead Costs:");
		lblResponse = new JLabel("Welcome to the TRAPSCalendar Program!");
		
		txtfEventName = new JTextField();
		txtfEventVenue = new JTextField();
		txtfVenueCapacity = new JTextField();
		txtfEventDate = new JTextField();
		txtfTicketsSold = new JTextField();
		txtfTicketPrice = new JTextField();
		txtfOverhead = new JTextField();
		
		btnAddEvent.addActionListener(action);
		
		window.add(lblEventName, 10, 10, 135, 20);
		window.add(lblEventVenue, 10, 40, 135, 20);
		window.add(lblVenueCapacity, 10, 70, 130, 20);
		window.add(lblEventDate, 10, 100, 130, 20);
		window.add(lblTicketsSold, 10, 130, 100, 20);
		window.add(lblTicketPrice, 10, 160, 100, 20);
		window.add(lblOverhead, 10, 190, 100, 20);
		window.add(lblResponse, 10, 220, 240, 20);
		
		window.add(txtfEventName, 150, 10, 100, 20);
		window.add(txtfEventVenue, 150, 40, 100, 20);
		window.add(txtfVenueCapacity, 150, 70, 100, 20);
		window.add(txtfEventDate, 150, 100, 100, 20);
		window.add(txtfTicketsSold, 150, 130, 100, 20);
		window.add(txtfTicketPrice, 150, 160, 100, 20);
		window.add(txtfOverhead, 150, 190, 100, 20);
		
		window.add(btnAddEvent, 10, 250, 240, 20);
	}
	
	class ButtonEvent extends WidgetViewerActionEvent {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isNumeric(txtfEventName.getText()) && !txtfEventName.getText().isEmpty()) {
				if (isNumeric(txtfEventVenue.getText()) && !txtfEventVenue.getText().isEmpty()) {
					
				}
			}
			window.close();
		}
	}
	
	public Event getEvent() {
		return evt0;
	}
	
	public JButton getButton() {
		return btnAddEvent;
	}
	
	public boolean isNumeric(String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) return false;
		}
		return true;
	}
}
