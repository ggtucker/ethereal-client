package eth.client.map;

import java.util.ArrayList;
import java.util.List;

import eth.client.manager.ViewManager;
import eth.client.math.Vector2f;
import eth.client.math.Vector2i;

public class GameMap {
	
	private Chunk[][] chunks;
	private int numRows;
	private int numCols;
	
	private List<Chunk> nearbyChunks;
	private Vector2i lastCoords;
	
	public GameMap() {
		numRows = 25;
		numCols = 25;
		chunks = new Chunk[numRows][numCols];
		nearbyChunks = new ArrayList<Chunk>();
		lastCoords = new Vector2i(-1, -1);
		initChunks();
	}
	
	private void initChunks() {
		for(int x = 0; x < numRows; x++) {
			for(int y = 0; y < numCols; y++) {
				chunks[x][y] = new Chunk(new Vector2i(x, y));
			}
		}
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumCols() {
		return numCols;
	}
	
	public List<Chunk> getNearbyChunks() {
		return nearbyChunks;
	}
	
	public void update() {
		
		final ViewManager viewManager = ViewManager.getInstance();
		final Vector2f playerPosition = viewManager.getPlayerPosition();
		final Vector2i chunkCoords = GameMapUtil.chunkCoordsFromPixelCoords(playerPosition);
		if(!chunkCoords.equals(lastCoords)) {
			System.out.println(chunkCoords);
			lastCoords = chunkCoords;
			loadNewChunks();
			unloadOldChunks();
		}
	}
	
	private void loadNewChunks() {
		
		final List<Chunk> loadList = getLoadList();
		
		for(int i = 0; i < loadList.size(); i++) {
			final Chunk chunk = loadList.get(i);
			if(chunk != null && !chunk.isLoaded()) {
				loadChunk(chunk);
				System.out.println("Loaded " + chunk);
			}
		}
	}
	
	private void unloadOldChunks() {
		
		for(int i = 0; i < nearbyChunks.size(); i++) {
			final Chunk chunk = nearbyChunks.get(i);
			if(!isNearby(chunk)) {
				unloadChunk(chunk);
				System.out.println("Unloaded " + chunk);
			}
		}
	}
	
	private void loadChunk(Chunk chunk) {
		synchronized(chunk) {
			chunk.load();
			nearbyChunks.add(chunk);
		}
	}
	
	private void unloadChunk(Chunk chunk) {
		synchronized(chunk) {
			nearbyChunks.remove(chunk);
			chunk.unload();
		}
	}
	
	private boolean isNearby(Chunk chunk) {
		final int diffX = lastCoords.getX() - chunk.getX();
		final int diffY = lastCoords.getY() - chunk.getY();
		
		return !(Math.abs(diffX) > 1 || Math.abs(diffY) > 1);
	}
	
	private List<Chunk> getLoadList() {
		
		final List<Chunk> loadList = new ArrayList<Chunk>();
		
		loadList.add(getChunk(lastCoords.getX(), lastCoords.getY()));
		loadList.add(getChunk(lastCoords.getX(), lastCoords.getY() - 1));
		loadList.add(getChunk(lastCoords.getX(), lastCoords.getY() + 1));
		loadList.add(getChunk(lastCoords.getX() + 1, lastCoords.getY()));
		loadList.add(getChunk(lastCoords.getX() + 1, lastCoords.getY() - 1));
		loadList.add(getChunk(lastCoords.getX() + 1, lastCoords.getY() + 1));
		loadList.add(getChunk(lastCoords.getX() - 1, lastCoords.getY()));
		loadList.add(getChunk(lastCoords.getX() - 1, lastCoords.getY() - 1));
		loadList.add(getChunk(lastCoords.getX() - 1, lastCoords.getY() + 1));
		
		return loadList;
	}
	
	private Chunk getChunk(int x, int y) {
		if(x < 0 || x >= numCols
		|| y < 0 || y >= numRows) {
			return null;
		}
		return chunks[x][y];
	}
}