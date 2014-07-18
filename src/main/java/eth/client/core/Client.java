package eth.client.core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.apache.log4j.Logger;

public class Client implements Runnable {
	
	private static final Logger LOGGER = Logger.getLogger(Client.class);
	
	private int port;
	private boolean running;
	private DatagramSocket socket;
	
	public Client(int port) {
		this.port = port;
		this.running = false;
		this.socket = null;
	}
	
	public void run() {
		LOGGER.info("Client is now running");
		openSocket();
		this.running = true;
		while(isRunning()) {
			final byte[] buffer = new byte[4096];
			final DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				if(!isRunning()) {
					LOGGER.info("Client stopped");
					return;
				}
				LOGGER.error("Client had error receiving packet", e);
				continue;
			}
			new ResponseHandler(packet).run();
		}
		LOGGER.info("Client shutting down");
	}
	
	public synchronized boolean isRunning() {
		return this.running;
	}
	
	public synchronized void stop() {
		this.running = false;
		this.socket.close();
	}
	
	private void openSocket() {
		try {
			socket = new DatagramSocket(port);
		} catch (IOException e) {
			throw new RuntimeException("Client could not listen on port " + port, e);
		}
	}
}