import java.io.*;
import java.net.*;

class Program {

	public static void main(String[] args) throws Exception {
		var listener = new ServerSocket(4000);
		service(listener);
	}

	private static void service(ServerSocket server) throws IOException {
		Shop shop = Shop.open("store.xml");
		for(;;){
			Socket client = server.accept();
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(output));
			try{
				client.setSoTimeout(20000);
				writer.println("Welcome to YourBit Computers");
				writer.flush();
				String item = reader.readLine();
				String info = shop.getItemInfo(item);
				if(info != null){
					writer.println(info);
					writer.flush();
				}
					
			}catch(Exception e){}
			writer.close();
			reader.close();
			client.close();
		}
	}
}

