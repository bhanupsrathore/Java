package banking;

final class SavingsAccount extends Account {

	//final field cannot be reassigned (constant)
	private static final double MIN_BAL = 5000;

	SavingsAccount() {
		balance = MIN_BAL;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if(balance - amount < MIN_BAL)
			throw new InsufficientFundsException();
		balance -= amount;
	}
}

