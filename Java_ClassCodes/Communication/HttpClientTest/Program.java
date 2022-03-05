import java.net.*;
import java.net.http.*;

class Program {

	public static void main(String[] args) throws Exception{
		String item = args[0].toLowerCase();
		int quantity = Integer.parseInt(args[1]);
		URI site = new URI("http://localhost:4000/shop/" + item);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
						.GET()
						.uri(site)
						.build();
		var response = client.send(request, HttpResponse.BodyHandlers.ofString());
		if(response.statusCode() == 200){
			String[] parts = response.body().split(",");
			double price = Double.parseDouble(parts[0].substring(6));
			int stock = Integer.parseInt(parts[1].substring(6));
			if(quantity <= stock)
				System.out.printf("Total Payment: %.2f%n", quantity * price);
			else
				System.out.println("Item out of stock!");
		}else{
			System.out.println("Item not sold!");
		}
	}
}

