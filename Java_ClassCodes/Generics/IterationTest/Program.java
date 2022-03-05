class Program {

	public static void main(String[] args) {
		SmartStack<String> a = new SmartStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		for(var i = a.iterator(); i.hasNext(); )
			System.out.println(i.next());
		//System.out.println(a.empty());
		System.out.println("-----------------------------");
		SmartStack<Double> b = new SmartStack<>(); 
		b.push(43.1);
		b.push(65.2);
		b.push(54.3);
		b.push(38.4);
		//for-each loop is supported for Iterable type
		for(double i : b)
			System.out.println(i);
	}

}

