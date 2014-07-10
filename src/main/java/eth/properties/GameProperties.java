package eth.properties;

import eth.manager.MapManager;
import eth.math.Vector2i;

public final class GameProperties {

	private GameProperties() {
		// Prevent construction
	}
	
	private static Vector2i resolution = new Vector2i(1366, 768);
	private static Vector2i windowSize = resolution.clone();
	private static int pixelsPerMeter = 64;
	private static int tileSize = pixelsPerMeter;
	private static int chunkSize = 16;
	
	private static Vector2i minViewLocation = new Vector2i(resolution.getX() / 2, resolution.getY() / 2);
	private static Vector2i maxViewLocation = new Vector2i(
			(MapManager.getInstance().getMap().getNumCols() * chunkSize * tileSize) - (resolution.getX() / 2),
			(MapManager.getInstance().getMap().getNumRows() * chunkSize * tileSize) - (resolution.getY() / 2));
	
	public static int windowWidth() {
		return windowSize.getX();
	}
	
	public static int windowHeight() {
		return windowSize.getY();
	}
	
	public static int resolutionWidth() {
		return resolution.getX();
	}
	
	public static int resolutionHeight() {
		return resolution.getY();
	}
	
	public static Vector2i resolution() {
		return resolution;
	}
	
	public static Vector2i minViewLocation() {
		return minViewLocation;
	}
	
	public static Vector2i maxViewLocation() {
		return maxViewLocation;
	}
	
	public static int pixelsPerMeter() {
		return pixelsPerMeter;
	}
	
	public static int tileSize() {
		return tileSize;
	}
	
	public static int chunkSize() {
		return chunkSize;
	}
}