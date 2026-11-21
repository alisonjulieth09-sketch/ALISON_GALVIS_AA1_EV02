package co.ayb.auth.controller;
import co.ayb.auth.model.Producto; import co.ayb.auth.repository.ProductoRepository; import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.validation.annotation.Validated; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException;
@RestController @RequestMapping("/api/inventario") @Validated
public class InventarioController {
 private final ProductoRepository repo; public InventarioController(ProductoRepository r){repo=r;}
 @GetMapping("/bajo-stock") public java.util.List<Producto> bajoStock(@RequestParam(defaultValue="5") @Min(0) int minimo){return repo.findAll().stream().filter(p->p.getStock()<=minimo).toList();}
 @PatchMapping("/{id}/stock") public Producto ajustar(@PathVariable Long id,@RequestParam @Min(0) int stock){Producto p=repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Producto no encontrado"));p.setStock(stock);return repo.save(p);}
}
