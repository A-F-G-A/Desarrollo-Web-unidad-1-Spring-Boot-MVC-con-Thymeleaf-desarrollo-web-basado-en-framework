package cel1.service;

import cel1.entity.Celular;
import cel1.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelularService {

    private final CelularRepository celularRepository;

    @Autowired
    public CelularService(CelularRepository celularRepository) {
        this.celularRepository = celularRepository;
    }

    public List<Celular> obtenerTodos() {
        return celularRepository.findAll();
    }

    public Optional<Celular> obtenerPorId(String id) {
        return celularRepository.findById(id);
    }

    public Celular guardar(Celular celular) {
        return celularRepository.save(celular);
    }

    public void eliminar(String id) {
        celularRepository.deleteById(id);
    }

    public List<Celular> buscarPorMarca(String marca) {
        return celularRepository.findByMarcaContainingIgnoreCase(marca);
    }

    public List<Celular> buscarPorSistemaOperativo(String sistemaOperativo) {
        return celularRepository.findBySistemaOperativoContainingIgnoreCase(sistemaOperativo);
    }

    public List<Celular> buscarPorOperador(String operador) {
        return celularRepository.findByOperadorContainingIgnoreCase(operador);
    }
}
