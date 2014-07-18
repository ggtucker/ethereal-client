package eth.client.map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import eth.client.math.Vector2f;
import eth.client.math.Vector2i;
import eth.client.properties.GameProperties;

public class Chunk {
	
	private Tile[][] tiles;
	private Vector2i position;
	private boolean loaded;
	
	public Chunk(Vector2i position) {
		this.position = position;
		this.loaded = false;
	}
	
	public boolean isLoaded() {
		return loaded;
	}
	
	public void load() {
		final int chunkLength = GameProperties.chunkLength();
		this.tiles = new Tile[chunkLength][chunkLength];
		
		for(int x = 0; x < chunkLength; x++) {
			for(int y = 0; y < chunkLength; y++) {
				tiles[x][y] = new Tile();
			}
		}
		this.loaded = true;
	}
	
	public void unload() {
		this.tiles = null;
		this.loaded = false;
	}
	
	public void draw(Graphics2D g) {
		if(!loaded) {
			return;
		}
		
		//final AssetManager assetManager = AssetManager.getInstance();
		final int chunkLength = GameProperties.chunkLength();
		
		for(int x = 0; x < chunkLength; x++) {
			for(int y = 0; y < chunkLength; y++) {
				final BufferedImage image = tiles[x][y].getType().getImage();
				final Vector2f coords = GameMapUtil.pixelCoordsFromChunkAndTileCoords(position, new Vector2i(x, y));
				g.drawImage(image, (int) coords.getX(), (int) coords.getY(), null);
			}
		}
	}
	
	public Vector2i getPosition() {
		return position;
	}
	
	public int getX() {
		return position.getX();
	}
	
	public int getY() {
		return position.getY();
	}

	@Override
	public String toString() {
		return "Chunk [position=" + position + ", loaded=" + loaded + "]";
	}
}