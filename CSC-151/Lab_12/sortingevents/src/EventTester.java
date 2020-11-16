//////////////////////////////////////////////////////////////////////////
// Filename: EventTester.java                               			//
// Date: November 1, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Tests the Event class and displays results					//
//////////////////////////////////////////////////////////////////////////

public class EventTester {

	public static void main(String[] args) {
		Event party1 = new Event("Jim's Party", "Jim's House");								//Creates two events
		Event party2 = new Event("Jam's Party", "Jam's House", 150, "20200530", 0, 5, 50);
		
		party1.setDate("20200415");
		party1.setOverhead(200);															//Sets parameters of one party
		party1.setTicketPrice(8);
		party1.setVenueCapacity(500);
		
		System.out.println("Event Name: " 			+ 	party1.getEventName() +				//Displays details of both parties
							"\nEvent Location: " 	+ 	party1.getEventVenue() +
							"\nEvent Capacity: " 	+ 	party1.getVenueCapacity() +
							"\nEvent Date: " 		+ 	party1.getDate() +
							"\nOverhead Costs: $" 	+ 	(int)party1.getOverhead() +
							"\nTickets To Sell: " 	+ 	party1.getBreakEvenPoint() +
							"\nTicket Price: $" 	+ 	(int)party1.getTicketPrice() +
							"\nTickets Sold: " 		+ 	party1.getTicketsSold());
		
		System.out.println("Event Name: " 			+ 	party2.getEventName() +
							"\nEvent Location: " 	+ 	party2.getEventVenue() +
							"\nEvent Capacity: " 	+ 	party2.getVenueCapacity() +
							"\nEvent Date: " 		+ 	party2.getDate() +
							"\nOverhead Costs: $" 	+ 	(int)party2.getOverhead() +
							"\nTickets To Sell: " 	+ 	party2.getBreakEvenPoint() +
							"\nTicket Price: $" 	+ 	(int)party2.getTicketPrice() +
							"\nTickets Sold: " 		+ 	party2.getTicketsSold());
		
		System.out.println("We can sell 50000 tickets to " + party1.getEventName() + ": " + party1.sellTickets(50000));		//Checks sellTickets() is working
		System.out.println("We can sell 50000 tickets to " + party2.getEventName() + ": " + party2.sellTickets(50000));
		System.out.println("We can sell 300 tickets to " + party1.getEventName() + ": " + party1.sellTickets(300));
		System.out.println("We can sell 100 tickets to " + party2.getEventName() + ": " + party2.sellTickets(100));
		
		if (party1.compareName(party2) < 0)
			System.out.println(party1.getEventName() + " comes before " + party2.getEventName() + " alphabetically");		//Checks if Compare methods work properly
		else if (party1.compareName(party2) == 0)
			System.out.println("Both events have the same name");
		else
			System.out.println(party2.getEventName() + " comes before " + party1.getEventName() + " alphabetically");
		
		if (party1.compareDate(party2) < 0)
			System.out.println(party1.getEventName() + " comes before " + party2.getEventName());
		else if (party1.compareDate(party2) == 0)
			System.out.println("Both events are on the same day");
		else
			System.out.println(party2.getEventName() + " comes before " + party1.getEventName());
		
		System.out.println("We've earned $" + party1.getProfit() + " from " + party1.getEventName());						//Checks if get profit is working properly
		System.out.println("We've earned $" + party2.getProfit() + " from " + party2.getEventName());
		
		if (party1.compareProfit(party2) < 0)
			System.out.println("We made more money with " + party1.getEventName() + " than " + party2.getEventName());
		else if (party1.compareProfit(party2) == 0)
			System.out.println("We broke even with both events.");
		else
			System.out.println("We made more money with " + party2.getEventName() + " than " + party1.getEventName());
		
	}

}
