//////////////////////////////////////////////////////////////////////////
// Filename: TRAPSCalendarTester.java                               	//
// Date: November 8, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Tests the TRAPSCalendar class and displays results			//
//////////////////////////////////////////////////////////////////////////

package eventcalenderpt1;

public class TRAPSCalendarTester {

	public static void main(String[] args) {
		TRAPSCalendar evtCalendar1 = new TRAPSCalendar();
		
		Event party1 = new Event("Jim's Party", "Jim's House");								//Creates two events
		Event party2 = new Event("Jam's Party", "Jam's House", 150, "20200530", 0, 5, 50);
		
		evtCalendar1.add(party1);														//Adds parties to event list
		evtCalendar1.add(party2);
		
		evtCalendar1.get(1).setDate("20200415");
		evtCalendar1.get(1).setOverhead(200);											//Sets parameters of one party
		evtCalendar1.get("Jim's Party").setTicketPrice(8);								//Makes use of both types of get() method
		evtCalendar1.get("Jim's Party").setVenueCapacity(500);
		
		System.out.println("There are " + evtCalendar1.size() + " events planned\n");	//Testing the size() method
		
		Event p1 = evtCalendar1.list().get(0);											//Testing the list() method
		Event p2 = evtCalendar1.list().get(1);
		
		System.out.println("Event Name: " 			+ 	p1.getEventName() +				//Displays details of both parties
							"\nEvent Location: " 	+ 	p1.getEventVenue() +
							"\nEvent Capacity: " 	+ 	p1.getVenueCapacity() +
							"\nEvent Date: " 		+ 	p1.getDate() +
							"\nOverhead Costs: $" 	+ 	(int)p1.getOverhead() +
							"\nTickets To Sell: " 	+ 	p1.getBreakEvenPoint() +
							"\nTicket Price: $" 	+ 	(int)p1.getTicketPrice() +
							"\nTickets Sold: " 		+ 	p1.getTicketsSold());

		System.out.println("Event Name: " 			+ 	p2.getEventName() +
							"\nEvent Location: " 	+ 	p2.getEventVenue() +
							"\nEvent Capacity: " 	+ 	p2.getVenueCapacity() +
							"\nEvent Date: " 		+ 	p2.getDate() +
							"\nOverhead Costs: $" 	+ 	(int)p2.getOverhead() +
							"\nTickets To Sell: " 	+ 	p2.getBreakEvenPoint() +
							"\nTicket Price: $" 	+ 	(int)p2.getTicketPrice() +
							"\nTickets Sold: " 		+ 	p2.getTicketsSold());

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
