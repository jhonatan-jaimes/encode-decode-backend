# API para la generación de servicios varios

## Despliegue

### Docker

Esta api REST se despliega en docker para los usuarios que 
decidan usarlo con este metodo.

* Archivo Dockerfile despliega el proyecto

### Tools

* __JAVA - 17__    
* SPRINGBOOT - SNAPSHOT 3.3
* MAVEN 
* DOCKER
* DOTENV
* MYSQL

### Configuración ___DOTENV___

Esta configuración se encuentra en el metodo main y se usa para cargar todas las 
caracteristicas, debes crear tu propio __.env__ y colocar tus
propias variables de entoro de la app

```properties
MYSQL_USER= xxxx        <-- usuario base de datos
MYSQL_PASS= xxxx        <-- contraseña
MYSQL_URI= xxxx         <-- link base de datos

ALLOWED_ORIGINS= xxxx   <-- links que permiten consumir la api
```

### Configuración del <u>aplication.propierties</u>

```properties
spring.application.name=encode-decode

spring.datasource.url=${MYSQL_URI}
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASS}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

server.port=8080

cors.allowed-origins={ALLOWED_ORIGINS}
```

### Clase para iniciar <u>.env</u>
```java
public class DotEnv {
    /*
     * Metodo static para iniciar el .env.
     * */
    public static void dotenv(){
        Dotenv dotenv = Dotenv.load();
        System.setProperty("MYSQL_URI", dotenv.get("MYSQL_URI"));
        System.setProperty("MYSQL_USER", dotenv.get("MYSQL_USER"));
        System.setProperty("MYSQL_PASS", dotenv.get("MYSQL_PASS"));

        System.setProperty("ALLOWED_ORIGINS", dotenv.get("ALLOWED_ORIGINS"));
    }
}
```

### Configuración metodo main en <u>JAVA</u>
```java
public static void main(String[] args) {

    /*
     * Se utiliza DOTENV para poder configurar a medida de usuario el servidor, se debe crear un".env"
     * y se encarga de mapear.
     * */
    DotEnvConfig.dotenv(); // <--- Aqui arranca el dotenv (.env) para arrancar la app.

    SpringApplication.run(EncodeDecodeApplication.class, args);
}
```
