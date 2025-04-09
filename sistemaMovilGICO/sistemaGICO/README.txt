# sistemaGICO

**sistemaGICO** is the mobile version of the GICO system, designed as a native Android application. Its purpose is to provide access from mobile devices to essential functions of the inventory management system.

## Features

- Product information lookup.
- User management (roles, access).
- Connection to web services and the GICO WEB system API (GICO-AD).
- Responsive and mobile-friendly interface.

## Project Structure

- `app/`: Contains the source code of the Android application.
- `.idea/`: IDE configuration files (Android Studio).
- `gradle/`, `gradlew`, `build.gradle`: Configuration and build automation files using Gradle.
- `settings.gradle`: Defines the project's modules.

## Technologies Used

- **Java**  
- **Android SDK**  
- **Gradle** as the build system  
- **Android Studio** as the development environment

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/ronalddiaz-94/GICO.git
2. Open the sistemaMovilGICO/sistemaGICO folder in Android Studio.
3. Sync the project with Gradle.
4. Set up an emulator or connect an Android device.
5. Run the app from Android Studio (Run > Run 'app').


## Prerequisites
	*Android Studio (recommended)
	*Java Development Kit (JDK) 8 or higher
	*Android SDK configured
	*Connection to the GICO system API (online or local backend server)

## Additional Notes
	*Check the endpoint configuration in the code (IP or backend domain).
	*For local network testing, ensure the device has access to the server.
