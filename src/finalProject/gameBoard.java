package finalProject;

import java.awt.Font;

import sedgewick.StdDraw;

public class gameBoard {
	
	private int score;
	
	public gameBoard() {
		this.score = 0;
	}

	
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
		StdDraw.text(10, 10, "Play");
	}
	
	public void drawBoard() {
		
		StdDraw.setPenColor(StdDraw.BLACK);
		//Main Square
		StdDraw.rectangle(10, 10, 5, 10);
		
		//Hold Block Square
		StdDraw.rectangle(2.5, 18, 2.5, 3);
		
		//Instructions and Controls
		StdDraw.rectangle(1.45, 8, 3, 4);
		Font title = new Font("Arial",Font.CENTER_BASELINE,25);
		StdDraw.setFont(title);
		StdDraw.text(1.45, 11.3, "Instructions");
		Font instructions = new Font("Arial",Font.CENTER_BASELINE,13);
		StdDraw.setFont(instructions);
		StdDraw.text(1.45, 10.55, "Move the pieces to the bottom.");
		StdDraw.text(1.45, 9.95, "When a line is full it is cleared.");
		StdDraw.text(1.45, 9.35, "Reach the top & the game is over.");
		StdDraw.setFont(title);
		StdDraw.text(1.45, 8.05, "Controls");
		Font controls = new Font("Arial",Font.CENTER_BASELINE,15);
		StdDraw.setFont(controls);
		StdDraw.text(1.45, 7.25, "Move: Left/Right Arrow Keys");
		StdDraw.text(1.45, 6.5, "Fast Drop: Up Arrow Key");
		StdDraw.text(1.45, 5.75, "Rotate: Space Bar");
		StdDraw.text(1.45, 5, "Hold/Replace a Block: Z");

		
		//Next Block Square
		StdDraw.rectangle(16.5, 15, 1.5, 5);
		Font subtitle = new Font("Arial",Font.CENTER_BASELINE,30);
		StdDraw.setFont(subtitle);
		StdDraw.text(16.5, 5, "Pause"); 
		
		//Score and Number
		StdDraw.setFont(new Font("Arial",Font.CENTER_BASELINE,25));
		StdDraw.text(16.5 , 9.2, "Score");
		StdDraw.text(16.5 , 8.9, "----------");
		StdDraw.text(16.5, 8.2, String.valueOf(this.score));
	}

	public void pauseScreen() {
		System.out.println("draw pause");
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.rectangle(10, 10, 5, 10);
		Font titleFont = new Font("Arial",Font.BOLD,70);
		Font subtitle = new Font("Arial",Font.CENTER_BASELINE,30);
		StdDraw.setFont(titleFont);
		StdDraw.text(10, 15, "Pause");
		StdDraw.setFont(subtitle);
		StdDraw.text(10, 13, "Resume");
		StdDraw.text(10, 11, "Tutorial");
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

	public int getScore() {
		return this.score;
	}
	
	public void setScore(int val) {
		this.score = val;
	}
	
	public void addToScore(int val) {
		this.score += val;
	}
}
