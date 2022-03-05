package banking;

//non-instantiable class can only be used as a super-class
public abstract class Account {

	long id;
	protected double balance;

	public long id() { return id; }

	public double balance() { return balance; }

	//pure (unimplemented) instance method (cannot be defined in a non-abstract class)
	//must be overridden in non-abstract subclasses
	public abstract void deposit(double amount);

	public abstract void withdraw(double amount) throws InsufficientFundsException;

	//non-overridable method - such methods are invoked at runtime using static binding which is faster
	public final void transfer(double amount, Account that) throws InsufficientFundsException, IllegalTransferException {
		if(this == that)
			throw new IllegalTransferException();
		this.withdraw(amount);
		that.deposit(amount);
	}
}

