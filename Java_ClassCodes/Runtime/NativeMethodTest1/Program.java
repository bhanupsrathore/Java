import java.util.Arrays;

class Program {

	private static native long gcd(long first, long second);

	private static native String reverse(String text);

	private static native void square(double[] values);

	public static void main(String[] args) {
		//on UNIX, libnatsup.so will be loaded from a location specified in java.library.path property
		System.loadLibrary("natsup"); 
		switch(args[0]){
			case "gcd":
				long m = Long.parseLong(args[1]);
				long n = Long.parseLong(args[2]);
				System.out.println(gcd(m, n));
				break;
			case "reverse":
				System.out.println(reverse(args[1]));
				break;
			case "square":
				double[] values = Arrays.stream(args)
								.skip(1)
								.mapToDouble(Double::parseDouble)
								.toArray();
				square(values);
				Arrays.stream(values).forEach(System.out::println);
				
		}
	}
}

