import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up;
	
	public KeyManager() {
		keys = new boolean[256];
	}

	public void tick(){
		up = keys[KeyEvent.VK_W];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
	  //keys[e.getKeyCode()] = false;
	}
	
	public void reset() {	
		keys[KeyEvent.VK_W] = false;
		up = false;
	}
	
}
