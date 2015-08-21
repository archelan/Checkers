
public class Utils {
	public static boolean canMove(Board board, int color){
		//TODO QUEEN
		return true;
	}
	
	public static boolean canCapture(Board board, int color){
		//TODO QUEEN
		return true;
	}
	
	public static int invertColor(int color){
		return color == 1 ? 2 : 1;
	}
	
	static int getRightDirection(int color){
		return color == 1 ? 1 : -1;
	}
}
