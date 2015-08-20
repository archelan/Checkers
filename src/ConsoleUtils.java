
public class ConsoleUtils {
	public static char yToNumber(int y) {
		return (char) ('1' + y);
	}

	public static char xToLetter(int x) {
		return (char) ('a' + x);
	}
	
	public static Move stringToMove(String s, int color){
		char[] ca = s.toCharArray();//TODO add safety
		if (ca.length != 4) {
			System.out.println("Incorrect move notation. Expect 4 characters like: 'c3d4'.");
			return null;
		}
		//e2e4
		return MoveGen.gen(ca[0]-'a',ca[1]-'1',ca[2]-'a',ca[3]-'1',color);
	}
}
