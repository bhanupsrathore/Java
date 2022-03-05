#include "series.h"

namespace Series
{
	double Sequence::Sum(int count)
	{
		double total = 0;
		
		for(int i = 1; i <= count; ++i)
			total += Next();
		return total;
	}

	LinearSequence::LinearSequence(double start, float step)
	{
		current = start;
		rise = step;
	}

	double LinearSequence::Next()
	{
		double result = current;

		current += rise;
		return result;
	}

	double LinearSequence::Seek(int term)
	{
		return current += rise * (term - 1);
	}

	PowerSequence::PowerSequence(float factor)
	{
		current = 1;
		base = factor;
	}

	double PowerSequence::Next()
	{
		double result = current;

		current *= base;
		return result;
	}
}

