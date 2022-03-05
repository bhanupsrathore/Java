package finance;

public class PersonalLoan {

	@MaxDuration(value=4)
	public float common(double amount, int duration) {
		return 10 + 0.5f * duration / 3;
	}

	public float employees(double amount, int duration) {
		return 0.5f * common(amount, duration);
	}	
}

