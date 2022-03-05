import shopping.OrderManager;
import java.rmi.Naming;

class Program {
	
	public static void main(String[] args) throws Exception {
		var stub = (OrderManager)Naming.lookup("rmi://localhost:7000/orderManager");
		String customerId = args[0].toUpperCase();
		try{
			if(args.length > 2){
				int productNo = Integer.parseInt(args[1]);
				int quantity = Integer.parseInt(args[2]);
				int orderNo = stub.placeOrder(customerId, productNo, quantity);
				System.out.printf("New Order Number: %d%n", orderNo);
			}else{
				var orders = stub.getOrdersOf(customerId);
				for(var order : orders)
					System.out.printf("%d\t%d\t%s%n", order.getProductNo(), order.getQuantity(), order.getOrderDate());
			}
		}catch(Exception e){
			System.out.printf("Remote Operation Failed: %s%n", e);
		}
	}
	
}

