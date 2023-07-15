package chess;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.Piece;

public class View {
	Model model;
	
	JFrame frame1 = new JFrame();
	JFrame frame2 = new JFrame();
	JLabel header1 = new JLabel();
	JLabel header2 = new JLabel();
	Board[] bs;
	
	public void initialise(){
		this.model = new Model();
		bs = model.initialise();
		
		JButton resign1 = new JButton("Resign");
		JButton resign2 = new JButton("Resign");
		
		// init frames one and two
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setTitle("Chess - White");
		frame1.getContentPane().setLayout(new BorderLayout());
		frame1.setMinimumSize(new Dimension(400, 500));
		frame1.setLocationRelativeTo(null);
		frame1.add(header1, BorderLayout.NORTH);
		header1.setText("white player - make your move");
		frame1.add(bs[0], BorderLayout.CENTER);
		frame1.add(resign1, BorderLayout.SOUTH);
		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setTitle("Chess - Black");
		frame2.getContentPane().setLayout(new BorderLayout());
		frame2.setMinimumSize(new Dimension(400, 500));
		frame2.setLocationRelativeTo(null);
		frame2.add(header2, BorderLayout.NORTH);
		header2.setText("Black player - Wait to move");
		frame2.add(bs[1], BorderLayout.CENTER);
		frame2.add(resign2, BorderLayout.SOUTH);
				
		// pack and set frames to visible
		frame1.pack();
		frame2.pack();
		frame1.setVisible(true);
		frame2.setVisible(true);
	}
}
