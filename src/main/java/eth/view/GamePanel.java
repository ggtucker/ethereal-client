package eth.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import eth.event.listeners.TickListener;
import eth.manager.MapManager;
import eth.manager.SpriteManager;
import eth.manager.ViewManager;
import eth.map.Chunk;
import eth.math.Vector2f;
import eth.sprite.SpriteObject;

public class GamePanel extends JPanel implements TickListener {
	private static final long serialVersionUID = 1L;
	
	private final MapManager mapManager = MapManager.getInstance();
	
	private final SpriteManager spriteManager = SpriteManager.getInstance();
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		final Graphics2D g2d = (Graphics2D) g;
		
		// Move view to player view location
		final ViewManager viewManager = ViewManager.getInstance();
		final Vector2f viewPosition = viewManager.getViewPosition();
		g2d.translate(viewPosition.getX(), viewPosition.getY());
		
		// Draw chunks
		final List<Chunk> chunks = mapManager.getMap().getNearbyChunks();
		for(int i = 0; i < chunks.size(); i++) {
			final Chunk chunk = chunks.get(i);
			chunk.draw(g2d);
		}
		
		// Draw sprites
		for(final SpriteObject sprite : spriteManager.getSprites()) {
			sprite.draw(g2d);
		}
	}

	public void tickTimeElapsed(float seconds) {
		repaint();
	}
}
