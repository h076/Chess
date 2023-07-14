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
	Controller controller;
	
	JFrame frame1 = new JFrame();
	JFrame frame2 = new JFrame();
	JLabel header1 = new JLabel();
	JLabel header2 = new JLabel();
	Board board1 = new Board();
	Board board2 = new Board();
	
	// Image array
	Image imgs[] = new Image[12];
	
	public void initialise(Model model, Controller controller){
		this.model = model;
		this.controller = controller;
		
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
		frame1.add(board1, BorderLayout.CENTER);
		frame1.add(resign1, BorderLayout.SOUTH);
		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setTitle("Chess - Black");
		frame2.getContentPane().setLayout(new BorderLayout());
		frame2.setMinimumSize(new Dimension(400, 500));
		frame2.setLocationRelativeTo(null);
		frame2.add(header2, BorderLayout.NORTH);
		header2.setText("Black player - Wait to move");
		frame2.add(board2, BorderLayout.CENTER);
		frame2.add(resign2, BorderLayout.SOUTH);
		
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
				
		// pack and set frames to visible
		frame1.pack();
		frame2.pack();
		frame1.setVisible(true);
		frame2.setVisible(true);
	}
	
	public void refresh() {
		int num = model.numOfPieces();
		for(int i=0; i<num; i++) {
			Piece p = model.getPiece(i);
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
			JLabel Icon1 = new JLabel(new ImageIcon(imgs[ind]));
			JLabel Icon2 = new JLabel(new ImageIcon(imgs[ind]));
			board1.add(Icon1);
			board2.add(Icon2);
			Icon1.setBounds(p.getX()*64, p.getY()*64, 64, 64);
			System.out.println("added ind "+ind+", name is ... "+p.getName());
		
		}
		frame1.pack();
		frame2.pack();
	}
	
}
