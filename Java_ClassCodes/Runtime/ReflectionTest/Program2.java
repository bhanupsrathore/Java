//record is a reference type which produces value-like immutable instances whose
//states cannot be modified. Java compiler (from version 16.0) automatically generates
//a class for the record type which contains private final instance fields along with a constructor
//to initialize them and methods for getting their values. This class also overrides toString,
//hashCode and equals methods of java.lang.Object
record Item(String product, String brand) {}

record Customer(String id, double purchase, int rating) {}


class Program {

	private static void printAsXml(Object info) {
		Class<?> c = info.getClass();
		System.out.printf("<%s>%n", c.getName());
		for(var f : c.getDeclaredFields()){
			System.out.printf("  <%s>", f.getName());
			try{
				f.setAccessible(true);
				System.out.print(f.get(info));
			}catch(Exception e){
				System.out.print(e);
			}
			System.out.printf("</%s>%n", f.getName());
		}
		System.out.printf("</%s>%n", c.getName());
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

