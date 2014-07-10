package eth.gameobjects;

import eth.collision.CollisionObject;
import eth.manager.SpriteManager;
import eth.math.Vector2f;
import eth.sprite.SpriteObject;

public abstract class GameObject {
	private static int objectIdCounter = 0;
	
	protected int objectId;
	protected Vector2f position;
	protected Vector2f velocity;
	protected Vector2f acceleration;
	protected Vector2f direction;
	protected CollisionObject collision;
	protected SpriteObject sprite;
	protected int speed;
	
	protected GameObject() {
		this.objectId = objectIdCounter++;
		this.position = new Vector2f(0, 0);
		this.velocity = new Vector2f(0, 0);
		this.acceleration = new Vector2f(0, 0);
		this.direction = new Vector2f(0, 0);
		this.speed = 0;
	}
	
	protected GameObject(Vector2f position, SpriteObject sprite) {
		this.objectId = objectIdCounter++;
		this.position = position;
		this.velocity = new Vector2f(0, 0);
		this.acceleration = new Vector2f(0, 0);
		this.direction = new Vector2f(0, 0);
		this.sprite = sprite;
		this.speed = 0;
	}
	
	public void update(float secondsElapsed) {
		velocity = Vector2f.add(velocity, Vector2f.multiply(acceleration, secondsElapsed));
		position = Vector2f.add(position, Vector2f.multiply(velocity, secondsElapsed));
		acceleration.clear();
		sprite.update(secondsElapsed, position, direction);
	}
	
	public void addSpriteToWorld() {
		SpriteManager.getInstance().addSprite(sprite);
	}
	
	public void removeSpriteFromWorld() {
		SpriteManager.getInstance().removeSprite(sprite.getObjectId());
	}
	
	public int getObjectId() {
		return objectId;
	}
	
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public Vector2f getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}
	
	public Vector2f getAcceleration() {
		return acceleration;
	}
	
	public void setAcceleration(Vector2f acceleration) {
		this.acceleration = acceleration;
	}
	
	public Vector2f getDirection() {
		return direction;
	}
	
	public void setDirection(Vector2f direction) {
		this.direction = direction;
	}
	
	public SpriteObject getSprite() {
		return sprite;
	}
	
	public void setSprite(SpriteObject sprite) {
		this.sprite = sprite;
	}
	
	public CollisionObject getCollision() {
		return collision;
	}
	
	public void setCollision(CollisionObject collision) {
		this.collision = collision;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
