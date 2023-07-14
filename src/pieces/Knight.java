package pieces;

import java.util.LinkedList;

public class Knight extends Piece{
	
	String name;

	public Knight(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Knight";
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
