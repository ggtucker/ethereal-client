package eth.client.event.events;

import eth.client.event.GameEvent;
import eth.client.event.listeners.QuitListener;

public class QuitEvent implements GameEvent<QuitListener> {
	public void notify(QuitListener listener) {
		listener.quit();
	}
}