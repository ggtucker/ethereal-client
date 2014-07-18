package eth.client.sprite.animation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import eth.client.math.Vector2i;

public class Animation {
	
	private BufferedImage spriteSheet;
	private Vector2i spriteSize;
	private int numFrames;
	private int numColumns;
	private int index;
	
	private float timePeriod;
	private float timeElapsed;
	
	public Animation(BufferedImage spriteSheet, Vector2i spriteSize, int numFrames, int numColumns, float timePeriod) {
		this.spriteSheet = spriteSheet;
		this.spriteSize = spriteSize;
		this.numFrames = numFrames;
		this.numColumns = numColumns;
		this.timePeriod = timePeriod;
		this.index = 0;
		this.timeElapsed = 0.0F;
	}
	
	public void update(float deltaTime) {
		if(timePeriod == 0) {
			return;
		}
		
		timeElapsed += deltaTime;
		
		if(timeElapsed >= timePeriod) {
			timeElapsed -= timePeriod;
			
			if(index + 1 < numFrames) {
				index++;
			} else {
				index = 0;
			}
		}
	}
	
	public void draw(Graphics2D g, int frameX, int frameY) {
		final int row = index / numColumns;
		final int col = index % numColumns;
		final int pixelX = col * spriteSize.getX();
		final int pixelY = row * spriteSize.getY();
		
		g.drawImage(
				spriteSheet,
				frameX,
				frameY,
				frameX + spriteSize.getX(),
				frameY + spriteSize.getY(),
				pixelX,
				pixelY,
				pixelX + spriteSize.getX(),
				pixelY + spriteSize.getY(),
				null);
	}
	
	public Vector2i getSize() {
		return spriteSize;
	}
}
