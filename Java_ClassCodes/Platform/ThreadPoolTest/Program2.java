import java.util.Scanner;
import java.util.concurrent.Executors;

class Program {

	public static void main(String[] args) throws Exception {
		var input = new Scanner(System.in);
		var pool = Executors.newFixedThreadPool(2); //create a pool of two worker threads
		System.out.print("Limit (1/2): ");
		int m = input.nextInt();
		var c1 = new Computation(1, m);
		var r1 = pool.submit(c1); //a worker thread will be assigned c1.call
		System.out.print("Limit (2/2): ");
		int n = input.nextInt();
		var c2 = new Computation(m + 1, n);
		var r2 = pool.submit(c2);
		System.out.print("Computing.");
		while(!r1.isDone() || !r2.isDone()){
			System.out.print(".");
			Thread.sleep(300); //pause the current thread for 300 milliseconds
		}
		System.out.println("Done!");
		var r = r1.get() + r2.get();
		System.out.printf("Result = %d%n", r);
		pool.shutdown();
	}
}

