package co.ayb.auth.controller;
import co.ayb.auth.dto.VentaRequest; import co.ayb.auth.model.Venta; import co.ayb.auth.service.VentaService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/ventas")
public class VentaController {
 private final VentaService service; public VentaController(VentaService s){service=s;}
 @GetMapping public List<Venta> listar(){return service.listar();}
 @PostMapping public ResponseEntity<Venta> crear(@Valid @RequestBody VentaRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(r));}
}
