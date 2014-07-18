package eth.client.application;

import eth.client.controller.CPUTickController;
import eth.client.controller.KeyController;
import eth.client.controller.MouseController;
import eth.client.core.GameWorld;
import eth.client.event.EventDispatcher;
import eth.client.event.events.KeyboardEvent;
import eth.client.event.events.MouseEvent;
import eth.client.event.events.QuitEvent;
import eth.client.event.events.TickEvent;
import eth.client.gameobjects.Player;
import eth.client.manager.ClientManager;
import eth.client.manager.GameObjectManager;
import eth.client.manager.InputManager;
import eth.client.manager.MapManager;
import eth.client.math.Vector2f;
import eth.client.view.GameFrame;
import eth.client.view.GamePanel;

public class ClientApplication {
	public static void main(String[] args) {
		org.apache.log4j.BasicConfigurator.configure();
		
		// Create event dispatcher
		final EventDispatcher dispatcher = new EventDispatcher();
		
		// Register controllers
		final CPUTickController tickController = new CPUTickController(dispatcher);
		final KeyController keyController = new KeyController(dispatcher);
		final MouseController mouseController = new MouseController(dispatcher);
		
		// Register game world
		final GameWorld gameWorld = new GameWorld(dispatcher);
		
		// Register game view (frame & panel)
		final GamePanel gamePanel = new GamePanel();
		final GameFrame gameFrame = new GameFrame(dispatcher);
		gameFrame.add(gamePanel);
		gameFrame.addKeyListener(keyController);
		gameFrame.addMouseListener(mouseController);
		gameFrame.addMouseMotionListener(mouseController);
		
		// Acquire managers
		final ClientManager clientManager = ClientManager.getInstance();
		final GameObjectManager gameObjectManager = GameObjectManager.getInstance();
		final InputManager inputManager = InputManager.getInstance();
		final MapManager mapManager = MapManager.getInstance();
		
		// Instantiate game objects
		final Player player = new Player(new Vector2f(96, 96));
		gameObjectManager.addGameObject(player);
		
		// Add sprites to world
		player.addSpriteToWorld();
		
		// Assign listeners
		dispatcher.listen(QuitEvent.class, tickController);
		dispatcher.listen(TickEvent.class, gameWorld);
		dispatcher.listen(TickEvent.class, gamePanel);
		dispatcher.listen(TickEvent.class, gameObjectManager);
		dispatcher.listen(TickEvent.class, mapManager);
		dispatcher.listen(KeyboardEvent.class, inputManager);
		dispatcher.listen(MouseEvent.class, inputManager);
		
		clientManager.start();
		tickController.run();
	}
}