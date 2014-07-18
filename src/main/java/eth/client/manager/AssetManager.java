package eth.client.manager;
/*package eth.manager;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class AssetManager {

	private static final Logger LOGGER = Logger.getLogger(AssetManager.class);
	
	private static AssetManager instance = null;
	
	public static AssetManager getInstance() {
		if(instance == null) {
			instance = new AssetManager();
		}
		return instance;
	}
	
	public BufferedImage getImage(String path) {
		BufferedImage image = null;
		try {
			image = imageCache.get(path);
		} catch(ExecutionException e) {
			LOGGER.error("AssetManager failed get image out of the cache.", e);
		}
		return image;
	}
	
	private final LoadingCache<String, BufferedImage> imageCache = CacheBuilder.newBuilder()
		.maximumSize(100)
		.expireAfterWrite(10, TimeUnit.MINUTES)
		.build(new CacheLoader<String, BufferedImage>() {
			public BufferedImage load(String path) throws IOException {
				return loadImage(path);
			}
		});
	
	private BufferedImage loadImage(String path) throws IOException {
		return ImageIO.read(getClass().getClassLoader().getResource(path));
	}
}
*/