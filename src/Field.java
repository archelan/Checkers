
public class Field {
	Check check = null;
	Position pos;
	
	public Field(Position pos, Check check) {
		this.pos = pos;
		this.check = check;
	}

	boolean isWhite(){
		return Utils.isWhiteField(pos); 
	}
	
	boolean isBlack(){
		return Utils.isBlackField(pos);
	}
}
