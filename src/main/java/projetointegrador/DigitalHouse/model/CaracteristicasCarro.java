package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "caracteristicas_carro")
public class CaracteristicasCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
