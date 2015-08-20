
public class Check {
	private final int color;
	private Position pos;//TODO really weird
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
		if (color == 1 && Utils.isTopRow(pos)) makeQueen();
		if (color == 2 && Utils.isBottomRow(pos)) makeQueen();				
	}
}
