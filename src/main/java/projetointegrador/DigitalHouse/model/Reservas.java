package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reserva")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
