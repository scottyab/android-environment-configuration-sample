# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/scottab/dev/adt-bundle-mac-x86_64/sdk-macosx-v2/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


-keepattributes SourceFile,LineNumberTable,*Annotation*

#crashlytics Config
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

#For Fabric to properly de-obfuscate your crash reports, you need to remove this line from your ProGuard config:
#-printmapping mapping.txt


#Hockey app config
-keep public class javax.net.ssl.**
-keepclassmembers public class javax.net.ssl.** {
  *;
}

-keep public class org.apache.http.**
-keepclassmembers public class org.apache.http.** {
  *;
}

-keepclassmembers class net.hockeyapp.android.UpdateFragment {
  *;
}


#crittercism config
-keep public class com.crittercism.**
-keepclassmembers public class com.crittercism.* {
    *;
}