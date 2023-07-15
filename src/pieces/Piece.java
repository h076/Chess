package pieces;

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
	
	public void move(int xp, int yp) {
		for(Piece p: ps) {
			if(p.getXp()==xp&&p.getYp()==yp) {
				p.kill();
			}
		}
		this.xp=xp;
		this.yp=yp;
		x=xp*64;
		y=yp*64;
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
}
