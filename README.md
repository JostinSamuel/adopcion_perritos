# Aplicación Backend de Adopción de Perritos

Esta es una aplicación backend en Java Spring Boot para gestionar publicaciones de adopción de perritos. La aplicación permite a los usuarios publicar perritos que necesitan adopción en una sección dedicada.

## Características

- **Registro y Autenticación de Usuarios**: Los usuarios pueden registrarse e iniciar sesión en la aplicación.
- **Publicación de Perritos**: Los usuarios pueden crear, actualizar y ver publicaciones de perritos que necesitan adopción.
- **Gestión del Estado de Adopción**: Los usuarios pueden actualizar el estado de adopción de los perritos.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Security
- Maven
- JPA/Hibernate
- MySQL (o cualquier otra base de datos relacional)

## Comenzando

### Prerrequisitos

- Java 11 o superior
- Maven
- PostgreSQL (o cualquier otra base de datos relacional)

### Instalación

1. **Clonar el repositorio**:
    ```sh
    git clone https://github.com/JostinSamuel/adopcion_perritos.git
    ```

2. **Configurar la base de datos**:
    Actualiza el archivo `application.properties` con la configuración de tu base de datos.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Construir el proyecto**:
    ```sh
    mvn clean install
    ```

4. **Ejecutar la aplicación**:
    ```sh
    mvn spring-boot:run
    ```

## Endpoints de la API

### Autenticación

- **Registro**: `POST /auth/signup`
    ```json
    {
        "email": "jostin@gmail.com",
        "password": "123456789",
        "fullName": "Jostin Samuel"
    }
    ```

- **Inicio de Sesión**: `POST /auth/login`
    ```json
    {
        "email": "jostin@gmail.com",
        "password": "123456789"
    }
    ```

### Publicaciones de Perritos

- **Obtener Todas las Publicaciones**: `GET /adopciones`
- **Crear Publicación**: `POST /adopciones`
    ```json
    {
        "nombre": "Fido",
        "edad": 3,
        "tamanio": "MEDIANO",
        "raza": "Labrador",
        "descripcion": "Amigable y enérgico",
        "imagenes": ["image1.jpg", "image2.jpg"],
        "ubicacion": "New York",
        "estado": "DISPONIBLE"
    }
    ```

- **Actualizar Estado de Adopción**: `PUT /adopciones/{id}/estado?nuevoEstado=CONFIRMADO`

## Contribuciones

¡Las contribuciones son bienvenidas! Por favor, abre un issue o envía un pull request para cualquier cambio.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.
