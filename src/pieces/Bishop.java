package pieces;

import java.util.Arrays;
import java.util.LinkedList;

public class Bishop extends Piece{
	
	String name;
	int [][] directions = {{1,1},{1,-1},{-1,1},{-1,-1}};

	public Bishop(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Bishop";
	}
	
	@Override
	public boolean valid(int xp, int yp) {
		int [] location = {this.xp,this.yp};
		int [] end = {xp,yp};
		int [] dir = {xp-this.xp,yp-this.yp};
		if((Math.abs(dir[0]) != 0) && (Math.abs(dir[1]) != 0 )) {
			dir[0] = dir[0]/Math.abs(dir[0]);
			dir[1] = dir[1]/Math.abs(dir[1]);
		}else 
			return false;
		
		for (int [] d : directions) {
			if(Arrays.equals(d, dir)) {
				if(checkPath(location,end,dir)==null) {
					if(isPiece(xp,yp) != null && isPieceWhite(xp,yp) != isWhite)
						return true;
					else if(isPiece(xp,yp)==null)
						return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
}
