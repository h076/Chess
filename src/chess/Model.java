package chess;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Model {
	
	View view;
	LinkedList<Piece> ps = new LinkedList<>();
	Board[] bs = new Board[2];
	Piece selectedPiece = null;
	int currentPlayer;
	
	public Board[] initialise() {
		// set white as initial player
		this.currentPlayer = 1;
		
		// set white pieces
		new Rook(0,7,true,ps);
		new Knight(1,7,true,ps);
		new Bishop(2,7,true,ps);
		new Queen(3,7,true,ps);
		new King(4,7,true,ps);
		new Bishop(5,7,true,ps);
		new Knight(6,7,true,ps);
		new Rook(7,7,true,ps);
		
		for(int x=0; x<8; x++)
			new Pawn(x,6,true,ps);
		
		// set black pieces
		new Rook(0,0,false,ps);
		new Knight(1,0,false,ps);
		new Bishop(2,0,false,ps);
		new Queen(3,0,false,ps);
		new King(4,0,false,ps);
		new Bishop(5,0,false,ps);
		new Knight(6,0,false,ps);
		new Rook(7,0,false,ps);
		
		for(int x=0; x<8; x++)
			new Pawn(x,1,false,ps);
		
		//test pieces
		//new Pawn(0,0,false,ps);
		//new Pawn(0,7,true,ps);
		
		//initialise the boards
		bs[0] = new Board(ps, false);
		bs[1] = new Board(ps, true);
		
		for(Board b : bs) {
			b.addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseDragged(MouseEvent e) {
					if(selectedPiece!=null) {
						if(b.isInverted()) {
							selectedPiece.setX(e.getX()-32);
							selectedPiece.setY(e.getY()-32);
						}else {
							selectedPiece.setX(e.getX()-32);
							selectedPiece.setY(e.getY()-32);
						}
						b.repaint();
					}
				}

				@Override
				public void mouseMoved(MouseEvent e) {}
			});
			b.addMouseListener( new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					System.out.println("pressed at "+e.getX()+","+e.getY());
					if(b.isInverted()) {
						selectedPiece = getPiece(e.getX(), invertY(e.getY()));
						System.out.println("selected piece is "+ selectedPiece.getName() +" and is " +selectedPiece.white());
					}else {
						selectedPiece = getPiece(e.getX(), e.getY());
						System.out.println("selected piece is "+ selectedPiece.getName() +" and is " +selectedPiece.white());
					}
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					if(selectedPiece!=null) {
						if(b.isInverted()) {
							System.out.println("moved to postion: "+(e.getX()/64)+","+(e.getY()/64));
							selectedPiece.move(e.getX()/64, invertY(e.getY())/64);
						}else {
							System.out.println("moved to postion: "+(e.getX()/64)+","+(invertY(e.getY())/64));
							selectedPiece.move(e.getX()/64, e.getY()/64);
						}
						bs[0].repaint();
						bs[1].repaint();
					}
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
			});
		}
		return bs;
	}
	
	public Piece getPiece(int x, int y) {
		for(Piece p : ps) {
			if(p.getXp()==(x/64) && p.getYp()==(y/64)) {
				return p;
			}
		}
		return null;
	}
	
	public int invertY(int y) {
		if(isBetween(y,0,63)) {
			y=y+448;
		}else if(isBetween(y,448,511)) {
			y=y-448;
		}else if(isBetween(y,64,127)) {
			y=y+320;
		}else if(isBetween(y,384,447)) {
			y=y-320;
		}else if(isBetween(y,128,191)) {
			y=y+192;
		}else if(isBetween(y,320,383)) {
			y=y-192;
		}else if(isBetween(y,192,255)) {
			y=y+64;
		}else if(isBetween(y,256,319)) {
			y=y-64;
		}
		return y;
	}
	
	public boolean isBetween(int num, int lower, int higher) {
		return lower <= num && num <= higher;
	}
	
	public int numOfPieces() {return ps.size();}
	public Piece getPiece(int ind) {return ps.get(ind);}
}
