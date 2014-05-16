import java.util.ArrayList;
import java.awt.Color;

public class DataOfSquare {

	
	//ArrayList that'll Contain the Colors
	private ArrayList<Color> listOfColors =new ArrayList<Color>();
	private int color; //2: snake , 1: food, 0:empty 
	private SquarePanel square;
	public DataOfSquare(int col){
		
		//Lets add the Color to the arrayList
		listOfColors.add(Color.DARK_GRAY);//0
		listOfColors.add(Color.BLUE);    //1
		listOfColors.add(Color.white);   //2
		color=col;
		square = new SquarePanel(listOfColors.get(color));
	}
	public void lightMeUp(int c){
		square.ChangeColor(listOfColors.get(c));
	}
	public SquarePanel getSquare(){
		return square;
	}
}
