package eth.event.listeners;

import eth.event.events.KeyboardEvent;

public interface KeyboardListener {
	public void keyPressed(KeyboardEvent e);
	public void keyReleased(KeyboardEvent e);
}
