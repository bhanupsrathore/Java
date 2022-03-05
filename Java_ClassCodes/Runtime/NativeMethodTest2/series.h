namespace Series
{
	//Abstract Data Type (ADT) - is a class which contains (by definition or inheritance) at least one pure virtual function.
	//Such a class does not support creation of new instances but can have objects whicn indirect to instances of its sub-classes 
	//which have overriden its pure virtrual functions. 
	class Sequence
	{
	public:
		//pure virtual function
		virtual double Next() = 0;

		double Sum(int);

		//a class with a virtual member function must define a virtual destructor
		virtual ~Sequence() {}
	};

	class RandomAccess
	{
	public:
		virtual double Seek(int) = 0;

		virtual ~RandomAccess() {}
	};

	//multiple inheritance
	class LinearSequence : public Sequence, public RandomAccess
	{
	public:
		LinearSequence(double, float);

		//overriding pure virtal function of base class
		double Next();

		double Seek(int);
	private:
		double current;
		float rise;
	};

	class PowerSequence : public Sequence
	{
	public:
		PowerSequence(float);

		double Next();
	private:
		double current;
		float base;
	};
}

