package projetointegrador.DigitalHouse.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetointegrador.DigitalHouse.carros.model.CarroModel;

public interface CarroRepository extends JpaRepository<CarroModel,Long > {
}
