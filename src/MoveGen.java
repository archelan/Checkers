
public class MoveGen {
	public static Move gen(Position start, Position end, int color){
		Move move = new Move(start, end, color);
		if (!Utils.isInBoard(move.start) || !Utils.isInBoard(move.end)) return null;
		if (Math.abs(move.getXDiff()) != Math.abs(move.getYDiff())) return null;
		return move;
	}
	public static Move gen(int x1, int y1, int x2, int y2, int color){
		return gen(new Position(x1,y1), new Position(x2,y2), color);
	}
}