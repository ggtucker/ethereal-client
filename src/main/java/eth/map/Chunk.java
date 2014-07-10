package eth.map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import eth.math.Vector2f;
import eth.math.Vector2i;
import eth.properties.GameProperties;

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
		final int chunkSize = GameProperties.chunkSize();
		this.tiles = new Tile[chunkSize][chunkSize];
		
		for(int x = 0; x < chunkSize; x++) {
			for(int y = 0; y < chunkSize; y++) {
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
		final int chunkSize = GameProperties.chunkSize();
		
		for(int x = 0; x < chunkSize; x++) {
			for(int y = 0; y < chunkSize; y++) {
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