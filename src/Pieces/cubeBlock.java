package Pieces;

import java.util.ArrayList;

public class cubeBlock implements Tetromino {

	//List of Blocks in current Tetromino
	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	
	public cubeBlock(Block topLeftCenter, double radius) {
		this.center = topLeftCenter;
		this.blocks = new ArrayList<>();
		this.radius = radius;
		initializeBlock();
	}
	
	public ArrayList<Block> getBlocks(){
		return this.blocks;
	}
	
	public Block getCenter() {
		return this.center;
	}

	public double getRadius() {
		return this.radius;
	}
	
	public void initializeBlock() {
		//Make upperLeft Block
		this.blocks.add(new Block(this.center.getX(), this.center.getY()));
		
		//Upper Right
		this.blocks.add(new Block(this.center.getX() + radius, this.center.getY()));
		
		//Bottom Left
		this.blocks.add(new Block(this.center.getX(), this.center.getY() - radius));
		
		///Bottom Right
		this.blocks.add(new Block(this.center.getX() + radius, this.center.getY() - radius));
				
	}
	
	public void moveLeft() {
		for (Block b: blocks) {
			b.moveLeft();
		}
	}
	
	public void moveRight() {
		for (Block b: blocks) {
			b.moveRight();
		}
	}
}
