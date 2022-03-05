import finance.MaxDuration;
import java.lang.reflect.Method;

class Program {

	public static void main(String[] args) throws Exception {
		double p = Double.parseDouble(args[0]);
		Class<?> c = Class.forName(args[1]);
		Object scheme = c.getConstructor().newInstance(); //dynamic instantiation
		Method option = c.getMethod(args[2], double.class, int.class);
		MaxDuration md = option.getAnnotation(MaxDuration.class);
		int m = md != null ? md.value() : 10;
		for(int n = 1; n <= m; ++n){
			float rate = (float)option.invoke(scheme, p, n); //late-binding
			float i = rate / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%d\t%.2f%n", n, emi);
		}
	}
}

