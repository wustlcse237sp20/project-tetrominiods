package finalProject;

import java.awt.Font;

import sedgewick.StdDraw;

public class gameBoard {

	public void setup() {
		//Necessary for drawing board and setting scales
		StdDraw.setCanvasSize(850,850);
		StdDraw.setScale(-1, 20);
	}
	
	public void startScreen() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.rectangle(10, 10, 5, 10);
		Font tetrisFont = new Font("Arial",Font.BOLD,70);
		Font subtitle = new Font("Arial",Font.CENTER_BASELINE,30);
		StdDraw.setFont(tetrisFont);
		StdDraw.text(10, 15, "Tetris");
		StdDraw.setFont(subtitle);
		StdDraw.text(10, 10, "Press Enter to Begin!");
	}
	
	public void drawBoard() {
		
		StdDraw.setPenColor(StdDraw.BLACK);
		//Main Square
		StdDraw.rectangle(10, 10, 5, 10);
		
		//Hold Block Square
		StdDraw.rectangle(3, 18, 2, 2);
		
		//Next Block Square
		StdDraw.rectangle(16.5, 15, 1.5, 5);
	}

	public void pauseScreen() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.rectangle(10, 10, 5, 10);
	}

	public void printLosingScreen() {
		// TODO Auto-generated method stub
		StdDraw.setPenColor(StdDraw.GRAY);
		//Main Square
		StdDraw.filledRectangle(10, 10, 30, 30);
		StdDraw.setPenRadius(10);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(10, 10, "You lose :(");
		StdDraw.show(20);
		StdDraw.pause(4000);
	}

}
