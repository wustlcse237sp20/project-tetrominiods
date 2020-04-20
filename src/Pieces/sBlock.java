package Pieces;

import java.awt.Color;
import java.util.ArrayList;

import sedgewick.StdDraw;

public class sBlock implements Tetromino {

	//List of Blocks in current Tetromino
	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	private int state = 1;
	
	public sBlock(Block topLeftCenter, double radius) {
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
		//Bottom Left
<<<<<<< HEAD
		this.blocks.add(new Block(this.center.getX() - radius, this.center.getY() - radius, getColor()));
		
		//Bottom Center
		this.blocks.add(new Block(this.center.getX(), this.center.getY() - radius, getColor()));
		
		//Top Center
		this.blocks.add(new Block(this.center.getX(), this.center.getY(), getColor()));
		
		///Top Right
		this.blocks.add(new Block(this.center.getX() + radius, this.center.getY(), getColor()));
=======
		this.blocks.add(new Block(this.center.getX() - radius, this.center.getY() - radius));
		
		//Bottom Center
		this.blocks.add(new Block(this.center.getX(), this.center.getY() - radius));
		
		//Top Center
		this.blocks.add(new Block(this.center.getX(), this.center.getY()));
		
		///Top Right
		this.blocks.add(new Block(this.center.getX() + radius, this.center.getY()));
>>>>>>> ce0d70072d78214bd4bef10bc8c9bf109243c276
				
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
		return StdDraw.GREEN; 
	}
	public void rotate() {
		Block firstBlock = blocks.get(0);
		if (state %2 == 1) { //rotate right
<<<<<<< HEAD
			blocks.set(1, new Block (firstBlock.getX(), firstBlock.getY()-1, getColor()));
			blocks.set(2, new Block (firstBlock.getX()+1, firstBlock.getY()-1, getColor()));
			blocks.set(3, new Block (firstBlock.getX()+1, firstBlock.getY()-2, getColor()));
			
		}
		else{
			blocks.set(1, new Block (firstBlock.getX()+1, firstBlock.getY(), getColor()));
			blocks.set(2, new Block (firstBlock.getX()+1, firstBlock.getY()+1, getColor()));
			blocks.set(3, new Block (firstBlock.getX()+2, firstBlock.getY()+1, getColor()));
=======
			blocks.set(1, new Block (firstBlock.getX(), firstBlock.getY()-1));
			blocks.set(2, new Block (firstBlock.getX()+1, firstBlock.getY()-1));
			blocks.set(3, new Block (firstBlock.getX()+1, firstBlock.getY()-2));
			
		}
		else{
			blocks.set(1, new Block (firstBlock.getX()+1, firstBlock.getY()));
			blocks.set(2, new Block (firstBlock.getX()+1, firstBlock.getY()+1));
			blocks.set(3, new Block (firstBlock.getX()+2, firstBlock.getY()+1));
>>>>>>> ce0d70072d78214bd4bef10bc8c9bf109243c276
		}
		state++;
		
}
<<<<<<< HEAD
	
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
		
		while (blocks.get(0).getY() < b.getY()-1) {
			moveUp();
		}
	}
=======
>>>>>>> ce0d70072d78214bd4bef10bc8c9bf109243c276
}
