import java.awt.image.BufferedImage;

public class Game implements Runnable {
	
	public String title;
	
	//Input
	private KeyManager keyManager;
	
	int laeuft = 0;
	private boolean running = false;
	private Thread thread;
	
	public Game() {
	}
	
	private void render() {
		Rule rule = new Rule(this);
		rule.tick();
	}
	
	public void run() {
		if(laeuft < 2) {
			render();
			laeuft++;
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}