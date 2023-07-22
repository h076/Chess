package pieces;

import java.util.LinkedList;

public class Pawn extends Piece{

	String name;

	public Pawn(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Pawn";
	}
	
	@Override
	public boolean valid(int xp, int yp) {
		if(this.xp==xp) {
			int dif = yp-this.yp;
			if((dif<0 && isWhite) || (dif>0 && !isWhite)) {
				dif = Math.abs(dif);
				if(dif==2 && (this.yp==1 || this.yp==6))
					return true;
				if(dif==1)
					return true;
			}
		}
		return false;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
