class Program {


	public static void main(String[] args) {
		System.out.println("Welcome Investor");
		double s = Double.parseDouble(args[0]);
		int y = Integer.parseInt(args[1]);
		Investment i = new Investment(s, y);
		System.out.printf("Income in risk-free investment: %.2f%n", i.income());
		i.allowRisk(true);
		System.out.printf("Income in riskful investment: %.2f%n", i.income());
	}

}

