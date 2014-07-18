package eth.client.math;

public class IntRect {

	private Vector2i position;
	private Vector2i size;
	
	public IntRect(int x, int y, int width, int height) {
		this.position = new Vector2i(x, y);
		this.size = new Vector2i(width, height);
	}
	
	public IntRect(Vector2i position, Vector2i size) {
		this.position = position;
		this.size = size;
	}
	
	public void setPosition(Vector2i position) {
		this.position = position;
	}
	
	public Vector2i getPosition() {
		return position;
	}
	
	public Vector2i getSize() {
		return size;
	}
	
	public int getX() {
		return position.getX();
	}
	
	public int getY() {
		return position.getY();
	}
	
	public int getWidth() {
		return size.getX();
	}
	
	public int getHeight() {
		return size.getY();
	}
}
