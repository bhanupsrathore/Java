class Computation implements java.util.concurrent.Callable<Long> {

	private int first, last;

	public Computation(int first, int last) {
		this.first = first;
		this.last = last;
	}

	public Long call() {
		long result = 0;
		for(int value = first; value <= last; ++value)
			result += Worker.doWork(value);
		return result;
	}
}

