package projetointegrador.DigitalHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetointegrador.DigitalHouse.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
