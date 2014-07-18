package eth.client.controller;

import eth.client.event.EventDispatcher;
import eth.client.event.events.MouseEvent;

public class MouseController implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener {
	private EventDispatcher dispatcher;
	
	public MouseController(EventDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	
	public void mouseDragged(java.awt.event.MouseEvent e) {
	}

	public void mouseMoved(java.awt.event.MouseEvent e) {
		final MouseEvent event = new MouseEvent(e.getX(), e.getY());
		dispatcher.notify(event);
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
	}
}
