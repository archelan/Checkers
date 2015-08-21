import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;


public class MainClass {

	public static void main(String[] args) {
		/*for (char c = 0; c < 255; c++) {
			System.err.print(c);
			System.err.println((int) c);
		}*/
		//System.exit(0);
		String startMessage = "Welcome to Shahki!\nChoose game mode:\n" +
		"1 - two players\n" + "2 - play against bot\n" +
		"3 - Bot match\n" + "9 - game replay\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int gameType = ConsoleUtils.getInt(br, 1, 9, startMessage);
			if (gameType == 9) {
				ReplayWatcher.start();
			} else if (gameType >= 1 && gameType <= 3) {
				Player first = null, second = null;
				Board board = new Board();
				if (gameType == 1) {
					first = new HumanPlayer(board, 1);
					second = new HumanPlayer(board, 2);
				} else if (gameType == 2) {
					int color = ConsoleUtils.getInt(br, 1, 2, "Select your color(1 or 2).");
					Player human = new HumanPlayer(board, color);
					Player bot = new BotPlayer(board, Utils.invertColor(color));
					first = color == 1 ? human : bot;
					second = color == 2 ? human : bot;
				} else if (gameType == 3) {
					first = new BotPlayer(board, 1);
					second = new BotPlayer(board, 2);
				}
				BoardDrawer.drawBoard(board);
				while (first.makeMove() && second.makeMove()) {					
				}
			}
		}

	}

}
