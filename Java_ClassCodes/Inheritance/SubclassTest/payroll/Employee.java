package payroll;

public class Employee {
	
	private int hours;
	private float rate;
	private static int count; //class field - value is shared by all instances

	//parameterized constructor
	public Employee(int h, float r) {
		hours = h;
		rate = r;
		count += 1;
	}

	//parameterless constructor
	public Employee() {
		this(0, 50); //calling another constructor of 'this' class
	}

	//field accessor methods
	public int getHours() { return hours; }
	public void setHours(int value) { hours = value; }

	public float getRate() { return rate; }
	public void setRate(float value) { rate = value; }

	public double income() {
		double income = hours * rate;
		int ot = hours - 180;
		if(ot > 0)
			income += 50 * ot;
		return income;
	}

	//static method can be called on the class and as such it can only refer
	//to other static members of that class
	public static int countInstances() {
		return count;
	}

}

