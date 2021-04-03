# Android-Developer-Fundamentals-Java

This Repo is for the [Android Developer Fundamentals (Java)](https://developer.android.com/courses/fundamentals-training/overview-v2) course from google.

## Unit 1: Getting started

**Short Summary:**

- To install Android Studio, go to Android Studio and follow the instructions to download and install it.
- When creating a new app, ensure that **API 15: Android 4.0.3 IceCreamSandwich** is set as the Minimum SDK.
- To see the app's Android hierarchy in the Project pane, click the Project tab in the vertical tab column, and then choose - Android in the popup menu at the top.
- Edit the build.gradle(Module:app) file when you need to add new libraries to your project or change library versions.
- All code and resources for the app are located within the app and res folders. The java folder includes activities, tests, and other components in Java source code. The res folder holds resources, such as layouts, strings, and images.
- Edit the AndroidManifest.xml file to add features components and permissions to your Android app. All components for an app, such as multiple activities, must be declared in this XML file.
- Use the Android Virtual Device (AVD) manager to create a virtual device (also known as an emulator) to run your app.
- Add Log statements to your app, which display messages in the Logcat pane as a basic tool for debugging. (Log comes with many default versions, such as Log.d for DEBUG, Log.e for ERROR, Log.w for WARN, and Log.i for INFO.)  
  Also by convention, usually log tagsare defined as constans for the Activity
  ```
  private static final String LOG_TAG = MainActivity.class.getSimpleName();
  ```
- To run your app on a physical Android device using Android Studio, turn on USB Debugging on the device. Open Settings > About phone and tap Build number seven times. Return to the previous screen (Settings), and tap Developer options. Choose USB Debugging.
