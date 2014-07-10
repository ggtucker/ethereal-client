package eth.event.events;

import eth.event.GameEvent;
import eth.event.listeners.KeyboardListener;

public class KeyboardEvent extends java.awt.event.KeyEvent implements GameEvent<KeyboardListener> {
	private static final long serialVersionUID = 1L;
	
	private final boolean isPressed;
	
	public KeyboardEvent(java.awt.event.KeyEvent e, boolean isPressed) {
		super(e.getComponent(), e.getID(), e.getWhen(), e.getModifiers(),
				e.getKeyCode(), e.getKeyChar(), e.getKeyLocation());
		this.isPressed = isPressed;
	}
	
	public void notify(KeyboardListener listener) {
		if(isPressed) {
			listener.keyPressed(this);
		} else {
			listener.keyReleased(this);
		}
	}

	@Override
	public String toString() {
		String eventType = "KEY_RELEASED";
		if(isPressed) {
			eventType = "KEY_PRESSED";
		}
		return "KeyEvent [" + eventType + ",keyCode=" + getKeyCode()
				+ ",keyText=" + getKeyText(getKeyCode()) + ",keyChar=" + getKeyChar() + "]";
	}
}
