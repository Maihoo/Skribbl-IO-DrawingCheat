import java.awt.Robot;
import java.awt.event.InputEvent;

public class DrawBot {

    Game game;
    
    public DrawBot(Game game) {
    	this.game = game;
    }
    
    public void move(Robot robot, int x, int y) {
    	robot.mouseMove(x, y);
    }
    
    public void click(Robot robot) {
    	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	robot.delay(2);
    	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    
    public void grey(Robot robot) {
    	robot.mouseMove(610, 910);
    	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	robot.delay(1);
    	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    
    public void black(Robot robot) {
    	robot.mouseMove(585, 910);
    	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	robot.delay(1);
    	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void light(Robot robot) {
    	robot.mouseMove(610, 890);
    	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	robot.delay(1);
    	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}