class Program {

	public static void main(String[] args) {
		double t1 = Double.parseDouble(args[0]);
		double t2 = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		var seq = new LegacySequence(t1, t2);
		System.out.printf("Result = %.3f%n", seq.compute(n));
	}
}

