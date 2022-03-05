import java.util.Scanner;

class Program {

	public static void main(String[] args) throws Exception {
		var input = new Scanner(System.in);
		System.out.print("Limit (1/2): ");
		int m = input.nextInt();
		var c1 = new Computation(1, m);
		var r1 = c1.call();
		System.out.print("Limit (2/2): ");
		int n = input.nextInt();
		var c2 = new Computation(m + 1, n);
		var r2 = c2.call();
		var r = r1 + r2;
		System.out.printf("Result = %d%n", r);
	}
}

