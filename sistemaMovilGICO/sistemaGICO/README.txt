# sistemaGICO

**sistemaGICO** es la versión móvil del sistema GICO, diseñada como una aplicación Android nativa. Su propósito es brindar acceso desde dispositivos móviles a funciones esenciales del sistema de gestión de inventarios.

## Características

- Consulta de información de productos.
- Gestión de usuarios (roles, acceso).
- Conexión los servicios web, API del sistema GICO WEB (GICO-AD).
- Interfaz responsiva y adaptada a móviles.

## Estructura del Proyecto

- `app/`: Contiene el código fuente de la aplicación Android.
- `.idea/`: Archivos de configuración del IDE (Android Studio).
- `gradle/`, `gradlew`, `build.gradle`: Archivos de configuración y automatización de compilación con Gradle.
- `settings.gradle`: Define los módulos del proyecto.

## Tecnologías Utilizadas

- **Java** 
- **Android SDK**
- **Gradle** como sistema de construcción
- **Android Studio** como entorno de desarrollo

## Cómo Ejecutar

1. Clona el repositorio:

   ```bash
   git clone https://github.com/ronalddiaz-94/GICO.git
2. Abre la carpeta sistemaMovilGICO/sistemaGICO en Android Studio.
3. Sincroniza el proyecto con Gradle.
4. Configura un emulador o conecta un dispositivo Android.
5. Ejecuta la app desde Android Studio (Run > Run 'app').


## Requisitos Previos
	*Android Studio (recomendado)
	*Java Development Kit (JDK) 8 o superior
	*Android SDK configurado
	*Conexión a la API del sistema GICO (servidor backend en línea o local)

## Notas Adicionales
	*Verifica la configuración de endpoints en el código (IP o dominio del backend).
	*Para pruebas en red local, asegúrate de que el dispositivo tenga acceso al servidor.