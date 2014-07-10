package eth.math;

public class Vector2f {
	private float x, y;
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2f clone() {
		return new Vector2f(x, y);
	}
	
	public void clear() {
		this.x = 0;
		this.y = 0;
	}
	
	public void set(Vector2f other) {
		if(other == null) return;
		set(other.x, other.y);
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getAngle(Vector2f target) {
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
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
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
		Vector2f other = (Vector2f) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vector2 [x=" + x + ", y=" + y + "]";
	}
	
	public static Vector2f of(Vector2i intVector) {
		return new Vector2f(intVector.getX(), intVector.getY());
	}
	
	public static Vector2f add(Vector2f first, Vector2f second) {
		if(first == null || second == null) {
			return null;
		}
		return new Vector2f(first.x + second.x, first.y + second.y);
	}
	
	public static Vector2f subtract(Vector2f first, Vector2f second) {
		if(first == null || second == null) {
			return null;
		}
		return new Vector2f(first.x - second.x, first.y - second.y);
	}
	
	public static float dot(Vector2f first, Vector2f second) {
		if(first == null || second == null) {
			return 0.0F;
		}
		return first.x * second.x + first.y * second.y;
	}
	
	public static Vector2f multiply(Vector2f first, float scalar) {
		if(first == null) {
			return null;
		}
		return new Vector2f(first.x * scalar, first.y * scalar);
	}
}
