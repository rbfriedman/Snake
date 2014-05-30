import java.awt.Color;


public enum SquareStatus {
	SNAKE(Color.DARK_GRAY),FOOD(Color.BLUE),EMPTY(Color.WHITE);
	Color c;
	SquareStatus(Color c){
		this.c = c;
	}
	
	Color getColor(){
		return c;
	}
}
