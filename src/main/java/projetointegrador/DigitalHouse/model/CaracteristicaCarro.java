package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "TB_CARACTERISTICAS")
public class CaracteristicaCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "caracteristicaCarro")
    private List<Carro> carro;
}
