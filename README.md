# Test assignment Solution 
This Repo provides the solution of Abn Amro assignment on Reference app

**Pre-requisites:**
--

In order to complete this assignment , I used

·	macOS High Sierra

·	Android Studio Bumblebee

·	Android SDK v29,30 

·	Android Emulator & Real device

·	GitHub account

·	JDK 11   
**Tools:**
--

which help in achieving espresso automation for android Instrumentation test

·	UiAutomator : locator strategy

·	Android studio 

·	Gradle

·	junit

·	Vysor: Real device screen mirroring

·	ADB

·	GitHub CI


**Scenario covered :**
--

·	Validate Reference app UI elements

·	Validate More Options/Setting functionality

·	Validate Mail icon functionality

·	Validate the app activity by changing screen orientation(portrait/landscape)

·	Validate tab color (UI scenario) 

**Framework Structure :**
--

<img width="295" alt="image" src="https://user-images.githubusercontent.com/82476790/165700885-b6c71f57-4af5-4ca9-ba1b-1d66ab2df262.png">

·	referenceAppTests : comprises baseClass & other test classes

·	referenceAppPages: comprises page element 

·	CustomMatchers: comprises custom matcher for click operation & screen orientation

·	Utilities: comprises screenshot class & tags interfaces

·	Runner: Comprises runner class


###### Running Espresso Testing**
--

**Locally**  : 

1. Git clone and open the project in android studio and execute the espresso test using instrumentationRunner class in runner package inside androidTest .
                                                Or
   Git clone  & open terminal/cmd and navigate till project path and execute below command

`
adb shell am instrument -w -m -e clearPackageData true   -e debug false -e class 'runner.instrumentationRunner' com.abnamro.apps.referenceandroid.test/androidx.test.runner.AndroidJUnitRunner`


2. Executing locally build & test using gradle command in terminal/cmd  

    -Command will execute all test in espresso android test
   ` ./gradlew connectedDebugAndroidTest`
   
   -Test can be executed by using tags (@Regression or @Smoke)
`     ./gradlew connectedDebugAndroidTest -Ptags="Regression" `
             or 
             
      `./gradlew connectedDebugAndroidTest -Ptags="Smoke"`
    
   
**Remotely** : Using GitHub CI
  -Push the code or create the pull request then GitHUb CI will start executing jobs on api level 29 & 26 currently on android emulator (created android CI yml file)
  
  
  
  **Reporting** : if executed locally HTML report can be extracted from android studio 
  
  **Screenshot**: Screenshot will get saved in device downloads folder after execution ( Screenshot code is commented as causing exception on GitHUB CI                      but worked fine locally 
  
  
 ** 
  Note: Espresso framework can be extended with firebase, device firms such as browserstack or sauce lab **

