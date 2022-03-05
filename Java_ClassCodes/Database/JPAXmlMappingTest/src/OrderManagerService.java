package shopping;

import java.util.List;
import java.rmi.RemoteException;
import javax.persistence.Persistence;

public class OrderManagerService extends java.rmi.server.UnicastRemoteObject implements OrderManager {

	public OrderManagerService() throws RemoteException {
		super(); //exports this object on a random TCP port
	}

	public int placeOrder(String customerId, int productNo, int quantity) throws RemoteException {
		var emf = Persistence.createEntityManagerFactory("SalesPU");
		var em = emf.createEntityManager();
		try{
			var tx = em.getTransaction();
			tx.begin();
			var ctr = em.find(CounterEntity.class, "orders");
			var ord = new OrderEntity();
			ord.setOrderNo(ctr.getNextValue() + 1000);
			ord.setOrderDate(new java.util.Date());
			ord.setCustomerId(customerId);
			ord.setProductNo(productNo);
			ord.setQuantity(quantity);
			em.persist(ord);
			tx.commit(); //save all the changes made to the in-memory entities
			return ord.getOrderNo();
		}finally{
			em.close();
		}	
	}

	public List<OrderEntity> getOrdersOf(String customerId) throws RemoteException {
		var emf = Persistence.createEntityManagerFactory("SalesPU");
		var em = emf.createEntityManager();
		try{
			var query = em.createQuery("SELECT e FROM OrderEntity e WHERE e.customerId=?1", OrderEntity.class);
			query.setParameter(1, customerId);
			return query.getResultList();
		}finally{
			em.close();
		}	

	}
}


