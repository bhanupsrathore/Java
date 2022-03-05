class Investment {

	//instance fields - each object will contain its own values
	private double sum;
	private int years;
	private boolean risk;

	//parameterized constructor
	public Investment(double amount, int period) {
		sum = amount;
		years = period;
		risk = false;
	}

	public void allowRisk(boolean yes) {
		risk = yes;
	}

	public double income() {
		float rate = risk ? 8 : 6;
		double amount = sum * Math.pow(1 + rate / 100, years);
		return amount - sum;
	}
}

