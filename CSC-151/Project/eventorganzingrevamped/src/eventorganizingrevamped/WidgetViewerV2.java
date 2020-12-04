package eventorganizingrevamped;

import java.awt.Color;
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

public class WidgetViewerV2 {

	public static final int DEFAULT_X_SIZE = 800;

	public static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;
	public static final int DEFAULT_Y_SIZE = 400;
	private JFrame jframe;
	private JPanel anchor;
	private boolean userClicked = false;
	private Lock lock;
	private Condition waitingForUser;

	private JComponent userInputComponent = null;
	private ActionListener eventHandler;

	public WidgetViewerV2() {
		this(DEFAULT_X_SIZE, DEFAULT_Y_SIZE, true, Color.LIGHT_GRAY,"CSC151 - Java Programming");
	}
	public WidgetViewerV2(int pixelSizeInX, int pixelSizeInY, boolean centered, Color color) {
		this(pixelSizeInX, pixelSizeInY, centered, color,"CSC151 - Java Programming");
	}

	public WidgetViewerV2(int pixelSizeInX, int pixelSizeInY, boolean centered, Color color, String title) {
		lock = new ReentrantLock();
		waitingForUser = lock.newCondition();
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
		if (title == "CSC151 - Java Programming") {
			jframe.setTitle("CSC151 - Java Programming");
		} else {
			jframe.setTitle(title);
		}
		anchor = new JPanel();
		anchor.setLayout(null);

		jframe.setContentPane(anchor);

		jframe.setSize(pixelSizeInX, pixelSizeInY);

		if (centered) {
			jframe.setLocationRelativeTo(null);
		}
		if (color == Color.LIGHT_GRAY) {
			jframe.getContentPane().setBackground(Color.LIGHT_GRAY);
		} else {
			jframe.getContentPane().setBackground(color);
		}

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}

	
	public void clear() {
		anchor.removeAll();
	}
	
	public void add(JComponent jcomp, int x, int y, int w, int h) {
		jcomp.setBounds(x, y, w, h);
		anchor.add(jcomp);
		jframe.setContentPane(anchor);
	}

	public void addAndWait(AbstractButton absButton) {
		userInputComponent = absButton;
		absButton.addActionListener(eventHandler);

		addWait(absButton, absButton.getText().length() + 2);
	}
	public void addAndWait(AbstractButton absButton, int x, int y, int w, int h) {
		userInputComponent = absButton;
		absButton.addActionListener(eventHandler);

		addWait(absButton, x,y,w,h);
	}

	public void addButtonAndWait(String prompt) {
		JButton jb = new JButton(prompt);
		addAndWait(jb);
	}

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
		add(jcomp, 0, 10, guessAtWidth, 20);
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
	private void addWait(JComponent jcomp, int x, int y, int w, int h) {
		add(jcomp, x, y, w, h);
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
	
	public void close() {
		jframe.dispose();
	}
}