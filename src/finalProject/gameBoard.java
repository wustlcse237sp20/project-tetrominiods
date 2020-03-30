package finalProject;

import sedgewick.StdDraw;

public class gameBoard {

	public void setup() {
		//Necessary for drawing board and setting scales
		StdDraw.setCanvasSize(850,850);
		StdDraw.setScale(-1, 20);
	}
	
	public void drawBoard() {
		//Main Square
		StdDraw.rectangle(10, 10, 5, 10);
		
		//Hold Block Square
		StdDraw.rectangle(3, 18, 2, 2);
		
		//Next Block Square
		StdDraw.rectangle(16.5, 15, 1.5, 5);
	}

}
