# Samsung Servised Android App

This is the source code for the Samsung Servised Android application.

## How to import and build the project

1. Open Android Studio on your local machine.
2. Select **Open an existing Android Studio project**.
3. Navigate to the `samsung-servised-app` directory and open it.
4. Ensure you have the Android SDK installed and configured in Android Studio.
5. Build the project using **Build > Make Project** or run it on an emulator/device.

## Notes

- The project requires Android SDK to be installed and configured.
- The `local.properties` file is not included here and should be created automatically by Android Studio or manually with the path to your SDK, e.g.:
```
sdk.dir=/path/to/your/android/sdk
```
- For more information, see the [Android Studio documentation](https://developer.android.com/studio).

## Dashboard Server

A simple Node.js Express server and dashboard are included in the `dashboard-server` directory.

To run the dashboard server:
```
cd dashboard-server
npm install
npm start
```

The dashboard will be available at http://localhost:8000
