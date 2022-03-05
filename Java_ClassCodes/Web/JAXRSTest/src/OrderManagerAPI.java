:package modern.web.app;

import shopping.*;
import java.rmi.*;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/orders")
public class OrderManagerAPI {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readOrders(@PathParam("id") String customer) {
		try{
			OrderManager stub = (OrderManager)Naming.lookup("rmi://localhost:7000/orderManager");
			List<OrderEntity> orders = stub.getOrdersOf(customer);
			if(orders.size() == 0)
				return Response.status(404).build();
			return Response.status(200).entity(orders).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOrder(OrderEntity info) {
		try{
			OrderManager stub = (OrderManager)Naming.lookup("rmi://localhost:7000/orderManager");
			int orderNo = stub.placeOrder(info.getCustomerId(), info.getProductNo(), info.getQuantity());
			info.setOrderNo(orderNo);
			return Response.ok(info).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}
}

