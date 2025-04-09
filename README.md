# GICO

**GICO** es un sistema integral diseñado para la gestión de información de inventarios, proporcionando herramientas tanto en plataformas web como móviles para facilitar procesos administrativos.

## Estructura del Repositorio

El repositorio se organiza en dos componentes principales:

- **GICOWEB/**: Aplicación web destinada a la administración y gestión de inventarios.
  - **GICO-AD/**: Módulo administrativo que maneja gestión de usuarios, proveedores, productos, ventas, clientes, notas de crédito, bodegas, proformas. Basado en servicios web tipo REST.

  - **GICO/**: Módulo central que gestiona la parte visual (frontend) del sistema y se comunica con GICO-AD para obtener la información.

- **sistemaMovilGICO/**: Aplicación móvil que ofrece funcionalidades esenciales del sistema GICO en dispositivos Android.
  - **sistemaGICO/**: Proyecto Android que permite a usuarios interactuar con el sistema desde sus dispositivos móviles.

## Tecnologías Utilizadas

- **Backend**: Java EE para la aplicación web.
- **Frontend**: HTML, CSS, JavaScript, con preprocesadores como SCSS.
- **Móvil**: Desarrollo nativo para Android utilizando Java.
- **Base de Datos**: PLpgSQL, indicando el uso de PostgreSQL.
- **Herramientas de Construcción**: Gradle para la aplicación móvil y Apache Ant para la aplicación web.

## Instrucciones de Instalación

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/ronalddiaz-94/GICO.git

2. Configuración de la Aplicación Web:
	*Importar el proyecto GICOWEB en NetBeans.
	*Configurar un servidor compatible.
	*Asegurar que las dependencias estén presentes en el directorio librerias/.
	*Configurar la conexión a la base de datos PostgreSQL utilizando los scripts proporcionados en el repositorio.
3. Configuración de la Aplicación Móvil:
	*Importar el proyecto sistemaMovilGICO/sistemaGICO en Android Studio.
	*Sincronizar el proyecto con Gradle.
	*Configurar un emulador o conectar un dispositivo Android.
	*Verificar la configuración de los endpoints para la comunicación con el backend.

Se recomienda revisar los archivos README.md específicos en cada subdirectorio
