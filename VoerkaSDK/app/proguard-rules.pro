# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#指定压缩级别
-optimizationpasses 5
#不跳过非公共的库的类成员
-dontskipnonpubliclibraryclassmembers
#混淆是采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#把混淆类中的方法名也混淆了
-useuniqueclassmembernames
#优化时允许访问并修改有修饰符的类和类的成员
-allowaccessmodification
#将文件来源重命名为"SourceFile"字符串
-renamesourcefileattribute SourceFile
#保留行号
-keepattributes SourceFile,LineNumberTable

#以下是打印出的关键的流程日志
-dontpreverify
#混淆时是否记录日志
-verbose
#apk包内所有class的内部结构
-dump class_files.txt
#未混淆的类和成员
-printseeds seeds.txt
#列出从apk中删除的代码
-printusage unused.txt
#混淆前后的映射
-printmapping mapping.txt

#以下情况不能使用混淆。
#（1）反射中使用的元素，需要保证类名、方法名、属性名不变，否则混淆后会反射不了。
#（2）最好不让一些bean对象混淆。
#（3）四大组件不建议混淆，四大组件必须在AndroidManifest中注册声明，而混淆后类名会发生更改，这样不符合四大组件的注册机制。
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
#（4）注解不能混淆，很多场景下注解被用于在运行时反射一些元素。
-keepattributes *Annotation*
#（5）不能混淆枚举中的value和valueOf方法，因为这两个方法是静态添加到代码中运行，也会被反射使用，所以无法混淆这两种方法。
#应用使用枚举将添加很多方法，增加了包中的方法数，将增加dex的大小。
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#（6）JNI调用Java方法，需要通过类名和方法名构成的地址形成。
#（7）Java使用Native方法，Native是C/C++编写的，方法是无法一同混淆的。
-keepclasseswithmembernames class * {
    native <methods>;
}
#（8）JS调用Java方法。
-keepattributes *JavascriptInterface*
#（9）WebView中JavaScript的调用方法不能混淆。
-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
    public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView,java.lang.String,android.graphics.Bitmap);
    public boolean *(android.webkit.WebView,java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView,java.lang.String);
}
#（10）第三方库建议使用其自身混淆规则
#（11）Parcelable的子类和Creator的静态成员变量不混淆，否则会出现android.os.Bad-ParcelableExeception异常。
#Serializable接口类反序列化：
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] sericalPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
#（12）Gson的序列号和反序列化，其实质上是使用反射获取类解析的。
-keep class com.google.gson.** {*;}
-keep class sun.misc.Unsafe {*;}
-keep class com.google.gson.stream.** {*;}
-keep class com.google.gson.examples.android.model.** {*;}
-keep class com.google.** {
    <fields>;
    <methods>;
}
-dontwarn com.google.gson.**
#（13）使用keep注解的方式，哪里不想混淆就"keep"哪里，先建立注解类。
#package com.demo.annotation;
#//@Target(ElementType.METHOD)
#public @interface Keep{}
#@Target可以控制其可用范围为类（class）、方法（METHOD）、变量（FIELD）等。然后在proguard-rules.pro中声明：
-dontskipnonpubliclibraryclassmembers
-printconfiguration
-keep,allowobfuscation @interface android.support.annotation.Keep
-keep @android.support.annotation.Keep class *
-keepclassmembers class * {
    @android.support.annotation.Keep *;
}
#support-annotation中已经提供了@Keep的注解，可以保持类不被混淆。
#只要认真记住一个混淆原则：混淆改变Java路径名，那么保持所在路径不被混淆就是至关重要的。