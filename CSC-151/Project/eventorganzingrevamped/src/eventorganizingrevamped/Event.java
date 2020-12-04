//////////////////////////////////////////////////////////////////////////
// Filename: Event.java                                 				//
// Date: December 2, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Creates the Event class										//
//////////////////////////////////////////////////////////////////////////

package eventorganizingrevamped;

public class Event {
	private String name;			//Name of event
	private String venue;			//Place event will be held at
	private int venueCapacity;		//Maximum tickets we can sell
	private int ticketsSold;		//Tickets already sold
	private double ticketPrice;		//Price of tickets
	private String eventDate;		//Date of event in YYYYMMDD format
	private double overhead;		//Up-front costs to event planners
	
	public Event() {				//Creates empty event object
		name = "";
		venue = "";
		venueCapacity = 0;
		ticketsSold = 0;
		ticketPrice = 0;
		eventDate = "";
		overhead = 0;
	}
	
	public Event(String eventName, String eventVenue) {		//Creates event with only name and place
		name = eventName;
		venue = eventVenue;
		venueCapacity = 0;
		ticketsSold = 0;
		ticketPrice = 0;
		eventDate = "";
		overhead = 0;
	}
	
	public Event(String eventName, String eventVenue, int venueCapacity, String date, int ticketsSold, int ticketPrice, int overhead) {
		name = eventName;			//Creates fully planned out events
		venue = eventVenue;
		this.venueCapacity = venueCapacity;
		eventDate = date;
		this.ticketsSold = ticketsSold;
		this.ticketPrice = ticketPrice;
		this.overhead = overhead;
	}
	
	public int compareDate(Event other) {		//Checks if one event comes before or after the other
		if (this.getDate().compareTo(other.getDate()) < 0)
			return -1;
		else if (this.getDate().compareTo(other.getDate()) == 0)
			return 0;
		else
			return 1;
	}
	
	public int compareName(Event other) {		//Checks which event comes first alphabetically
		if (this.getEventName().compareTo(other.getEventName()) < 0)
			return -1;
		else if (this.getEventName().compareTo(other.getEventName()) == 0)
			return 0;
		else
			return 1;
	}
	
	public int compareProfit(Event other) {		//Compares the amount of money made at each event
		if (this.getProfit() > other.getProfit())
			return -1;
		else if (this.getProfit() == other.getProfit())
			return 0;
		else
			return 1;
	}
	
	public int getBreakEvenPoint() {			//Calculates how many tickets need to be sold at minimum
		return (int)Math.ceil(overhead / ticketPrice);
	}
	
	public String getDate() {					//Returns event date
		return eventDate;
	}
	
	public String getEventName() {				//Returns event name
		return name;
	}
	
	public String getEventVenue() {				//Returns event place
		return venue;
	}
	
	public int getOverhead() {					//Returns up-front costs
		return (int)overhead;
	}
	
	public int getProfit() {					//Calculates and returns profit made with event
		return (int)(ticketsSold * ticketPrice) - (int)overhead;
	}
	
	public int getTicketPrice() {				//Returns ticket prices
		return (int)ticketPrice;
	}
	
	public int getTicketsSold() {				//Returns how many tickets are already sold
		return ticketsSold;
	}
	
	public int getVenueCapacity() {				//Returns max capacity of location
		return venueCapacity;
	}
	
	public boolean sellTickets(int numberOfTickets) {		//Checks if we can sell specified number of tickets
		if (numberOfTickets + ticketsSold > venueCapacity)
			return false;		//Too many tickets sold, denied
		else {
			ticketsSold += numberOfTickets;
			return true;		//We have enough tickets, sold
		}
	}
	
	public void setDate(String date) {		//Sets event date
		eventDate = date;
	}
	
	public void setEventName(String eventName) {	//Sets event name
		name = eventName;
	}
	
	public void setEventVenue(String eventVenue) {	//Sets event place
		venue = eventVenue;
	}
	
	public void setOverhead(int overhead) {			//Sets event up-front costs
		this.overhead = overhead;
	}
	
	public void setTicketPrice(int ticketPrice) {	//Sets ticket price
		this.ticketPrice = ticketPrice;
	}
	
	public void setTicketsSold(int ticketsSold) {	//Sets number of tickets already sold
		this.ticketsSold = ticketsSold;
	}
	
	public void setVenueCapacity(int venueCapacity) {	//Sets capacity of place
		this.venueCapacity = venueCapacity;
	}
	
	@Override
	public String toString() {							//Prints out everything in a readable string
		return "Event " + name + ", Event Date: " + eventDate + ", Event Venue: " + venue + 
				", Venue Capacity: " + venueCapacity + ", Ticket Price: $" + getTicketPrice() + 
				", Tickets Sold: " + ticketsSold + ", Break-even Point: " + getBreakEvenPoint() + 
				", Overhead: " + overhead + ", Profits: $" + getProfit(); 
	}
}
