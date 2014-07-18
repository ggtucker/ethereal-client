package eth.client.map;

import eth.client.math.Vector2f;
import eth.client.math.Vector2i;
import eth.client.properties.GameProperties;

public class GameMapUtil {
	
	private GameMapUtil() {
		// Prevent construction
	}
	
	public static Vector2i chunkCoordsFromPixelCoords(Vector2f pixelCoords) {
		final int chunkX = (int) (pixelCoords.getX() / GameProperties.tileSize() / GameProperties.chunkLength());
		final int chunkY = (int) (pixelCoords.getY() / GameProperties.tileSize() / GameProperties.chunkLength());
		return new Vector2i(chunkX, chunkY);
	}
	
	public static Vector2f pixelCoordsFromChunkCoords(Vector2i chunkCoords) {
		final int chunkX = chunkCoords.getX() * GameProperties.tileSize() * GameProperties.chunkLength();
		final int chunkY = chunkCoords.getY() * GameProperties.tileSize() * GameProperties.chunkLength();
		return new Vector2f(chunkX, chunkY);
	}
	
	public static Vector2f pixelCoordsFromChunkAndTileCoords(Vector2i chunkCoords, Vector2i tileCoords) {
		final Vector2f pixelChunkCoords = pixelCoordsFromChunkCoords(chunkCoords);
		final Vector2f relativeTileCoords = relativePixelCoordsFromTileCoords(tileCoords);
		return Vector2f.add(pixelChunkCoords, relativeTileCoords);
	}
	
	public static Vector2f relativePixelCoordsFromTileCoords(Vector2i tileCoords) {
		final float tileX = tileCoords.getX() * GameProperties.tileSize();
		final float tileY = tileCoords.getY() * GameProperties.tileSize();
		return new Vector2f(tileX, tileY);
	}
}
