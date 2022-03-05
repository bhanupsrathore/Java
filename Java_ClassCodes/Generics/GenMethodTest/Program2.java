class Program {

	private static Object select(int choice, Object first, Object second) {
		if((choice % 2) == 1)
			return first;
		return second;
	}


	public static void main(String[] args) {
		if(args.length > 0)
		{
			int s = Integer.parseInt(args[0]);
			String ss = (String) select(s, "Monday", "Tuesday");
			System.out.printf("Selected String = %s%n", ss);
			//auto-boxing - converting a primitive (double) type into Object type by enclosing  
			//its value in an instance of its wrapper class (java.lang.Double)
			double sd = (double)select(s, 54.3, 45.6);
			System.out.printf("Selected double = %s%n", sd);
			Interval si = (Interval)select(s, new Interval(2, 30), "3:20");	
			System.out.printf("Selected Interval = %s%n", si);
		}
	}
}

