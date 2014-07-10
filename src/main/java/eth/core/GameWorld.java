package eth.core;

import eth.event.EventDispatcher;
import eth.event.events.GameStartedEvent;
import eth.event.listeners.TickListener;

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
