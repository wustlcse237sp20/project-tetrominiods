package Pieces;

import java.awt.Color;
import java.util.ArrayList;


public interface Tetromino {

    public ArrayList<Block> getBlocks();
	
	public Block getCenter();

	public double getRadius();
	
	public void initializeBlock();
	
	public void moveLeft();
	
	public void moveRight();
	
	public void moveDown();
	
	public void moveUp();
	
	public Color getColor();
	
	public void rotate();
	
	//fix this:
	public void moveToHoldPosition(Block b);
	
	public void moveToXPos(Block b) ;
	
	public void moveToYPos(Block b) ;
	
}