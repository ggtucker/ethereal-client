package eth.math;

public class Vector2i {
	private int x, y;
	
	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2i clone() {
		return new Vector2i(x, y);
	}
	
	public void clear() {
		this.x = 0;
		this.y = 0;
	}
	
	public void set(Vector2i other) {
		if(other == null) return;
		set(other.x, other.y);
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public float getAngle(Vector2i target) {
		float angle = (float) Math.atan2(target.getY() - y, target.getX() - x);
		angle += Math.PI / 2.0;
		if(angle < 0){
			angle += 2.0 * Math.PI;
		}
	    return angle;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2i other = (Vector2i) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vector2 [x=" + x + ", y=" + y + "]";
	}
	
	public static Vector2i of(Vector2f floatVector) {
		return new Vector2i((int) floatVector.getX(), (int) floatVector.getY());
	}
	
	public static Vector2i add(Vector2i first, Vector2i second) {
		if(first == null || second == null) {
			return null;
		}
		return new Vector2i(first.x + second.x, first.y + second.y);
	}
	
	public static Vector2i subtract(Vector2i first, Vector2i second) {
		if(first == null || second == null) {
			return null;
		}
		return new Vector2i(first.x - second.x, first.y - second.y);
	}
	
	public static float dot(Vector2i first, Vector2i second) {
		if(first == null || second == null) {
			return 0.0F;
		}
		return first.x * second.x + first.y * second.y;
	}
	
	public static Vector2i multiply(Vector2i first, int scalar) {
		if(first == null) {
			return null;
		}
		return new Vector2i(first.x * scalar, first.y * scalar);
	}
}
