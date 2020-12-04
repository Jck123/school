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

package eventorganizingrevamped;

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
		return calendar.get(i);
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
	
	public ArrayList<Event> sortByProfit() {					//Modified version of SelectionSort code that makes use of the get() and compareProfit() methods
		ArrayList<Event> newCalendar = new ArrayList<Event>();
		
		for (int i = 0; i < calendar.size(); i++) {
			newCalendar.add(calendar.get(i));
		}
		
	    for (int i = 0; i < newCalendar.size(); i++) {
	        // Find the minimum in the newCalendar[i..newCalendar.size()-1]
	        Event currentMin = newCalendar.get(i);
	        int currentMinIndex = i;

	        for (int j = i + 1; j < newCalendar.size(); j++) {
	          if (currentMin.compareProfit(newCalendar.get(j)) > 0) {
	            currentMin = newCalendar.get(j);
	            currentMinIndex = j;
	          }
	        }

	        // Swap newCalendar[i] with newCalendar[currentMinIndex] if necessary;
	        if (currentMinIndex != i) {
	          newCalendar.set(currentMinIndex, newCalendar.get(i));
	          newCalendar.set(i, currentMin);
	        }
	    }
	    return newCalendar;
	}
	
	public ArrayList<Event> sortByDate() {						//Modified version of SelectionSort code that makes use of the get() and compareDate() methods
		ArrayList<Event> newCalendar = new ArrayList<Event>();
		
		for (int i = 0; i < calendar.size(); i++) {
			newCalendar.add(calendar.get(i));
		}
		
	    for (int i = 0; i < newCalendar.size(); i++) {
	        // Find the minimum in the newCalendar[i..newCalendar.size()-1]
	    	Event currentMin = newCalendar.get(i);
	        int currentMinIndex = i;

	        for (int j = i + 1; j < newCalendar.size(); j++) {
	          if (currentMin.compareDate(newCalendar.get(j)) > 0) {
	            currentMin = newCalendar.get(j);
	            currentMinIndex = j;
	          }
	        }

	        // Swap newCalendar[i] with newCalendar[currentMinIndex] if necessary;
	        if (currentMinIndex != i) {
	          newCalendar.set(currentMinIndex, newCalendar.get(i));
	          newCalendar.set(i, currentMin);
	        }
	    }
	    return newCalendar;
	}
}