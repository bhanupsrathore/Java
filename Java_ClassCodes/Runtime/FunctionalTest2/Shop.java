import java.util.*;

record Item(String name, String brand) {}

record Customer(String id, double purchase, int rating) implements Comparable<Customer> {
	public int compareTo(Customer that) {
		return id.compareTo(that.id);
	}
}

class Shop {

	public Item[] getItems() {
		return new Item[] {
			new Item("cpu", "intel"),
			new Item("ssd", "samsung"),
			new Item("mouse", "microsoft"),
			new Item("hdd", "samsung"),
			new Item("motherboard", "intel"),
			new Item("keyboard", "logitech"),
			new Item("ssd", "seagate"),
			new Item("monitor", "samsung"),
		};
	}

	public Collection<Customer> getCustomers() {
		Collection<Customer> customers = new ArrayList<>();
		customers.add(new Customer("rohan", 36000, 4));
		customers.add(new Customer("prashant", 45000, 2));
		customers.add(new Customer("akshay", 24000, 1));
		customers.add(new Customer("rutuja", 68000, 5));
		customers.add(new Customer("upendra", 54000, 3));
		customers.add(new Customer("sanket", 13000, 2));
		customers.add(new Customer("dhananjay", 92000, 4));
		customers.add(new Customer("rani", 49000, 5));
		customers.add(new Customer("pradeep", 29000, 1));
		customers.add(new Customer("nikhil", 52000, 3));
		return customers;
	}
}

