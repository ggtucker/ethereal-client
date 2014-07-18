package eth.client.controller;

import eth.client.event.EventDispatcher;
import eth.client.event.events.KeyboardEvent;

public class KeyController implements java.awt.event.KeyListener {
	private EventDispatcher dispatcher;
	
	public KeyController(EventDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	
	public void keyPressed(java.awt.event.KeyEvent e) {
		final KeyboardEvent event = new KeyboardEvent(e, true);
		dispatcher.notify(event);
	}
	
	public void keyReleased(java.awt.event.KeyEvent e) {
		final KeyboardEvent event = new KeyboardEvent(e, false);
		dispatcher.notify(event);
	}
	
	public void keyTyped(java.awt.event.KeyEvent e) {}
}
