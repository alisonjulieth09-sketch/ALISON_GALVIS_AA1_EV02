# Plan de pruebas y registro de resultados
**Importante:** esta matriz es un protocolo para ejecutar. No se marcan casos como aprobados sin ejecución real en el entorno del aprendiz.

| ID | Módulo | Prueba | Resultado esperado | Resultado real |
|---|---|---|---|---|
| P01 | Auth | POST registro con usuario nuevo | HTTP 201 | Por ejecutar |
| P02 | Auth | POST login con clave correcta | HTTP 200 | Por ejecutar |
| P03 | Auth | POST login con clave incorrecta | HTTP 401 | Por ejecutar |
| P04 | Productos | POST producto válido | HTTP 201 y producto | Por ejecutar |
| P05 | Productos | GET listado y filtro categoría | HTTP 200 | Por ejecutar |
| P06 | Productos | PUT y DELETE por ID | HTTP 200 y 204 | Por ejecutar |
| P07 | Productos | Precio negativo o nombre vacío | HTTP 400 | Por ejecutar |
| P08 | Clientes | Crear, consultar, actualizar y borrar | 201, 200, 200, 204 | Por ejecutar |
| P09 | Categorías | GET /api/categorias | Lista de categorías | Por ejecutar |
| P10 | Inventario | GET /api/inventario/bajo-stock | Productos bajo umbral | Por ejecutar |
| P11 | Inventario | PATCH /api/inventario/{id}/stock?stock=12 | Stock actualizado | Por ejecutar |
| P12 | Ventas | Registrar venta con stock suficiente | HTTP 201 y stock descontado | Por ejecutar |
| P13 | Ventas | Registrar venta sin stock suficiente | HTTP 409; sin venta parcial | Por ejecutar |

## Ejecución
1. Iniciar la aplicación.
2. Abrir Postman y crear solicitudes con base `http://localhost:8080`.
3. Usar los ejemplos de `DOCUMENTACION_API.md`.
4. Registrar fecha, versión, ambiente, código HTTP, respuesta y captura de cada caso.
5. Repetir las pruebas después de cualquier cambio.

## Formato para completar
- Fecha y hora:
- Equipo / sistema operativo:
- JDK y Maven:
- Ambiente:
- ID de prueba:
- Resultado obtenido:
- Evidencia (nombre de captura):
- Observaciones:
