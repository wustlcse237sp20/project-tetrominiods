package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Pieces.Block;
import Pieces.Tetromino;
import Pieces.cubeBlock;
import Pieces.lineBlock;
import Pieces.tBlock;
import Pieces.zBlock;
import Pieces.lBlock;
import Pieces.jBlock;
import Pieces.sBlock;
import sedgewick.StdDraw;


class blockMovementTests {

	private Block tb;
	
	@BeforeEach
	void setupTestingObjects(){
		tb = new Block(5.0, 17.0);
	}
	
	@Test
	void testMoveLeft() {
		double originalX = tb.getX();
		tb.moveLeft();
		if(tb.getX() != originalX - 1) {
			fail("did not move left");
		}
		assertTrue(true);
	}
	
	@Test
	void testMoveRight() {
		double originalX = tb.getX();
		tb.moveRight();
		if(tb.getX() != originalX + 1) {
			fail("did not move right");
		}
		assertTrue(true);
	}
	
	@Test
	void testMoveUp() {
		double originalY = tb.getY();
		tb.moveUp();
		if(tb.getY() != originalY + 1) {
			fail("did not move up");
		}
		assertTrue(true);
	}
	
	@Test
	void testMoveDown() {
		double originalY = tb.getY();
		tb.moveDown();
		if(tb.getY() != originalY - 1) {
			fail("did not move down");
		}
		assertTrue(true);
	}

}
