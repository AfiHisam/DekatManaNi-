# DekatManaNi-
DekatManaNi? is an android apps with very basic structure that  help you know your current position/address via phone gps

Add this 2 line of code in AndroidManifest.xml

 <pre>
 < uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
 < uses-permission android:name="android.permission.INTERNET" />
 </pre>

and add volley dependencies in your build.gradle(Module:app)
<pre>
compile 'com.android.volley:volley:1.0.0'
</pre>
