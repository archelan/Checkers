
public class Move {
	final Position start, end;
	final int color;
	@Deprecated
	Move(Position start, Position end, int color){
		this.color = color;
		this.start = start;
		this.end = end;
	}
	@Deprecated
	Move(int x1, int y1, int x2, int y2, int color){
		this.color = color;
		this.start = new Position(x1, y1);
		this.end = new Position(x2, y2);
	}
	int getYDiff(){
		return end.y - start.y;
	}
	int getXDiff(){
		return end.x - start.x;
	}
}
