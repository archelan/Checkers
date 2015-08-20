import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainClass {

	public static void main(String[] args) {
		/*for (char c = 0; c < 255; c++) {
			System.err.print(c);
			System.err.println((int) c);
		}*/
		//System.exit(0);
		System.out.println("Welcome to Shahki!\nChoose game mode:");
		System.out.println("1 - two players");
		System.out.println("2 - game replay");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				String s = br.readLine();
				if (s.length() == 1) {
					switch (s.charAt(0)){
					case '1': {
						Board board = new Board();		
						Player first = new HumanPlayer(board, 1),
							   second = new HumanPlayer(board, 2);
						
						BoardDrawer.drawBoard(board);
						while (true) {			
							first.makeMove();		
							second.makeMove();
						}
						//break;
					}
					case '2': {
						ReplayWatcher.start();						
						//break;
					}
					}
				}
				System.out.println("Game Over.");
				System.out.println("Choose game mode.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
