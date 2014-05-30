import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Window extends JFrame {
	private static final long serialVersionUID = -2544001418764869760L;
	public static ArrayList<ArrayList<DataOfSquare>> Grid;
	public static int width = 40;
	public static int height = 40;

	private JButton jbReset;
	private JPanel contentPanel;
	private ThreadsController threadControl;

	public Window() {

		// Creates the arraylist that'll contain the threads
		Grid = new ArrayList<ArrayList<DataOfSquare>>();
		ArrayList<DataOfSquare> data;

		// Creates Threads and its data and adds it to the arrayList
		for (int i = 0; i < width; i++) {
			data = new ArrayList<DataOfSquare>();
			for (int j = 0; j < height; j++) {
				DataOfSquare c = new DataOfSquare(SquareStatus.EMPTY);
				data.add(c);
			}
			Grid.add(data);
		}
		// Adding components to the frame
		JPanel shellPanel = new JPanel();
		jbReset = new JButton("New Game");
		jbReset.setPreferredSize(new Dimension(100,100));
		contentPanel = new JPanel();
		// Setting ActionListeners
		jbReset.addActionListener(new NewGameListener());
		// Setting up the layout of the panel
	
		contentPanel.setLayout(new GridLayout(40, 40, 0, 0));
		shellPanel.add(contentPanel);
		
		// Start & pauses all threads, then adds every square of each thread to
		// the panel
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				contentPanel.add(Grid.get(i).get(j).getSquare());
			}
		}
		shellPanel.add(jbReset);
		add(shellPanel);
		// initial position of the snake
		Tuple position = new Tuple(10, 10);
		// passing this value to the controller
		threadControl = new ThreadsController(position);
		// Let's start the game now..
		threadControl.start();

		// Links the window to the keyboardlistenner.
		contentPanel.setFocusable(true);
		contentPanel.addKeyListener((KeyListener) new KeyboardListener());

		// To do : handle multiplayers .. The above works, test it and see what
		// happens

		// Tuple position2 = new Tuple(13,13);
		// ControlleurThreads c2 = new ControlleurThreads(position2);
		// c2.start();

	}
	private class NewGameListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			contentPanel.requestFocus();
			//threadControl = new ThreadsController(new Tuple(10,10));
			// Let's start the game now..
			
				threadControl.restart();
				
			
			
		}
		
	}
}
