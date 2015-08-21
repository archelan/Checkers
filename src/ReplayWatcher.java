import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReplayWatcher {
	static void start(){
		Board board = new Board();
		BoardDrawer.drawBoard(board);
		int color = 1;
		BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
        try {
        	System.out.println("Provide path to replay:");
        	while (true) {
        		String path = cr.readLine();
        		BufferedReader fr = new BufferedReader(new FileReader(path));
        		while (true) {
        			String s = fr.readLine();
        			if (s == null) return;
            		Move move = ConsoleUtils.stringToMove(s, color, board);
            		if (move != null && board.tryMakeMove(move)) {
            			color = Utils.invertColor(color);
            			continue;
            		} else {
            			System.exit(0);
            		}
            	}        		
        	}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
