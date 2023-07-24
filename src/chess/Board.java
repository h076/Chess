package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import pieces.Piece;

public class Board extends JPanel {
	
	private static final int DIM_WIDTH = 512;
	private static final int DIM_HEIGHT = 512;
	private static final int SQ_SIZE = 64;
	
	boolean white = true;
	Image imgs[] = new Image[12];
	LinkedList<Piece> ps;
	Boolean invert;
	
	public Board(LinkedList<Piece> ps, Boolean invert) {
		this.ps = ps;
		this.invert = invert;
		
		// Cut and save piece images from png.
		BufferedImage all = null;
		try {
			all = ImageIO.read(new File("/home/harryub/Documents/Java/Chess/src/chess.png"));
		} catch (IOException e) {
			System.out.println("Failed to load icons");
			e.printStackTrace();
		}
		
		// Store all sub-images in image array.
		int ind=0;
		for(int y=0; y<400; y+=200) {
			for(int x=0; x<1200; x+=200) {
				imgs[ind++] = all.getSubimage(x, y, 200, 200).getScaledInstance(64,  64,  BufferedImage.SCALE_SMOOTH);
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Paint board using dimensions and square size.
		for(int i=0; i<DIM_HEIGHT; i+=SQ_SIZE) {
			if(white) {
				white=!white;
			} else {
				white=!white;
			}
			for(int j=0; j<DIM_WIDTH; j+=SQ_SIZE) {
				if(white) {
					g.setColor(Color.green);
					g.fillRect(j,  i, SQ_SIZE, SQ_SIZE);
					white=!white;
				} else {
					g.setColor(Color.white);
					g.fillRect(j, i, SQ_SIZE, SQ_SIZE);
					white=!white;
				}
			}
		}
		
		// Loop through Pieces linked list ps.
		// Each piece name is compared in the conditional statements,
		// an index is given for p which corresponds to its image in imgs array.
		// Each piece is then drawn onto the board using g.drawImage.
		for(Piece p : ps) {
			int ind = 0;
			if(p.getName()=="King") {
				ind=0;
			}
			if(p.getName()=="Queen") {
				ind=1;
			}
			if(p.getName()=="Bishop") {
				ind=2;
			}
			if(p.getName()=="Knight") {
				ind=3;
			}
			if(p.getName()=="Rook") {
				ind=4;
			}
			if(p.getName()=="Pawn") {
				ind=5;
			}
			if(!p.white()) {
				ind+=6;
			}
			
			// If the board is inverted (black player) then the pieces Y Board position is inverted.
			if(invert) {
				int y=p.getYp();
				switch(y) {
					case 0:
						y=7;
						break;
					case 7:
						y=0;
						break;
					case 1:
						y=6;
						break;
					case 6:
						y=1;
						break;
					case 2:
						y=5;
						break;
					case 5:
						y=2;
						break;
					case 3:
						y=4;
						break;
					case 4:
						y=3;
						break;
				}
				
				// This condition will catch out a piece that is being moved by the player.
				if(p.getY()%64 != 0) {
					// If a piece is currently being moved then we cannot just invert its Y board position,
					// instead we will get its true Y co-ordinate and invert this to follow the mouse.
					g.drawImage(imgs[ind], p.getX(), Model.invertY(p.getY()), this);
				}else {
					g.drawImage(imgs[ind], p.getX(), y*64, this);
				}
			}else {
				g.drawImage(imgs[ind], p.getX(), p.getY(), this);
			}
			
		}
	}
	
	public Dimension getPreferredSize() {return new Dimension(DIM_WIDTH, DIM_HEIGHT);}
	public Boolean isInverted() {return invert;}
}
