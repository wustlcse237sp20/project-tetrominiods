package Pieces;

import java.util.ArrayList;


public interface Tetromino {

    public ArrayList<Block> getBlocks();
	
	public Block getCenter();

	public double getRadius();
	
	public void initializeBlock();
	
	public void moveLeft();
	
	public void moveRight();
}