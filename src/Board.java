import java.util.ArrayList;


public class Board {
	private Field field[][];
	private ArrayList<Check> checks = new ArrayList<Check>();
	
	Board(){
		field = new Field[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				Check c = null;
				Position pos = new Position(x, y);
				if (Utils.isFirstStartPos(pos))
					c = new Check(1);
				else if (Utils.isSecondStartPos(pos))
					c = new Check(2);
				checks.add(c);
				field[x][y] = new Field(pos,c);				
			}
		}
	}
			
	public boolean tryMakeMove(Move move){
		Check check = getCheck(move.start);
		if (check == null) return false;
		if (check.getColor() != move.color) return false;
		if (check.isQueen()) {
			System.out.println("Can't move Queens yet, sorry(");
			return false;
		} else {
			int rightDirection = move.color == 1 ? 1 : -1;
			if (getCheck(move.end) != null) return false;
			if (move.getYDiff() == rightDirection){//regular move
				//do nothing
			} else if (Math.abs(move.getYDiff()) == 2){//capture move
				Position posToCapture = new Position((move.start.x+move.end.x)/2, 
												(move.start.y+move.end.y)/2);
				Check checkToCapture = getCheck(posToCapture);
				if (checkToCapture != null &&
					checkToCapture.getColor() != move.color) {
					removeCheck(posToCapture);
					System.out.println(posToCapture + " captured!");
				} else {
					return false;
				}
			} else {
				return false;
			}				
		}
		
		moveCheck(move);
		BoardDrawer.drawBoard(this);
		
		return true;		
	}

	Check getCheck(Position pos){
		return field[pos.x][pos.y].check;
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
