package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
	
	private static final int DIM_WIDTH = 512;
	private static final int DIM_HEIGHT = 512;
	private static final int SQ_SIZE = 64;
	
	boolean white = true;
	Image imgs[] = new Image[12];
	
	public Board() {
		setLayout(new FlowLayout());
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
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DIM_WIDTH, DIM_HEIGHT);
	}
}
