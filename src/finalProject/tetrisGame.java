package finalProject;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
	
	public static ArrayList<Tetromino> allBlocks = new ArrayList<>();
	public static Tetromino holdBlock;
	public static Block [][] gameBoard = new Block[25][10];
	public static Timer timer = timer = new Timer();
	
	public static void main(String [] args) {
		new gameBoard().setup();
		new gameBoard().drawBoard();
		setupKeyboard();
		
		//Create Player's Block
		allBlocks.add(currentBlock);
		
		
		for (Tetromino b: allBlocks) {
			drawBlocks(b);
		}
		timer.schedule(new timedBlockMovement(), 0, 700);
	
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
	public static void reDraw() {
		clearBoard();
		if (collision()) {
			moveToNextPiece();
			
		}
		else {
			drawPreview();
		}
		new gameBoard().drawBoard();
		drawAllBlocks();
		
		if (holdBlock != null) {
			drawUIBlock(holdBlock);
		}
		StdDraw.show(20);
		
		
	}
	
	private static void drawUIBlock(Tetromino t) {
		StdDraw.setPenColor(t.getColor());
		for (Block block: t.getBlocks()) {
			StdDraw.square(block.getX() + .1, block.getY() - 0.3, t.getRadius()/2);
		}
		
	}

	private static void drawPreview() {
		Color initColor = currentBlock.getColor();
		int count = 0;
			while(!collision()) {
				count++;
				currentBlock.moveDown();
			}
			currentBlock.moveUp();
			//waiting to set color
			drawBlocks(currentBlock);
			
			currentBlock.moveDown();
			 for (int i = 0; i < count; i++) {
				 currentBlock.moveUp();
			 }
		
	}
	
	private static void moveToNextPiece() {
		currentBlock.moveUp();
		setAsObstacle(currentBlock);
		currentBlock = createNewPlayerBlock();
		allBlocks.add(currentBlock);
		if (checkForGameLoss()) {
			new gameBoard().printLosingScreen();
			timer.cancel();
			System. exit(0);
		}
	}
	
	private static boolean checkForGameLoss() {
		if (collision()) {
			return true;
		}
		return false;
	}

	public static Tetromino createNewPlayerBlock() {
		int randIndex = (int)(Math.random() * 7);//gets a random number corresponding to block 
		
		if (randIndex == 0)
			return new cubeBlock(new Block(5.5,17.5),1);
		
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

	/**
	 * Draws all Tetromino Pieces in the game
	 */
	
	private static void drawAllBlocks() {
		for (Tetromino b: allBlocks) {
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
	public static void drawBlocks(Tetromino t) {
		StdDraw.setPenColor(t.getColor());
		for (Block block: t.getBlocks()) {
			StdDraw.square(block.getX() + 5, block.getY(), t.getRadius()/2);
		}
	}
	
	
	private static void fastDrop() {
		// TODO Auto-generated method stub
		while(!collision()) {
			currentBlock.moveDown();
		}
	}

	/**
	 * Initializes button presses on keyBoard 
	 * Found Here: https://stackoverflow.com/questions/27967575/trouble-with-key-pressings-in-java
	 */
	
	private static void setupKeyboard() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
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
	                        	reDraw();
                        	}
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                        	if (canMoveRight()) {
	                        	currentBlock.moveRight();
	                        	if (collision()) {
	                        		currentBlock.moveLeft();
	                        	}
	                        	reDraw();
                        	}
                         }
                        
         
                  	  if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                      	currentBlock.rotate();
                      	while(collision()) {
                      		currentBlock.moveLeft();
                      	}
                      	reDraw();
                  	  }
                   
                  	if (ke.getKeyCode() == KeyEvent.VK_UP) {
                    	fastDrop();
                    	reDraw();
                     }
                  	
                  	if (ke.getKeyCode() == KeyEvent.VK_Z) {
                  		if (holdBlock == null) {
	                    	holdBlock = currentBlock;
	                    	holdBlock.moveToHoldPosition(new Block(1.5,18));
	                    	currentBlock = createNewPlayerBlock();
                  		}
//                  		else {
//                  			Tetromino hold = holdBlock;
//                  			holdBlock = currentBlock;
//                  			currentBlock = holdBlock;
//	                    	
//                  		}
                     }
                       
                    }
                   
                    //
                    switch (ke.getID()) {
                    case KeyEvent.KEY_RELEASED:
                    	
                    	 
                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                        	currentBlock.moveDown();
                        	reDraw();
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
	
        
	

