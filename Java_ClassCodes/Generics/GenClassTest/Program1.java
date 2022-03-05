class Program {

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		while(!a.empty())
			System.out.println(a.pop());
		System.out.println("-----------------------------");
		SimpleStack<Double> b = new SimpleStack<>(); //infering type from declaration
		b.push(43.1);
		b.push(65.2);
		b.push(54.3);
		b.push(38.4);
		while(!b.empty())
			System.out.println(b.pop());
	}

}

