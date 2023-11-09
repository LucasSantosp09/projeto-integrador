package projetointegrador.DigitalHouse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "reserva")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Clientes clientes;

    @OneToOne
    @JoinColumn(name = "carro_id")
    private Carros carros;

    private Date DataInicio;

    private Date DataFim;

    private Double precoTotal;



}
