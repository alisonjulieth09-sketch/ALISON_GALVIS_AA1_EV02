package co.ayb.auth.controller;
import co.ayb.auth.model.Cliente; import co.ayb.auth.service.ClienteService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/clientes")
public class ClienteController {
 private final ClienteService service; public ClienteController(ClienteService s){service=s;}
 @GetMapping public List<Cliente> listar(){return service.listar();}
 @GetMapping("/{id}") public Cliente buscar(@PathVariable Long id){return service.buscar(id);}
 @PostMapping public ResponseEntity<Cliente> crear(@Valid @RequestBody Cliente c){return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(c));}
 @PutMapping("/{id}") public Cliente actualizar(@PathVariable Long id,@Valid @RequestBody Cliente c){return service.actualizar(id,c);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Long id){service.eliminar(id);return ResponseEntity.noContent().build();}
}
