package banking;

//factory class
public class Banker {

	private static long nid;

	public static Account openCurrentAccount() {
		Account acc = new CurrentAccount();
		acc.id = 100000000 + nid++;
		return acc;
	}

	public static Account openSavingsAccount() {
		Account acc = new SavingsAccount();
		acc.id = 200000000 + nid++;
		return acc;
	}

	//static initializer is executed first time the class is used
	static {
		nid = System.currentTimeMillis() % 1000000;
	}

	//a class with only static members does not require instances
	private Banker() {}
}

