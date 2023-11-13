package projetointegrador.DigitalHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetointegrador.DigitalHouse.model.Locadora;

@Repository
public interface LocadoraRepository extends JpaRepository<Locadora, Long> {
}
