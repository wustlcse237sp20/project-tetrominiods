package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import Pieces.Block;
import Pieces.cubeBlock;
import Pieces.lineBlock;
import Pieces.tBlock;
import Pieces.zBlock;
import Pieces.lBlock;
import Pieces.jBlock;
import Pieces.sBlock;

class creationTests {

	private Block b;
	private cubeBlock cube;
	private lineBlock line;
	private tBlock t;
	private zBlock z;
	private lBlock l;
	private jBlock j;
	private sBlock s;
	
	
	@BeforeEach
	void setupTestingObjects(){
		b = new Block(5.0, 17.0);
		cube = new cubeBlock(b, 1);
		line = new lineBlock(b, 1);
		t = new tBlock(b, 1);
		z = new zBlock(b, 1);
		l = new lBlock(b, 1);
		j = new jBlock(b, 1);
		s = new sBlock(b, 1);
	}
	
	@Test
	void testIsBlockCreated() {
		if(b == null) {
			fail("block does not exist");
		}
		assertTrue(true);
	}
	
	@Test
	void testIsCubeBlockCreated() {
		if(cube == null){
			fail("cube block not created");
		}
		assertTrue(true);
	}
	
	@Test
	void testIsLineBlockCreated() {
		if(line == null){
			fail("line block not created");
		}
		assertTrue(true);
	}
	
	@Test
	void testIsTBlockCreated() {
		if(t == null){
			fail("t block not created");
		}
		assertTrue(true);
	}
	
	@Test
	void testIsZBlockCreated() {
		if(z == null){
			fail("z block not created");
		}
		assertTrue(true);
	}
	
	@Test
	void testIsLBlockCreated() {
		if(l == null){
			fail("l block not created");
		}
		assertTrue(true);
	}
	
	@Test
	void testIsJBlockCreated() {
		if(j == null){
			fail("j block not created");
		}
		assertTrue(true);
	}
	
	@Test
	void testIsSBlockCreated() {
		if(s == null){
			fail("s block not created");
		}
		assertTrue(true);
	}
	

}
