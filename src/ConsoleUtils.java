import java.io.BufferedReader;


public class ConsoleUtils {
	public static char yToNumber(int y) {
		return (char) ('1' + y);
	}

	public static char xToLetter(int x) {
		return (char) ('a' + x);
	}
	
	public static Move stringToMove(String s, int color, Board board){
		char[] ca = s.toCharArray();//TODO add safety
		if (ca.length != 4) {
			System.out.println("Incorrect move notation. Expect 4 characters like: 'c3d4'.");
			return null;
		}
		//e2e4
		return MoveGen.gen(ca[0]-'a',ca[1]-'1',ca[2]-'a',ca[3]-'1',color,board);
	}

	public static int getInt(BufferedReader br, String str) {
		return getInt(br, Integer.MIN_VALUE, Integer.MAX_VALUE, str);
	}
	
	public static int getInt(BufferedReader br, int l, int r, String str) {
		int x = -1;
		while (true){
			if (str!=null) System.out.println(str);
			String input;
			try {
				input = br.readLine();
				x = Integer.parseInt(input);
			} catch (Exception e) {
				continue;
			}			
			if (x >= l && x <= r) {
				return x;
			} else {
				continue;
			}
		}
		//return x;
	}
}
