import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

class Window extends JFrame implements MouseListener, ActionListener {
	private static final long serialVersionUID = -2544001418764869760L;
	public static ArrayList<ArrayList<DataOfSquare>> Grid;
	public static int width = 40;
	public static int height = 40;

	private JButton jbReset;
	private JPanel contentPanel;
	private ThreadsController threadControl;
	private JPanel shellPanel;
	private CountDownPanel countDownPanel;

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
		shellPanel = new JPanel();
		jbReset = new JButton("New Game");
		jbReset.setPreferredSize(new Dimension(100, 100));
		contentPanel = new JPanel();
		// Setting ActionListeners
		jbReset.addActionListener(this);
		// Setting up the layout of the panel
		// contentPanel.setBackground(Color.pink);
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
		add(shellPanel, BorderLayout.CENTER);
		// initial position of the snake
		Tuple position = new Tuple(10, 10);
		// passing this value to the controller
		threadControl = new ThreadsController(position);

		threadControl.start();

		contentPanel.setFocusable(true);
		contentPanel.addKeyListener((KeyListener) new KeyboardListener());

		jbReset.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		contentPanel.requestFocus();
		contentPanel.revalidate();
		// threadControl = new ThreadsController(new Tuple(10,10));
		// Let's start the game now..
		threadControl.deactivate();

		// TODO Auto-generated method stub
		remove(shellPanel);
		countDownPanel = new CountDownPanel();

		add(countDownPanel);
		repaint();
		// The thread to restart a new game is active and is only visible when
		// the countdownPanel is hidden
		threadControl.restart();
		contentPanel.grabFocus();
		countDownPanel.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				add(shellPanel);
				contentPanel.grabFocus();

			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentShown(ComponentEvent arg0) {

			}

		});

	}
}
