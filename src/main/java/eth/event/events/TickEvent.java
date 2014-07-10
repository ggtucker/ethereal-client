package eth.event.events;

import eth.event.GameEvent;
import eth.event.listeners.TickListener;

public class TickEvent implements GameEvent<TickListener> {
	private final float seconds;
	
	public TickEvent(float seconds) {
		this.seconds = seconds;
	}
	
	public void notify(TickListener listener) {
		listener.tickTimeElapsed(seconds);
	}
}