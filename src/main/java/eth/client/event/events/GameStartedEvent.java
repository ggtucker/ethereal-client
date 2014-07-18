package eth.client.event.events;

import eth.client.event.GameEvent;
import eth.client.event.listeners.GameStartedListener;

public class GameStartedEvent implements GameEvent<GameStartedListener> {
	public void notify(GameStartedListener listener) {
		listener.start();
	}
}