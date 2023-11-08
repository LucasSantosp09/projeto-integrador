package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "carros")
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
