//record is a reference type which produces value-like immutable instances whose
//states cannot be modified. Java compiler (from version 16.0) automatically generates
//a class for the record type which contains private final instance fields along with a constructor
//to initialize them and methods for getting their values. This class also overrides toString,
//hashCode and equals methods of java.lang.Object
record Item(String name, String brand) {}

record Customer(String id, double purchase, int rating) {}


class Program {

	private static void printAsXml(Item info) {
		System.out.println("<Item>");
		System.out.printf("  <name>%s</name>%n", info.name());
		System.out.printf("  <brand>%s</brand>%n", info.brand());
		System.out.println("</Item>");
		System.out.println();
	}

	private static void printAsXml(Customer info) {
		System.out.println("<Customer>");
		System.out.printf("  <id>%s</id>%n", info.id());
		System.out.printf("  <purchase>%s</purchase>%n", info.purchase());
		System.out.printf("  <rating>%s</rating>%n", info.rating());
		System.out.println("</Customer>");
		System.out.println();
		
	}

	public static void main(String[] args) {
		Item a = new Item("cpu", "intel");
		printAsXml(a);
		Item b = new Item("ssd", "seagate");
		printAsXml(b);
		Customer c = new Customer("Jack", 34000, 3);
		printAsXml(c);
	}
}

