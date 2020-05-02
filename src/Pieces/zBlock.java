package Pieces;

import java.awt.Color;
import java.util.ArrayList;

import sedgewick.StdDraw;

public class zBlock implements Tetromino {

	//List of Blocks in current Tetromino
	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	private int state = 1;
	
	public zBlock(Block topLeftCenter, double radius) {
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
		//Top Left
		this.blocks.add(new Block(this.center.getX() - radius, this.center.getY(), getColor()));
		
		//Top Center
		this.blocks.add(new Block(this.center.getX(), this.center.getY(), getColor()));
		
		//Bottom Center
		this.blocks.add(new Block(this.center.getX(), this.center.getY() - radius, getColor()));
		
		///Bottom Right
		this.blocks.add(new Block(this.center.getX() + radius, this.center.getY() - radius, getColor()));
				
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
	//
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
		return new Color(250,11,2);
	}
	public void rotate() {
		Block firstBlock = blocks.get(0);
		if (state %2 == 1) { //rotate right
			blocks.set(1, new Block (firstBlock.getX() + 1, firstBlock.getY()+1, getColor()));
			blocks.set(2, new Block (firstBlock.getX() + 1, firstBlock.getY(), getColor()));
			blocks.set(3, new Block (firstBlock.getX() , firstBlock.getY()-1, getColor()));
		}
		
		else{
			blocks.set(1, new Block (firstBlock.getX()+1, firstBlock.getY(), getColor()));
			blocks.set(2, new Block (firstBlock.getX()+1, firstBlock.getY()-1, getColor()));
			blocks.set(3, new Block (firstBlock.getX()+2, firstBlock.getY()-1, getColor()));
		}
		state++;
		
		

}
	
	public void moveToHoldPosition(Block b) {
		moveToXPos(b);
		moveToYPos(b);
		
	}
	public void moveToXPos(Block b) {
		while (blocks.get(0).getX() > b.getX()) {
			moveLeft();
		}
		
		while (blocks.get(0).getX() < b.getX()) {
			moveRight();
		}
	}
	
	public void moveToYPos(Block b) {
		while (blocks.get(0).getY() > b.getY()) {
			moveDown();
		}
		
		while (blocks.get(0).getY() < b.getY()) {
			moveUp();
		}
	}
	
	
}
