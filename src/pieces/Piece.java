package pieces;

import java.util.LinkedList;

public class Piece {
	
	int xp;
	int yp;
	boolean isWhite;
	LinkedList<Piece> ps;
	
	public Piece(int xp, int yp, boolean isWhite, LinkedList<Piece> ps) {
		this.xp = xp;
		this.yp = yp;
		this.isWhite = isWhite;
		this.ps = ps;
		ps.add(this);
	}
	
	public void move(int xp, int yp) {
		for(Piece p: ps) {
			if(p.xp==xp&&p.yp==yp) {
				p.kill();
			}
		}
		this.xp=xp;
		this.yp=yp;
	}
	
	public void kill() {
		ps.remove(this);
	}
	
	public String getName() {
		return null;
	}
	
	public boolean white() {
		return this.isWhite;
	}
	
	public int getX() {
		return this.xp;
	}
	
	public int getY() {
		return this.yp;
	}
}
