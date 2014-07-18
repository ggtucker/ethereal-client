package eth.client.manager;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import eth.client.core.Client;
import eth.client.event.listeners.TickListener;

public class ClientManager implements TickListener {

	private static ClientManager instance = null;
	
	private final Client client = new Client(4444);
	private final Thread clientThread = new Thread(client);
	
	protected ClientManager() {
		// Exists only to defeat instantiation
	}
	
	public static ClientManager getInstance() {
		if(instance == null) {
			instance = new ClientManager();
		}
		return instance;
	}
	
	public void start() {
		clientThread.start();
	}
	
	public void stop() {
		client.stop();
	}
	
	/*public void sendPacket() {
		InetAddress address = null;
		try {
			address = InetAddress.getByName("localhost");
		} catch (UnknownHostException e) {
			LOGGER.error("Unknown Host", e);
		}
		int port = 9987;
		byte[] buf = new byte[256];
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
		try {
			socket.send(packet);
		} catch (IOException e) {
			LOGGER.error("Couldn't send packet", e);
		}
	}*/
	
	public void tickTimeElapsed(float seconds) {
		// Do something with the client
	}
}
