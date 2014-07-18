package eth.client.sprite;

import java.awt.Graphics2D;

import eth.client.math.Vector2f;
import eth.client.sprite.animation.Animation;

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
	public void update(float secondsElapsed, Vector2f position, float angle) {
		if(!paused) {
			this.position = position;
			this.angle = angle;
			animation.update(secondsElapsed);
		}
	}
	
	private void rotate(Graphics2D g) {
		final Vector2f centerPosition = getCenter();
		g.rotate(this.angle, centerPosition.getX(), centerPosition.getY());
	}
}
