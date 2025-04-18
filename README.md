# Proyecto de Inventario de Productos

Este proyecto es una aplicación web para gestionar el inventario de productos, desarrollada con Java y Spring Boot. A continuación se detalla la configuración del entorno y los pasos necesarios para ejecutar la aplicación.

## IDE utilizado
- Visual Studio Code

## Extensiones utilizadas en Visual Studio Code
- Extension Pack for Java
- Spring Boot Extension Pack
- Lombok Annotations Support for VS Code
- Maven for Java

## Lenguaje de programación y herramientas
- Java 17
- Spring Boot 3.1.5
- Maven 3.9.3

## DBMS utilizado
- SQL Server 2019

## Base de datos
La base de datos se gestiona con **SQL Server**. El script de creación y configuración se encuentra en la siguiente ruta del proyecto:
```
scripts/miempresa_bd.sql
```

## Endpoints disponibles
- `/login` → Página de inicio de sesión
- `/` → Página de inicio (index)
- `/productoDetalle` → Página de inicio de sesión
- `/historico` → Página de inicio de sesión

## Pasos para ejecutar la aplicación
1. **Clonar el repositorio desde GitHub:**
```bash
git clone https://github.com/usuario/proyecto-inventario.git
```
2. **Abrir el proyecto en Visual Studio Code.**
3. **Instalar las extensiones mencionadas arriba** si no las tienes ya instaladas.
4. **Verificar la configuración de la base de datos en `application.properties`.**
5. **Ejecutar el script SQL `scripts/miempresa_bd.sql` en SQL Server para crear la base de datos.**
6. **Desde la terminal, ejecutar el siguiente comando para compilar y correr la aplicación:**
```bash
mvn spring-boot:run
```

---

¡Listo! La aplicación estará corriendo en [http://localhost:8080](http://localhost:8080)

