package finalProject;

import java.util.TimerTask;

class SayHello extends TimerTask {
    public void run() {
       System.out.println("Hello World!"); 
       tetrisGame.currentBlock.moveDown();
       tetrisGame.reDraw();
    }
}