package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Pieces.Block;


class boundaryTests {

	private Block b;
	private Block b2;
	
	@BeforeEach
	void setupTestingObjects(){
		b = new Block(0.51, 17.0);
		b2 = new Block(9.5, 17.0);
	}
	
	@Test
	void testLeftBlockBoundary() {
		if(b.getX() <= 0.5) {
			fail("block passes left boundary");
		}
		assertTrue(true);
	}
	
	@Test
	void testRightBlockBoundary() {
		if(b2.getX() > 9.5) {
			fail("block passes right boundary");
		}
		assertTrue(true);
	}

}
