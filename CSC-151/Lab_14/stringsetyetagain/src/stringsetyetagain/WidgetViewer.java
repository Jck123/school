package stringsetyetagain;

import java.awt.event.ActionListener;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * A really simple class to display Swing widgets in absolute Layout GUI.
 * <p>
 *
 * @author parks
 */
public class WidgetViewer {

	/**
	 * This is the width of the JFrame if no value is specified on the constructor
	 */
	public static final int DEFAULT_X_SIZE = 800;
	
	/**
	 * This is the height of the JFrame if no value is specified on the constructor
	 */
	public static final int DEFAULT_Y_SIZE = 400;

	private JFrame jframe;
	private JPanel anchor;
	private boolean userClicked = false;

	private Lock lock;
	private Condition waitingForUser;

	private JComponent userInputComponent = null;
	private ActionListener eventHandler;
	
	// last-used positions.  Start with some reasonable assumptions
	private int lastUsedX = 20;
	private int lastUsedY = 20;
	private int lastWidth = 200;
	private int lastHeight = 20;

	/**
	 * Default constructor will display an empty JFrame that has an Absolute layout
	 * JPanel as its content pane and initialize the frame to a default size.
	 */
	public WidgetViewer() {
		this(DEFAULT_X_SIZE, DEFAULT_Y_SIZE);
	}

	/**
	 * Constructor will display an empty JFrame that has an Absolute layout JPanel as its
	 * content pane and initialize the frame to a given size.
	 * 
	 * @param pixelSizeInX The width, in pixels, of this WidgetViewer frame
	 * @param pixelSizeInY The height, in pixels, of this WidgetViewer frame
	 * 
	 */
	public WidgetViewer(int pixelSizeInX, int pixelSizeInY) {
		lock = new ReentrantLock();
		waitingForUser = lock.newCondition();
		// lambda expression requires Java 8
		eventHandler = e -> {
			if (e.getSource() != userInputComponent) {
				return;
			}
			lock.lock();
			userClicked = true;
			waitingForUser.signalAll();
			lock.unlock();
			JComponent jbx = (JComponent) e.getSource();
			anchor.remove(jbx);
		};

		jframe = new JFrame();
		anchor = new JPanel();
		anchor.setLayout(null);
		jframe.setContentPane(anchor);
		jframe.setSize(pixelSizeInX, pixelSizeInY);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}

	/**
	 * Add a Swing widget to the GUI.
	 * GUI coordinates start at the top left corner of the frame, and 
	 * are measured in pixels.
	 * <ul>
	 * <li>x increases horizontally to (to the right)
	 * <li>y increases vertically GOING DOWN.
	 * </ul>
	 *
	 * @param jcomp
	 *            Swing widget (subclasses of JComponent--like JLabel and
	 *            JTextField) to be added to the JFrame
	 * 
	 * @param x the x value of this widget's top left corner
	 * @param y the y value of this widget's top left corner
	 * @param w the width, in pixels, of this widget
	 * @param h the height, in pixels, of this widget
	 */
	public void add(JComponent jcomp, int x, int y, int w, int h) {
		jcomp.setBounds(x, y, w, h);
		anchor.add(jcomp);
		jframe.setContentPane(anchor);
		lastUsedX = x;
		lastUsedY = y;
		lastWidth = w;
		lastHeight = h;
	}
	/**
	 * Add a widget to the frame.  We take a guess at the positioning and size
	 * based on the previously added widget.  If the guess turns out
	 * badly, switch to the other signature for the <em>add</em> method.
	 * 
	 * @param jcomp widget to be added
	 */
	
	public void add(JComponent jcomp) {
		lastUsedY += lastHeight;
		add(jcomp, lastUsedX, lastUsedY, lastWidth, lastHeight);
	}

	/**
	 * Add an Abstract Button (like a JButton) to the JFrame. Create an action
	 * listener to wait (suspend the caller) until it is clicked.
	 *
	 * @param absButton
	 *            Button (like a JButton) to add to the JFrame
	 */
	public void addAndWait(AbstractButton absButton) {
		userInputComponent = absButton;
		absButton.addActionListener(eventHandler);

		addWait(absButton, absButton.getText().length() + 2);
	}

	/**
	 * Convenience method to create a JButton with the given text and use it
	 * in an addAndWait.
	 * 
	 * @param prompt Text for the JButton to display
	 */
	public void addButtonAndWait(String prompt) {
		JButton jb = new JButton(prompt);
		addAndWait(jb);
	}

	/**
	 * Add a JTextField to the JFrame, and wait for the user to put the cursor in
	 * the field and click Enter. The caller is suspended until enter is clicked.
	 *
	 * @param jTextField
	 *            Field to add to the JFrame
	 */
	public void addAndWait(JTextField jTextField) {
		userInputComponent = jTextField;
		jTextField.addActionListener(eventHandler);

		addWait(jTextField, jTextField.getText().length() + 2);
	}

	@SuppressWarnings("unused")
	private void addWait(JComponent jcomp) {
		addWait(jcomp, 5);
	}

	private void addWait(JComponent jcomp, int charWidth) {
		int guessAtWidth = Math.min(charWidth * 10, jframe.getWidth());
		
		// save coordinates so we can restore them
		int savedX = lastUsedX;
		int savedY = lastUsedY;
		int savedHeight = lastHeight;
		int savedWidth = lastWidth;
		
		add(jcomp, 0, 10, guessAtWidth, 20);
		
		// restore
		lastUsedX = savedX;
		lastUsedY = savedY;
		lastHeight = savedHeight;
		lastWidth = savedWidth;
		
		lock.lock();
		try {
			while (!userClicked) {
				waitingForUser.await();
			}
			// we need this to make the just clicked widget disappear in some circumstances
			jframe.setContentPane(anchor);
		} catch (InterruptedException e1) {
			System.err.println("WidgetViewer reports that something really bad just happened");
			e1.printStackTrace();
			System.exit(0);
		}
		userClicked = false;
		waitingForUser.signalAll();
		lock.unlock();
	}
}