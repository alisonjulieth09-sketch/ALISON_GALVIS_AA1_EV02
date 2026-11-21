# Documentación funcional y técnica por módulo
**Proyecto:** Tienda de Ropa A&B  
**Evidencia:** GA8-220501096-AA1-EV02

## Arquitectura
`Cliente HTTP (Postman/navegador) → Controller → Service → Repository (Spring Data JPA) → H2`.
Los controladores exponen servicios REST; los servicios concentran reglas de negocio; repositorios gestionan persistencia.

## Módulos, entradas y salidas
| Módulo | Entradas | Proceso | Salidas |
|---|---|---|---|
| Autenticación | usuario, contraseña | Verifica duplicidad y BCrypt | Mensaje de registro/login |
| Productos | nombre, categoría, talla, color, precio, stock, descripción | CRUD y filtro | Producto o listado |
| Categorías | sin parámetros | Obtiene categorías distintas desde productos | Lista ordenada de categorías |
| Clientes | nombre, email, teléfono | CRUD y validación de correo | Cliente guardado/consultado |
| Inventario | ID, cantidad de stock; umbral bajo stock | Consulta y actualiza existencias | Producto actualizado/listado crítico |
| Ventas | cliente opcional, lista de productoId y cantidad | Verifica stock, calcula total y descuenta inventario en transacción | Venta con fecha, total y detalle |
| Reportes | umbral de inventario o consulta de ventas | Consolida registros existentes | Listado de ventas y productos con bajo stock |

## Reglas de negocio
1. Nombre, categoría, precio y stock del producto son obligatorios; precio > 0 y stock ≥ 0.
2. El usuario es único; su contraseña se guarda mediante BCrypt.
3. El email del cliente, cuando se informa, debe tener formato válido y no repetirse.
4. Una venta debe contener al menos un ítem.
5. La cantidad de cada ítem debe ser positiva y no puede superar el stock disponible.
6. El total se calcula con precio unitario × cantidad.
7. El descuento de existencias y el registro de venta se ejecutan en una transacción.

## Estado y alcance
El código incluye API REST para los módulos indicados. La autenticación no emite token ni protege actualmente los endpoints con autorización; la interfaz gráfica de tienda y pasarela de pagos no hacen parte de esta API. Los reportes son consultas básicas de ventas e inventario.
