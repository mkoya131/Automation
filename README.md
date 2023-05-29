# TheScoreAutomation

------------------------------------------------------------
Updations and Implementations done:
------------------------------------------------------------
1. Android Testing(Real devices and Emulator)
2. Application used: theScore (v23.5.0) - <a>https://thescore.en.uptodown.com/android</a>
3. Maven Project
3. Extent Reports
4. Screenshots

------------------------------------------------------------
Appium setup on Mac - Android:
------------------------------------------------------------
Softwares:
----------------------
<b>HomeBrew</b>

1. Package manager for mac OS; used to install Software packages
2. Go to: https://brew.sh/
3. Hit this command in Terminal:
`/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`

----------------------
<b>Node</b>

1. Command to install node (this will install npm as well):
`brew install node`
2. If node is already installed in your machine and you want to upgrade the version:
`brew upgrade node`
3. To check the version of Node:
`node -v`
4. To check the path of Node installation:
`where node`

----------------------
<b>Appium CLI</b>

1. To install Appium using NPM:
`npm install -g appium@1.22.3`
2. To check the version of Appium:
`appium -v`
3. To check the path of Appium installation:
`where appium`
4. To start the Appium server (Default port: 4723):
`appium`

----------------------
<b>Appium Inspector</b>

* Download and install - https://github.com/appium/appium-inspector/releases

----------------------
<b>Java JDK</b>

1. Download and install - https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html
2. Verify Java:
`java -version`

----------------------
<b>Android Studio</b>
 
* Download and install - https://developer.android.com/studio

----------------------
<b>Set Environment Variables</b>

* Terminal ->

a) Navigate to home directory: `cd ~/`
	
b) Create zprofile file: `touch .zprofile`
	
c) Open zprofile file: `open -e .zprofile`
	
d) Add below entries: 

`export JAVA_HOME=$(/usr/libexec/java_home)`
	
Important note: If above path doesn't work, try: `/Library/Java/JavaVirtualMachines/your_jdk_version/Contents/Home`

Here, your_jdk_version can be jdk11.0.18.jdk for example.

`export ANDROID_HOME=${HOME}/Library/Android/sdk`

`export PATH="${JAVA_HOME}/bin:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools:${PATH}"`
	
e) Close this file to save:

`source .zprofile`

* Verify setup using below commands:

`echo $JAVA_HOME`

`echo $ANDROID_HOME`

`echo $PATH`

----------------------
<b>Check Appium setup for Android</b>

* Terminal ->

`appium-doctor --android`

----------------------
<b>Emulator setup</b> 

** Create AVD and start it

a) AVD - Android Virtual Device

b) Open Android Studio

* More actions -> AVD Manager
1. Category -> Phone
2. Name -> Pixel 3 -> Next
3. System Image -> Select Latest

c) AVD name: Pixel 3

d) Start Appium server

e) Start Appium Inspector:

f) To get the udid (Unique Identifier):
`adb devices`


------------------------------------------------------------
**How to run the Project using mvn**
1. Navigate to project root directory from terminal
2. Run mvn command:
`mvn test`

------------------------------------------------------------

