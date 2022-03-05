package payroll;

//SalesPerson is defined as a subclass of Employee (super-class)
public class SalesPerson extends Employee {

	private double sales;

	public SalesPerson(int h, float r, double s) {
		super(h, r); //calling constructor of super-class (Employee)
		sales = s;
	}

	public double getSales() { return sales; }

	//method overriding allows a subclass to implement a method whose name, 
	//parameter-list and return type matches with a method of its super-class
	public double income() {
		double income = super.income(); // calling same method from super-class
		if(sales >= 20000)
			income += 0.05 * sales;
		return income;
	}
}

