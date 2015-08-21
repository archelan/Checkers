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
					c = new Check(1);
				else if (pos.isSecondStartPos())
					c = new Check(2);
				checks.add(c);
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
	
	public boolean isLegalMove(Move move){
		return move.isLegal();
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
	}
	
	private void moveCheck(Move move){
		getCheck(move.start).move(move.end);			
		field[move.end.x][move.end.y].check = getCheck(move.start);
		removeCheck(move.start);		
	}

}
