package eth.application;

import eth.controller.CPUTickController;
import eth.controller.KeyController;
import eth.controller.MouseController;
import eth.core.GameWorld;
import eth.event.EventDispatcher;
import eth.event.events.KeyboardEvent;
import eth.event.events.MouseEvent;
import eth.event.events.QuitEvent;
import eth.event.events.TickEvent;
import eth.gameobjects.Player;
import eth.manager.GameObjectManager;
import eth.manager.InputManager;
import eth.manager.MapManager;
import eth.math.Vector2f;
import eth.view.GameFrame;
import eth.view.GamePanel;

public class EtherealApplication {
	public static void main(String[] args) {
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
		
		tickController.run();
	}
}