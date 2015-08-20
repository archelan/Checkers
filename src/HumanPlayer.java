import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HumanPlayer extends Player{
	HumanPlayer(Board board, int color) {		
		super(board, color);		
		// TODO Auto-generated constructor stub
	}

	@Override
	void makeMove() {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
        	while (true) {
        		Move move = ConsoleUtils.stringToMove(br.readLine(), color);
        		if (move != null && board.tryMakeMove(move)) {        		
        			break;
        		} else {
        			System.out.println("Illegal move.");
        			continue;
        		}
        	}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
