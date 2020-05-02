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
		StdDraw.rectangle(10, 10, 1.5, 1);
		StdDraw.text(10, 10, "Play");
	}
	
	public void drawBoard() {
		
		StdDraw.setPenColor(StdDraw.BLACK);
		//Main Square
		StdDraw.rectangle(10, 10, 5, 10);
		
		//Hold Block Square
		StdDraw.rectangle(3, 18, 2, 2);
		
		//Next Block Square
		StdDraw.rectangle(16.5, 15, 1.5, 5);
		Font subtitle = new Font("Arial",Font.CENTER_BASELINE,30);
		StdDraw.setFont(subtitle);
		StdDraw.rectangle(16.5, 5, 1.35, 1);
		StdDraw.text(16.5, 5, "Pause"); 
	}

	public void pauseScreen() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.rectangle(10, 10, 5, 10);
		Font titleFont = new Font("Arial",Font.BOLD,70);
		Font subtitle = new Font("Arial",Font.CENTER_BASELINE,30);
		StdDraw.setFont(titleFont);
		StdDraw.text(10, 15, "Paused");
		StdDraw.setFont(subtitle);
		StdDraw.rectangle(10, 11, 3, 0.7);
		StdDraw.text(10, 11, "Resume");
		StdDraw.rectangle(10, 9, 4, 0.7);
		StdDraw.text(10, 9, "Quit Game");
		StdDraw.show();
	}
	
	public void resumeScreen() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.rectangle(10, 10, 5, 10);
		Font titleFont = new Font("Arial",Font.BOLD,70);
		StdDraw.setFont(titleFont);
		for (int i=3; i>0; i--){
			StdDraw.rectangle(10, 10, 5, 10);
			StdDraw.text(10, 13, "" + i);
			StdDraw.show(300);
			StdDraw.clear();
			StdDraw.pause(200);
		}
	}

	public void printLosingScreen() { 
		// TODO: add play again button
		StdDraw.setPenColor(StdDraw.GRAY);
		//Main Square
		StdDraw.filledRectangle(10, 10, 30, 30);
		StdDraw.setPenRadius(10);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(10, 10, "You lose :(");
		StdDraw.show(20);
		StdDraw.pause(4000);
	}

	public void quitScreen() { 
		// TODO: add play again button
		StdDraw.setPenColor(StdDraw.GRAY);
		//Main Square
		StdDraw.filledRectangle(10, 10, 30, 30);
		StdDraw.setPenRadius(10);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(10, 10, "Game Ended");
		StdDraw.show(20);
		StdDraw.pause(4000);
	}
}
