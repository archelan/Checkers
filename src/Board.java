import java.util.ArrayList;
import java.util.Random;


public class Board {
	private Field field[][];
	private ArrayList<Check> checks = new ArrayList<Check>();
	
	Board(){
		field = new Field[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				Check c = null;
				Position pos = new Position(x, y);
				if (pos.isFirstStartPos())
					c = new Check(1, this, pos);
				else if (pos.isSecondStartPos())
					c = new Check(2, this, pos);
				if (c!=null) {
					checks.add(c);					
				}
				field[x][y] = new Field(pos,c);
			}
		}
	}
			
	public boolean tryMakeMove(Move move){
		if (move.isRegular()) {
			moveCheck(move);
		} else if (move.isCapture()) {			
			removeCheck(move.getPosToCapture());
			moveCheck(move);
			System.out.println(move.getPosToCapture() + " captured!");
		} else {
			return false;
		}
		BoardDrawer.drawBoard(this);
		return true;		
	}

	Check getCheck(Position pos){
		return field[pos.x][pos.y].check;
	}
	
	Check getRandomCheck(int color){
		Random r = new Random();
		return checks.get(r.nextInt(checks.size()));
	}
	
	private void removeCheck(Position pos){
		field[pos.x][pos.y].check = null;
		checks.removeIf(a -> a.getPos().x == pos.x && a.getPos().y == pos.y);
	}
	
	private void moveCheck(Move move){
		getCheck(move.start).move(move.end);			
		field[move.end.x][move.end.y].check = getCheck(move.start);
		removeCheck(move.start);		
	}

	public ArrayList<Move> possibleMoves(Check check){
		ArrayList<Move> result = possibleRegularMoves();
		result.addAll(possibleCaptureMoves());
		return result;
	}
	
	public ArrayList<Move> possibleRegularMoves(){
		ArrayList<Move> result = new ArrayList<Move>();
		for (Check check: checks){
			result.addAll(check.getPossibleRegularMoves());
		}
		return result;
	}
	
	public ArrayList<Move> possibleCaptureMoves(){
		ArrayList<Move> result = new ArrayList<Move>();
		for (Check check: checks){
			result.addAll(check.getPossibleCaptureMoves());
		}
		return result;
	}
}
