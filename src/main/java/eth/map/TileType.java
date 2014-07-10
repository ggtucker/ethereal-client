package eth.map;

import java.awt.image.BufferedImage;

import eth.sprite.ImageUtil;

public enum TileType {
	GRASS("grass"),
	DIRT("dirt");
	
	private static final String TEXTURE_PATH = "images/textures/%s.png";
	
	private final BufferedImage image;
	
	private TileType(String name) {
		image = ImageUtil.loadImage(getClass().getClassLoader().getResource(getTexturePath(name)));
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	private String getTexturePath(String name) {
		return String.format(TEXTURE_PATH, name);
	}
}