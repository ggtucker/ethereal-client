package eth.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import eth.event.EventDispatcher;
import eth.event.events.QuitEvent;
import eth.properties.GameProperties;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private final EventDispatcher dispatcher;
	
	public GameFrame(EventDispatcher dispatcher) {
		this.dispatcher = dispatcher;
		initGUI();
	}
	
	private void initGUI() {
		final int windowWidth = GameProperties.windowWidth();
		final int windowHeight = GameProperties.windowHeight();
		
		setTitle("Ethereal game");
		addWindowListener(new WindowCloseAdapter());
		setBounds(0, 0, windowWidth + 8, windowHeight + 30);
		setResizable(false);
		setVisible(true);
	}
	
	private class WindowCloseAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent windowEvent) {
			QuitEvent event = new QuitEvent();
			dispatcher.notify(event);
			System.exit(0);
	    }
	}
}
