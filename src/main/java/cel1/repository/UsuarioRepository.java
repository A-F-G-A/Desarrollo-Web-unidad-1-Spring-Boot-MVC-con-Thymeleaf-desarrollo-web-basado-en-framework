package cel1.repository;

import cel1.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByIdAndClave(String id, String clave);

    List<Usuario> findByRol(String rol);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
}
