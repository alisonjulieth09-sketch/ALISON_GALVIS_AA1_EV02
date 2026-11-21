# Tienda de Ropa A&B — Evidencia GA8-220501096-AA1-EV02

Proyecto académico basado en la API entregada para GA7-220501096-AA5-EV03 y ampliado con módulos de clientes, categorías, inventario y ventas.

## Tecnologías
- Java 17, Spring Boot 3.4.5, Maven
- Spring Web, Spring Data JPA, Bean Validation
- BCrypt para hash de contraseñas
- H2 en modo archivo para desarrollo

## Módulos disponibles
- Autenticación: registro e inicio de sesión.
- Productos: CRUD y filtro por categoría.
- Categorías: listado de categorías presentes en productos.
- Clientes: CRUD.
- Inventario: consulta de productos con bajo stock y ajuste de existencias.
- Ventas: registro de venta con detalle resumido y descuento transaccional de stock.

## Ejecutar localmente
Requisitos: JDK 17 y Maven 3.6.3 o superior.
1. Abrir esta carpeta en VS Code, IntelliJ o Eclipse.
2. Ejecutar `mvn clean test`.
3. Ejecutar `mvn spring-boot:run`.
4. API: `http://localhost:8080`.
5. Consola H2: `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:file:./data/aybdb`, usuario `sa`, contraseña vacía).

En Windows también se incluye `scripts/ejecutar.bat`; en Linux/macOS `scripts/ejecutar.sh` (requieren Maven instalado).

## Endpoints
Ver `docs/DOCUMENTACION_MODULOS.md` y `docs/DOCUMENTACION_API.md`.

## Base de datos
H2 se usa como base persistente local. Hibernate crea/actualiza las tablas a partir de las entidades (`ddl-auto=update`). No se incluye información productiva ni contraseñas iniciales.

## Ambientes
- Desarrollo: perfil por defecto, H2 archivo local.
- Pruebas: `mvn test`; base H2 de pruebas configurada en `src/test/resources/application-test.properties`.
- Producción/despliegue: configuración de referencia en `Dockerfile` y `application-prod.properties`. Requiere hosting, variables seguras y URL pública; no se afirma que esté desplegado.

## Limitaciones importantes
- El login valida credenciales y las contraseñas se almacenan con BCrypt; esta entrega no implementa JWT ni control de autorización por roles para proteger cada endpoint.
- Las ventas descuentan stock dentro de una transacción. El detalle se conserva como texto resumido; para facturación avanzada se recomienda normalizar el detalle en una tabla `detalle_venta`.
- Las pruebas deben ejecutarse en el equipo del aprendiz y sus resultados/capturas reales agregarse al informe. No declarar como ejecutado lo que no se haya probado.

## GitHub
El archivo `REPOSITORIO.txt` conserva la URL informada en la entrega anterior. Verifica que sea accesible y que contenga esta versión antes de presentarla.
