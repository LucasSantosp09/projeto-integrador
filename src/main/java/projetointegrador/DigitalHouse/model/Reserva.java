package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    private Date DataInicio;

    private Date DataFim;

    private Double precoTotal;
}
