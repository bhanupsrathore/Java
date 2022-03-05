import payroll.Employee; //importing type-name Employee into the current (anonymous) package

class Program {

	private static double tax(Employee emp) {
		double i = emp.income(); //JVM will invoke income from the class used for creating instance referred by emp
		return i > 10000 ? 0.15 * (i - 10000) : 0;
	}

	private static void appraise(Employee emp) {
		float rate = emp.getRate();
		float raise;
		if(emp instanceof payroll.SalesPerson){
			//System.out.println("Appraising a SalesPerson");
			payroll.SalesPerson sp = (payroll.SalesPerson)emp; //explicit down-casting
			raise = sp.getSales() >= 75000 ? 1.10f : 1;
		}else{
			//System.out.println("Appraising an Employee");
			raise = emp.getHours() >= 175 ? 1.15f : 1;
		}
		emp.setRate(raise * rate);
	}

	public static void main(String[] args) {
		Employee jack = new Employee();
		jack.setHours(186);
		jack.setRate(52);
		var jill = new payroll.SalesPerson(186, 52, 64000); //compiler will infer var from the type specified in the initializer
		System.out.printf("Jack's Income is %.2f and Tax is %.2f%n", jack.income(), tax(jack));
		System.out.printf("Jill's Income is %.2f and Tax is %.2f%n", jill.income(), tax(jill));
		appraise(jack);
		appraise(jill);
		System.out.printf("Jack's income after appraisal is %.2f%n", jack.income());
		System.out.printf("Jill's income after appraisal is %.2f%n", jill.income());
		System.out.printf("Number of Employees = %d%n", Employee.countInstances());
	}
}

