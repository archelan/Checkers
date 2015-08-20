import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReplayWatcher {
	static void start(){
		Board board = new Board();
		BoardDrawer.drawBoard(board);
		int color = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
        	while (true) {
        		Move move = ConsoleUtils.stringToMove(br.readLine(), color);
        		if (move != null && board.tryMakeMove(move)) {
        			Utils.invertColor(color);
        			continue;
        		} else {
        			System.exit(0);
        		}
        	}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
