
public class Utils {
	public static boolean isInBoard(Position pos){
		if (pos.x >= 0 && pos.x < 8 && pos.y >= 0 && pos.y < 8)
			return true;
		else
			return false;
	}
	
	public static boolean isTopRow(Position pos){
		if (!isInBoard(pos)) return false;
		if (pos.y == 7)
			return true;
		else
			return false;
	}
	
	public static boolean isBottomRow(Position pos){
		if (!isInBoard(pos)) return false;
		if (pos.y == 0)
			return true;
		else
			return false;
	}
	
	public static boolean isWhiteField(Position pos){
		if (!isInBoard(pos)) return false;
		return (pos.x+pos.y)%2 == 1 ? true : false;
	}
	
	public static boolean isBlackField(Position pos){
		if (!isInBoard(pos)) return false;
		return !isWhiteField(pos);
	}
	
	public static boolean isFirstStartPos(Position pos){
		if (!isInBoard(pos)) return false;
		if (pos.y <= 2 && pos.y >= 0 && isBlackField(pos))
			return true;
		else
			return false;
	}
	
	public static boolean isSecondStartPos(Position pos){
		if (!isInBoard(pos)) return false;
		if (pos.y >= 5 && pos.y <= 7 && isBlackField(pos))
			return true;
		else
			return false;
	}
	
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
}
