import java.awt.Color;
import java.util.HashMap;

public class DataOfSquare {

	
	//Arraymap that'll Contain the Colors
	private HashMap<SquareStatus,Color> mapOfColors = new HashMap<SquareStatus,Color>();
	
	private SquarePanel square;
	public DataOfSquare(SquareStatus s){
		
		//Lets add the Color to the arraymap
		mapOfColors.put(SquareStatus.EMPTY, Color.WHITE);//0
		mapOfColors.put(SquareStatus.FOOD,Color.BLUE);    //1
		mapOfColors.put(SquareStatus.SNAKE,Color.DARK_GRAY);   //2
		
		square = new SquarePanel(mapOfColors.get(s));
	}
	public void changeStatus(SquareStatus s){
		square.ChangeColor(mapOfColors.get(s));
	}
	public SquarePanel getSquare(){
		return square;
	}
}
