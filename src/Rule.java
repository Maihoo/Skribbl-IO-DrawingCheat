import java.awt.AWTException;
import java.awt.Color;
import java.awt.Image;
import java.awt.Robot;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rule {

	public Robot robot;
	int h = 0;
	Color color;
	Game game;
	Pixel[] pixel = new Pixel[40000];
	DrawBot bot = new DrawBot(game);
	
	public Rule (Game game) {
		this.game = game;
	}
	
	public static void click(Robot robot) {}
	
	public void tick() {		
		if(h == 0) {
    		h++;
    		init();
    	}
	}
	
    public void init() {
    	//BufferedImage target = ImageLoader.loadImage("/textures/target.png");
    	BufferedImage target = null;
    	
    	String imageUrl = "https://pbs.twimg.com/profile_images/1308607353877602309/JSN_o59F.jpg";
		String destinationFile = "image.jpg";
		
		File file = new File(destinationFile);
		
		try {
			saveImage(imageUrl, file);
			
			target = ImageIO.read(file);
			
	    	ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
	        op.filter(target, target);
			
			try {
				robot = new Robot();
			} catch (AWTException e) {
				
				e.printStackTrace();
			}
	    	int y = 0;
	    	int x = -1;

	    	for(int i = 0; i < 40000; i++) {
	    		x++;
	    		if(x > 199) {
	    			x = 0;
	    			y++;
	    		}
	 
	    		color = new Color(target.getRGB(x*target.getWidth()/400, y*target.getHeight()/400));
	    		pixel[i] = new Pixel(x, y, color.getBlue());
	    	}
	    	draw2();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

    }
    
    public static void saveImage(String imageUrl, File file) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(file);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}
    
    public void draw() {
    	
    	bot.black(robot);
    	
    	for(int i = 0; i < 40000; i++) {
    		if(pixel[i].color<=50) {
    			bot.move(robot, (int) (470+pixel[i].x*3), (int) (250+pixel[i].y*3));
    			bot.click(robot);
    		}
    	}
    	
    	bot.grey(robot);
    	
    	for(int i = 0; i < 40000; i++) {
    		if(pixel[i].color<=120 && pixel[i].color>50) {
    			bot.move(robot, (int) (470+pixel[i].x*3), (int) (250+pixel[i].y*3));
    			bot.click(robot);
    		}
   
    	}
    	
    	bot.light(robot);
    	
    	for(int i = 0; i < 40000; i++) {
    		if(pixel[i].color<=200 && pixel[i].color>120) {
    			bot.move(robot, (int) (470+pixel[i].x*3), (int) (250+pixel[i].y*3));
    			bot.click(robot);
    		}
    	}
    }
    
    public void draw3() {
    	Quicksort.quickSort(pixel, 0, pixel.length-1);
    	for(int i = 0; i<10000; i++) {
    		System.out.println(pixel[i].color + " " + pixel[i].x + " " + pixel[i].y);
    	}
    }
    
    public void draw2() {
    	bot.black(robot);
    	Quicksort.quickSort(pixel, 0, pixel.length-1);
    	int i = 0;
    	while(pixel[i].color<=50) {
    		bot.move(robot, (int) (470+pixel[i].x*3), (int) (250+pixel[i].y*3));
			bot.click(robot);
			i++;
    	}
    	
    	/*bot.grey(robot);
    	
    	while(pixel[i].color<=120) {
    		bot.move(robot, (int) (470+pixel[i].x*3), (int) (250+pixel[i].y*3));
			bot.click(robot);
			i++;
    	}
    	
    	bot.light(robot);
    	
    	while(pixel[i].color<=180) {
        	bot.move(robot, (int) (470+pixel[i].x*3), (int) (250+pixel[i].y*3));
    		bot.click(robot);

    		i++;
    		
    		if(i == 39999) break;
    	}*/
    }
}
