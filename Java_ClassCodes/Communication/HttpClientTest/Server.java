class Server {

	public static void main(String[] args) throws Exception {
		var shop = Shop.open("store.xml");
		var port = new java.net.InetSocketAddress(4000);
		var server = com.sun.net.httpserver.HttpServer.create(port, 10);
		server.createContext("/shop", client -> {
			String item = client.getRequestURI().getPath().substring(6);
			String info = shop.getItemInfo(item);
			if(info != null){
				byte[] content = info.getBytes();
				client.sendResponseHeaders(200, content.length);
				var output = client.getResponseBody();
				output.write(content);
				output.close();
			}else{
				client.sendResponseHeaders(404, -1);
			}
		});
		server.start();
	}
}

