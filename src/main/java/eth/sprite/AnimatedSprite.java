package eth.sprite;

import java.awt.Graphics2D;

import eth.manager.InputManager;
import eth.manager.ViewManager;
import eth.math.Vector2f;
import eth.sprite.animation.Animation;

public class AnimatedSprite extends SpriteObject {

	private Animation animation;
	private boolean paused;
	
	public AnimatedSprite(Animation animation) {
		this.animation = animation;
		this.paused = false;
		setSize(Vector2f.of(animation.getSize()));
	}
	
	@Override
	public void draw(Graphics2D g) {
		rotate(g);
		animation.draw(g, (int) position.getX(), (int) position.getY()); 
	}

	@Override
	public void update(float secondsElapsed, Vector2f position, Vector2f direction) {
		if(!paused) {
			this.position = position;
			this.direction = direction;
			animation.update(secondsElapsed);
		}
	}
	
	// TODO
	private void rotate(Graphics2D g) {
		final InputManager inputManager = InputManager.getInstance();
		final Vector2f mousePosition = Vector2f.of(inputManager.getMousePosition());
		final ViewManager viewManager = ViewManager.getInstance();
		final Vector2f viewPosition = viewManager.getViewPosition();
		final Vector2f relativePosition = Vector2f.subtract(mousePosition, viewPosition);
		final Vector2f centerPosition = getCenter();
		g.rotate(centerPosition.getAngle(relativePosition), centerPosition.getX(), centerPosition.getY());
	}
}
