import java.net.*;
import java.util.*;

class Program {

	public static void main(String[] args) throws Exception {
		String[] symbols = {"APPL", "GOGL", "INTC", "MSFT", "ORCL"};
		Random rdm = new Random();
		DatagramSocket publisher = new DatagramSocket();
		InetAddress addr = InetAddress.getByName("230.0.0.1"); //class D address: 224-239.*.*.*
		for(;;){
			int i = rdm.nextInt(5);
			double p = 0.01 * (1000 + rdm.nextInt(9000));
			String message = String.format("%s - %.2f", symbols[i], p);
			byte[] data = message.getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, addr, 5000);
			publisher.send(packet);
			Thread.sleep(10000);
		}
	}
}

