package eth.sprite;

import java.awt.Graphics2D;

import eth.math.Vector2f;

public abstract class SpriteObject {
	private static int objectIdCounter = 0;
	
	protected int objectId;
	protected Vector2f position;
	protected Vector2f direction;
	protected Vector2f size;
	protected Vector2f scale;
	protected float alpha;
	
	protected SpriteObject() {
		this.objectId = objectIdCounter++;
		this.position = new Vector2f(0, 0);
		this.size = new Vector2f(0, 0);
		this.scale = new Vector2f(0, 0);
		this.alpha = 1;
	}
	
	public abstract void draw(Graphics2D g);
	public abstract void update(float secondsElapsed, Vector2f position, Vector2f direction);
	
	public int getObjectId() {
		return objectId;
	}
	
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	
	public Vector2f getCenter() {
		return new Vector2f(position.getX() + size.getX()/2, position.getY() + size.getY()/2);
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public Vector2f getSize() {
		return size;
	}
	
	public void setSize(Vector2f size) {
		this.size = size;
	}
	
	public Vector2f getScale() {
		return scale;
	}
	
	public void setScale(Vector2f scale) {
		this.scale = scale;
	}
	
	public float getAlpha() {
		return alpha;
	}
	
	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}
}
