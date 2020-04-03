package Pieces;

import java.util.ArrayList;

public class lineBlock implements Tetromino {

	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}
	
	public void moveDown() {
		for (Block b: blocks) {
			b.moveDown();
		}
	}
}
