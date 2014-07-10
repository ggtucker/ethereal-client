package eth.sprite.animation;

import java.awt.image.BufferedImage;

import eth.math.Vector2i;
import eth.sprite.ImageUtil;

public enum AnimationType {
	PLAYER_WALKING("playerWalking", new Vector2i(64, 64), 15, 4, 0.05F);
	
	private static final String TEXTURE_PATH = "images/sprites/%s.png";
	
	private final Animation animation;
	
	private AnimationType(String name, Vector2i spriteSize, int numFrames, int numColumns, float timePeriod) {
		final BufferedImage spriteSheet = ImageUtil.loadImage(getClass().getClassLoader().getResource(getTexturePath(name)));
		this.animation = new Animation(spriteSheet, spriteSize, numFrames, numColumns, timePeriod);
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	private String getTexturePath(String name) {
		return String.format(TEXTURE_PATH, name);
	}
}