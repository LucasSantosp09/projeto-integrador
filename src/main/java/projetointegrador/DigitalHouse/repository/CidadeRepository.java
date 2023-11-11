package projetointegrador.DigitalHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetointegrador.DigitalHouse.model.Cidade;

public interface CidadeRepository extends JpaRepository <Cidade, Long> {
}
