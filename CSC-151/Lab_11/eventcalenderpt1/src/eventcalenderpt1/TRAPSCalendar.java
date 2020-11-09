//////////////////////////////////////////////////////////////////////////
// Filename: TRAPSCalendar.java                               			//
// Date: November 8, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Creates a list of events and uses methods to manage it		//
//////////////////////////////////////////////////////////////////////////

package eventcalenderpt1;

import java.util.ArrayList;

public class TRAPSCalendar {
	private ArrayList<Event> calendar;		//Holds list of events
	
	public TRAPSCalendar() {
		calendar = new ArrayList<Event>();		//Constructor
	}
	
	public boolean add(Event evt) {				//Adds events to list
		return calendar.add(evt);
	}
	
	public Event get(int i) {					//Gets items from list based on position(in the order they were added)
		return calendar.get(i - 1);
	}
	
	public Event get(String name) {				//Gets specific item from list if event name matches
		for (Event evt : calendar) {
			if (evt.getEventName().equals(name))
				return evt;
		}
		return null;							//Returns null if nothing matches
	}
	
	public int size() {							//Returns size of list
		return calendar.size();
	}
	
	public ArrayList<Event> list() {			//Returns entire list in order the events were added
		return calendar;
	}
}
