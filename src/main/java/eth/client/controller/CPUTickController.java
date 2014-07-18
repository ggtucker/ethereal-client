package eth.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import eth.client.event.EventDispatcher;
import eth.client.event.events.TickEvent;
import eth.client.event.listeners.QuitListener;

public class CPUTickController implements QuitListener {
	
	public static final int TIMER_DELAY = 16; // milliseconds
	public static final float TIMER_SECOND_DELAY = TIMER_DELAY / 1000.0F;
	
	private EventDispatcher dispatcher;
	private Timer timer;
	
	public CPUTickController(EventDispatcher dispatcher) {
		this.dispatcher = dispatcher;
		this.timer = new Timer(TIMER_DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tick();
			}
		});
	}
	
	public void run() {
		timer.start();
	}
	
	private void tick() {
		final TickEvent event = new TickEvent(TIMER_SECOND_DELAY);
		dispatcher.notify(event);
	}

	public void quit() {
		timer.stop();
	}
}