package Pieces;

import java.awt.Color;
import java.util.ArrayList;

import sedgewick.StdDraw;

public class tBlock implements Tetromino {

	//List of Blocks in current Tetromino
	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	private int state = 1;
	
	public tBlock(Block topLeftCenter, double radius) {
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
				this.blocks.add(new Block(this.center.getX(), this.center.getY() - radius, getColor()));
				
		//Bottom Left
		this.blocks.add(new Block(this.center.getX() - radius, this.center.getY() - radius, getColor()));
		
		
		
		//Top Center
		this.blocks.add(new Block(this.center.getX(), this.center.getY(), getColor()));
		
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
	//
	public Color getColor() {
		return new Color(134,2,250); //needs to be changed to purple
	}
	
	public void rotate() {
		Block firstBlock = blocks.get(0);
		if (state %4 == 1) { //rotate right
		blocks.set(1, new Block (firstBlock.getX(), firstBlock.getY()-1, getColor())); 
		blocks.set(2, new Block (firstBlock.getX() + 1, firstBlock.getY(), getColor()));
		blocks.set(3, new Block (firstBlock.getX(), firstBlock.getY() + 1 , getColor()));	
		}
		
		if (state %4 == 2) { //rotate right
		blocks.set(1, new Block (firstBlock.getX() - 1, firstBlock.getY(), getColor()));
		blocks.set(2, new Block (firstBlock.getX() , firstBlock.getY() -1 , getColor()));
		blocks.set(3, new Block (firstBlock.getX() +1 , firstBlock.getY() , getColor()));
		}
		
		if (state % 4 == 3) {
		blocks.set(1, new Block (firstBlock.getX(), firstBlock.getY() + 1, getColor()));
		blocks.set(2, new Block (firstBlock.getX() - 1, firstBlock.getY(), getColor()));
		blocks.set(3, new Block (firstBlock.getX(), firstBlock.getY()-1, getColor()));
	}
		if (state % 4 == 0) {
		blocks.set(1, new Block (firstBlock.getX(), firstBlock.getY()+1, getColor()));
		blocks.set(2, new Block (firstBlock.getX()+1, firstBlock.getY(), getColor()));
		blocks.set(3, new Block (firstBlock.getX() -1, firstBlock.getY(), getColor()));
		}
		state++;
				
		//need to fix so it decrements from 4, but currently it has all 4 rotation states	
	}
	
	public void moveToHoldPosition(Block b) {
		moveToXPos(b);
		moveToYPos(b);
		
	}
	public void moveToXPos(Block b) {
		while (blocks.get(0).getX() > b.getX()+1) {
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
		
		while (blocks.get(0).getY() < b.getY()-1) {
			moveUp();
		}
	}
}
