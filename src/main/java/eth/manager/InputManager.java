package eth.manager;

import java.util.HashSet;
import java.util.Set;

import eth.event.events.KeyboardEvent;
import eth.event.listeners.KeyboardListener;
import eth.event.listeners.MouseListener;
import eth.math.Vector2i;

public class InputManager implements KeyboardListener, MouseListener {

	private static InputManager instance = null;
	
	private final Set<Integer> pressed = new HashSet<Integer>();
	private final Vector2i mousePosition = new Vector2i(0, 0);
	
	protected InputManager() {
		// Exists only to defeat instantiation
	}
	
	public static InputManager getInstance() {
		if(instance == null) {
			instance = new InputManager();
		}
		return instance;
	}
	
	public boolean isPressed(int... keyCodes) {
		for(int keyCode : keyCodes) {
			if(!pressed.contains(keyCode)) {
				return false;
			}
		}
		return true;
	}
	
	public int getMouseX() {
		return mousePosition.getX();
	}
	
	public int getMouseY() {
		return mousePosition.getY();
	}
	
	public Vector2i getMousePosition() {
		return mousePosition;
	}

	public void keyPressed(KeyboardEvent e) {
		pressed.add(e.getKeyCode());
	}

	public void keyReleased(KeyboardEvent e) {
		pressed.remove(e.getKeyCode());
	}

	public void mouseMoved(int x, int y) {
		mousePosition.set(x - 8, y - 30);
	}
}
