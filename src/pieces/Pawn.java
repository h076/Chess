package pieces;

import java.util.LinkedList;

public class Pawn extends Piece{

	String name;

	public Pawn(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Pawn";
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
