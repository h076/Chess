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
		
		// cut and save piece images
		BufferedImage all = null;
		try {
			all = ImageIO.read(new File("/home/harryub/Documents/Java/Chess/src/chess.png"));
		} catch (IOException e) {
			System.out.println("Failed to load icons");
			e.printStackTrace();
		}
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
			if(invert) {
				g.drawImage(imgs[ind], p.getX(), invertY(p.getY()), this);
				System.out.println(p.getY()+" has been inverted to "+invertY(p.getY()));
			}else {
				g.drawImage(imgs[ind], p.getX(), p.getY(), this);
			}
			
		}
	}
	
	public int invertY(int y) {
		if(y<255)
			y=255+(255-y);
		else if(y>255)
			y=255-(y-255);
		return y;
	}
	
	public boolean isBetween(int num, int lower, int higher) {
		return lower <= num && num <= higher;
	}
	
	public Dimension getPreferredSize() {return new Dimension(DIM_WIDTH, DIM_HEIGHT);}
	public Boolean isInverted() {return invert;}
}
