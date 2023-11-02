package projetointegrador.DigitalHouse.carros.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "carros")
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
}
