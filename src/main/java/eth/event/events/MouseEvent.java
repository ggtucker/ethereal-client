package eth.event.events;

import eth.event.GameEvent;
import eth.event.listeners.MouseListener;

public class MouseEvent implements GameEvent<MouseListener> {
	private final int x;
	private final int y;
	
	public MouseEvent(int x, int y)  {
		this.x = x;
		this.y = y;
	}

	public void notify(MouseListener listener) {
		listener.mouseMoved(x, y);
	}
}
