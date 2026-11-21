# Configuración de servidores y ambientes

## Desarrollo
- Aplicación: Spring Boot, puerto 8080.
- Base de datos: H2 archivo local `./data/aybdb`.
- Consola H2: `/h2-console`, solo uso local.
- Comando: `mvn spring-boot:run`.

## Pruebas
- Perfil: `test`.
- Base: H2 en memoria `jdbc:h2:mem:aybtest`.
- Comando: `mvn -Dspring.profiles.active=test test` (los tests de Spring pueden activar su propia configuración).
- Registrar resultados reales en `PRUEBAS_Y_RESULTADOS.md`.

## Producción (plantilla, no desplegada)
- Puerto configurable por `PORT`.
- Perfil `prod`.
- No habilitar consola H2.
- Configurar base de datos persistente, HTTPS, credenciales como variables secretas, monitoreo y respaldos.
- URL pública: pendiente de contratar/configurar hosting y desplegar.

## Configuración de requisitos aprobados
No se adjuntan actas de aprobación de requisitos. Si el instructor o cliente aprobó requisitos, anexar acta firmada o correo de aprobación en esta carpeta.
