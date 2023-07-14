package pieces;

import java.util.LinkedList;

public class Rook extends Piece{

	String name;

	public Rook(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Rook";
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
