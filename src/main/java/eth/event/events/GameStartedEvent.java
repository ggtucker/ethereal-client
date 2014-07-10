package eth.event.events;

import eth.event.GameEvent;
import eth.event.listeners.GameStartedListener;

public class GameStartedEvent implements GameEvent<GameStartedListener> {
	public void notify(GameStartedListener listener) {
		listener.start();
	}
}