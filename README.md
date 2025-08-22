# Api REST 

## Despliegue

### Docker

Esta api REST se despliega en docker para los usuarios que 
decidan usarlo con este metodo.

```docker
docker build -t encode-decode .
docker run -p 8080:8080 mi-backend
```

### Tools

1. JAVA - 17    
2. SPRINGBOOT - SNAPSHOT 3.3
3. MAVEN 
4. DOCKER
5. DOTENV

### Configuración DOTENV

Esta configuración se encuentra en el metodo main y se usa para cargar todas las 
caracteristicas, debes crear tu propio __.env__ y colocar tus
propias variables de entoro de la app

```java
public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();
    // Variables necesarias para que la api funcione.
    System.setProperty("DB_URL", dotenv.get("DB_URL"));
    System.setProperty("DB_USER", dotenv.get("DB_USER"));
    System.setProperty("DB_PASS", dotenv.get("DB_PASS"));
    // <-- aquí puedes seguir colocando más variables de entorno. 
    
    SpringApplication.run(EncodeDecodeApplication.class, args);
}
```
