package up_down;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Superclass for event handlers in WidgetViewer.
 * 
 * @author parks
 *
 */
public class WidgetViewerActionEvent implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String badProgrammer = "your event handler class MUST have a method 'public void actionPerformed(ActionEvent e)' to handle your events";
		System.err.println(badProgrammer);
		throw new MissingOverrideError(badProgrammer);
		
	}
	
	
	/**
	 * Ugly misuse of LinkageError, but I needed an unchecked exception to alert students that their 
	 * WidgetViewerActionEvent subclass needs to have
	 * 
	 * public void actionPerformed(ActionEvent e)
	 * 
	 * method.
	 * 
	 * @author jparks
	 *
	 */
	public static class MissingOverrideError extends LinkageError {

		public MissingOverrideError(String s) {
			super(s);
			// TODO Auto-generated constructor stub
		}
		
	}

}
