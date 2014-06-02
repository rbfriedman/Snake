import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_6:
			// if it's not the opposite direction
			if (ThreadsController.directionSnake != 2)
				ThreadsController.directionSnake = 1;
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_8:
			if (ThreadsController.directionSnake != 4)
				ThreadsController.directionSnake = 3;
			break;

		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_4:

			if (ThreadsController.directionSnake != 1)
				ThreadsController.directionSnake = 2;
			break;

		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_2:
			if (ThreadsController.directionSnake != 3)
				ThreadsController.directionSnake = 4;
			break;
		case KeyEvent.VK_ESCAPE:

		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
