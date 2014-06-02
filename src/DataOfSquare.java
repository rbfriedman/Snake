import java.awt.Color;
import java.util.HashMap;

public class DataOfSquare {

	private SquarePanel square;

	public DataOfSquare(SquareStatus s) {

		square = new SquarePanel(s);
	}

	public void changeStatus(SquareStatus s) {
		square.ChangeColor(s);
	}

	public SquarePanel getSquare() {
		return square;
	}
}
