package eth.client.core;

import java.net.DatagramPacket;

public class ResponseHandler implements Runnable {
	
	private final DatagramPacket packet;
	
	public ResponseHandler(DatagramPacket packet) {
		this.packet = packet;
	}
	
	public void run() {
		System.out.println(packet.getAddress());
	}
}
