//enum is a class which only supports a set of instances referenced by its static fields
//with names specified in its definition
enum RiskLevel {
	NONE, LOW, HIGH;
}

class Investment {

	private double sum;
	private int years;
	private RiskLevel risk;

	public Investment(double amount, int period) {
		sum = amount;
		years = period;
		risk = RiskLevel.NONE;
	}

	public void allowRisk(boolean yes) {
		risk = yes ? RiskLevel.LOW : RiskLevel.NONE;
	}

	//method overloading enables a class to define multiple methods with same name
	//but different parameter types
	public void allowRisk(RiskLevel level) {
		risk = level;
	}

	public double income() {
		float rate;
		switch(risk)
		{
			case LOW:
				rate = 8;
				break;
			case HIGH:
				rate = 11;
				break;
			default:
				rate = 6;
		}
		double amount = sum * Math.pow(1 + rate / 100, years);
		return amount - sum;
	}
}

