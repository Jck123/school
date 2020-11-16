import java.util.ArrayList;

/**
 * This is a "sanity check" to see if your TRAPSCalendar class implements 
 * all the proper methods and their signatures.
 * <ul>
 * <li>Put this class in the same src directory as your TRAPSCalendar class.  
 * </li>
 * <li>This class <em>must</em> compile to receive a passing grade for the TRAPSCalendar class
 * </li>
 * <li><em>Don't</em> try to run this class--it does nothing.  This is strictly a compile-time 
 * method name, method signature, constructor signature check.
 * </li>
 * </ul>
 * 
 * @author parks
 *
 */

public class TRAPSCalendarSanityCheck {

    public static void main(String[] args) {
	TRAPSCalendar tc = new TRAPSCalendar();
	boolean b = tc.add(new Event());
	int i = tc.size();
	ArrayList<Event> l = tc.list();	
	
	// comment out the next two lines for the Writing Classes Better lab
	// but don't forget to uncomment them for Object Oriented Thinking	
	l = tc.sortByDate();
	l = tc.sortByProfit();
	
	Event e = tc.get(1);
	e = tc.get("ename");
    }

}
