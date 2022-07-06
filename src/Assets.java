import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Assets {
	
	public static BufferedImage loadImageFromURL(String urlString) {
		BufferedImage image = ImageLoader.loadImage("/textures/target.png");
		
		try {
		    URL url = new URL(urlString);
		    image = ImageIO.read(url);
		} catch (IOException e) {}
		
		return image;
	}
}