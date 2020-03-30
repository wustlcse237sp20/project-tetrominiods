package finalProject;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Pieces.Block;
import Pieces.Tetromino;
import Pieces.cubeBlock;
import sedgewick.StdDraw;



public class tetrisGame {
	
	public static cubeBlock currentBlock = new cubeBlock(new Block(5.5,10.5),1);
	public static ArrayList<Tetromino> allBlocks = new ArrayList<>();

	
	public static void main(String [] args) {
		new gameBoard().setup();
		new gameBoard().drawBoard();
		setupKeyboard();
		
	
	
		//Creates Cubes at bottom of screen
		for (int i = 0; i < 5; i++) {
			allBlocks.add(new cubeBlock (new Block(0.5 + (i * 2),1.5), 1));
		}
		
		//Movable Cube for testing
		allBlocks.add(currentBlock);
		
		
		for (Tetromino b: allBlocks) {
			drawBlocks(b);
		}
		
		//GameBoard is used to map where all pieces exist on board
		int [][] gameBoard = new int[20][10];
		for(Tetromino b: allBlocks) {
			for (Block p: b.getBlocks()) {
				System.out.println("Adding (" + p.getX() + " , " + p.getY() + ") ");
				gameBoard[(int)p.getY()][(int)p.getX()] = 1;
			}
			
		}
		
		//count how often pieces exist in board
		for (int i =0; i < gameBoard.length; i++) {
			int count=0;
			for (int j = 0; j < gameBoard[0].length; j++) {
				if (gameBoard[i][j] == 1) {
					count++;
					System.out.println("Block at (" + i + " , " + j + ")" );
				}
			}
			if (count >= 10)
			System.out.println("Row " + i + " is full");
			
		}
		Timer timer = new Timer();
		timer.schedule(new SayHello(), 0, 5000);
		
		System.out.println("Done");
		
	
			
		
	
	}


	
	
	
	/**
	 * Draws the entire game in its current state (should be called per each movement)
	 */
	public static void reDraw() {
		clearBoard();
		new gameBoard().drawBoard();
		drawAllBlocks();
		StdDraw.show(20);
	}

	/**
	 * Draws all Tetromino Pieces in the game
	 */
	
	private static void drawAllBlocks() {
		System.out.println(allBlocks.size());
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
		StdDraw.setPenColor(StdDraw.BLUE);
		for (Block block: t.getBlocks()) {
			StdDraw.square(block.getX() + 5, block.getY(), t.getRadius()/2);
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
                        	if (isWithinBounds()) {
	                        	currentBlock.moveLeft();
	                        	System.out.println("Moved to " + currentBlock.getBlocks().get(0).getX() );
	                        	reDraw();
                        	}
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                        	if (isWithinBounds()) {
	                        	currentBlock.moveRight();
	                        	System.out.println("Moved to " + currentBlock.getBlocks().get(0).getX() );
	                        	reDraw();
                        	}
                         }
                        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                            System.out.println("Space");
                         }
                        
                   
                    }
                    return false;
                }
            }

			private boolean isWithinBounds() {
				return currentBlock.getBlocks().get(0).getX() > 0.5 && currentBlock.getBlocks().get(0).getX() < 8.5;
			}
            
        });
	}
}
