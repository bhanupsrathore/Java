//a class defined without an explicitly specified super-class implicitly extends java.lang.Object
//which is the root type in Java and can be used to refer to an instance of any type.
class Interval
{
	private int min, sec;

	public Interval(int m, int s) {
		min = m + s / 60;
		sec = s % 60;
	}

	public int minutes() { return min; }

	public int seconds() { return sec; }

	public int time() { return 60 * min + sec; }

	//overriding toString method of java.lang.Object to return the representation
	//of this object as a string.
	public String toString() {
		return String.format("%d:%02d", min, sec);
	}

	//overriding hashCode method of java.lang.Object to return different integer values
	//for different instances of this class
	public int hashCode() {
		return min + sec;
	}

	//overriding equals method of java.lang.Object to return whether field values of this
	//object match with those of other object passed as argument
	public boolean equals(Object other) {
		if(other instanceof Interval that){
			return (this.min == that.min) && (this.sec == that.sec);
		}
		return false;
	}
}

