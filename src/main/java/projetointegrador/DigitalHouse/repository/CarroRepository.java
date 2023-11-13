package projetointegrador.DigitalHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetointegrador.DigitalHouse.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {}
