package projetointegrador.DigitalHouse.caracteristicas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="caracteristicas")
public class CaracteristicasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String icone;
}
