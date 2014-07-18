package eth.client.event.listeners;

import eth.client.event.events.KeyboardEvent;

public interface KeyboardListener {
	public void keyPressed(KeyboardEvent e);
	public void keyReleased(KeyboardEvent e);
}
