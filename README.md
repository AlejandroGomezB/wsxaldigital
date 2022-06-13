# Prueba Xaldigital - Servicio web wsxaldigital 
@Alejandro Gomez Barreto
## Tecnologias Utilizadas
- Aplicacion
  - Java JDK 8
  - Spring Boot 2.5.2
  - JPA
  - Hibernate
- IDE
  - Eclipse
- Servidor de Aplicaciones
  - Tomcat embebido
- Servidor de BD
  - MySQL 5.7
- Test de API
  - Postman
## Experiencia
La realización de esta prueba fue un reto para mi debido que no tenia los conocimientos suficientes para el manejo de dockers, asi como de la API de swagger para la generacion de los contratos de interfaz. Durante la investigacion se observo varias formas de implementar dichas herramientas pero por cuestion de tiempo no se pudo probar dichos metodos por lo cual se implemento el metodo mas sencillo en su aplicacion
## Retos
Los retos que puedo mencionar en la realización de esta prueba son:
- Dockers: Es la primera vez que trabajo con esta tecnologia y se tuvo que investigar y configurar el equipo en el que se trabajo para poder trabjar con esta herramienta, presentandose problemas para enlazar el contenedor con el gestor de BD MySqlServer.
## Swagger
Para la visualizacion del contrato de interfaz por medio de la herramienta de swagger, se ingresara en la siguiente ruta una vez deployada la aplicacion wsxaldigital
- Liga: http://localhost:8081/wsxaldigital/swagger-ui.html#/
Nota: Remplazar por la direccion donde se encuentre la aplicación en caso de aplicar.
## Intalación
Para iniciar la instalación del servicio web, se debera primero crear la BD y sus respectivas tablas, para relazar esta acció se tocara a continaución
### Base de datos
Vamos a ejecutar en nuestro gestor de BD MySqlServer el script que se encuentra en la raiz del proyecto para crear la BD y la insercion de algunos datos. El archivo se llama "Script.sql".
Para la configuracion de la conexion de base de datos, vamos a cambiar las credenciales por las que usamos en nuestro gestor de base de datos tanto en los archivos application.properties y en docker-compose.yml. 
### Puerto del servicio
El Servicio se encuentra configurado para trabajar sobre el puerto 8081, en caso que desee cambiar el puerto lo podra hacer en el archivo application.properties en la propiedad server.port
### Ruta
La aplicacion esta configurada para que su ruta inicie de la siguiente manera: http://localhost:8081/wsxaldigital
Nota: Recuerde que puede cambiar el localhost por la direccion que usted haya configurado.

