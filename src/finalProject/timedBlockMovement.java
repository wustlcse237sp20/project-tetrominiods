package finalProject;

import java.util.TimerTask;

import Pieces.Block;

class timedBlockMovement extends TimerTask {
    public void run() {
    	Block centerBlock = tetrisGame.currentBlock.getBlocks().get(0);
      tetrisGame.currentBlock.moveDown();
     
       tetrisGame.reDraw();
    }
}//