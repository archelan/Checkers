
public class Check {
	private final int color;
	private Position pos;//warning is really weird
	private boolean isQueen = false;
	Check(int color){
		this.color = color;
	}
	boolean isQueen(){
		return isQueen;
	}
	int getColor(){
		return color;
	}
	private void makeQueen(){
		isQueen = true;
	}
	void move(Position pos) {		
		this.pos = pos;
		if (color == 1 && pos.isTopRow()) makeQueen();
		if (color == 2 && pos.isBottomRow()) makeQueen();				
	}
	
}
