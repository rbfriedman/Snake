import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SquarePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private SquareStatus s;
	private Color c;
	public SquarePanel(SquareStatus s){
		this.s = s;
		this.c = s.getColor();
	}
	
	public void ChangeColor(SquareStatus s){
		this.s = s;
		this.c = s.getColor();
		this.repaint();
	}
	public void paintComponent(Graphics g){
		
		g.setColor(c);
		
		g.drawOval(0, 0, getWidth(), getHeight());
	}
	
}

