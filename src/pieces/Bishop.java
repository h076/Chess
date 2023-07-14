package pieces;

import java.util.LinkedList;

public class Bishop extends Piece{
	
	String name;

	public Bishop(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Bishop";
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
}
