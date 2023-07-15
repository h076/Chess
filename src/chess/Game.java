package chess;

public class Game {

	View view;
	
	Game() {
		view = new View();
		view.initialise();
	}
	
	public static void main(String[] args) {
		new Game();	
	}
}
