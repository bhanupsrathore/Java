import java.net.*;

class Program {
	
	public static void main(String[] args) throws Exception {
		InetSocketAddress group = new InetSocketAddress("230.0.0.1", 0);
		MulticastSocket subscriber = new MulticastSocket(5000);
		subscriber.joinGroup(group, null);
		DatagramPacket packet = new DatagramPacket(new byte[65507], 65507);
		for(int i = 0; i < 5; ++i){
			subscriber.receive(packet);
			String message = new String(packet.getData(), 0, packet.getLength());
			System.out.println(message);
		}
		subscriber.leaveGroup(group, null);
		subscriber.close();
	}
}

