
public abstract class Player {
	int color;
	Board board;
	
	abstract boolean makeMove();
	Player(Board board, int color){
		this.color = color;
		this.board = board;
	}
}
