package finalProject;

import java.util.TimerTask;

import Pieces.Block;

class timedBlockMovement extends TimerTask {
    public void run() {
    	Block centerBlock = tetrisGame.currentBlock.getBlocks().get(0);
<<<<<<< HEAD
      tetrisGame.currentBlock.moveDown();
     
       tetrisGame.advanceGame();
=======
       System.out.println("Block is currently at (" + centerBlock.getX() + ", " + centerBlock.getY() + ")"); 
       tetrisGame.currentBlock.moveDown();
     
       tetrisGame.reDraw();
>>>>>>> ce0d70072d78214bd4bef10bc8c9bf109243c276
    }
}//