package eth.client.manager;

import eth.client.math.Vector2f;
import eth.client.math.Vector2i;
import eth.client.properties.GameProperties;

public class ViewManager {

	private static ViewManager instance = null;
	
	private Vector2i minViewLocation = new Vector2i(
			GameProperties.resolutionWidth() / 2,
			GameProperties.resolutionHeight() / 2);
	
	private Vector2i maxViewLocation = new Vector2i(
			(MapManager.getInstance().getMap().getNumCols()
					* GameProperties.chunkLength()
					* GameProperties.tileSize())
					- (GameProperties.resolutionWidth() / 2),
			(MapManager.getInstance().getMap().getNumRows()
					* GameProperties.chunkLength()
					* GameProperties.tileSize())
					- (GameProperties.resolutionHeight() / 2));
	
	private Vector2f playerPosition = new Vector2f(
			GameProperties.resolutionWidth(),
			GameProperties.resolutionHeight());
	
	private Vector2f viewPosition = new Vector2f(0, 0);
	
	protected ViewManager() {
		// Exists only to defeat instantiation
	}
	
	public static ViewManager getInstance() {
		if(instance == null) {
			instance = new ViewManager();
		}
		return instance;
	}
	
	public Vector2i getMinViewLocation() {
		return minViewLocation;
	}
	
	public Vector2i getMaxViewLocation() {
		return maxViewLocation;
	}
	
	public Vector2f getPlayerPosition() {
		return playerPosition;
	}
	
	public Vector2f getViewPosition() {
		return viewPosition;
	}
	
	public void setPlayerPosition(Vector2f playerPosition) {
		this.playerPosition = playerPosition;
	}
	
	public void setViewPosition(Vector2f viewPosition) {
		this.viewPosition = viewPosition;
	}
	
	public void setViewPosition(float x, float y) {
		setViewPosition(new Vector2f(x, y));
	}
}
