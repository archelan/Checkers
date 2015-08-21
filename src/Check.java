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
		ArrayList<Move> moves = new ArrayList<Move>();
		if (isQueen) {			
			for (int i = -7; i <= 7; i++) {
				for (int j = -7; j <= 7; j++) {
					moves.add(MoveGen.gen(pos.x, pos.y, 
							pos.x + i, pos.y + j, color, board));
				}
			}
		} else {
			moves.add(MoveGen.gen(pos.x, pos.y,
					pos.x + 1, pos.y + Utils.getRightDirection(color),
					color, board));			
			moves.add(MoveGen.gen(pos.x, pos.y,
					pos.x - 1, pos.y + Utils.getRightDirection(color),
					color, board));			
		}
		moves.forEach(move -> {
			if (move != null && move.isRegular()) result.add(move);
		});
		return result;
	}
	
	public ArrayList<Move> getPossibleCaptureMoves(){
		ArrayList<Move> result = new ArrayList<Move>();
		ArrayList<Move> moves = new ArrayList<Move>();
		if (isQueen) {
			for (int i = -7; i <= 7; i++) {
				for (int j = -7; j <= 7; j++) {
					moves.add(MoveGen.gen(pos.x, pos.y, 
							pos.x + i, pos.y + j, color, board));
				}
			}
		} else {
			moves.add(MoveGen.gen(pos.x, pos.y,
					pos.x + 2, pos.y + 2 * Utils.getRightDirection(color),
					color, board));			
			moves.add(MoveGen.gen(pos.x, pos.y,
					pos.x - 2, pos.y + 2 * Utils.getRightDirection(color),
					color, board));
		}
		moves.forEach(move -> {
			if (move != null && move.isCapture()) result.add(move);
		});
		return result;
	}
	@Override
	public String toString() {		
		return pos.toString() + "(" + color + ")" + (isQueen ? "Q" : "");
	}
}
