package pieces;

import java.util.Arrays;
import java.util.LinkedList;

public class Queen extends Piece{

	String name;
	int [][] directions = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

	public Queen(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Queen";
	}
	
	@Override
	public boolean valid(int xp, int yp) {
		int [] location = {this.xp,this.yp};
		int [] end = {xp,yp};
		int [] dir = {xp-this.xp,yp-this.yp};
		if(dir[0]==0 && dir[1]!=0) {
			dir[1] = dir[1]/Math.abs(dir[1]);
		}else if(dir[1]==0 && dir[0]!=0) {
			dir[0] = dir[0]/Math.abs(dir[0]);
		}else if((Math.abs(dir[0]) != 0) && (Math.abs(dir[1]) != 0 )) {
			dir[0] = dir[0]/Math.abs(dir[0]);
			dir[1] = dir[1]/Math.abs(dir[1]);
		}else
			return false;
		
		for (int [] d : directions) {
			if(Arrays.equals(d, dir)) {
				if(checkPath(location,end,dir)) {
					if(isPiece(xp,yp) && (isPieceWhite(xp,yp) != isWhite))
						return true;
					else if(!isPiece(xp,yp))
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
