package eth.client.math;

public class FloatRect {

	private Vector2f position;
	private Vector2f size;
	
	public FloatRect(float x, float y, float width, float height) {
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(width, height);
	}
	
	public FloatRect(Vector2f position, Vector2f size) {
		this.position = position;
		this.size = size;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public Vector2f getSize() {
		return size;
	}
	
	public float getX() {
		return position.getX();
	}
	
	public float getY() {
		return position.getY();
	}
	
	public float getWidth() {
		return size.getX();
	}
	
	public float getHeight() {
		return size.getY();
	}
}
