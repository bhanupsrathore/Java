package taxation;

public interface TaxPayer {

	double annualIncome();

	//inheriting class can reuse the default implementation provided by the interface
	//or it can override it to provide its own implementation
	default double incomeTax() {
		double e = annualIncome() - 120000;
		return e > 0 ? 0.15 * e : 0;
	}
}

