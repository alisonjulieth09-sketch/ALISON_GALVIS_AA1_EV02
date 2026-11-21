# Manual técnico — Tienda de Ropa A&B

## 1. Requisitos
JDK 17, Maven 3.6.3+, conexión a internet para descargar dependencias la primera vez y Postman opcional.

## 2. Instalación
Clonar/copiar el proyecto; abrir la carpeta que contiene `pom.xml`; ejecutar `mvn clean test` y luego `mvn spring-boot:run`.

## 3. Configuración de base de datos
Desarrollo usa H2 en archivo: `jdbc:h2:file:./data/aybdb`, usuario `sa`, contraseña vacía. La consola está en `/h2-console`. No exponer la consola H2 en producción. Hibernate usa `ddl-auto=update` en desarrollo.

## 4. Configuración por ambiente
- Desarrollo: `application.properties`.
- Pruebas: `src/test/resources/application-test.properties`.
- Producción: `application-prod.properties`; definir variables de entorno y cambiar el motor de BD por uno administrado antes de publicar.

## 5. Componentes
- `controller`: endpoints REST.
- `service`: reglas de negocio y transacciones.
- `repository`: persistencia JPA.
- `model`: entidades Usuario, Producto, Cliente y Venta.
- `dto`: objetos de entrada.
- `config`: codificador BCrypt.
- `exception`: respuestas globales de error.

## 6. Compilación y artefacto
Ejecutar `mvn clean package`. El JAR se genera en `target/ayb-api-0.0.1-SNAPSHOT.jar`. Ejecutar con `java -jar target/ayb-api-0.0.1-SNAPSHOT.jar`. El JAR debe generarse en el equipo con JDK/Maven; no se adjunta uno no compilado.

## 7. Despliegue
Se incluye Dockerfile como plantilla. Construir con `docker build -t tienda-ayb .` y ejecutar con variables seguras y volumen persistente. La URL pública depende del proveedor de hosting que seleccione el aprendiz; no existe URL desplegada en esta entrega.

## 8. Seguridad y respaldo
BCrypt protege contraseñas almacenadas. No publicar secretos. Configurar HTTPS, autorización de endpoints, copias de seguridad y base de datos administrada antes de uso real. El login actual no genera JWT.
