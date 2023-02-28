# CRUD usando Spring Boot, Thymeleaf y Docker

### Para probar la aplicación
- Ejecutar el docker-compose.yml
#### Al ejecutar la aplicación
- Primero usar: spring.jpa.hibernate.ddl-auto=create-drop
- Detener la ejecución
- Después usar: spring.jpa.hibernate.ddl-auto=update
- Ejecutar nuevamente
- Ir a localhost:8080 y probar el CRUD
- Hacer la conexión del gestor de BDD con la BDD, se recomienda DBeaver

### Para acceder al contenedor:
- Docker exec -it <nombre_contenedor> bash