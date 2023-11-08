package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
