package eventorganizing;

public class Event {
	private String name;
	private String venue;
	private int venueCapacity;
	private int ticketsSold;
	private double ticketPrice;
	private String eventDate;
	private double overhead;
	
	public Event() {
		name = "";
		venue = "";
		venueCapacity = 0;
		ticketsSold = 0;
		ticketPrice = 0;
		eventDate = "";
		overhead = 0;
	}
	
	public Event(String eventName, String eventVenue) {
		name = eventName;
		venue = eventVenue;
		venueCapacity = 0;
		ticketsSold = 0;
		ticketPrice = 0;
		eventDate = "";
		overhead = 0;
	}
	
	public Event(String eventName, String eventVenue, int venueCapacity, String date, int ticketsSold, int ticketPrice, int overhead) {
		name = eventName;
		venue = eventVenue;
		this.venueCapacity = venueCapacity;
		eventDate = date;
		this.ticketsSold = ticketsSold;
		this.ticketPrice = ticketPrice;
		this.overhead = overhead;
	}
	
	public int compareDate(Event other) {
		if (this.getDate().compareTo(other.getDate()) < 0)
			return -1;
		else if (this.getDate().compareTo(other.getDate()) == 0)
			return 0;
		else
			return 1;
	}
	
	public int compareName(Event other) {
		if (this.getEventName().compareTo(other.getEventName()) < 0)
			return -1;
		else if (this.getEventName().compareTo(other.getEventName()) == 0)
			return 0;
		else
			return 1;
	}
	
	public int compareProfit(Event other) {
		if (this.getProfit() > other.getProfit())
			return -1;
		else if (this.getProfit() == other.getProfit())
			return 0;
		else
			return 1;
	}
	
	public int getBreakEvenPoint() {
		return (int)Math.ceil(overhead / ticketPrice);
	}
	
	public String getDate() {
		return eventDate;
	}
	
	public String getEventName() {
		return name;
	}
	
	public String getEventVenue() {
		return venue;
	}
	
	public int getOverhead() {
		return (int)overhead;
	}
	
	public int getProfit() {
		return (int)(ticketsSold * ticketPrice) - (int)overhead;
	}
	
	public int getTicketPrice() {
		return (int)ticketPrice;
	}
	
	public int getTicketsSold() {
		return ticketsSold;
	}
	
	public int getVenueCapacity() {
		return venueCapacity;
	}
	
	public boolean sellTickets(int numberOfTickets) {
		if (numberOfTickets + ticketsSold > venueCapacity)
			return false;
		else {
			ticketsSold += numberOfTickets;
			return true;
		}
	}
	
	public void setDate(String date) {
		eventDate = date;
	}
	
	public void setEventName(String eventName) {
		name = eventName;
	}
	
	public void setEventVenue(String eventVenue) {
		venue = eventVenue;
	}
	
	public void setOverhead(int overhead) {
		this.overhead = overhead;
	}
	
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public void setTicketsSold(int ticketsSold) {
		this.ticketsSold = ticketsSold;
	}
	
	public void setVenueCapacity(int venueCapacity) {
		this.venueCapacity = venueCapacity;
	}
}
