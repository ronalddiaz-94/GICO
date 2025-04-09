# GICO-AD

**GICO-AD** es el módulo administrativo del sistema GICO, desarrollado en Java y estructurado para ejecutarse como una aplicación web con soporte para JSP/Servlets. Esta sección se enfoca en la gestión de usuarios, proveedores, productos, ventas, clientes, notas de crédito, bodegas, proformas. Basado en servicios web tipo REST.

## Estructura de Carpetas

- `src/`: Contiene el código fuente Java (servlets, controladores, lógica de negocio).
- `web/`: Archivos de presentación (recursos estáticos).
- `librerias/`: Librerías externas requeridas para el despliegue.
- `nbproject/`: Configuración del proyecto para el entorno NetBeans.
- `build.xml`: Script de compilación.
- `prepros-6.config`: Configuración de Prepros, herramienta para preprocesadores web.

## Tecnologías Utilizadas

- **Java EE** (Servlets, JSP)
- **JavaScript**
- **NetBeans IDE**
- **Payara Server** (servidor sugerido)
- **Prepros** (para procesamiento de recursos estáticos)

##  Instrucciones de Despliegue

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/ronalddiaz-94/GICO.git

2. Abrir el proyecto GICO-AD en NetBeans.
3. Configurar el servidor Apache Tomcat en NetBeans.
4. Verificar la conexión a base de datos en los archivos de configuración (si aplica).
5. Ejecutar el proyecto desde NetBeans.




# GICO

**GICO** es un módulo del sistema GICOWEB, desarrollado para facilitar la gestión de información de inventerios. Este componente se centra en la parte visual (frontend) del sistema y se comunica con GICO-AD para obtener la información.

## Estructura del Proyecto

- `src/`: Contiene el código fuente principal del proyecto.
- `web/`: Incluye los archivos relacionados con la interfaz de usuario y recursos web.
- `librerias/`: Directorio destinado a las dependencias y bibliotecas externas necesarias para el funcionamiento del proyecto.
- `nbproject/`: Archivos de configuración específicos para el entorno de desarrollo NetBeans.
- `.gitignore`: Archivo que especifica qué archivos y directorios deben ser ignorados por Git.
- `build.xml`: Script de construcción utilizado para automatizar tareas como la compilación y el despliegue.
- `prepros-6.config`: Archivo de configuración para Prepros, una herramienta que compila preprocesadores como Sass o LESS.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal del proyecto.
- **HTML/CSS/JavaScript**: Tecnologías usadas para la presentación visual de la información
- **NetBeans**: Entorno de desarrollo integrado (IDE) utilizado para el desarrollo del proyecto.
- **Payara Server**: Herramienta de automatización de compilación utilizada para gestionar tareas de construcción.
- **Prepros**: Aplicación utilizada para compilar preprocesadores y optimizar recursos web.

## Instrucciones de Instalación

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/ronalddiaz-94/GICO.git
2. Importar el proyecto en NetBeans:
	*Abrir NetBeans.
	*Seleccionar File > Open Project.
	*Navegar hasta el directorio GICOWEB/GICO y abrir el proyecto.
3. Configurar las dependencias:
	*Asegurarse de que todas las bibliotecas necesarias estén presentes en el directorio librerias/.
	*Si alguna dependencia falta, añadirla manualmente al proyecto.
4. Configurar el servidor:
	*Asegurarse de que un servidor compatible esté configurado en NetBeans.
	*Establecer el contexto del proyecto según sea necesario.
5. Compilar y ejecutar:
	*Ejecutar el proyecto dentro de NetBeans o desplegarlo manualmente en el servidor configurado.


# SQL

**SQL** es un módulo del sistema GICOWEB, el cual contiene backups de las sentencias SQL de la base de datos utilizada para la centralización de la información.
