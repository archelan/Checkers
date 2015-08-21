import java.util.ArrayList;


public class Check {
	private final int color;
	private Position pos;//warning is really weird
	private boolean isQueen = false;
	private Board board;
	Check(int color, Board board, Position pos){
		this.pos = pos;
		this.board = board;
		this.color = color;
	}
	boolean isQueen(){
		return isQueen;
	}
	Position getPos(){
		return pos;
	}
	int getColor(){
		return color;
	}
	private void makeQueen(){
		isQueen = true;
	}
	public void move(Position pos) {		
		this.pos = pos;
		if (color == 1 && pos.isTopRow()) makeQueen();
		if (color == 2 && pos.isBottomRow()) makeQueen();				
	}
	
	public ArrayList<Move> getPossibleRegularMoves(){
		ArrayList<Move> result = new ArrayList<Move>();
		if (isQueen) {
			return result;
		} else {
			Move rightMove = MoveGen.gen(pos.x, pos.y,
					pos.x + 1, pos.y + Utils.getRightDirection(color),
					color, board);			
			Move leftMove = MoveGen.gen(pos.x, pos.y,
					pos.x - 1, pos.y + Utils.getRightDirection(color),
					color, board);
			
			if (rightMove != null && rightMove.isRegular()) result.add(rightMove);
			if (leftMove != null && leftMove.isRegular()) result.add(leftMove);
			return result;
		}
	}
	
	public ArrayList<Move> getPossibleCaptureMoves(){
		ArrayList<Move> result = new ArrayList<Move>();
		if (isQueen) {
			return result;
		} else {
			Move rightMove = MoveGen.gen(pos.x, pos.y,
					pos.x + 2, pos.y + 2 * Utils.getRightDirection(color),
					color, board);			
			Move leftMove = MoveGen.gen(pos.x, pos.y,
					pos.x - 2, pos.y + 2 * Utils.getRightDirection(color),
					color, board);
			
			if (rightMove != null && rightMove.isCapture()) result.add(rightMove);
			if (leftMove != null && leftMove.isCapture()) result.add(leftMove);
			
			return result;
		}
	}
}
