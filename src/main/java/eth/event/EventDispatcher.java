package eth.event;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher {
	@SuppressWarnings("rawtypes")
	private final HashMap<Class, ArrayList> map = new HashMap<Class, ArrayList>();
	
	public <L> void listen(Class<? extends GameEvent<L>> event, L listener) {
		final ArrayList<L> listeners = listenersOf(event);
		
		synchronized(listeners) {
			if(!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}
	
	public <L> void mute(Class<? extends GameEvent<L>> type, L listener) {
		final ArrayList<L> listeners = listenersOf(type);
		
		synchronized(listeners) {
			listeners.remove(listener);
		}
	}
	
	public <L> void notify(final GameEvent<L> event) {
		@SuppressWarnings("unchecked")
		final Class<GameEvent<L>> type = (Class<GameEvent<L>>) event.getClass();
		final ArrayList<L> listeners = listenersOf(type);
		
		for(L listener : listeners) {
			event.notify(listener);
		}
	}
	
	private <L> ArrayList<L> listenersOf(Class<? extends GameEvent<L>> type) {
		synchronized(map) {
			@SuppressWarnings("unchecked")
			final ArrayList<L> existing = map.get(type);
			if(existing != null) {
				return existing;
			}
			
			final ArrayList<L> created = new ArrayList<L>();
			map.put(type, created);
			return created;
		}
	}
}
