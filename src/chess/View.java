package chess;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View {
	Model model;
	Controller controller;
	
	JFrame frame1 = new JFrame();
	JFrame frame2 = new JFrame();
	JLabel header1 = new JLabel();
	JLabel header2 = new JLabel();
	Board board1 = new Board();
	Board board2 = new Board();
	
	public void initialise(Model model, Controller controller) {
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
		
		// pack and set frames to visible
		frame1.pack();
		frame2.pack();
		frame1.setVisible(true);
		frame2.setVisible(true);
	}
	
}
