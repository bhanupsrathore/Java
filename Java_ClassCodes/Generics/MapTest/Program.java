import java.util.*;

class Program {
	
	public static void main(String[] args) {
		//Map<String, Interval> store = new HashMap<>();
		Map<String, Interval> store = new TreeMap<>();
		store.put("monday", new Interval(5, 31));
		store.put("tuesday", new Interval(4, 12));
		store.put("wednesday", new Interval(7, 43));
		store.put("thursday", new Interval(6, 54));
		store.put("friday", new Interval(2, 45));
		store.put("tuesday", new Interval(8, 22));
		if(args.length > 0){
			String key = args[0].toLowerCase();
			Interval val = store.get(key);
			if(val != null)
				System.out.printf("Value = %s%n", val);
		}else{
			for(var pair : store.entrySet())
				System.out.printf("%-16s%12s%n", pair.getKey(), pair.getValue());	
		}
	}
}

