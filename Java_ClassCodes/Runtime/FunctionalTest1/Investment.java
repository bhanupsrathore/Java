@FunctionalInterface
interface InterestRate {
	float forPeriod(int duration);
}

record Investment(double sum, int years) {

	public double income(InterestRate interest) {
		float rate = interest.forPeriod(years);
		double amount = sum * Math.pow(1 + rate / 100, years);
		return amount - sum;
	}
}

