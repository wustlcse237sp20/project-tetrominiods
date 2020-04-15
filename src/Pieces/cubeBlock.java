package Pieces;

import java.awt.Color;
import java.util.ArrayList;

import sedgewick.StdDraw;

public class cubeBlock implements Tetromino {

	//List of Blocks in current Tetromino
	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	private int state = 1;
	
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
		this.blocks.add(new Block(this.center.getX(), this.center.getY(), getColor()));
		
		//Upper Right
		this.blocks.add(new Block(this.center.getX() + radius, this.center.getY(), getColor()));
		
		//Bottom Left
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
		return StdDraw.PINK;
	}
	public void rotate() {
		//Does nothing because its a square
		
		
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
