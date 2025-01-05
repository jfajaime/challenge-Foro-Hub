# 📝 ForoHub

ForoHub es una plataforma de foros en línea que permite a los usuarios crear, leer, actualizar y eliminar tópicos. 
Este proyecto utiliza Spring Boot para el backend y JWT para la autenticación de usuarios.

## 🌟 Características

- CRUD de tópicos
- Autenticación de usuarios mediante JWT (JSON Web Tokens)
- Base de datos relacional
- Documentación de la API con Swagger

## 🛠️ Requisitos

- Java 11 o superior
- Maven
- MySQL

## 🚀 Instalación

### 1. Clona el repositorio:
     
   git clone https://github.com/tu-usuario/foro-hub.git
   cd foro-hub
   
#### 2.Configura la base de datos en application.properties:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

#### 3.Ejecuta la aplicación:

mvn spring-boot:run

## 📚 Uso
### 🔐 Autenticación
La autenticación de usuarios se realiza mediante JWT. Los tokens JWT son generados al iniciar sesión y deben ser incluidos
en el encabezado de las solicitudes a las rutas protegidas.

#### 📝 Registro de usuario

[POST /api/auth/register](http://localhost:8080/login)

Cuerpo de la solicitud:

json
{
	"nombre": "tu nombre",
	"email": "tu _correo@gmail.com",
	"clave": "tu clave"
}
#### 🔑 Inicio de sesión

[POST /api/auth/register](http://localhost:8080/login)

Respuesta:

json
{
  "token": "jwt_token_generado"
}
### 🔒 Rutas protegidas

Para acceder a las rutas protegidas, incluye el token JWT en el encabezado de la solicitud:
Authorization: Bearer jwt_token_generado

#### ➕ Crear un nuevo tópico

POST /api/topics](http://localhost:8080/topico)

Cuerpo de la solicitud:

{	
	"titulo": "titulo23",
	"mensaje": "mensaje23",	
	"status": true,
	"autor":"fernando612374",
	"curso": "curso621374",
	"respuesta": "respuesta613472"
	
}

#### 📄 Obtener todos los tópicos

GET /api/topics](http://localhost:8080/topico)

#### ✏️ Actualizar un tópico

PUT /api/topics/{id}](http://localhost:8080/topico)

Cuerpo de la solicitud:
	{
			"id": 13,
			"titulo": "AQUI VA EL TITULO",
		  "status": true,
			"curso": "AQUI VA INFORMACION ADICIONAL"
		}
  TAMBIEN PUEDES BORRAR, VER POR ID, CERRAR POR STATUS, BUSCAR POR AÑO Y CURSO ETC..

 ## 🚧 Dificultades Encontradas
Configuración de Lombok: Asegúrate de que el IDE esté configurado correctamente para procesar las anotaciones de Lombok.

Manejo de Excepciones: Implementa un manejo global de excepciones para proporcionar mensajes de error claros y específicos.

Validación de Datos: Utiliza la anotación @Valid para validar los datos de entrada y evitar registros duplicados.

Configuración de HikariCP: Asegúrate de que las propiedades del pool de conexiones estén correctamente configuradas.

## 📈 Adicional informacion:
Autenticación y Autorización: Implementacion de seguridad con Spring Security y JWT.

Documentación: Añadir documentación con Swagger.

Pruebas: Implementar pruebas unitarias y de integración.

## 🙏 Agradecimientos
Queremos agradecer a todas las personas que contribuyeron a este proyecto:

A nuestro equipo de desarrollo por su arduo trabajo y dedicación.

A la comunidad de código abierto por sus valiosas herramientas y recursos.

A Microsoft Copilot por su asistencia en la generación de contenido y soporte técnico.

#### 📄 Licencia
Algun dia generare proyectos importantes para que tengan licencia 😬.
