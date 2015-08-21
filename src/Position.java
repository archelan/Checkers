
public class Position {
	final int x,y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isInBoard(){
		if (this.x >= 0 && this.x < 8 && this.y >= 0 && this.y < 8)
			return true;
		else
			return false;
	}
	
	public boolean isTopRow(Position this){
		if (!this.isInBoard()) return false;
		if (this.y == 7)
			return true;
		else
			return false;
	}
	
	public boolean isBottomRow(Position this){
		if (!this.isInBoard()) return false;
		if (this.y == 0)
			return true;
		else
			return false;
	}
	
	public boolean isWhiteField(){
		if (!this.isInBoard()) return false;
		return (this.x+this.y)%2 == 1 ? true : false;
	}
	
	public boolean isBlackField(){
		if (!this.isInBoard()) return false;
		return !this.isWhiteField();
	}
	
	public boolean isFirstStartPos(){
		if (!this.isInBoard()) return false;
		if (this.y <= 2 && this.y >= 0 && this.isBlackField())
			return true;
		else
			return false;
	}
	
	public boolean isSecondStartPos(){
		if (!this.isInBoard()) return false;
		if (this.y >= 5 && this.y <= 7 && this.isBlackField())
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return ConsoleUtils.xToLetter(x) + "" + ConsoleUtils.yToNumber(y);
	}

	public boolean isSame(Position pos) {		
		return (this.x == pos.x && this.y == pos.y) ? true : false;
	}
}
