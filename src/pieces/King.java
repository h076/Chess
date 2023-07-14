package pieces;

import java.util.LinkedList;

public class King extends Piece{
	
	String name;

	public King(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "King";
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
