package Pieces;

import java.awt.Color;
import java.util.ArrayList;

import sedgewick.StdDraw;

public class lineBlock implements Tetromino {

	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	private int state = 1;
	
	public lineBlock(Block topLeftCenter, double radius) {
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
		//Make bottom block
		this.blocks.add(new Block(this.center.getX(), this.center.getY()));
		
		//Make 2nd from bottom
		this.blocks.add(new Block(this.center.getX(), this.center.getY() + radius));
		
		//Make 3rd from bottom
		this.blocks.add(new Block(this.center.getX(), this.center.getY() + (2 * radius)));
		
		///Make Top Block
		this.blocks.add(new Block(this.center.getX(), this.center.getY() + (3 * radius)));
	}

	@Override
	public void moveLeft() {
	
		for (Block b: blocks) {
			b.moveLeft();
		}
		
	}

	@Override
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
		return StdDraw.CYAN;
	}
	
	public void rotate() {
		Block firstBlock = blocks.get(0);
		if (state == 1) { //rotate right
			blocks.set(1, new Block (firstBlock.getX() + 1, firstBlock.getY()));
			blocks.set(2, new Block (firstBlock.getX() + 2, firstBlock.getY()));
			blocks.set(3, new Block (firstBlock.getX() + 3, firstBlock.getY()));
		}
		
		
			

	}
}
