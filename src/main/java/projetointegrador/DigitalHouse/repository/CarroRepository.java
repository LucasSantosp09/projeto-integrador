package projetointegrador.DigitalHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetointegrador.DigitalHouse.model.Carro;
import projetointegrador.DigitalHouse.model.Categoria;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    // Método para obter todos os carros
    List<Carro> findAll();
    Optional<Carro> findById(Long id);
}
