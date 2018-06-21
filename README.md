# DekatManaNi-
DekatManaNi? is an android apps with very basic structure that  help you know your current position/address via phone gps.

## Lets start
Add this 2 line of code in AndroidManifest.xml

 <pre>
 < uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
 < uses-permission android:name="android.permission.INTERNET" />
 </pre>

and add volley library in your build.gradle (Module: app)
<pre>
compile 'com.android.volley:volley:1.0.0'
</pre>
<i> Note : Volley library is use to call and handle json from google api </i>
<hr>

it's up to you how to design a layout, but I'm using a simple one

<pre>

< ?xml version="1.0" encoding="utf-8"?>
< RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context="com.example.afihisam.dekatmanani.MainActivity"
    tools:showIn="@layout/activity_main">

    < RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true">

        < Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Dekat mana ni"
            android:id="@+id/location"
            android:layout_centerVertical="true"
            android:layout_centerHorizontal="true" />

        < TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="?android:attr/textAppearanceMedium"
            android:text="Address"
            android:id="@+id/add"
            android:layout_below="@+id/longitute"
            android:layout_centerHorizontal="true"
            android:paddingTop="30dp" />

        < TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="?android:attr/textAppearanceMedium"
            android:text="Gps"
            android:id="@+id/textView"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true" />

        < TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="?android:attr/textAppearanceSmall"
            android:text="Latitute"
            android:id="@+id/latitute"
            android:layout_below="@+id/textView"
            android:layout_centerHorizontal="true" />

        < TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="?android:attr/textAppearanceSmall"
            android:text="Longitute"
            android:id="@+id/longitute"
            android:layout_below="@+id/latitute"
            android:layout_centerHorizontal="true" />

        < TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="?android:attr/textAppearanceSmall"
            android:text="..."
            android:id="@+id/address"
            android:layout_below="@+id/add"
            android:layout_centerHorizontal="true" />

    </ RelativeLayout>
</ RelativeLayout>

</pre>
<img src="https://github.com/AfiHisam/DekatManaNi-/blob/master/location.jpg" width="40%">
