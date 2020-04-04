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
import Pieces.lBlock;
import Pieces.jBlock;
import Pieces.sBlock;
import sedgewick.StdDraw;



public class tetrisGame {
	
	public static cubeBlock currentBlock = new cubeBlock(new Block(5.5,17.5),1);
	public static ArrayList<Tetromino> allBlocks = new ArrayList<>();
	public static Block [][] gameBoard = new Block[20][10];
	public static Timer timer = timer = new Timer();
	
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
		
	
		for(Tetromino b: allBlocks) {
			if (!b.equals(currentBlock))
				setAsObstacle(b);
			
		}
		
		//count how often pieces exist in board
//		for (int i =0; i < gameBoard.length; i++) {
//			int count=0;
//			for (int j = 0; j < gameBoard[0].length; j++) {
//				if (gameBoard[i][j] == 1) {
//					count++;
//					System.out.println("Block at (" + i + " , " + j + ")" );
//				}
//			}
//			if (count >= 10)
//			System.out.println("Row " + i + " is full");
			
//		}
	
		timer.schedule(new SayHello(), 0, 400);
		
	
		System.out.println("Done");	
	
		
	}

	private static void setAsObstacle(Tetromino b) {
		for (Block p: b.getBlocks()) {
				gameBoard[(int)p.getY()][(int)p.getX()] = p;
			}
		
	}
	
	public static boolean checkForCollision() {
		for (Block b : currentBlock.getBlocks()) {
			if (gameBoard[(int)b.getY()][(int)b.getX()] != null) {
				System.out.println("Collision at (" + b.getX() + ", " + b.getY() + ")");
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
		if (checkForCollision()) {
			currentBlock.moveUp();
			setAsObstacle(currentBlock);
			currentBlock = new cubeBlock(new Block(5.5,10.5),1);

			allBlocks.add(currentBlock);
		}
		
		
		new gameBoard().drawBoard();
		drawAllBlocks();
		StdDraw.show(20);
		
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
	                        	if (checkForCollision()) {
	                        		System.out.println("cant move left here");
	                        		
	                        		currentBlock.moveRight();
	                        	}
	                        	reDraw();
                        	}
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                        	if (canMoveRight()) {
	                        	currentBlock.moveRight();
	                        	if (checkForCollision()) {
	                        		System.out.println("cant move right here");
	                        		
	                        		currentBlock.moveLeft();
	                        	}
	                        	reDraw();
                        	}
                         }
                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                        	timer.cancel();
                			timer = new Timer();
                			timer.schedule(new SayHello(), 0, 500);
                            System.out.println("Space");
                         }
                        
                   
                    }
                    switch (ke.getID()) {
                    case KeyEvent.KEY_RELEASED:
                    	 if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    			
                    			timer.cancel();
                    			timer = new Timer();
                    			timer.schedule(new SayHello(), 0, 700);
                             System.out.println("released Space");
                          }
                  
                    }
                    return false;
                }
            }

	

			private boolean canMoveLeft() {
				return currentBlock.getBlocks().get(0).getX() > 0.5;
			}
			private boolean canMoveRight() {
				return currentBlock.getBlocks().get(0).getX() < 9.5;
			}
        });
	}
}
