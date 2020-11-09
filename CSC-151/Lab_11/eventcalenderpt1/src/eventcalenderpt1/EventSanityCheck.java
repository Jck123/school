/**
 * This is a "sanity check" to see if your Event class implements 
 * all the proper methods and their signatures.
 * <ul>
 * <li>Put this class in the same src directory as your Event class.  
 * </li>
 * <li>This class <em>must</em> compile to receive a passing grade for the Event class
 * </li>
 * <li><em>Don't</em> try to run this class--it does nothing.  This is strictly a compile-time 
 * method name, method signature, constructor signature check.
 * </li>
 * </ul>
 * 
 * @author parks
 *
 */


package eventcalenderpt1;

public class EventSanityCheck {

    public EventSanityCheck() {
	Event e = new Event();
	e = new Event("party", "venue");
	e = new Event("bday2", "bobAndJane2",55, "2019-01-02", 13, 12, 112);
	String s = e.getDate();
	s = e.getEventName();
	s = e.getEventVenue();
	s = e.toString();
	int i = e.compareDate(e);
	i = e.compareName(e);
	i = e.compareProfit(e);
	i = e.getBreakEvenPoint();
	i = e.getOverhead();
	i = e.getProfit();
	i = e.getTicketPrice();
	i = e.getTicketsSold();
	boolean b = e.sellTickets(2);
	e.setDate("2019-01-02");
	e.setEventName("name");
	e.setEventVenue("ven");
	e.setOverhead(2);
	e.setTicketPrice(5);
	e.setTicketsSold(3);
    }
}
