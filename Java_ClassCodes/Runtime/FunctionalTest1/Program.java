import java.util.Scanner;

class Program {

	private static float safeScheme(int n) {
		return n < 3 ? 6 : 7;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Amount and Duration: ");
		double s = input.nextDouble();
		int y = input.nextInt();
		var inv = new Investment(s, y);
		//passing method reference to income method
		System.out.printf("Income in riskless investment: %.2f%n", inv.income(Program::safeScheme));
		//passing lambda expression: (arguments) -> expression
		System.out.printf("Income in riskful investment: %.2f%n", inv.income(n -> 9 + 0.1f * n));

	}
}

