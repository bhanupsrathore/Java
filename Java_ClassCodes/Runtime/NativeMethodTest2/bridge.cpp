#include "series.h"
#include "LegacySequence.h"

JNIEXPORT jdouble JNICALL Java_LegacySequence_compute(JNIEnv* env, jobject self, jint count)
{
	jclass cls = env->GetObjectClass(self);
	jfieldID idFirst = env->GetFieldID(cls, "first", "D");
	jdouble first = env->GetDoubleField(self, idFirst);
	jfieldID idSecond = env->GetFieldID(cls, "second", "D");
	jdouble second = env->GetDoubleField(self, idSecond);
	jmethodID idTrans = env->GetMethodID(cls, "transform", "(ID)D");
	Series::LinearSequence seq(first, second - first);
	jdouble result = 0;

	for(int term = 1; term <= count; ++term)
	{
		jdouble value = seq.Next();
		result += env->CallDoubleMethod(self, idTrans, term, value);
	}

	return result;
}

