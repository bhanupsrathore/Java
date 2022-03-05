class JointAccount {

	private int balance;

	public int balance() { return balance; }

	public boolean deposit(int amount) {
		Worker.doWork(amount / 500);
		balance += amount;
		return true;
	}

	public boolean withdraw(int amount) {
		boolean success = false;
		if(balance >= amount){
			Worker.doWork(amount / 500);
			balance -= amount;
			success = true;
		}
		return success;
	}
}

