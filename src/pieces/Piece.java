package pieces;

import java.util.Arrays;
import java.util.LinkedList;

public class Piece {
	
	int xp;
	int yp;
	
	int x;
	int y;
	
	boolean isWhite;
	LinkedList<Piece> ps;
	
	public Piece(int xp, int yp, boolean isWhite, LinkedList<Piece> ps) {
		this.xp = xp;
		this.yp = yp;
		x=xp*64;
		y=yp*64;
		this.isWhite = isWhite;
		this.ps = ps;
		ps.add(this);
	}
	
	public boolean move(int xp, int yp) {
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
			return true;
		}else {
			x=this.xp*64;
			y=this.yp*64;
			return false;
		}
	}
	
	public boolean valid(int xp, int yp) {
		return true;
	}
	
	public Piece isPiece(int x, int y) {
		for(Piece p : ps) {
			if(p.getXp()==x && p.getYp()==y) {
				return p;
			}
		}
		return null;
	}
	
	public Boolean isPieceWhite(int x, int y) {
		for(Piece p : ps) {
			if(p.getXp()==x && p.getYp()==y) {
				if(p.white())
					return true;
			}
		}
		return false;
	}
	
	public Piece checkPath(int [] location, int [] end, int [] direction) {
		location[0] += direction[0];
		location[1] += direction[1];
		while(!Arrays.equals(location, end)) {
			Piece p = isPiece(location[0],location[1]);
			if(p!=null) {
				return p;
			}
			location[0] += direction[0];
			location[1] += direction[1];
		}
		return null;
	}
	
	public void kill() {ps.remove(this);}
	
	public String getName() {return null;}
	public boolean white() {return this.isWhite;}
	
	public int getXp() {return this.xp;}
	public int getYp() {return this.yp;}
	
	public void setXp(int xp) {this.xp=xp;}
	public void setYp(int yp) {this.yp=yp;}
	
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	
	public void setX(int x) {this.x=x;}
	public void setY(int y) {this.y=y;}
	
	public Piece Check(int x, int y) {return null;};
}
