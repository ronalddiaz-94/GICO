# GICO

**GICO** is a comprehensive system designed for inventory information management, providing tools on both web and mobile platforms to facilitate administrative processes.

## Repository Structure

The repository is organized into two main components:

- **GICOWEB/**: Web application intended for inventory administration and management.
  - **GICO-AD/**: Administrative module that handles user management, suppliers, products, sales, clients, credit notes, warehouses, and quotes. It is based on RESTful web services.

  - **GICO/**: Core module that manages the visual part (frontend) of the system and communicates with GICO-AD to retrieve information.

- **sistemaMovilGICO/**: Mobile application that offers essential functionalities of the GICO system on Android devices.
  - **sistemaGICO/**: Android project that allows users to interact with the system from their mobile devices.

## Technologies Used

- **Backend**: Java EE for the web application.
- **Frontend**: HTML, CSS, JavaScript, with preprocessors like SCSS.
- **Mobile**: Native Android development using Java.
- **Database**: PLpgSQL, indicating the use of PostgreSQL.
- **Build Tools**: Gradle for the mobile application and Apache Ant for the web application.

## Installation Instructions

1. **Clone the repository**:

   ```bash
   git clone https://github.com/ronalddiaz-94/GICO.git
   
2. Web Application Setup:
	*Import the GICOWEB project into NetBeans.
	*Set up a compatible server.
	*Ensure all dependencies are present in the librerias/ directory.
	*Configure the PostgreSQL database connection using the scripts provided in the repository.
4. Mobile Application Setup:
	*Import the sistemaMovilGICO/sistemaGICO project into Android Studio.
	*Sync the project with Gradle.
	*Set up an emulator or connect an Android device.
	*Verify the endpoint configuration for backend communication.

It is recommended to review the specific README.md files in each subdirectory.
