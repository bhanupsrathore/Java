class JointAccount {

	private int balance;

	public int balance() { return balance; }

	public synchronized boolean deposit(int amount) {
		Worker.doWork(amount / 500);
		balance += amount;
		//enables any one thread waiting on monitor of this object to resume execution
		this.notify();
		return true;
	}

	public boolean withdraw(int amount) {
		boolean success = false;
		//to execute synchronized block, a thread must lock the monitor of the target object
		//only one thread can lock monitor of an object at a time and in unlocks this monitor
		//when it exits the synchronized block
		synchronized(this){
			if(balance >= amount){
				Worker.doWork(amount / 500);
				balance -= amount;
				success = true;
			}
		}
		return success;
	}

	public synchronized void withdrawAfterDeposit(int amount) throws InterruptedException {
		do{
			//current thread unlocks the monitor of this and waits for
			//another thread to notify this monitor
			this.wait();
		}while(balance < amount);
		withdraw(amount);
	}
}

