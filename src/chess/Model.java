package chess;

import java.util.LinkedList;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Model {
	
	Controller controller;
	View view;
	LinkedList<Piece> ps = new LinkedList<>();
	
	public void initialise(View view, Controller controller) {
		// set white
		new Rook(7,0,true,ps);
		new Knight(7,1,true,ps);
		new Bishop(7,2,true,ps);
		new Queen(7,3,true,ps);
		new King(7,4,true,ps);
		new Bishop(7,5,true,ps);
		new Knight(7,6,true,ps);
		new Rook(7,7,true,ps);
		
		for(int y=0; y<8; y++)
			new Pawn(6,y,true,ps);
		
		// set black
		new Rook(0,0,false,ps);
		new Knight(0,1,false,ps);
		new Bishop(0,2,false,ps);
		new Queen(0,3,false,ps);
		new King(0,4,false,ps);
		new Bishop(0,5,false,ps);
		new Knight(0,6,false,ps);
		new Rook(0,7,false,ps);
		
		for(int y=0; y<8; y++)
			new Pawn(1,y,false,ps);
	}
	
	public int numOfPieces() {
		return ps.size();
	}
	
	public Piece getPiece(int ind) {
		return ps.get(ind);
	}
}
