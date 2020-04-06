package Pieces;

import java.awt.Color;
import java.util.ArrayList;

import sedgewick.StdDraw;

public class lBlock implements Tetromino {

	//List of Blocks in current Tetromino
	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	private int state = 1;
	
	public lBlock(Block topLeftCenter, double radius) {
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
		///Bottom Center
		this.blocks.add(new Block(this.center.getX(), this.center.getY() - radius));
				
		//Top Left
		this.blocks.add(new Block(this.center.getX() - radius, this.center.getY() + radius));
		
		//Center Left
		this.blocks.add(new Block(this.center.getX() - radius, this.center.getY()));
		
		//Bottom Left
		this.blocks.add(new Block(this.center.getX() - radius, this.center.getY() - radius));
		
		
				
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
		return StdDraw.ORANGE;
	}
	
	public void rotate() {
		Block firstBlock = blocks.get(0);
		if (state %2 ==  1) { //rotate right
			blocks.set(1, new Block (firstBlock.getX(), firstBlock.getY()+ 1));
			blocks.set(2, new Block (firstBlock.getX() + 2, firstBlock.getY() + 1));
			blocks.set(3, new Block (firstBlock.getX() + 1, firstBlock.getY() + 1));
		}
		
		if (state%2 ==0) {
			blocks.set(1, new Block (firstBlock.getX()-1, firstBlock.getY()));
			blocks.set(2, new Block (firstBlock.getX()-1, firstBlock.getY() + 2));
			blocks.set(3, new Block (firstBlock.getX()-1, firstBlock.getY() + 1));
		}
		
		if(state %3 == 0) {
			blocks.set(1, new Block(firstBlock.getX() - 1,firstBlock .getY() ));
			blocks.set(2, new Block(firstBlock.getX() , firstBlock.getY() - 1 ));
			blocks.set(3, new Block(firstBlock.getX() , firstBlock.getY() - 2));	
		}
		
		state++;
		
	}
}
