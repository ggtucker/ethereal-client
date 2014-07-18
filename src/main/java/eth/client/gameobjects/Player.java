package eth.client.gameobjects;

import eth.client.event.events.KeyboardEvent;
import eth.client.manager.InputManager;
import eth.client.manager.ViewManager;
import eth.client.math.Vector2f;
import eth.client.math.Vector2i;
import eth.client.properties.GameProperties;
import eth.client.sprite.AnimatedSprite;
import eth.client.sprite.animation.AnimationType;

public class Player extends GameObject {
	
	private final double DIAGONAL = Math.cos(Math.PI / 4);
	
	public Player(Vector2f position) {
		super(position, new AnimatedSprite(AnimationType.PLAYER_WALKING.getAnimation()));
	}
	
	@Override
	public void update(float secondsElapsed) {
		super.update(secondsElapsed);
		updateViewPosition();
		updateRotation();
		updateSpeed();
		updateVelocity();
	}
	
	public void updateViewPosition() {
		final ViewManager viewManager = ViewManager.getInstance();
		viewManager.setPlayerPosition(position);
		final Vector2i minViewLocation = ViewManager.getInstance().getMinViewLocation();
		final Vector2i maxViewLocation = ViewManager.getInstance().getMaxViewLocation();
		if(position.getX() > minViewLocation.getX() && position.getX() < maxViewLocation.getX()) {
			viewManager.setViewPosition(-position.getX() + GameProperties.resolutionWidth() / 2, viewManager.getViewPosition().getY());
		}
		if(position.getY() > minViewLocation.getY() && position.getY() < maxViewLocation.getY()) {
			viewManager.setViewPosition(viewManager.getViewPosition().getX(), -position.getY() + GameProperties.resolutionHeight() / 2);
		}
	}
	
	public void updateRotation() {
		final InputManager inputManager = InputManager.getInstance();
		final Vector2f mousePosition = Vector2f.of(inputManager.getMousePosition());
		final ViewManager viewManager = ViewManager.getInstance();
		final Vector2f viewPosition = viewManager.getViewPosition();
		final Vector2f relativePosition = Vector2f.subtract(mousePosition, viewPosition);
		angle = getCenter().getAngle(relativePosition);
	}
	
	public void updateSpeed() {
		final InputManager inputManager = InputManager.getInstance();
		
		if(inputManager.isPressed(KeyboardEvent.VK_SHIFT)) {
			speed = (int) GameProperties.runSpeed() * GameProperties.pixelsPerMeter();
		} else {
			speed = (int) GameProperties.walkSpeed() * GameProperties.pixelsPerMeter();
		}
	}
	
	public void updateVelocity() {
		final InputManager inputManager = InputManager.getInstance();
		final float diagonalSpeed = (float) (DIAGONAL * speed);
		
		velocity.clear();
		if(inputManager.isPressed(KeyboardEvent.VK_W, KeyboardEvent.VK_A)) {
			velocity.set(new Vector2f(-diagonalSpeed, -diagonalSpeed));
		} else if(inputManager.isPressed(KeyboardEvent.VK_W, KeyboardEvent.VK_D)) {
			velocity.set(new Vector2f(diagonalSpeed, -diagonalSpeed));
		} else if(inputManager.isPressed(KeyboardEvent.VK_S, KeyboardEvent.VK_A)) {
			velocity.set(new Vector2f(-diagonalSpeed, diagonalSpeed));
		} else if(inputManager.isPressed(KeyboardEvent.VK_S, KeyboardEvent.VK_D)) {
			velocity.set(new Vector2f(diagonalSpeed, diagonalSpeed));
		} else if(inputManager.isPressed(KeyboardEvent.VK_W)) {
			velocity.set(new Vector2f(0, -speed));
		} else if(inputManager.isPressed(KeyboardEvent.VK_S)) {
			velocity.set(new Vector2f(0, speed));
		} else if(inputManager.isPressed(KeyboardEvent.VK_A)) {
			velocity.set(new Vector2f(-speed, 0));
		} else if(inputManager.isPressed(KeyboardEvent.VK_D)) {
			velocity.set(new Vector2f(speed, 0));
		}
	}
}