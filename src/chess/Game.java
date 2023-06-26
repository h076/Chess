package chess;

public class Game {

	Model model;
	Controller controller;
	View view;
	
	Game() {
		model = new Model();
		controller = new Controller();
		view = new View();
		
		// initialise the game
		model.initialise(view, controller);
		controller.initialise(model, view);
		view.initialise(model, controller);
		
		// start game 
		controller.startup();
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
