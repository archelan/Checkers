
public class Move {
	final Position start, end;
	final int color;
	final Board board;
	Move(Move move){
		this.board = move.board;
		this.color = move.color;
		this.start = move.start;
		this.end = move.end;
	}
	@Deprecated
	Move(Position start, Position end, int color, Board board){
		this.board = board;
		this.color = color;
		this.start = start;
		this.end = end;
	}
	@Deprecated
	Move(int x1, int y1, int x2, int y2, int color, Board board){
		this.board = board;
		this.color = color;
		this.start = new Position(x1, y1);
		this.end = new Position(x2, y2);
	}
	int getYDiff(){
		return end.y - start.y;
	}
	int getXDiff(){
		return end.x - start.x;
	}
	@Override
	public String toString() {
		return start.toString()+end.toString()+"("+ color + ")";
	}
	
	private boolean isPartiallyCorrect(){
		Check check = board.getCheck(start);
		if (check == null) return false;
		if (check.getColor() != color) return false;
		if (board.getCheck(end) != null) return false;
		return true;
	}
	
	public boolean isLegal(){
		return isRegular() || isCapture();
	}
	
	public boolean isRegular(){
		if (!isPartiallyCorrect()) return false;
		Check check = board.getCheck(start);
		if (check.isQueen()) {
			System.out.println("Can't move Queens yet, sorry(");
			return false;
		} else {			
			if (getYDiff() == Utils.getRightDirection(color)){
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean isCapture(){
		return getPosToCapture() == null ? false : true;
	}
	
	public Position getPosToCapture(){
		if (!isPartiallyCorrect()) return null;
		if (Math.abs(getYDiff()) == 2){
			Position posToCapture = new Position((start.x+end.x)/2, 
											(start.y+end.y)/2);
			Check checkToCapture = board.getCheck(posToCapture);
			if (checkToCapture != null &&
				checkToCapture.getColor() != color) {
				return posToCapture;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
