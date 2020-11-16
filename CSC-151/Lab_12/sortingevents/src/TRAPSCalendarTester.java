//////////////////////////////////////////////////////////////////////////
// Filename: TRAPSCalendarTester.java                               	//
// Date: November 15, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Tests the TRAPSCalendar class and displays results			//
//////////////////////////////////////////////////////////////////////////

public class TRAPSCalendarTester {

	public static void main(String[] args) {
		TRAPSCalendar evtCalendar1 = new TRAPSCalendar();
		
		Event party1 = new Event("Jim's Party", "Jim's House");								//Creates five events
		Event party2 = new Event("Jam's Party", "Jam's House", 150, "20200530", 0, 5, 50);
		Event party3 = new Event("Jem's Party", "Jem's House", 150, "20201212", 50, 5, 50);
		Event party4 = new Event("Jom's Party", "Jom's House", 150, "20200324", 75, 5, 50);
		Event party5 = new Event("Jum's Party", "Jum's House", 150, "20200822", 100, 5, 50);
		
		evtCalendar1.add(party1);														//Adds parties to event list
		evtCalendar1.add(party2);
		evtCalendar1.add(party3);
		evtCalendar1.add(party4);
		evtCalendar1.add(party5);
		
		evtCalendar1.get(0).setDate("20200415");
		evtCalendar1.get(0).setOverhead(200);											//Sets parameters of one party
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

		System.out.println("We've earned $" + party1.getProfit() + " from " + party1.getEventName());						//Checks if get profit is working properly
		System.out.println("We've earned $" + party2.getProfit() + " from " + party2.getEventName());
		System.out.println("We've earned $" + party3.getProfit() + " from " + party3.getEventName());
		System.out.println("We've earned $" + party4.getProfit() + " from " + party4.getEventName());
		System.out.println("We've earned $" + party5.getProfit() + " from " + party5.getEventName());
		
		Event topProfit = evtCalendar1.sortByProfit().get(0);				//Keeps code clean
		Event firstEvent = evtCalendar1.sortByDate().get(0);
		
		System.out.println("We've made the most money with " + topProfit.getEventName() + " with $" + topProfit.getProfit());	//Tests new methods sortByProfit() and sortByDate()
		System.out.println("The first event to occur will be " + firstEvent.getEventName() + " on " + firstEvent.getDate());
		System.out.println("The third event added was " + evtCalendar1.get(2).getEventName());									//Confirms that the original eventcalendar was unchanged
	}
}
