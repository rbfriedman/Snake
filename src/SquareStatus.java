import java.awt.Color;


public enum SquareStatus {
	SNAKE(Color.GREEN),FOOD(Color.BLUE),EMPTY(Color.WHITE);
	Color c;
	SquareStatus(Color c){
		this.c = c;
	}
	
	Color getColor(){
		return c;
	}
}
