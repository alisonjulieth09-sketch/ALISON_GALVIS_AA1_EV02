package co.ayb.auth.repository;
import co.ayb.auth.model.Cliente; import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente,Long> { boolean existsByEmail(String email); }
