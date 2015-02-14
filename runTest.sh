#!/bin/bash

./gradlew connectedAndroidTest
adb install ./app/build/outputs/apk/app-debug.apk
adb install ./app/build/outputs/apk/app-debug-test-unaligned.apk
adb shell am instrument -w -e class com.akafune.androidcommandtest.app.ApplicationTest com.akafune.androidcommandtest.app.test/android.support.test.runner.AndroidJUnitRunner
