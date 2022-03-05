class Deviation {
	public double value;
}

class Program {

	//variadic method operates upon variable number of arguments (var-arg)
	private static double average(double first, double second, double... remaining) {
		double sum = first + second;
		//for-each iteration
		for(double value : remaining){
			sum += value;
		}
		return sum / (2 + remaining.length);
	}

	private static double averageWithDeviation(double first, double second, Deviation dev) {
		dev.value = first > second ? (first - second) / 2 : (second - first) / 2;
		return (first + second) / 2;
	}

	public static void main(String[] args) {
		if(args.length < 2){
			System.out.printf("Average of two values = %f%n", average(23.4, 32.1));
			System.out.printf("Average of three values = %f%n", average(23.4, 32.1, 19.2));
			System.out.printf("Average of five values = %f%n", average(23.4, 32.1, 19.2, 45.6, 9.5));
		}else{
			double b = Double.parseDouble(args[0]);
			double c = Double.parseDouble(args[1]);
			Deviation d = new Deviation();
			double a = averageWithDeviation(b, c, d);
			System.out.printf("Average is %f with a deviation of %f%n", a, d.value);
		}
	}
}

