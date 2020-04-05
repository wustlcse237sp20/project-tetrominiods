package Pieces;

import java.awt.Color;
import java.util.ArrayList;

import sedgewick.StdDraw;

public class jBlock implements Tetromino {

	//List of Blocks in current Tetromino
	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	private int state = 1;
	
	public jBlock(Block topLeftCenter, double radius) {
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
		//Bottom Center
		this.blocks.add(new Block(this.center.getX(), this.center.getY() - radius));
		
		//Bottom Right
		this.blocks.add(new Block(this.center.getX() + radius, this.center.getY() - radius));
		
		//Center Right
		this.blocks.add(new Block(this.center.getX() + radius, this.center.getY()));
		
		///Top Right
		this.blocks.add(new Block(this.center.getX() + radius, this.center.getY() + radius));
				
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
	
	public void moveDown() {
		for (Block b: blocks) {
			b.moveDown();
		}
	}
	
	public void moveUp() {
		for (Block b: blocks) {
			b.moveUp();
		}
	}
	
	
	public Color getColor() {
		return StdDraw.BLUE;
	}
	public void rotate() {
		Block firstBlock = blocks.get(0);
		for (Block b: blocks) {
		if (state == 1) { //rotate right
			blocks.set(1, new Block (firstBlock.getX() + 1, firstBlock.getY()));
			blocks.set(2, new Block (firstBlock.getX() + 2, firstBlock.getY()));
			blocks.set(3, new Block (firstBlock.getX() + 3, firstBlock.getY()));
		}
		}
		
	//change this so that you just call the method and can apply it through multiple states//

	}
}