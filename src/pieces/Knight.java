package pieces;

import java.util.LinkedList;

public class Knight extends Piece{
	
	String name;
	int [][] moves = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}}; 

	public Knight(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Knight";
	}
	
	@Override
	public boolean valid(int xp, int yp) {
		int xdif = xp - this.xp;
		int ydif = yp - this.yp;
		for(int [] m : moves) {
			if(xdif==m[0] && ydif==m[1]) {
				if(isPiece(xp,yp) && (isPieceWhite(xp,yp) != isWhite))
					return true;
				else if(!isPiece(xp,yp))
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
