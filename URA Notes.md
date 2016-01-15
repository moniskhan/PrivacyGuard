
# Android build process:
1. Download Android Studio, install SDK 19
2. Imported project from local repo
3. install intelhaxm-android to be able to run emulator
4. Change the memory limit of AVD emulator to that of HAXM (1 GB) for emulator to work:	[Stackoverflow](http://stackoverflow.com/questions/21031903/how-to-fix-hax-is-not-working-and	-emulator-runs-in-emulation-mode)


To execute "adb devices":
- find platform-tools in explorer
- C:\Users\<user>\AppData\Local\Android\sdk
- open command prompt and execute command

device does not automatically show up when running app since drivers don't get installed:
http://stackoverflow.com/questions/16596877/android-studio-doesnt-see-device

- Steps to resolve:
- If you using Windows, the device won't show up because of driver issue.
- Go to device manager (just search it using Start) and look for any devices showing an error. Many androids will show as an unknown USB device and comes with exclamation mark. Select that device and try to update the drivers for it.
- But before that, you have to update your sdk manager and make sure Google USB Driver package is installed.
- When done, the driver files are downloaded into the \extras\google\usb_driver\ directory. Hints: Search "android_winusb.inf" under Windows Start and Open File Location to get the directory mentioned.
- Open up your device manager, navigate to your android device, right click on it and select Update Driver Software then select Browse driver software. Follow the file location path previously to install Google USB Driver.
- Restart Android Studio and Developer Options in your android device and reconnect USB.


Checking SQLite Databases:
Go to Tools -> DDMS or click the Device Monitor icon next to SDK Manager in Tool bar.
Device Monitor window will open, In File Explorer tab click data -> data -> your project name. After that your databases file will open . click "pull a file from device" icon. Save the file using .db extension.
open FireFox, Press Alt , Tools->SQLiteManager.
Follow Database -> connect to Database -> browse your database file and click ok. Your SQLite file will opened now.

Google Maps set up Android 19: http://www.androidhive.info/2013/08/android-working-with-google-maps-v2/
C:\Program Files\Java\jre1.8.0_60\bin>
keytool -list -v -keystore "%USERPROFILE%\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android

SHA1: 58:95:40:B9:31:02:12:93:34:78:0D:ED:C6:8A:A1:3B:66:9A:07:99
API key: AIzaSyBL9tVkRjRtayPIpBnnri7MfAlka-lkwyU

TODO:
- Social Media integration (be able to share leakage statistics)
- OnResume/OnStop as well as testing app life cycle/corner cases (force stop, etc.)
- Stress testing (ensure VPN does not cause performance issues
- User studies to gain feedback/Tweaks to front facing UI (increased height for table rows, icons, etc.)
- Rating system which associates each app with a five star rating based on leakage history/ show star rating below app icons on phone
- Allow an option for the user to share statistics with us so overall stats on apps can be aggregated
- Potentially display leakage stats as they become more complex in graphical form
- Test on multiple OS versions, and look into new features offered by 5.x and 6.x

Code Documentation:
MySocketForwarder.java
	- run invokes vpnService.notify which seems to generate the notifications
	- notify method defined in MyVpnService.java
	- DEBUG = false (and is not used and hence nothing is being logged)
LocationGuard.java
	- onCreate sets the content view and sets the OnClickListener for the "connect" button


API 23 (6.0):
	- getActiveNotifications(); // to determine which notifications launched from this app are active
	- NotificationListenerService?

Renaming Notes:
Package names have "y59song"?
Define strings/constants etc. in R.layout xml files?

## FAQ

### 1. Failed to find target with hash string 'android-19'


	Error:Cause: failed to find target with hash string 'android-19' in: /Users/justinhu/Library/Android/sdk <a href="openAndroidSdkManager">Open Android SDK Manager</a>

- Install packages via SDK Manager

### 2. Dependency error
	 Error:(30, 30) error: package android.support.v4.app does not exist
In Android Studio:

1. Right click on your projects "app" folder and click on -> module settings
2. Click on the "dependencies" tab
3. Click on the + sign to add a new dependency and select "Library Dependency"
4. Look for the library you need and add it