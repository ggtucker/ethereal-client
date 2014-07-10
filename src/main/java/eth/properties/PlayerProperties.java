package eth.properties;

public class PlayerProperties {

	private PlayerProperties() {
		// Prevent construction
	}
	
	private static float walkSpeed = 4.0F;
	private static float runSpeed = 6.0F;
	
	public static float walkSpeed() {
		return walkSpeed;
	}
	
	public static float runSpeed() {
		return runSpeed;
	}
}
