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


class rotationTests {
	
private Block tb1;


@BeforeEach
	void setupTestingObjects(){
		tb1 = new Block(9.5, 17.0);
	}
	
	//check if rotated, should work similar to cubeBlock with no change

	@Test
	void testRotation(){
		double originalX = tb1.getX();
		tb1.rotate();
		if( originalX == tb1.getX()){
	fail("block did not rotate");
	}
		assertTrue(true);
	}
	
}

	

	

	
	


