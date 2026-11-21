package co.ayb.auth.service;
import co.ayb.auth.model.Cliente; import co.ayb.auth.repository.ClienteRepository; import org.springframework.stereotype.Service; import org.springframework.http.HttpStatus; import org.springframework.web.server.ResponseStatusException; import java.util.List;
@Service public class ClienteService {
 private final ClienteRepository repo; public ClienteService(ClienteRepository r){repo=r;}
 public List<Cliente> listar(){return repo.findAll();} public Cliente buscar(Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente no encontrado"));}
 public Cliente crear(Cliente c){if(c.getEmail()!=null&&!c.getEmail().isBlank()&&repo.existsByEmail(c.getEmail()))throw new ResponseStatusException(HttpStatus.CONFLICT,"El correo ya está registrado");return repo.save(c);}
 public Cliente actualizar(Long id,Cliente d){Cliente c=buscar(id);c.setNombre(d.getNombre());c.setEmail(d.getEmail());c.setTelefono(d.getTelefono());return repo.save(c);}
 public void eliminar(Long id){repo.delete(buscar(id));}
}
