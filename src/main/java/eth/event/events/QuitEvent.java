package eth.event.events;

import eth.event.GameEvent;
import eth.event.listeners.QuitListener;

public class QuitEvent implements GameEvent<QuitListener> {
	public void notify(QuitListener listener) {
		listener.quit();
	}
}