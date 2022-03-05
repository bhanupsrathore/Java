#include "Program.h"

JNIEXPORT jlong JNICALL Java_Program_gcd(JNIEnv*, jclass, jlong first, jlong second)
{
	while(first != second)
	{
		if(first > second)
			first -= second;
		else
			second -= first;
	}
	return first;
}

JNIEXPORT jstring JNICALL Java_Program_reverse(JNIEnv* env, jclass, jstring text)
{
	jint n = env->GetStringLength(text);
	jchar* buffer = new jchar[n];

	env->GetStringRegion(text, 0, n, buffer);
	for(jint i = 0, j = n - 1; i < j; ++i, j--)
	{
		jchar ic = buffer[i];
		jchar jc = buffer[j];
		buffer[i] = jc;
		buffer[j] = ic;
	}
	jstring result = env->NewString(buffer, n);
	delete[] buffer;
	
	return result;
}

JNIEXPORT void JNICALL Java_Program_square(JNIEnv* env, jclass, jdoubleArray values)
{
	jint n = env->GetArrayLength(values);
	jdouble* elements = new jdouble[n];

	env->GetDoubleArrayRegion(values, 0, n, elements);
	for(int i = 0; i < n; ++i)
		elements[i] *= elements[i];
	env->SetDoubleArrayRegion(values, 0, n, elements);

	delete[] elements;
}

