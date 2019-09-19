#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_ty_android_jnidemoapp_NativeTestLib_readStr(JNIEnv *env, jclass clazz) {
    // TODO: implement readStr()
    char* ret = "Greeting from lib!!";
    return (*env)->NewStringUTF(env, ret);
}