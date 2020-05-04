package finalProject;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Pieces.Block;
import Pieces.Tetromino;
import Pieces.cubeBlock;
import Pieces.lineBlock;
import Pieces.tBlock;
import Pieces.zBlock;
import Pieces.lBlock;
import Pieces.jBlock;
import Pieces.sBlock;
import sedgewick.StdDraw;



public class tetrisGame {
	
	public static Tetromino currentBlock = createNewPlayerBlock();
	public static Tetromino nextBlock = createNextBlock();
	
	public static ArrayList<Block> allBlocks = new ArrayList<>();

	public static Tetromino holdBlock;
	public static Block [][] gameBoard = new Block[25][10];
	public static Timer timer = timer = new Timer();
	public static gameBoard board = new gameBoard();
	public static int prevScore = 1000;
	public static void main(String [] args) {
		board.setup();
		startMenu();
		board.drawBoard();
		setupKeyboard();
		timer.schedule(new timedBlockMovement(), 0, 1000);
	}

	private static void addBlock(Tetromino t) {
		for(Block b: t.getBlocks()) {
			allBlocks.add(b);
		}
	
	}
	
	public static void startMenu() {
		board.startScreen();
		boolean mouseClick = false;
		while(mouseClick == false) {
			if (StdDraw.mousePressed()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				//If the the start button is clicked, then break out the loop to start the game.
				if(((x >= 9.5) && (x <=10.5)) && ((y >=9.5)&&(y<=10.5))){ //if the click is on the play button
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.text(10, 10, "Play");
					StdDraw.setPenColor();
					StdDraw.pause(100);
					mouseClick = true;
				}
				
			}
		StdDraw.pause(20);
		}
	}
	
	public static void pauseMenu() {
		new gameBoard().pauseScreen();
		boolean mouseClick = false;
		while(mouseClick == false) {
			if (StdDraw.mousePressed()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				//If resume button is clicked
				if(((x >= 9.0) && (x <=11.0)) && ((y >=10.0)&&(y<=12.0))){ //if the click is on the play button
					mouseClick = true;
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.text(10, 11, "Resume");
					StdDraw.setPenColor();
					StdDraw.pause(100);
					resumeScreen();
				}
				//If "quit game" button is clicked
				else if(((x >= 9.0) && (x <=11.0)) && ((y >=8.0)&&(y<=10.0))){ //if the click is on the play button
					mouseClick = true;

					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.text(10, 9, "Quit Game");
					StdDraw.setPenColor();
					StdDraw.pause(100);
					new gameBoard().quitScreen();
					timer.cancel();
					System. exit(0);
				}
				else {
					//do nothing
				}
			}
		StdDraw.pause(20);
		}
	}
	
	public static void resumeScreen() {
		board.resumeScreen();
	}

	private static void setAsObstacle(Tetromino b) {
		for (Block p: b.getBlocks()) {
				gameBoard[(int)p.getY()][(int)p.getX()] = p;
			}
	}
	
