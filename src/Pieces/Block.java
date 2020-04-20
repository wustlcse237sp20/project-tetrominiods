package Pieces;

<<<<<<< HEAD
import java.awt.Color;
=======
>>>>>>> ce0d70072d78214bd4bef10bc8c9bf109243c276
import java.util.ArrayList;

public class Block {

	
	private double x;
	private double y;
	private ArrayList<Block> blocks;
	private Block center;
	private double radius;
	private int state = 1;
<<<<<<< HEAD
	private Color color;
=======
>>>>>>> ce0d70072d78214bd4bef10bc8c9bf109243c276
//
	
	public Block(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
<<<<<<< HEAD
	public Block(double x, double y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
=======
>>>>>>> ce0d70072d78214bd4bef10bc8c9bf109243c276
	

	public double getX() {
		return this.x;
		
	}
	
	public double getY() {
		return this.y;
		
	}
	public double setX() {
		return this.x;
		
	}
	
	public double setY() {
		return this.y;
		
	}
	
	public void moveLeft() {
		this.x -= 1;
	}
	
	public void moveRight() {
		this.x += 1;
	}
	
	public void moveDown() {
		this.y -= 1;
	}
	
	public void moveUp() {
		this.y += 1;
	}
	public void rotate() {
		Block firstBlock = blocks.get(0);
		if (state == 1) { //rotate right
<<<<<<< HEAD
			blocks.set(1, new Block (firstBlock.getX() + 1, firstBlock.getY(), this.color));
			blocks.set(2, new Block (firstBlock.getX() + 2, firstBlock.getY(), this.color));
			blocks.set(3, new Block (firstBlock.getX() + 3, firstBlock.getY(), this.color));
		}

	}
	
	public Color getColor() {
		return this.color;
	}

	public void setColor(Color c) {
		this.color = c;
		
	}
=======
			blocks.set(1, new Block (firstBlock.getX() + 1, firstBlock.getY()));
			blocks.set(2, new Block (firstBlock.getX() + 2, firstBlock.getY()));
			blocks.set(3, new Block (firstBlock.getX() + 3, firstBlock.getY()));
		}

	}		
>>>>>>> ce0d70072d78214bd4bef10bc8c9bf109243c276
	}
	
	
	

