package eth.manager;

import eth.event.listeners.TickListener;
import eth.map.GameMap;

public class MapManager implements TickListener {

	private static MapManager instance = null;
	
	private final GameMap map = new GameMap();
	
	protected MapManager() {
		// Exists only to defeat instantiation
	}
	
	public static MapManager getInstance() {
		if(instance == null) {
			instance = new MapManager();
		}
		return instance;
	}
	
	public GameMap getMap() {
		return map;
	}
	
	public void tickTimeElapsed(float seconds) {
		map.update();
	}
}
