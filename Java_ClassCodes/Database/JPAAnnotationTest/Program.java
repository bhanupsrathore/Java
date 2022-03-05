import shopping.ProductEntity;
import javax.persistence.Persistence;

class Program {

	public static void main(String[] args) throws Exception {
		var emf = Persistence.createEntityManagerFactory("SalesPU");
		var em = emf.createEntityManager();
		if(args.length == 0){
			var query = em.createQuery("SELECT e FROM ProductEntity e", ProductEntity.class);
			for(var product : query.getResultList())
				System.out.printf("%d\t%.2f\t%d%n", product.getProductNo(), product.getPrice(), product.getStock());
		}else{
			int id = Integer.parseInt(args[0]);
			var product = em.find(ProductEntity.class, id);
			if(product != null){
				for(var order : product.getOrders())
					System.out.printf("%s\t%d\t%s%n", order.getCustomerId(), order.getQuantity(), order.getOrderDate());
			}else{
				System.out.println("No such product!");
			}
		}
		em.close();
	}
}

