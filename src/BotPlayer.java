import java.util.ArrayList;
import java.util.Random;


public class BotPlayer extends Player {

	BotPlayer(Board board, int color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean makeMove() {
		ArrayList<Move> moves = board.possibleCaptureMoves();
		if (!moves.isEmpty()) {
			return move(moves);
		} else {
			moves = board.possibleRegularMoves();
			if (!moves.isEmpty()) {
				return move(moves);			
			} else {
				System.out.println("Bot bug. Impossible move");
				System.exit(0);
				return true;
			}
		}
	}

	private boolean move(ArrayList<Move> moves){
		Random rnd = new Random();
		if (!board.tryMakeMove(moves.get(rnd.nextInt(moves.size())))) {
			System.out.println("Bot bug. Impossible move");
			return false;
		}
		return true;
	}
}
