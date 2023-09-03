package pieces;

import java.util.LinkedList;

public class King extends Piece{
	
	String name;
	boolean checked = false;
	int [][] straights = {{1,0},{0,1},{-1,0},{0,-1}};
	int [][] diagonals = {{1,1},{1,-1},{-1,1},{-1,-1}};
	int [][] knights = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};

	public King(int xp, int yp, boolean iswhite, LinkedList<Piece> ps) {
		super(xp, yp, iswhite, ps);
		this.name = "King";
	}
	
	@Override
	public Piece Check(int x, int y) {
		Piece p;
		int tempX;
		int tempY;
		
		System.out.println("1");
		// check for pawns
		if(isWhite) {
			p = isPiece(x-1,y-1);
			if(p!=null) {
				if(p.getName()=="Pawn" && p.white()!=isWhite)
					return p;
			}
			p = isPiece(x+1,y-1);
			if(p!=null) {
				if(p.getName()=="Pawn" && p.white()!=isWhite)
					return p;
			}
		}else {
			p = isPiece(x-1,y+1);
			if(p!=null) {
				if(p.getName()=="Pawn" && p.white()!=isWhite)
					return p;
			}
			p = isPiece(x+1,y+1);
			if(p!=null) {
				if(p.getName()=="Pawn" && p.white()!=isWhite)
					return p;
			}
		}
		
		System.out.println("2");
		// check straights for rooks and queen
		for(int [] s : straights) {
			System.out.println("2.1");
			tempX = x+s[0];
			tempY = y+s[1];
			while((-1<tempX && tempX<8) && (-1<tempY && tempY<8)) {
				System.out.println("2.2");
				p = isPiece(tempX,tempY);
				if(p!=null) {
					System.out.println("is piece");
					if(p.getName()=="King" && p.white()==isWhite) {
						tempX += s[0];
						tempY += s[1];
						continue;
					}
					if(p.getName()=="Queen" && p.white()!=isWhite)
						return p;
					if(p.getName()=="Bishop" && p.white()!=isWhite)
						return p;
					break;
				}else {
					System.out.println("isnt piece");
					tempX += s[0];
					tempY += s[1];
				}
			}
		}
		
		System.out.println("3");
		// check diagonals for bishops and queen
		for(int [] d : diagonals) {
			tempX = x+d[0];
			tempY = y+d[1];
			while((-1<tempX && tempX<8) && (-1<tempY && tempY<8)) {
				p = isPiece(tempX,tempY);
				if(p!=null) {
					if(p.getName()=="King" && p.white()==isWhite) {
						tempX += d[0];
						tempY += d[1];
						continue;
					}
					if(p.getName()=="Queen" && p.white()!=isWhite)
						return p;
					if(p.getName()=="Bishop" && p.white()!=isWhite)
						return p;
					break;
				}else {
					tempX += d[0];
					tempY += d[1];
				}
			}	
		}
		
		System.out.println("4");
		// check for knight
		for(int [] k : knights) {
			tempX = x+k[0];
			tempY = y+k[1];
			p = isPiece(tempX,tempY);
			if(p!=null) {
				if(p.getName()=="Knight" && p.white()!=isWhite)
					return p;
			}
		}
		
		return null;
	}
	
	public void setChecked(boolean c) {this.checked=c;} 
	public boolean getChecked() {return this.checked;}
	
	@Override
	public String getName() {
		return this.name;
	}
}
