
public class Position {
	final int x,y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return ConsoleUtils.xToLetter(x) + "" + ConsoleUtils.yToNumber(y);
	}
}
