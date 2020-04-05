package finalProject;

import java.util.TimerTask;

import Pieces.Block;

class SayHello extends TimerTask {
    public void run() {
    	Block centerBlock = tetrisGame.currentBlock.getBlocks().get(0);
       System.out.println("Block is currently at (" + centerBlock.getX() + ", " + centerBlock.getY() + ")"); 
       tetrisGame.currentBlock.moveDown();
     
       tetrisGame.reDraw();
    }
}//