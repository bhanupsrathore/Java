class LegacySequence {

	private double first, second;

	public LegacySequence(double first, double second) {
		this.first = first;
		this.second = second;
	}

	private double transform(int term, double value) {
		return value * value;
	}

	public native double compute(int count);

	static{
		System.loadLibrary("bridge");
	}
}

