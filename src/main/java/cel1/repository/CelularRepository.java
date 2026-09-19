package cel1.repository;

import cel1.entity.Celular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CelularRepository extends JpaRepository<Celular, String> {

    List<Celular> findByMarcaContainingIgnoreCase(String marca);

    List<Celular> findBySistemaOperativoContainingIgnoreCase(String sistemaOperativo);

    List<Celular> findByOperadorContainingIgnoreCase(String operador);
}
