package chess;

public class testView {
	
	Model model;
	Controller controller;
	View view;
	
	testView() {
		model = new Model();
		controller = new Controller();
		
		view = new View();
		view.initialise(model, controller);
	}

	public static void main(String[] args) {
		new testView();
	}
}
