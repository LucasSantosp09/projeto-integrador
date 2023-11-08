package projetointegrador.DigitalHouse.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "locadora")
public class Locadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
