package pieces;

import java.util.LinkedList;

public class Queen extends Piece{

	String name;

	public Queen(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Queen";
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
