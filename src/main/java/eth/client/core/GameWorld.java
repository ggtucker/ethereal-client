package eth.client.core;

import eth.client.event.EventDispatcher;
import eth.client.event.events.GameStartedEvent;
import eth.client.event.listeners.TickListener;

public class GameWorld implements TickListener {
	private EventDispatcher dispatcher;
	private GameState state;
	
	public GameWorld(EventDispatcher dispatcher) {
		this.dispatcher = dispatcher;
		state = GameState.PREPARING;
	}
	
	public void startGame() {
		state = GameState.RUNNING;
		GameStartedEvent event = new GameStartedEvent();
		dispatcher.notify(event);
	}
	
	public void tickTimeElapsed(float seconds) {
		if(state == GameState.PREPARING) {
			startGame();
		}
	}
}
