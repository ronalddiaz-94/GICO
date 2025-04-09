# GICO-AD

**GICO-AD** is the administrative module of the GICO system, developed in Java and structured to run as a web application with JSP/Servlet support. This section focuses on managing users, suppliers, products, sales, clients, credit notes, warehouses, and quotes. It is based on RESTful web services.

## Folder Structure

- `src/`: Contains the Java source code (servlets, controllers, business logic).
- `web/`: Presentation files (static resources).
- `librerias/`: External libraries required for deployment.
- `nbproject/`: Project configuration for the NetBeans environment.
- `build.xml`: Build script.
- `prepros-6.config`: Configuration for Prepros, a tool for web preprocessors.

## Technologies Used

- **Java EE** (Servlets, JSP)
- **JavaScript**
- **NetBeans IDE**
- **Payara Server** (recommended server)
- **Prepros** (for processing static resources)

## Deployment Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/ronalddiaz-94/GICO.git

2. Open the GICO-AD project in NetBeans.
3. Configure the Apache Tomcat server in NetBeans.
4. Verify the database connection in the configuration files (if applicable).
5. Run the project from NetBeans.




# GICO

**GICO** is a module of the GICOWEB system, developed to facilitate inventory information management. This component focuses on the visual part (frontend) of the system and communicates with GICO-AD to retrieve information.

## Project Structure

- `src/`: Contains the main source code of the project.
- `web/`: Includes files related to the user interface and web resources.
- `librerias/`: Directory for external dependencies and libraries required for the project to function.
- `nbproject/`: Configuration files specific to the NetBeans development environment.
- `.gitignore`: Specifies which files and directories should be ignored by Git.
- `build.xml`: Build script used to automate tasks such as compilation and deployment.
- `prepros-6.config`: Configuration file for Prepros, a tool that compiles preprocessors like Sass or LESS.

## Technologies Used

- **Java**: Main programming language of the project.
- **HTML/CSS/JavaScript**: Technologies used for the visual presentation of information.
- **NetBeans**: Integrated Development Environment (IDE) used for project development.
- **Payara Server**: Application server used for building and deploying Java EE applications.
- **Prepros**: Tool used to compile preprocessors and optimize web resources.

## Installation Instructions

1. **Clone the repository**:

   ```bash
   git clone https://github.com/ronalddiaz-94/GICO.git
2. Import the project into NetBeans:
	*Open NetBeans.
	*Go to File > Open Project.
	*Navigate to the GICOWEB/GICO directory and open the project.
3. Configure dependencies:
	*Make sure all necessary libraries are present in the librerias/ directory.
	*If any dependency is missing, add it manually to the project.
4. Configure the server:
	*Ensure a compatible server is configured in NetBeans. 
	*Set the project context as needed.
5. Build and run:
	*Run the project from within NetBeans or deploy it manually to the configured server.


# SQL

**SQL** is a module of the GICOWEB system, which contains backups of the SQL statements used in the database for centralizing information.
