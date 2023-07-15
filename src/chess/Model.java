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
		
		//initialise the boards
		bs[0] = new Board(ps, false);
		bs[1] = new Board(ps, true);
		
		for(Board b : bs) {
			b.addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseDragged(MouseEvent e) {
					if(selectedPiece!=null) {
						selectedPiece.setX(e.getX()-32);
						selectedPiece.setY(e.getY()-32);
						b.repaint();
					}
				}

				@Override
				public void mouseMoved(MouseEvent e) {}
			});
			b.addMouseListener( new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					selectedPiece = getPiece(e.getX(), e.getY());
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					selectedPiece.move(e.getX()/64, e.getY()/64);
					b.repaint();
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
	
	public int numOfPieces() {return ps.size();}
	public Piece getPiece(int ind) {return ps.get(ind);}
}
