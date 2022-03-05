class Program {

	public static void main(String[] args) throws Exception {
		var acc = new JointAccount();
		acc.deposit(5000);
		System.out.println("Joint-account opened for Jack and Jill");
		System.out.printf("Initial balance: %d%n", acc.balance());
		System.out.println("Jack is withdrawing 3000...");
		if(acc.withdraw(3000) == false)
			System.out.println("Jack's withdraw operation failed!");
		System.out.println("Jill is withdrawing 4000...");
		if(acc.withdraw(4000) == false)
			System.out.println("Jill's withdraw operation failed!");
		System.out.printf("Final balance: %d%n", acc.balance());
	}
}

