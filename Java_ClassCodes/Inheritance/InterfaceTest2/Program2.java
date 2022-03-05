import taxation.*;

class Auditor  implements AutoCloseable{
	
	public Auditor() {
		System.out.println("Acquiring departmental resources");
	}

	public void audit(TaxPayer person, String id) {
		if(id.length() < 4)
			throw new IllegalArgumentException("Invalid tax-payer ID");
		System.out.printf("Payment for %s is %.2f%n", id, person.incomeTax() + 500);

	}

	public void close() {
		System.out.println("Releasing departmental resources");
	}
}

class Program {

	private static void processDealer(double amount) {
		var d = new Dealer(amount);
		var a = new Auditor();
		a.audit(d, "Jack");
		a.close();
	}

	private static void processWorker(double amount, String name) {
		var w = new Worker(amount);
		try(var a = new Auditor()){
			a.audit(w, name);
		}

	}

	public static void main(String[] args) {
		try{
			double amt = Double.parseDouble(args[0]);
			if(args.length < 2)
				processDealer(amt);
			else
				processWorker(amt, args[1]);
		}catch(Exception e){
			System.out.printf("Error: %s%n", e);
		}
	}
}

