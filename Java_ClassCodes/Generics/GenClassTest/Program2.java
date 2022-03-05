class Program {

	private static void printStack(SimpleStack<?> store) {
		for(int i = 0; !store.empty(); ++i){
			if(i > 0)
				System.out.print(", ");
			System.out.print(store.pop());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		printStack(a);
		SimpleStack<Double> b = new SimpleStack<>(); 
		b.push(43.1);
		b.push(65.2);
		b.push(54.3);
		b.push(38.4);
		printStack(b);
	}

}

