import java.util.stream.IntStream;

class Program {

	public static void main(String[] args) throws Exception {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 20;
		long t1 = System.currentTimeMillis();
		long r = IntStream.range(1, n + 1)
					.mapToLong(Worker::doWork)
					.sum();
		long t2 = System.currentTimeMillis();
		System.out.printf("Result = %d, computed in %.3f seconds%n", r , 0.001 * (t2 - t1));
	}
}

