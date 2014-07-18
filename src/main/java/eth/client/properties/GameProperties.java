package eth.client.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import eth.client.math.Vector2i;

public class GameProperties {
	private static final Logger LOGGER = Logger.getLogger(GameProperties.class);
	private static final String PROPERTIES_FILE_NAME = "gameProperties";
	
	public static final String RESOLUTION_WIDTH = "resolution_width";
	public static final String RESOLUTION_HEIGHT = "resolution_height";
	public static final String WINDOW_WIDTH = "window_width";
	public static final String WINDOW_HEIGHT = "window_height";
	public static final String PIXELS_PER_METER = "ppm";
	public static final String TILE_SIZE = "tile_size";
	public static final String CHUNK_LENGTH = "chunk_length";
	
	// To be put on server side later
	public static final String WALK_SPEED = "walk_speed";
	public static final String RUN_SPEED = "run_speed";
	
	private static final Properties properties = new Properties();
	
	static {
		loadProperties();
	}
	
	public static int windowWidth() {
		return getInt(WINDOW_WIDTH);
	}
	
	public static int windowHeight() {
		return getInt(WINDOW_HEIGHT);
	}
	
	public static int resolutionWidth() {
		return getInt(RESOLUTION_WIDTH);
	}
	
	public static int resolutionHeight() {
		return getInt(RESOLUTION_HEIGHT);
	}
	
	public static Vector2i resolution() {
		return new Vector2i(getInt(RESOLUTION_WIDTH), getInt(RESOLUTION_HEIGHT));
	}
	
	public static int pixelsPerMeter() {
		return getInt(PIXELS_PER_METER);
	}
	
	public static int tileSize() {
		return getInt(TILE_SIZE);
	}
	
	public static int chunkLength() {
		return getInt(CHUNK_LENGTH);
	}
	
	public static float walkSpeed() {
		return getFloat(WALK_SPEED);
	}
	
	public static float runSpeed() {
		return getFloat(RUN_SPEED);
	}
	
	public static void set(String key, String value) {
		properties.setProperty(key, value);
	}
	
	public static void set(String key, int value) {
		properties.setProperty(key, Integer.toString(value));
	}
	
	public static void set(String key, float value) {
		properties.setProperty(key, Float.toString(value));
	}
	
	public static void saveProperties() {
		try {
			final FileOutputStream out = new FileOutputStream(PROPERTIES_FILE_NAME);
			properties.store(out, "---Game Properties---");
			out.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("Properties file not found", e);
		} catch (IOException e) {
			LOGGER.error("Problem writing to properties output stream", e);
		}
	}
	
	public static void loadProperties() {
		try {
			final FileInputStream fileInput = new FileInputStream(PROPERTIES_FILE_NAME);
			properties.load(fileInput);
			fileInput.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("Properties file not found", e);
		} catch (IOException e) {
			LOGGER.error("Problem reading from properties input stream", e);
		}
	}
	
	private static String getString(String key) {
		return properties.getProperty(key);
	}
	
	private static int getInt(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}
	
	private static float getFloat(String key) {
		return Float.parseFloat(properties.getProperty(key));
	}
}