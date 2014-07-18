package eth.client.sprite;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class ImageUtil {
	
	private static final Logger LOGGER = Logger.getLogger(ImageUtil.class);
	
	public static BufferedImage rotateImage(BufferedImage image, double radians) {
	    double sin = Math.abs(Math.sin(radians));
	    double cos = Math.abs(Math.cos(radians));
	    int originalWidth = image.getWidth();
	    int originalHeight = image.getHeight();
	    int newWidth = (int) Math.floor(originalWidth * cos + originalHeight * sin);
	    int newHeight = (int) Math.floor(originalHeight * cos + originalWidth * sin);
	    BufferedImage rotatedBI = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = rotatedBI.createGraphics();
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.translate((newWidth - originalWidth) / 2, (newHeight - originalHeight) / 2);
	    g2d.rotate(radians, originalWidth / 2, originalHeight / 2);
	    g2d.drawImage(image, 0, 0, null);
	    g2d.dispose();
	    return rotatedBI;
	}
	
	public static BufferedImage loadImage(URL texturePath) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(texturePath);
		} catch(IOException e) {
			LOGGER.error("ImageUtil failed to load image at " + texturePath + ".", e);
		}
		return image;
	}
}
