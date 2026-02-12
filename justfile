# Build release version of the project
b:
    ./gradlew assembleRelease

# Build debug version of the project
bd:
    ./gradlew assembleDebug

# Install FOSS flavour on connected device/emulator and launch the app
foss:
    ./gradlew installFossRelease
    adb shell am start -n org.fossify.phone/org.fossify.phone.activities.SplashActivity.Green

# Install FOSS debug flavour and launch the app
fossd:
    ./gradlew installFossDebug
    adb shell am start -n org.fossify.phone.debug/org.fossify.phone.activities.SplashActivity.Green
