package co.ayb.auth.controller;
import co.ayb.auth.repository.ProductoRepository; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/categorias")
public class CategoriaController {
 private final ProductoRepository productos; public CategoriaController(ProductoRepository p){productos=p;}
 @GetMapping public List<String> listar(){return productos.findAll().stream().map(p->p.getCategoria()).filter(Objects::nonNull).distinct().sorted(String.CASE_INSENSITIVE_ORDER).toList();}
}
