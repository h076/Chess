package pieces;

import java.util.LinkedList;

public class Pawn extends Piece{

	String name;

	public Pawn(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "Pawn";
	}
	
	@Override
	public void move(int xp, int yp) {
		if(valid(xp, yp)) {
			for(Piece p: ps) {
				if(p.getXp()==xp&&p.getYp()==yp) {
					System.out.println("killing "+p.getName());
					p.kill();
					break;
				}
			}
			this.xp=xp;
			this.yp=yp;
			x=xp*64;
			y=yp*64;
			if(isWhite && yp==0)
				promote();
			else if(!isWhite && yp==7)
				promote();
		}else {
			x=this.xp*64;
			y=this.yp*64;
			return;
		}
	}
	
	@Override
	public boolean valid(int xp, int yp) {
		if(this.xp==xp) {
			if((isPiece(this.xp,this.yp-1)==null && isWhite) || (isPiece(this.xp,this.yp+1)==null && !isWhite)) {
				int dif = yp-this.yp;
				if((dif<0 && isWhite) || (dif>0 && !isWhite)) {
					dif = Math.abs(dif);
					if(dif==2 && (this.yp==1 || this.yp==6))
						return true;
					if(dif==1)
						return true;
				}
			}
		}else if((this.xp == xp-1) || (this.xp == xp+1)) {
			int dif = yp-this.yp;
			if((dif<0 && isWhite) || (dif>0 && !isWhite)) {
				dif = Math.abs(dif);
				if((dif==1 && isPiece(xp,yp)!=null) && (isPieceWhite(xp,yp) != isWhite)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void promote() {
		new Queen(this.xp,this.yp,this.isWhite,this.ps);
		this.kill();
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
