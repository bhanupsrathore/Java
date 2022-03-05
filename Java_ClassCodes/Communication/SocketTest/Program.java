import java.io.*;
import java.net.*;

class Program {

	public static void main(String[] args) throws Exception {
		String item = args[0].toLowerCase();
		int quantity = Integer.parseInt(args[1]);
		String host = args.length > 2 ? args[2] : "localhost";
		Socket server = new Socket(host, 4000);
		InputStream input = server.getInputStream();
		OutputStream output = server.getOutputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output), true);
		System.out.println(reader.readLine());
		writer.println(item);
		String info = reader.readLine();
		writer.close();
		reader.close();
		server.close();
		if(info != null){
			String[] parts = info.split(",");
			double price = Double.parseDouble(parts[0].substring(6));
			int stock = Integer.parseInt(parts[1].substring(6));
			if(quantity <= stock){
				System.out.printf("Total payment: %.2f%n", quantity * price);
			}else{
				System.out.println("Item out of stock!");
			}
		}else{
			System.out.println("Item not sold!");
		}
	}
}

