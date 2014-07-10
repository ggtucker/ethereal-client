package eth.map;

import java.util.Random;

public class Tile {

	private TileType type;
	
	public Tile() {
		final Random random = new Random();
		switch(random.nextInt(2)) {
			case 0:
				this.type = TileType.GRASS;
				break;
			default:
				this.type = TileType.DIRT;
				break;
		}
	}
	
	public Tile(TileType type) {
		this.type = type;
	}
	
	public TileType getType() {
		return type;
	}
}