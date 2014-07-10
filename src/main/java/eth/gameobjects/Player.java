package eth.gameobjects;

import eth.event.events.KeyboardEvent;
import eth.manager.InputManager;
import eth.manager.ViewManager;
import eth.math.Vector2f;
import eth.math.Vector2i;
import eth.properties.GameProperties;
import eth.properties.PlayerProperties;
import eth.sprite.AnimatedSprite;
import eth.sprite.animation.AnimationType;

public class Player extends GameObject {
	
	private final double DIAGONAL = Math.cos(Math.PI / 4);
	
	public Player(Vector2f position) {
		super(position, new AnimatedSprite(AnimationType.PLAYER_WALKING.getAnimation()));
	}
	
	@Override
	public void update(float secondsElapsed) {
		super.update(secondsElapsed);
		velocity.clear();
		
		// Update player and view position
		final ViewManager viewManager = ViewManager.getInstance();
		viewManager.setPlayerPosition(position);
		final Vector2i minViewLocation = GameProperties.minViewLocation();
		final Vector2i maxViewLocation = GameProperties.maxViewLocation();
		if(position.getX() > minViewLocation.getX() && position.getX() < maxViewLocation.getX()) {
			viewManager.setViewPosition(-position.getX() + GameProperties.resolutionWidth() / 2, viewManager.getViewPosition().getY());
		}
		if(position.getY() > minViewLocation.getY() && position.getY() < maxViewLocation.getY()) {
			viewManager.setViewPosition(viewManager.getViewPosition().getX(), -position.getY() + GameProperties.resolutionHeight() / 2);
		}
		
		final InputManager inputManager = InputManager.getInstance();
		
		// Update speed
		if(inputManager.isPressed(KeyboardEvent.VK_SHIFT)) {
			speed = (int) PlayerProperties.runSpeed() * GameProperties.pixelsPerMeter();
		} else {
			speed = (int) PlayerProperties.walkSpeed() * GameProperties.pixelsPerMeter();
		}
		
		final float diagonalSpeed = (float) (DIAGONAL * speed);
		
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
