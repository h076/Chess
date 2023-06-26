package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {
	
	private static final int DIM_WIDTH = 512;
	private static final int DIM_HEIGHT = 512;
	private static final int SQ_SIZE = 64;
	
	boolean white = true;
	
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
