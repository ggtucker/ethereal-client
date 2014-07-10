package eth.event;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eth.event.events.QuitEvent;
import eth.event.listeners.QuitListener;

public class EventDispatcherTest {
	
	private EventDispatcher dispatcher;
	
	@Mock
	private QuitListener listener;
	
	@Before
	public void fillTheDispatcher() {
		MockitoAnnotations.initMocks(this);
		dispatcher = new EventDispatcher();
		dispatcher.listen(QuitEvent.class, listener);
	}
	
	@Test
	public void listenerReactsWhenNotified() {
		QuitEvent event = new QuitEvent();
		dispatcher.notify(event);
		verify(listener, times(1)).quit();
	}
	
	@Test
	public void listenerReactsWhenNotifiedMultipleTimes() {
		QuitEvent event = new QuitEvent();
		for(int i = 0; i < 10; i++) {
			dispatcher.notify(event);
		}
		verify(listener, times(10)).quit();
	}
	
	@Test
	public void listenerStopsListeningWhenMuted() {
		dispatcher.mute(QuitEvent.class, listener);
		QuitEvent event = new QuitEvent();
		dispatcher.notify(event);
		verify(listener, times(0)).quit();
	}
}
