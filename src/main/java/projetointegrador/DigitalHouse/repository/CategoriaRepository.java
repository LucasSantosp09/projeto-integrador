package projetointegrador.DigitalHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetointegrador.DigitalHouse.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
