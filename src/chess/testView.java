package chess;

public class testView {
	
	Model model;
	Controller controller;
	View view;
	
	testView(){
		model = new Model();
		model.initialise(view, controller);
		controller = new Controller();
		
		view = new View();
		view.initialise(model, controller);
		view.refresh();
	}

	public static void main(String[] args){
		new testView();
	}
}