	public static boolean collision() {
		for (Block b : currentBlock.getBlocks()) {
			if (b.getY() < 0.5) {
				return true;
			}
			try {
				if (gameBoard[(int)b.getY()][(int)b.getX()] != null) {
					return true;
				}
			}
			catch(Exception ArrayIndexOutOfBoundsException){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Draws the entire game in its current state (should be called per each movement)
	 */
	public static void advanceGame() {
		clearBoard();
		//if the pause button has been clicked, go to pause menu
		if(StdDraw.mousePressed()) {
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			System.out.println(x + " " + y);
			if(((x >= 15.0) && (x <=18.0)) && ((y >=4.0)&&(y<=6.0))){ //if the click is on the play button
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.text(16.5, 5, "Pause"); 
				StdDraw.setPenColor();
				StdDraw.pause(200);
				StdDraw.clear();
				pauseMenu();
			}
		}
		
		if (collision()) {
			startNextTurn();
		}
		redrawGame();
		StdDraw.show(20);
	}

	private static void redrawGame() {
		drawTetromino(currentBlock);
		drawPreview();
		board.drawBoard();
		drawGameBlocks();
		drawUIBlock2(nextBlock);
		
		if (holdBlock != null) {
			drawUIBlock(holdBlock);
		}
	}

	private static void startNextTurn() {
		moveToNextPiece();
		moveToNextPieceQueue();
		checkForLineClear();
	}
	
	private static void checkForLineClear() {
		int linesCleared = 0;
		for (int i =0; i < gameBoard.length; i++) {
			int count=0;
			for (int j = 0; j < gameBoard[0].length; j++) {
				if (gameBoard[i][j] != null) {
					count++;
				}
			}
			if (count >= 10) {
				moveRowsDownFromPos(i);
				i--;  //decrements because we just removed a row
				linesCleared++;
			}
		}
		board.addToScore(linesCleared == 4 ? 600 : linesCleared * 100 );
	}

	private static void moveRowsDownFromPos(int startPos) {
		removeLinesFromGameBoard(startPos);
		removeLinesFromObstacle(startPos);
		
	}

	private static void removeLinesFromObstacle(int startPos) {
		ArrayList<Block> blocksToRemove = new ArrayList<Block>();
		for(Block b: allBlocks) {
			if(b.getY() == (int)startPos) {
				blocksToRemove.add(b);
			
			}
			else if(b.getY()>(int)startPos) {
				b.moveDown();
				if(b.getY() <0.5) {
					blocksToRemove.add(b);
				}
			}
		}
		for (Block b: blocksToRemove){
			allBlocks.remove(b);
		}
	}

	private static void removeLinesFromGameBoard(int startPos) {
		for(int i = startPos+1; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[0].length; j++) {
				gameBoard[i-1][j] = gameBoard[i][j];
			}
		}
	}

	private static void drawUIBlock(Tetromino t) {
		StdDraw.setPenColor(t.getColor());
		for (Block block: t.getBlocks()) {
			StdDraw.square(block.getX() + .1, block.getY() - 0.3, t.getRadius()/2);
		}
		
	}
	
	public static void drawUIBlock2(Tetromino t) {
		StdDraw.setPenColor(t.getColor());
		for (Block block: t.getBlocks()) {
			StdDraw.square(block.getX() + 11, block.getY() - 0.3, t.getRadius()/2);
	}
	}

	private static void drawPreview() {
		int count = 0;
		//Moves down until collision
		while(!collision()) {
			count++;
			currentBlock.moveDown();
		}
		currentBlock.moveUp();
		Color saveColor = currentBlock.getColor();
		Color gray = new Color(202, 207, 204);
		changeBlocksToColor(gray, currentBlock);
		drawTetromino(currentBlock);
		changeBlocksToColor(saveColor, currentBlock);
		
		currentBlock.moveDown();
		
		//Move Back up afterwards
		 for (int i = 0; i < count; i++) {
			 currentBlock.moveUp();
	 }
		
}
	
	private static void changeBlocksToColor(Color c, Tetromino t) {
		for(Block b: t.getBlocks()) {
			b.setColor(c);
		}
		
	}

	private static void moveToNextPiece() {
		currentBlock.moveUp();
		setAsObstacle(currentBlock);
		addBlock(currentBlock);
		currentBlock = createNewPlayerBlock();
		board.addToScore(40);
		if (checkForGameLoss()) {
			endGame();
		}
		
		adjustGameSpeed();
	}

	private static void adjustGameSpeed() {
		if (board.getScore() > prevScore) {
			timer.cancel();
			timer = new Timer();
			timer.schedule(new timedBlockMovement(), 0, 1000 - (board.getScore() / 8));
			redrawGame();
			StdDraw.show(1);
			prevScore += 1000;
		}
		
		
		
		//Score     Time
		//500   -   900
		//1000  - 
		//2000
		//3000
	}

	private static void endGame() {
		board.printLosingScreen();
		timer.cancel();
		System. exit(0);
	}
	
	private static boolean checkForGameLoss() {
		if (collision()) {
			return true;
		}
		return false;
	}

	public static Tetromino createNewPlayerBlock() {
		
		int randIndex = (int)(Math.random() * 7);//gets a random number corresponding to block 
		
		if (randIndex == 0) {
			return new cubeBlock(new Block(5.5,17.5),1);
		}
		
		else if (randIndex == 1) {
			return new lineBlock(new Block(5.5,17.5),1);
		}
		
		else if (randIndex == 2) {
			return new jBlock(new Block(5.5,17.5),1);
		}
		
		else if (randIndex == 3) {
			return new lBlock(new Block(5.5,17.5),1);
		}
				
		else if (randIndex == 4) {
			return new sBlock(new Block(5.5,17.5),1);
		}
				
		else if (randIndex == 5) {
			return new tBlock(new Block(5.5,17.5),1);
		}
				
		else{
			return new zBlock(new Block(5.5,17.5),1);
		}
}
	
	public static Tetromino createNextBlock() {
	int randIndex = (int)(Math.random() * 7);//gets a random number corresponding to block 

			if (randIndex == 0) {
			 return new cubeBlock(new Block(5.5,13),1);  
			}
			else if (randIndex == 1) {
				 return new lineBlock(new Block(5.5,13),1); 
				}
			else if (randIndex == 2) {
				 return new jBlock(new Block(5.5,13),1); 
				}
			else if (randIndex == 3) {
				 return new lBlock(new Block(5.5,13),1); 
				}
			else if (randIndex == 4) {
				 return new sBlock(new Block(5.5,13),1); 
				}
			else if (randIndex == 5) {
				 return new tBlock(new Block(5.5,13),1); 
				}
			else {
				return new zBlock(new Block(5.5, 13),1);
			}

		}

	
	public static void moveToNextPieceQueue() {
	//	currentBlock.moveUp();
		changeBlocksToColor(StdDraw.WHITE, nextBlock);
		nextBlock.moveRight();
		nextBlock.moveDown();
		nextBlock = createNextBlock();
		drawUIBlock2(nextBlock);
	//	board.addToScore(40);
		if (checkForGameLoss()) {
			endGame();
		}
	}
	
	private static void drawTetromino(Tetromino t) {
		for (Block b: t.getBlocks()) {
			drawBlocks(b);
		}
	}
	
	/**
	 * Draws all Tetromino Pieces in the game
	 */
	
	private static void drawGameBlocks() {
		for (Block b: allBlocks) {
			drawBlocks(b);
		}
	}
	
	public static void clearBoard() {
		StdDraw.clear();
	}
	
	
	/**
	 * Draws each block in the tetris piece given (currently blue)
	 * @param t Tetris piece to draw
	 */
	public static void drawBlocks(Block b) {
		StdDraw.setPenColor(b.getColor());
		StdDraw.filledSquare(b.getX() + 5, b.getY(), .5);
		StdDraw.setPenRadius(.003);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.square(b.getX()+5, b.getY(), .5);
		StdDraw.setPenRadius();

	}
	
	
	static void fastDrop() {
		// TODO Auto-generated method stub
		while(!collision()) {
			currentBlock.moveDown();
		}
	}
	/**
	 * Initializes button presses on keyBoard 
	 * Found Here: https://stackoverflow.com/questions/27967575/trouble-with-key-pressings-in-java
	 */
	protected static void setupKeyboard() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
	        @SuppressWarnings("unlikely-arg-type")
			@Override
	        public boolean dispatchKeyEvent(KeyEvent ke) {
	            synchronized (tetrisGame.class) {
	                switch (ke.getID()) {
	                case KeyEvent.KEY_PRESSED:
	                	
	                    if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
	                    	if (canMoveLeft()) {
	                        	currentBlock.moveLeft();
	                        	if (collision()) {
	                        		currentBlock.moveRight();
	                        	}
	                        	advanceGame();
	                    	}
	                    }
	                    if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
	                    	if (canMoveRight()) {
	                        	currentBlock.moveRight();
	                        	if (collision()) {
	                        		currentBlock.moveLeft();
	                        	}
	                        	advanceGame();
	                    	}
	                     }
	                    
	     
	              	  if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
	                  	currentBlock.rotate();
	                  	while(collision()) {
	                  		currentBlock.moveLeft();
	                  	}
	                  	advanceGame();
	              	  }
	               
	              	if (ke.getKeyCode() == KeyEvent.VK_UP) {
	                	fastDrop();
	                	advanceGame();
	                 }
	              	
	              	if (ke.getKeyCode() == KeyEvent.VK_Z) {
	              		if (holdBlock == null) {
	              			allBlocks.remove(currentBlock);
	                    	holdBlock = currentBlock;
	                    	holdBlock.moveToHoldPosition(new Block(1.5,18));
	                    	allBlocks.remove(holdBlock);
	                    	currentBlock = createNewPlayerBlock();
	              		}
	              		else {
	              			Tetromino temp = holdBlock;
	              			holdBlock = currentBlock;
	              			holdBlock.moveToHoldPosition(new Block(1.5,18));
	              			allBlocks.remove(holdBlock);
	              			currentBlock = temp;
	              		}
	                 }
	                   
	        
	                }
	               
	                //
	                switch (ke.getID()) {
	                case KeyEvent.KEY_RELEASED:
	                	
	                	 
	                    if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
	                    	currentBlock.moveDown();
	                    	advanceGame();
	                     }
	                
	              
	                }
	                return false;
	            }
	        }
	
	
			private boolean canMoveLeft() {
				boolean ret = true;
				for (Block b : currentBlock.getBlocks()) {
					if (b.getX() <= 0.5)
						ret = false;
				}
				return ret;
			}
			
			private boolean canMoveRight() {
				boolean ret = true;
				for (Block b : currentBlock.getBlocks()) {
					if (b.getX() > 9.5)
						ret = false;
				}
				return ret;
			}
		});
	}

	
}