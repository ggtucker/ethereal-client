package eth.client.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import eth.client.sprite.SpriteObject;

public class SpriteManager {
	
	private static SpriteManager instance = null;
	
	private final Map<Integer, SpriteObject> sprites = new HashMap<Integer, SpriteObject>();
	
	protected SpriteManager() {
		// Exists only to defeat instantiation
	}
	
	public static SpriteManager getInstance() {
		if(instance == null) {
			instance = new SpriteManager();
		}
		return instance;
	}
	
	public Collection<SpriteObject> getSprites() {
		return sprites.values();
	}
	
	public void addSprite(SpriteObject sprite) {
		sprites.put(sprite.getObjectId(), sprite);
	}
	
	public void removeSprite(SpriteObject sprite) {
		removeSprite(sprite.getObjectId());
	}
	
	public void removeSprite(int spriteId) {
		sprites.remove(spriteId);
	}
}
