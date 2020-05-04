package finalProject;

import java.util.TimerTask;

import Pieces.Block;

class timedBlockMovement extends TimerTask {
    public void run() {
      tetrisGame.currentBlock.moveDown();
       tetrisGame.advanceGame();
    }
}//