package eth.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import eth.event.listeners.TickListener;
import eth.gameobjects.GameObject;

public class GameObjectManager implements TickListener {
	
	private static GameObjectManager instance = null;
	
	private final Map<Integer, GameObject> gameObjects = new HashMap<Integer, GameObject>();
	
	protected GameObjectManager() {
		// Exists only to defeat instantiation
	}
	
	public static GameObjectManager getInstance() {
		if(instance == null) {
			instance = new GameObjectManager();
		}
		return instance;
	}
	
	public void addGameObject(GameObject gameObject) {
		gameObjects.put(gameObject.getObjectId(), gameObject);
	}
	
	public void removeGameObject(GameObject gameObject) {
		removeGameObject(gameObject.getObjectId());
	}
	
	public void removeGameObject(int gameObjectId) {
		gameObjects.remove(gameObjectId);
	}
	
	public void tickTimeElapsed(float seconds) {
		final Collection<GameObject> gameObjectList = gameObjects.values();
		for(final GameObject gameObject : gameObjectList) {
			gameObject.update(seconds);
		}
	}
}
