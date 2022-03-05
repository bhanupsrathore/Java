class Program {

	private static <T> T select(int choice, T first, T second) {
		if((choice % 2) == 1)
			return first;
		return second;
	}

	private static <T extends Comparable<T>> T select(T first, T second) {
		if(first.compareTo(second) > 0)
			return first;
		return second;
	}

	public static void main(String[] args) {
		if(args.length > 0)
		{
			int s = Integer.parseInt(args[0]);
			String ss = select(s, "Monday", "Tuesday");
			System.out.printf("Selected String = %s%n", ss);
			double sd = select(s, 54.3, 45.6);
			System.out.printf("Selected double = %s%n", sd);
			//Interval si = select(s, new Interval(2, 30), "3:20");	
			Interval si = select(s, new Interval(2, 30), new Interval(3, 20));	
			System.out.printf("Selected Interval = %s%n", si);
		}else{
			String ss = select("Monday", "Tuesday");
			System.out.printf("Selected String = %s%n", ss);
			double sd = select(54.3, 45.6);
			System.out.printf("Selected double = %s%n", sd);
			Interval si = select(new Interval(2, 30), new Interval(3, 20));	
			System.out.printf("Selected Interval = %s%n", si);
		}
	}
}

